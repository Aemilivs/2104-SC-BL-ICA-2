(
    ns 
        chatbot.chatbot
        (:require clojure.string)
        (:require [chatbot.decision-tree :as decision-tree])
)

(
    defn get-welcome-message
    "Get a welcome message"
    [tree]
    (
        format
            "Hello! I am a chatbot designed to help you in identifying %s.\nPlease answer to the questions with 'yes' and 'no', so that I can give you the most precise answer."
            (
                get
                    tree
                    "topic"
            )
    )
)

(
    defn write-question
    "Print a question for a user in the CLI"
    [node]
    (
        println (node "query")
    )
)

(
    defn read-answer
    "Read an answer from a user from the CLI"
    []
    (
        clojure.string/lower-case (read-line)
    )
)

(
    defn process-node
    "Process a node."
    [node]
    (
        do
        (
            write-question node
        )
        (
            let
            [
                answer (read-answer)
            ]
            (
                if
                (
                    =
                        answer
                        "yes"
                )
                (
                    node "left"
                )
                (
                    node "right"
                )
            )
        )
    )
)

(
    defn process-decision-tree
    "Process a decision tree from resources."
    []
    (
        let
        [
            tree (chatbot.decision-tree/read-data)
        ]
        (
            do
            (
                println
                (
                    get-welcome-message tree
                )
            )
            (
                Thread/sleep (rand-int 1250)
            )
            (
                loop
                [
                    node (tree "root")
                ]
                (
                    do
                    (
                        Thread/sleep (rand-int 1250)
                    )
                    (
                        if
                        (
                            nil?
                            (
                                get
                                    node
                                    "result"
                            )
                        )
                        (
                            recur (process-node node)
                        )
                        (
                            do
                            (
                                println 
                                    "The answer is: "
                                    (
                                        get
                                            node
                                            "result"
                                    )
                            )
                            (
                                println "Would you like to identify something else?"
                            )
                            (
                                let
                                [
                                    answer (read-answer)
                                ]
                                (
                                    if
                                    (
                                        =
                                            answer
                                            "yes"
                                    )
                                    (
                                        recur (tree "root")
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    )
)

(
    defn process
    "Process the text input and respond using pattern matchinng rules."
    []
    (
        process-decision-tree
    )
)
