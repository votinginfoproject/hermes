(defproject hermes-processor "0.1.0-SNAPSHOT"
  :description "Processes incoming hermes uploads and sends them to Metis"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.logging "0.2.6"]
                 [org.slf4j/slf4j-simple "1.7.7"]
                 [turbovote.resource-config "0.1.1"]
                 [democracyworks.squishy "1.0.0"]
                 [clj-http "0.9.1"]]
  :profiles {:dev {:resource-paths ["dev-resources"]}
             :production {:resource-paths ["env-configs/hermes-processor/production/resources"]}}
  :main ^{:skip-aot true} hermes-processor.core)
