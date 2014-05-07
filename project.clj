(defproject hermes-processor "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 [org.slf4j/slf4j-simple "1.7.6"]
                 [turbovote.resource-config "0.1.2-SNAPSHOT"]
                 [democracyworks.squishy "1.0.0-SNAPSHOT"]
                 [clj-http "0.9.1"]]
  :profiles {:dev {:resource-paths ["dev-resources"]}}
  :main ^{:skip-aot true} hermes-processor.core)
