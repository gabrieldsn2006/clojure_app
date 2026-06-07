(ns clojure_app.service
  (:require [clojure_app.view :as view]
            [clojure_app.api  :as api])
)


(defn user_data []
  (view/print_msg "\n=======================================")
  (view/print_msg "           DADOS DO USUARIO              ")
  (view/print_msg "=======================================\n")
  (view/print_msg "1. Consultar dados")
  (view/print_msg "2. Atualizar dados")
  (view/print_msg "0. Voltar")
  (view/print_msg "Selecione a opcao desejada: ")

  (let [option (view/read_input)]
    (case option
      "1" (view/print_msg (api/get_req "http://localhost:3000/user_data")) ; TODO GET
      "2" (let [user_name (view/read_with_msg "Nome: ")
                age       (Integer/parseInt (view/read_with_msg "Idade: "))
                height    (Integer/parseInt (view/read_with_msg "Altura (cm): "))
                weight    (Integer/parseInt (view/read_with_msg "Peso (kg): "))
                sex       (view/read_with_msg "Sexo (F/M): ")]
        (view/print_msg (api/post_req "http://localhost:3000/user_data"
                                      {:user_name user_name :age age :height height :weight weight :sex sex})) ; TODO POST
      )
      "0" nil ; voltar para o menu
      (view/print_msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)


(defn food []
  (view/print_msg "\n=======================================")
  (view/print_msg "           REGISTRAR GANHO               ")
  (view/print_msg "=======================================\n")
  (view/print_msg "1. Registrar")
  (view/print_msg "0. Voltar")
  (view/print_msg "Selecione a opcao desejada: ")

  (let [option (view/read_input)]
    (case option
      "1" (let [food_name  (view/read_with_msg "Alimento: ")
                food_value (Integer/parseInt (view/read_with_msg "Quantidade (g): "))
                date       (view/read_with_msg "Data (dd/MM/yyyy): ")]
        (view/print_msg (api/post_req "http://localhost:3000/food"
                                      {:food_name food_name :food_value food_value :date date})) ; TODO POST
      )
      "0" nil ; voltar para o menu
      (view/print_msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)


(defn activity []
  (view/print_msg "\n=======================================")
  (view/print_msg "           REGISTRAR PERDA               ")
  (view/print_msg "=======================================\n")
  (view/print_msg "1. Registrar")
  (view/print_msg "0. Voltar")
  (view/print_msg "Selecione a opcao desejada: ")

  (let [option (view/read_input)]
    (case option
      "1" (let [activity_name  (view/read_with_msg "Atividade: ")
                activity_value (Integer/parseInt (view/read_with_msg "Duracao (m): "))
                date           (view/read_with_msg "Data (dd/MM/yyyy): ")]
        (view/print_msg (api/post_req "http://localhost:3000/activity"
                                      {:activity_name activity_name :activity_value activity_value :date date})) ; TODO POST
      )
      "0" nil ; voltar para o menu
      (view/print_msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)


(defn statement []
  (view/print_msg "\n=======================================")
  (view/print_msg "        EXTRATO DE TRANSACOES            ")
  (view/print_msg "=======================================\n")
  (view/print_msg "1. Consultar todas transacoes")
  (view/print_msg "2. Consultar por periodo")
  (view/print_msg "0. Voltar")
  (view/print_msg "Selecione a opcao desejada: ")

  (let [option (view/read_input)]
    (case option
      "1" (view/print_msg (api/get_req "http://localhost:3000/statement")) ; TODO GET
      "2" (let [start_date (view/read_with_msg "Data Inicial (dd/MM/yyyy): ")
                end_date   (view/read_with_msg "Data Final (dd/MM/yyyy): ")]
        (view/print_msg (api/post_req "http://localhost:3000/statement"
                                      {:start_date start_date :end_date end_date})) ; TODO POST
      )
      "0" nil ; voltar para o menu
      (view/print_msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)


(defn balance []
  (view/print_msg "\n=======================================")
  (view/print_msg "          SALDO DE CALORIAS              ")
  (view/print_msg "=======================================\n")
  (view/print_msg "1. Consultar saldo atual")
  (view/print_msg "2. Consultar saldo por periodo")
  (view/print_msg "0. Voltar")
  (view/print_msg "Selecione a opcao desejada: ")
  (let [option (view/read_input)]
    (case option
      "1" (view/print_msg (api/get_req "http://localhost:3000/balance")) ; TODO GET
      "2" (let [start_date (view/read_with_msg "Data Inicial (dd/MM/yyyy): ")
                end_date   (view/read_with_msg "Data Final (dd/MM/yyyy): ")]
            (view/print_msg (api/post_req "http://localhost:3000/balance"
                                          {:start_date start_date :end_date end_date})) ; TODO POST
      )
      "0" nil ; voltar para o menu
      (view/print_msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)