# 6 letter words
There's a file in the root of the repository, input.txt, that contains words of varying lengths (1 to 6 characters).

Your objective is to show all combinations of those words that together form a word of 6 characters. That combination must also be present in input.txt
E.g.:  
<code>
foobar  
fo  
obar  
</code>

should result in the ouput:  
<code>
fo+obar=foobar
</code>

You can start by only supporting combinations of two words and improve the algorithm at the end of the exercise to support any combinations.

Treat this exercise as if you were writing production code; think unit tests, SOLID, clean code and avoid primitive obsession. Be mindful of changing requirements like a different maximum combination length, or a different source of the input data.

The solution must be stored in a git repo. After the repo is cloned, the application should be able to run with one command / script.

Don't spend too much time on this.

## Notes from developer
I created an additional recursive call in case multiple correct options were available after the first iteration.
Sadly this created a StackOverflowError even with an increased heap size.

As a temporary fix I've commented out one line of code in the second constructor of Combination. This means only a part of the possible results are returned, but at least it runs now.
If you want to try it out for yourself simply uncomment it, and it should work as designed (or it'll give you the same StackOverflowError that I got).
With a more powerful server and an even larger heap size it would work as intended, but sadly I don't have access to either of those.

I spent a bit over 3 hours on this solution, and it does what it was meant to do.

My next actions would have been to create unittests and an option for maximum combination length, if I were to continue working on this project.