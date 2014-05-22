(ns immutant.init
  (:require [immutant.daemons :as daemon]
            [hermes.core :as hermes]))

(def messages-future (atom nil))

(defn start []
  (reset! messages-future (hermes/-main)))

(defn stop []
  (swap! messages-future (fn [f] (when f (future-cancel f)))))

(daemon/daemonize "hermes.importer" start stop :singleton false)
