(
    ns 
        chatbot.chatbot
        (:require clojure.string)
        (:require [chatbot.decision-tree :as decision-tree])
        (:require chatbot.data)
)

(
    defn get-welcome-message
    "Get a welcome message"
    [tree]
    (
        format
            "I am a chatbot designed to help you in identifying %s.\nPlease answer to the questions with 'yes' and 'no', so that I can give you the most precise answer."
            (
                get
                    tree
                    "topic"
            )
    )
)

(
	defn greet
  	"Return user name"
  	[]
  	(
        println "Hello! What is your name?"
  	)
  	(
    let 
    [
        input (read-line)
    ]
    (
        println "Welcome, " input "!"
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
    defn recognize-response
    "Recognize whether the input is corresponding to given set of words."
    [
        input
        collection
    ]
    (
        let
        [
            words
            (
                clojure.string/split 
                    input 
                    #" "
            )
        ]
        (
            if 
            (
                < 
                    (count words) 
                    1
            )
            false
            (
                not
                (
                    nil?
                        (
                            some
                            (
                                fn
                                [word]
                                (
                                    some
                                        #(= % word)
                                        collection
                                )
                            )
                            words
                        )
                )
            )
        )
    )
)

(
    defn is-negative-response
    "Define whether the input is a negative response or not."
    [input]
    (
        recognize-response
            input
            chatbot.data/negative-responses
    )
)


(
    defn is-positive-response
    "Define whether the input is a positive response or not."
    [input]
    (
        recognize-response
            input
            chatbot.data/positive-responses
    )
)

(
    defn is-exit-sequence
    "Define whether the input is an exit sequence or not"
    [input]
    (
        recognize-response
            input
            chatbot.data/exit-words
    )
)

(
    defn read-answer
    "Read an answer from a user from the CLI"
    []
    (
        let
        [
            answer 
            (
                clojure.string/lower-case (read-line)
            )
        ]
        (
            if
                (
                    is-exit-sequence answer
                )
                (
                    do
                    (
                        println "Thank you for spending your time with me."
                    )
                    (
                        Thread/sleep (rand-int 1250)
                    )
                    (
                        System/exit 0
                    )
                )
                answer
        )
    )
)

(
    defn parse-answer
    "Parse the response in order to definitive boolean response from the user."
    []
    (
        loop
        [
            answer (read-answer)
        ]
        (
            let
            [
                answer-is-positive (is-positive-response answer)
                answer-is-negative (is-negative-response answer)
            ]
            (
                do
                (
                    if
                    (
                        or
                        (
                            and
                                answer-is-positive 
                                answer-is-negative
                        )
                        (
                            not
                            (
                                or
                                    answer-is-positive
                                    answer-is-negative
                            )
                        )
                    )
                    (
                        do
                        (
                            Thread/sleep (rand-int 1250)
                        )
                        (
                            println "I am sorry, I coulnd't understand your answer. Could you please rephrase it?"
                        )
                        (
                            recur (read-answer)
                        )
                    )
                    (
                        or
                            answer-is-positive
                            (not answer-is-negative)
                    )
                )
            )
        )
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
                answer (parse-answer)
            ]
            (
                if
                answer
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
                Thread/sleep (rand-int 500)
            )
            (
                greet
            )
            (
                Thread/sleep (rand-int 500)
            )
            (
                println
                (
                    get-welcome-message tree
                )
            )
            (
                println "If you intend to quit, please type 'quit'."
            )
            (
                Thread/sleep (rand-int 500)
            )
            (
                loop
                [
                    node (tree "root")
                ]
                (
                    do
                    (
                        Thread/sleep (rand-int 500)
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
                                    answer (parse-answer)
                                ]
                                (
                                    if
                                    answer
                                    (
                                        recur (tree "root")
                                    )
                                    (
                                        do
                                        (
                                            println "Thank you for spending your time with me."
                                        )
                                        (
                                            System/exit 0
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
)

(defn process
  "Process the text input and respond using pattern matchinng rules."
  []
  (process-decision-tree))
