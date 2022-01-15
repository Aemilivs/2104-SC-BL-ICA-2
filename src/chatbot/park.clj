(
    ns 
        chatbot.park
        (:require [clojure.data.json :as json])
)
  
    (
        defn read-data
        "Read data"
        []
        (
            json/read-str
            (
                slurp "resources/data-en.json"
            )
        )
    )

    (
        defn get-park-titles
        "Get park titles"
        []
        (
            set 
            (
                keys (read-data)
            )
        )
    )

    (
        defn get-park-property
        "Get park titles"
        [
            title
            property
        ]
        (
            (
                get 
                    (read-data) 
                    title
            ) 
                property
        )
    )

    (
        defn get-wc
        "Get whether wc is available in a park."
        [title]
        (
            get-park-property 
                title
                "wc" 
        )
    )

    (
        defn get-attractions
        "Retrieve the attractions of a park."
        [title]
        (
            get-park-property 
                title
                "attractions" 
        )
    )

    (
        defn get-biking
        "Get whether biking is possible in a park."
        [title]
        (
            get-park-property 
                title
                "biking" 
        )
    )

    (
        defn get-skating
        "Get whether skating is possible in a park."
        [title]
        (
            get-park-property 
                title
                "skating" 
        )
    )

    (
        defn get-sports
        "Get whether sports are possible in a park."
        [title]
        (
            get-park-property 
                title
                "sports" 
        )
    )

    (
        defn get-playground
        "Get whether biking is possible in a park."
        [title]
        (
            get-park-property 
                title
                "playground" 
        )
    )

    (
        defn get-dogs
        "Get whether one can walk a dog in a park."
        [title]
        (
            get-park-property 
                title
                "dogs" 
        )
    )

    (
        defn get-parking
        "Get whether parking is available in a park."
        [title]
        (
            get-park-property 
                title
                "parking" 
        )
    )
