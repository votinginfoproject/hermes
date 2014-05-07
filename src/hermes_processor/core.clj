(ns hermes-processor.core
  (:require [turbovote.aws-toolbox.data_readers]
            [turbovote.aws-toolbox.sqs :as sqs]
            [turbovote.resource-config :refer [config]]
            [clj-http.client :as client]
            [clj-http.cookies :as cookies]
            [clojure.tools.logging :refer [info]]))

(defn login []
  (let [params {:username (config :metis :username)
                :password (config :metis :password)}
        login-url (config :metis :login-url)]
    (client/post login-url {:form-params params})))

(defn notify-metis [bucket filename]
  (let [session-cookie (-> (login)
                           :cookies
                           (select-keys ["connect.sid"]))
        feed-url (config :metis :feed-url)]
    (client/post feed-url
                 {:cookies session-cookie
                  :form-params {:filename filename
                                :s3Bucket bucket}})))

(defn -main [& args]
  (info "Starting up...")
  (let [access-key (config :aws :creds :access-key)
        secret-key (config :aws :creds :secret-key)
        region (config :aws :sqs :region)
        client (sqs/client access-key secret-key region)
        queue (config :aws :sqs :queue)
        fail-queue (config :aws :sqs :fail-queue)]
    (sqs/consume-messages client notify-metis queue fail-queue))
  (info "Started"))
