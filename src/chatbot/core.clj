(
	ns 
		chatbot.core
		(:gen-class)
		(:require [chatbot.chatbot :as chatbot])
)

(
  	defn -main
  	[& args]
  	(println (chatbot/process))
)
