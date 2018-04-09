# TypingMonkey

Code and exercise from [http://natureofcode.com/book/chapter-9-the-evolution-of-code/](http://natureofcode.com/book/chapter-9-the-evolution-of-code/) , the GitHub link is: https://github.com/shiffman/The-Nature-of-Code . 

An evolutionary algorithm that tries to "create" a word / phrase. 
You can watch the words in each "generation" be created and hopefully become closer and closer to the target.

Constants used (determine effectiveness):
| name | value |
|--|--|
| target | "Hello World." |
| possible characters | "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM 1234567890.,;:?!" |
| mutation rate | 0.001 |
| population size | 1000 |
| mating pool multiplication | 1000 |
| target threshold | 800 |
| max-generations | 30 |
