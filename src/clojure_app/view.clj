(ns clojure_app.view)


(defn read_input []
  (print ">> ")
  (flush)
  (read-line)
)

(defn read_with_msg [msg]
  (print msg)
  (flush)
  (read-line)
)

(defn print_msg [msg]
  (println msg)
  (flush) ; Garante que o texto apareça antes de esperar o input
)

(defn print_user_data [user]
  (println "Nome:"   (:user_name user))
  (println "Idade:"  (:age       user))
  (println "Altura:" (:height    user) "cm")
  (println "Peso:"   (:weight    user) "kg")
  (println "Sexo:"   (:sex       user))
  (flush)
)

(defn print_transaction [transaction]
  (let [kcal  (:kcal transaction)
        name  (:name transaction)
        value (:value transaction)
        date  (:date transaction)]
    (if (pos? kcal)
      (println "Alimento:"  name ", Qtd:"     value ", Data:" date ", kcal:" kcal)
      (println "Atividade:" name ", Duracao:" value ", Data:" date ", kcal:" kcal)
    )
  )
  (flush)
)