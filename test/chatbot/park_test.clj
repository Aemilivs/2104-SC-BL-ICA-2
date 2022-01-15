(ns chatbot.park-test
  (:require [clojure.test :refer :all]
            [chatbot.park :refer :all]))

  (
    deftest read-data-first-key-test
    (
      testing 
      "JSON with park data is being read and first key is stromovka"
      (
        is 
        (
          = 
          "stromovka" 
          (first (get-park-titles))
        )
      )
    )
  )


  (
    deftest read-data-stromovka-playground-test
    (
      testing 
      "JSON with park data is being read and stromovka has a playground"
      (
        is 
        (
          = 
          true 
          (get-park-property "stromovka" "playground")
        )
      )
    )
  )