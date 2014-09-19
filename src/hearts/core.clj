(ns hearts.core
  (:require [tricks.cards]
            [tricks.core]
            [tricks.client-proxy]
            [tricks.server]
            [tricks.utils]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")

  (println (format "|%s|" tricks.cards/SUITS)))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn -main
  [& args]
  (let [{:keys [options arguments errors summary]} (parse-opts args tricks.core/cli-options)]
    ;; Handle help and error conditions
    (cond
      (:help options) (tricks.core/exit 0 (tricks.core/usage summary))
      errors (tricks.core/exit 1 (tricks.core/error-msg errors))
      :else
      (tricks.server/run [
                           ;["Clojure1" ["java" "-jar" "clojure_client-0.1.0-SNAPSHOT-standalone.jar" "Clojure1"] (java.io.File. "clients")]
                           ["Python_1" ["python" "simple_client.py" "Python_1"] (java.io.File. "clients")]
                           ["Python_4" ["python" "simple_client.py" "Python_4"] (java.io.File. "clients")]
                           ["Python_2" ["python" "simple_client.py" "Python_2"] (java.io.File. "clients")]
                           ["Python_3" ["python" "simple_client.py" "Python_3"] (java.io.File. "clients")]]
                         (:max-score options)))))