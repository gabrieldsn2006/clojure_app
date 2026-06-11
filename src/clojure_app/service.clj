(ns clojure_app.service
  (:require [clojure_app.view :as view]
            [clojure_app.api  :as api])
)


(defn user-data []
  (view/print-msg "\n=======================================")
  (view/print-msg "           DADOS DO USUARIO              ")
  (view/print-msg "=======================================\n")
  (view/print-msg "1. Consultar dados")
  (view/print-msg "2. Atualizar dados")
  (view/print-msg "0. Voltar")
  (view/print-msg "Selecione a opcao desejada: ")

  (let [option (view/read-input)]
    (case option
      "1" (view/print-user-data (api/get-req "http://localhost:3000/user_data"))
      "2" (let [user-name (view/read-with-msg "Nome: ")
                age       (Integer/parseInt (view/read-with-msg "Idade: "))
                height    (Integer/parseInt (view/read-with-msg "Altura (cm): "))
                weight    (Integer/parseInt (view/read-with-msg "Peso (kg): "))
                sex       (view/read-with-msg "Sexo (F/M): ")]
        (view/print-msg (:res (api/post-req "http://localhost:3000/user_data"
                                            {:user_name user-name :age age :height height :weight weight :sex sex})))
      )
      "0" nil ; voltar para o menu
      (view/print-msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)


(defn food []
  (view/print-msg "\n=======================================")
  (view/print-msg "           REGISTRAR GANHO               ")
  (view/print-msg "=======================================\n")
  (view/print-msg "1. Registrar")
  (view/print-msg "0. Voltar")
  (view/print-msg "Selecione a opcao desejada: ")

  (let [option (view/read-input)]
    (case option
      "1" (let [food-name  (view/read-with-msg "Alimento: ")
                food-value (Integer/parseInt (view/read-with-msg "Quantidade (g): "))
                date       (view/read-with-msg "Data (dd/MM/yyyy): ")]
        (try
          (view/print-msg (:res (api/post-req "http://localhost:3000/food"
                                              {:food_name food-name :food_value food-value :date date})))
          (catch Exception e (view/print-msg "ERRO na API: o alimento pode nao ter sido encontrado"))
        )
      )
      "0" nil ; voltar para o menu
      (view/print-msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)


(defn activity []
  (view/print-msg "\n=======================================")
  (view/print-msg "           REGISTRAR PERDA               ")
  (view/print-msg "=======================================\n")
  (view/print-msg "1. Registrar")
  (view/print-msg "0. Voltar")
  (view/print-msg "Selecione a opcao desejada: ")

  (let [option (view/read-input)]
    (case option
      "1" (let [activity-name  (view/read-with-msg "Atividade: ")
                activity-value (Integer/parseInt (view/read-with-msg "Duracao (m): "))
                date           (view/read-with-msg "Data (dd/MM/yyyy): ")]
        (try
          (view/print-msg (:res (api/post-req "http://localhost:3000/activity"
                                              {:activity_name activity-name :activity_value activity-value :date date})))
          (catch Exception e (view/print-msg "ERRO na API: a atividade pode nao ter sido encontrada"))
        )
      )
      "0" nil ; voltar para o menu
      (view/print-msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)


(defn transactions []
  (view/print-msg "\n=======================================")
  (view/print-msg "        EXTRATO DE TRANSACOES            ")
  (view/print-msg "=======================================\n")
  (view/print-msg "1. Consultar todas transacoes")
  (view/print-msg "2. Consultar por periodo")
  (view/print-msg "0. Voltar")
  (view/print-msg "Selecione a opcao desejada: ")

  (let [option (view/read-input)]
    (case option
      "1" (run! view/print-transaction (api/get-req "http://localhost:3000/transactions"))
      "2" (let [start-date (view/read-with-msg "Data Inicial (dd/MM/yyyy): ")
                end-date   (view/read-with-msg "Data Final (dd/MM/yyyy): ")]
        (run! view/print-transaction (api/post-req "http://localhost:3000/transactions"
                                                   {:start_date start-date :end_date end-date}))
      )
      "0" nil ; voltar para o menu
      (view/print-msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)


(defn balance []
  (view/print-msg "\n=======================================")
  (view/print-msg "          SALDO DE CALORIAS              ")
  (view/print-msg "=======================================\n")
  (view/print-msg "1. Consultar saldo atual")
  (view/print-msg "2. Consultar saldo por periodo")
  (view/print-msg "0. Voltar")
  (view/print-msg "Selecione a opcao desejada: ")
  (let [option (view/read-input)]
    (case option
      "1" (view/print-msg (api/get-req "http://localhost:3000/balance"))
      "2" (let [start-date (view/read-with-msg "Data Inicial (dd/MM/yyyy): ")
                end-date   (view/read-with-msg "Data Final (dd/MM/yyyy): ")]
        (view/print-msg (api/post-req "http://localhost:3000/balance"
                                      {:start_date start-date :end_date end-date}))
      )
      "0" nil ; voltar para o menu
      (view/print-msg "Opcao invalida!")
    )
    (if (= option "0")
      nil ; voltar para o menu
      (recur)
    )
  )
)