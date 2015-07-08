(ns leiningen.sqs
  (:require [clojure.string :refer [lower-case]]
            [leiningen.core.main :as main])
  (:import [org.elasticmq NodeAddress]
           [org.elasticmq.rest.sqs SQSRestServerBuilder$ SQSLimits]))

(defn- config-value
  "Get a value from project config or, optionally, use a default value."
  [project k & [default]]
  (get (project :sqs) k default))

(defn sqs
  "Run SQS in memory."
  [project & args]
  (let [port (Integer/valueOf (config-value project :port 8084))
        limits (if (= "strict" (config-value project :limits))
                     (SQSLimits/withName "Strict")
                     (SQSLimits/withName "Relaxed"))]
    (println "lein-sqs: starting in-memory sqs instance on port " port ". mode =" (lower-case (.toString limits)))
    (let [server (-> (SQSRestServerBuilder$/MODULE$)
                     (.withPort port)
                     (.withServerAddress (NodeAddress. "http" "localhost" port ""))
                     (.withSQSLimits limits)
                     (.start))]
      (if (seq args)
        (try
          (main/apply-task (first args) project (rest args))
          (finally (.stopAndWait server)))
        (while true (Thread/sleep 5000))))))
