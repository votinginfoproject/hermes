(ns hermes.core
  (:require [democracyworks.squishy :as sqs]
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
                  :form-params {:filenames filename
                                :s3bucket bucket}})))

(defn process-file [message]
  (-> message
      :body
      clojure.edn/read-string
      (#(vec (map % [:bucket :filename])))
      (#(apply notify-metis %))))

(defn -main [& args]
  (info "Starting up...")
  (sqs/consume-messages (sqs/client) process-file)
  (info "Started"))
