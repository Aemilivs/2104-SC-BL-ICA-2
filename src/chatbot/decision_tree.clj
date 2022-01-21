(
    ns 
        chatbot.decision-tree
        (:require [clojure.data.json :as json])
)

(
    defn read-data
    "Read data"
    []
    (
        json/read-str
        (
            slurp "resources/decision-tree.json"
        )
    )
)
