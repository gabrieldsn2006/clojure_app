(ns clojure_app.api
  (:require [clj-http.client :as client]
            [cheshire.core   :as json])
)


(defn get_req [endpoint]
  (:body (client/get endpoint))
)


(defn post_req [endpoint payload]
  (:body (client/post endpoint
      {:headers {"Content-Type" "application/json"}
       :body (json/generate-string payload)}
    )
  )
)
