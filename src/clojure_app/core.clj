(ns clojure-app.core
  (:require [clojure_app.view :as view]
            [clojure_app.service :as service])
  (:gen-class)
)

(defn execute [option]
  (case option
    "1" (service/user_data)
    "2" (service/food)
    "3" (service/activity)
    "4" (service/statement)
    "5" (service/balance)
    "0" (view/print_msg "Saindo da aplicacao... Ate logo!")
    (view/print_msg "Opcao Invalida!")
  )
)

(defn main_loop []
  (view/menu)
  (view/print_msg "\nDigite a opcao desejada: ")

  (let [option (view/read_input)]
    (execute option)
    (if (= option "0")
     (println "\nPrograma finalizado.")
     (recur)
    )
  )
)

(defn -main [& args]
  (view/title)
  (main_loop)
)