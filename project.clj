(defproject lein-sqs "0.1.1-SNAPSHOT"
  :description "lein plugin that wraps 'elasticmq' a local implementation of Amazon Simple Queue Service (SQS)"
  :url "https://github.com/mdaley/lein-sqs"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.elasticmq/elasticmq-server_2.11 "0.8.8"]]
  :scm {:name "git"
        :url "https://github.com/mdaley/lein-sqs"}
  :eval-in-leiningen true
  :repositories [["releases" {:url "https://clojars.org/repo"
                              :creds :gpg}]]

  :sqs {:port 8084
        :limits "relaxed"})
