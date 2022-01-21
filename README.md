# Prague Park Guide Chatbot

This technical report presents one of the deliverables for the second part of the semestral project (ICA-2) in Symbolic Computation module. The ICA-2 expands on the basic working solution of the chatbot application presented in ICA-1, by implementing additional features. The assignment was completed in a team of 4 students.

## Executive Summary

The city of Prague liked our chatbot application and got it implemented. Nevertheless, after a few months of usage, the city would like us to enhance it with more interactive features, namely, they would like to provide the users with the possibility to identify animals, birds, trees, landmarks in the parks. They ask us to choose a domain of relevant interest and demonstrate on it how these enhanced features would work and thus allow A/B testing with the users to see how they like it.

The chosen domain of interest on which we decided to demonstrate the additional functionality of our basic chatbot application, is birds. The reason for this choice is probably the fact, that with increasing age, one starts to appreciate the seemingly unpopular activity of birdwatching, especially when one manages to disconnect.

### Aims

The aim of this second and final project phase is to present a working demonstration of potential feature expansion of the already approved basic chatbot application. The program needs to incorporate a symbolic artificial intelligence by implementing a suitable decision tree.

### Technologies

The technologies used during the project development were the following:
- Clojure 1.10.1 - functional dialect of the Lisp programming language running on the Java platform
- Leiningen 2.9.7 - Clojure project automation tool
- Visual Studio Code - source-code editor made by Microsoft
  - Calva: Clojure & ClojureScript Interactive Programming - extension for Visual Studio Code
- GitHub - development platform

## System

Following section documents the functional requirements, implementation and testing of the resulting solution.

### Program Requirements

The following features present a minimal viable product defined by the assignment:

- The program must be started by an appropriate command
- The program needs to be at least usable from the REPL environment
- A dialogue must be terminated with a suitable keyword
- The program uses questions in order to determine the correct answer to the domain problem
- The program incorporates symbolic artificial intelligence by implementing a decision tree

Example of expected program output:
```
(chatbot)
> Hello! Who are you?
Petr
> Hello Petr. What kind of bird did you see?
I saw a blackbird.
> What colour was its beak?
Black
> Then it was probably a crow.
> Any more questions?
Yes, do you know what is this bird on the image? <image file>
> That is also a crow.
```

### Implementation

We have continued with the development practices used in the first project phase by defining the individual tasks, which can be completed separately by individual team members. The following tasks were identified:

- Cleaning up the code from the first project phase
- Implementing the question and answer processing logic
- Implementing the decision tree based on positive/negative responses to questions
- Improve the introductory and exit sequences

The development started with cleaning up the code of the basic chatbot implemented in the first phase and stripping it off of unnecessary code for the purposes of the expanded functionality presentation. After the code simplification and cleanup, the core functionality of the additional feature expansion was programmed by implementing a new code for processing the response provided by the user. The program introduction sequence asks the user to provide a simple positive or negative answer to the currently presented question. Once this basic interaction functionality was confirmed, the code for reading the provided JSON file containing the decision tree of appropriate questions and answers to the selected domain has been implemented. For the purposes of this demonstration, the decision tree contains only three-level deep interactions. Finally a an exit sequence out of the interaction loop has been developed.

Overall sequence of the operational capabilities of the current program's state is as follows:

- Greeting the user and asking for the user's name
- Informing the user about answering either positively or negatively to the given question
- Parsing the user's answers to the questions and mapping them to the appropriate interaction node in the decision tree
- Looping the interaction until the end of the decision tree is reached and a final answer provided or until an exit word is recognized by the program

### Testing

The resulting application testing was performed both manually in Leiningen REPL environment and by using Leiningen testing functionality.

The result of manual test run:

![Image](img/test_run1.png)

The result of running Leiningen test files:



## Conclusions

The assignment gave us a chance of implementing a very simple symbolic AI based on a two-branched answer based decision tree. We have simplified and optimized the code from the first project phase and managed to adhere to the recommended version control practices better then at the start of the semester.

## References

- Higginbotham, Daniel. Clojure for the brave and true: learn the ultimate language and become a better programmer. No Starch Press, 2015
- Style guide - https://guide.clojure.style/
- Git best practices - https://dev.to/bholmesdev/git-github-best-practices-for-teamsopinionated-28h7
- Bird Atlas - https://temata.rozhlas.cz/priroda/ptaci?show-hidden-element=Podrobn%C3%A9+vyhled%C3%A1v%C3%A1n%C3%AD&field_term_environment_tid=7612681&field_term_size_tid=7612705&field_term_color_tid=7612728&url=&combine=
