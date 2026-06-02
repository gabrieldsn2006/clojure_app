(ns clojure-app.core
  (:require [clojure_app.view    :as view]
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
  (view/print_msg "\n=======================================")
  (view/print_msg "       CALCULADORA DE CALORIAS           ")
  (view/print_msg "=======================================\n")
  (view/print_msg "1. Cadastrar/Consultar dados pessoais")
  (view/print_msg "2. Registrar consumo de alimento (Ganho)")
  (view/print_msg "3. Registrar atividade fisica (Perda)")
  (view/print_msg "4. Consultar extrato de transacoes")
  (view/print_msg "5. Consultar saldo de calorias")
  (view/print_msg "0. Sair")
  (view/print_msg "\nDigite a opcao desejada: ")

  (let [option (view/read_input)]
    (execute option)
    (if (= option "0")
     (view/print_msg "\nPrograma finalizado.")
     (recur)
    )
  )
)


(defn -main [& args]
  (main_loop)
)