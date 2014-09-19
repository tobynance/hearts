(defproject hearts "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [tricks "0.1.0-SNAPSHOT"]]
  :main ^:skip-aot hearts.core
  :target-path "target/%s"
  ;:resource-paths ["resources/tricks-0.1.0-SNAPSHOT.jar.jar"]
  :profiles {:uberjar {:aot :all}})
