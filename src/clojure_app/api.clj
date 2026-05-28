(ns clojure_app.api
  (:require [clj-http.client :as http-client])
)

(defn req [endpoint]
  (:body (http-client/get endpoint))
)