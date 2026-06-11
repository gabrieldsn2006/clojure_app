(ns clojure_app.api
  (:require [clj-http.client :as client]
            [cheshire.core   :as json])
)


(defn get-req [endpoint]
  (json/parse-string (:body (client/get endpoint)) true)
)


(defn post-req [endpoint payload]
  (json/parse-string (:body (client/post endpoint
      {:headers {"Content-Type" "application/json"}
       :body (json/generate-string payload)})) true)
)
