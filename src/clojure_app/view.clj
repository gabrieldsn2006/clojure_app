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