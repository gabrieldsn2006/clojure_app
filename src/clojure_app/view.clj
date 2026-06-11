(ns clojure_app.view)


(defn read-input []
  (print ">> ")
  (flush)
  (read-line)
)

(defn read-with-msg [msg]
  (print msg)
  (flush)
  (read-line)
)

(defn print-msg [msg]
  (println msg)
  (flush) ; Garante que o texto apareça antes de esperar o input
)

(defn print-user-data [user]
  (println "Nome:"   (:user_name user))
  (println "Idade:"  (:age       user))
  (println "Altura:" (:height    user) "cm")
  (println "Peso:"   (:weight    user) "kg")
  (println "Sexo:"   (:sex       user))
  (flush)
)

(defn print-transaction [transaction]
  (let [kcal  (:kcal  transaction)
        name  (:name  transaction)
        value (:value transaction)
        date  (:date  transaction)]
    (if (pos? kcal)
      (println "Alimento:"  name ", Gramas:"     value ", Data:" date ", kcal:" kcal)
      (println "Atividade:" name ", Duracao:" value ", Data:" date ", kcal:" kcal)
    )
  )
  (flush)
)