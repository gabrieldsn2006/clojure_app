(ns clojure_app.api
  (:require [clj-http.client :as client]
            [cheshire.core   :as json])
)


(defn get_req [endpoint]
  (json/parse-string (:body (client/get endpoint)) true)
)


(defn post_req [endpoint payload]
  (json/parse-string (:body (client/post endpoint
      {:headers {"Content-Type" "application/json"}
       :body (json/generate-string payload)})) true)
)
