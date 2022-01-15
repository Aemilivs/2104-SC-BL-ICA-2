(ns chatbot.responses-and-keywords)

(
    def keywords
    {
        "bicycle" "bicycle",
        "bike" "bicycle",
        "ride" "bicycle",
        "two-wheels" "bicycle",
        "playground" "playground",
        "kids" "playground",
        "wc" "wc",
        "public bathrooms" "wc",
        "attractions" "attractions",
        "sightseeings" "attractions",
        "skating" "skating",
        "sports" "sports",
        "activities" "sports",
        "fitness" "sports",
        "parking" "parking",
        "vehicle" "parking",
        "dogs" "dogs",
        "pets" "dogs"
    }
)

(
    def greetings
    '(
        "Hello! Please, state your question regarding parks of Prague. To exit, please write \"Bye!\"",
        "Hi! Feel free to ask me about parks of Prague. To end the chat, please type \"exit\".",
        "Welcome! I am glad to answer any question regarding parks of Prague. To quit, please type \"quit\""
    )
)

(
    def farewells
    '(
        "Thank you and goodbye!",
        "Bye!",
        "Farewell!"
    )
)

(
    def exit-words
    #{
        "bye",
        "exit",
        "quit"
    }
)

(
    def responses
    {
        "wc"
        {
            true
            '(
                "Yes, there are public bathrooms in {park}",
                "Yes! There is a toilet in {park}",
                "Sure! You can find a wc in{park}"
            )
            false
            '(
                "Unfortunatly no wc in {park}",
                "We appologize, {park}'s wc is closed for reconstruction"
            )
        }
        "attractions"
        {
            true
            '(
                "Yes, in {park} you can find: {attractions}",
                "Yes, a lot! There are the following attractions: {attractions}"
            )
            false
            '(
                "No, there are no any attractions in {park}",
                "Unfortunatly, main attraction is on reconstruction"
            )
        }
        "bicicle"
        {
            true 
            '(
                "You can ride bicycle in {park}",
                "There is a bicycle road in {park}",
                "{park} has the roads, you will be on two wheels"
            )
            false
            '(
                "Unfortunately, you can't ride bicycle in {park}.",
                "You can't ride bicycle in {park}"
            )
        },
        "skating"
        {
            true
            '(
                "Yes, there is free skatepark in {park}",
                "You can found publick outdoor skatepark in {park}"
            )
            false
            '(
                "No, there is no skating park in {park}",
                "No, skating is not allowed in {park}"
            )
        }
        "sports"
        {
            true
            '(
                "Different kind of outdoor sports and activities can be found in {park}",
                "Public fitness ground is located in {park}"
            )
            false
            '(
                "No dedicated sport grounds in {park}",
                "No sport grounds, but you can run around the {park}"
            )
        }
        "playground"
        {
            true
            '(
                "There is a playground in {park}", 
                "Kids can play in a playground in {park}"
            )
            false
            '(
                "Unfortunately, there is no playground in {park}",
                "We appologize, but playground in {park} is on reconstruction"
            )
        }
        "dogs"
        {
            true
            '(
                "Of course you can visit {park} with your good boy or girl",
                "You are welcome in {park} with your pet"
            )
            false
            '(
                "We appologize, but you can't walk the dog in {park}",
                "Dogs are not allowed in {park}"
            )
        }
        "parking"
        {
            true
            '(
                "Big free parking nearby {park}",
                "Yes, parking is available near {park}",
                "Sure, you can park you vehicle opposite to main entrance of {park}"
            )
            false
            '(
                "No free parking in {park}",
                "Parking in the adjacent street, free on weekends"
            )
        }
    }
)
