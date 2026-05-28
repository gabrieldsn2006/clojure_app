(ns clojure_app.service
  (:require [clojure_app.view :as view]
            [clojure_app.api :as api])
)

(defn user_data []
  (view/print_msg (api/req "http://localhost:3000/user_data"))
)

(defn food []
  (view/print_msg (api/req "http://localhost:3000/food"))
)

(defn activity []
  (view/print_msg (api/req "http://localhost:3000/activity"))
)

(defn statement []
  (view/print_msg (api/req "http://localhost:3000/statement"))
)

(defn balance []
  (view/print_msg (api/req "http://localhost:3000/balance"))
)