(ns clojure_app.view)

(defn title []
  (println "=======================================")
  (println "       CALCULADORA DE CALORIAS         ")
  (println "=======================================")
  (flush)
)

(defn menu []
  (println "\nEscolha uma opcao:")
  (println "1. Cadastrar/Consultar dados pessoais")
  (println "2. Registrar consumo de alimento (Ganho)")
  (println "3. Registrar atividade fisica (Perda)")
  (println "4. Consultar extrato de transacoes")
  (println "5. Consultar saldo de calorias")
  (println "0. Sair")
  (flush) ; Garante que o texto apareça antes de esperar o input
)

(defn read_input []
  (print ">> ")
  (flush)
  (read-line)
)

(defn print_msg [msg]
  (println msg)
  (flush)
)