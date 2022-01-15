(
  ns 
    chatbot.core
    (:gen-class)
    (:require [chatbot.chatbot :as chatbot])
    (:require [chatbot.responses-and-keywords :as data])
)
  
(
  defn prompt
  "Introduce CLI"
  []
  (
    do
      (
        let [input (read-line)]
        (
          do
            (
              Thread/sleep (rand-int 1250)
            )
            (
              println (chatbot/process input)
            )
            (recur)
        )
      )
  )
)

(
  defn -main
  [& args]
  (println (rand-nth data/greetings))
  (prompt)
)
