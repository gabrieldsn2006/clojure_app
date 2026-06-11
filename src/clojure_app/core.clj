(ns clojure-app.core
  (:require [clojure_app.view    :as view]
            [clojure_app.service :as service])
  (:gen-class)
)

(defn execute [option]
  (case option
    "1" (service/user-data)
    "2" (service/food)
    "3" (service/activity)
    "4" (service/transactions)
    "5" (service/balance)
    "0" (view/print-msg "Saindo da aplicacao... Ate logo!")
    (view/print-msg "Opcao Invalida!")
  )
)


(defn main_loop []
  (view/print-msg "\n=======================================")
  (view/print-msg "       CALCULADORA DE CALORIAS           ")
  (view/print-msg "=======================================\n")
  (view/print-msg "1. Cadastrar/Consultar dados pessoais")
  (view/print-msg "2. Registrar consumo de alimento (Ganho)")
  (view/print-msg "3. Registrar atividade fisica (Perda)")
  (view/print-msg "4. Consultar extrato de transacoes")
  (view/print-msg "5. Consultar saldo de calorias")
  (view/print-msg "0. Sair")
  (view/print-msg "\nDigite a opcao desejada: ")

  (let [option (view/read-input)]
    (execute option)
    (if (= option "0")
     (view/print-msg "\nPrograma finalizado.")
     (recur)
    )
  )
)


(defn -main [& args]
  (main_loop)
)