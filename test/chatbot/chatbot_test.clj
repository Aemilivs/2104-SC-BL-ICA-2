(ns chatbot.chatbot-test
  (:require [clojure.test :refer :all]
            [chatbot.chatbot :refer :all]))

  (
    deftest match-stromovka-title-test
    (
      testing 
      "Match closely resembling word with an existing park title - Stromovka"
      (
        is 
        (
          = 
          (match-subject "strmvk")
          "stromovka"
        )
      )
    )
  )

  (
    deftest match-petrin-title-test
    (
      testing 
      "Match closely resembling word with an existing park title - Petrin"
      (
        is 
        (
          = 
          (match-subject "ptrn")
          "petrin"
        )
      )
    )
  )

  (
    deftest match-kinskeho-zahrada-title-test
    (
      testing 
      "Match closely resembling word with an existing park title - Kinskeho Zahrada"
      (
        is 
        (
          = 
          (match-subject "kinskeho")
          "kinskeho-zahrada"
        )
      )
    )
  )