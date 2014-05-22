(defproject hermes "0.1.0-SNAPSHOT"
  :description "Processes incoming hermes uploads and sends them to Metis"
  :url "https://github.com/votinginfoproject/hermes"
  :license {:name "BSD 3-clause License"
            :url "http://opensource.org/licenses/BSD-3-Clause"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.logging "0.2.6"]
                 [org.slf4j/slf4j-simple "1.7.7"]
                 [turbovote.resource-config "0.1.1"]
                 [democracyworks.squishy "1.0.0"]
                 [clj-http "0.9.1"]]
  :plugins [[lein-immutant "1.2.0"]]
  :profiles {:dev {:resource-paths ["dev-resources"]}
             :production {:resource-paths ["env-configs/hermes-processor/production/resources"]}}
  :main ^{:skip-aot true} hermes-processor.core)
