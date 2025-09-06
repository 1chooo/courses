# Exercise 1 (1 checkoff point)

Question 1.1. What was the result of the command?

/voc/work

Question 1.2. What was the result of the command?

Hello.java  README.md

Question 1.3. Predict what the results of the pwd command would be at this point. Verify your answer by trying it.

- Predict: /voc/work/ex1
- Answer: /voc/work/ex1

Question 1.4. Assuming you are still in the ex1 directory, write down two different commands that will get you to your home directory from there (i.e., will make your home directory your current directory). You can test them out by going back to the ex1 directory after trying each one.

1. cd ..
2. cd ex1

Question 1.5. Make sure you are in your home directory. Write down the command to list what's in the directory one level up from your home directory. Try it.

ls ..

Question 1.6. Assuming you don't know what directory you are starting from, write down a sequence of commands such that after they are done, the ex1 directory in your workspace has a copy of the file Hello.java from your home directory. Try out your command sequence. Use ls to check if it worked.

cp Hello.java ./ex1/Hello.java
cd ex1/ && ls

Question 1.7. Write down (and execute) the command(s) to make a directory in your home directory called lab1.

mkdir lab1
ls

Question 1.8. What does the last "cp" command above do?

It copies the `ex1/Hello.java` to `lab1/` because we have entered to `lab1` through `cd lab1`.  

Question 1.9. Assuming you are starting from your home directory write down and execute a single command that will get you into your ex1 directory.

cd lab1/ex1

Question 1.10. What directory did you just change to?

We are back in `/voc/work/` directory because `lab1` is in `/voc/work/` and `ex1` is in `lab1`.

Question 1.11. "cd" into the ex1 directory. Using relative path names as seen in the previous examples, write down and execute a single command to make a directory called foo that's also inside the lab1 directory (but that is not a subdirectory of ex1. By "a single command", we mean you will still be in the same directory (ex1) after making the new directory. (When you are done a listing of the lab1 directory should show both ex1 and foo.)

cd lab1/ex1/ && mkdir ../foo && ls ../

Question 1.12. Write down and execute a single command to get into the new "foo" directory.

cd ../foo/

Question 1.13. Write down and execute a single command to list the files in the "ex1" directory (i.e., without changing directories).

ls ../ex1/

# Exercise 2 (1 checkoff point)

# Exercise 3 (1 checkoff point)

Question 3.1. Copy and paste the text of the compiler error message into the README file.

```
Hello.java:3: error: ';' expected
        System.out.println("Hello world!")
                                          ^
1 error
```

```
Hello.java:3: error: unclosed string literal
        System.out.println("Hello world!)
                           ^
1 error
```

Question 3.2. Note the line number of the third error. Where in the program does it think this error is?

The third error is reported on line 3.

The third error is still reported on line 3, at the end of the System.out.println(...) statement.
The compiler thinks a semicolon (;) is missing there. This is a cascading error: the real problem was leaving out the closing quotation mark, but because the compiler couldn’t correctly interpret the line, it also reported a missing semicolon.

```
Hello.java:3: error: ')' or ',' expected
        System.out.println(Hello world!)
                                ^
Hello.java:3: error: not a statement
        System.out.println(Hello world!)
                                 ^
Hello.java:3: error: ';' expected
        System.out.println(Hello world!)
                                      ^
3 errors
```

# Exercise 4 (1 checkoff point)

# Exercise 5 (1 checkoff point)


