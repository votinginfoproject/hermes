(ns immutant.init
  (:require [immutant.daemons :as daemon]
            [hermes-processor.core :as hermes-processor]))

(def messages-future (atom nil))

(defn start []
  (reset! messages-future (hermes-processor/-main)))

(defn stop []
  (swap! messages-future (fn [f] (when f (future-cancel f)))))

(daemon/daemonize "hermes-processor.importer" start stop :singleton false)
