Name: Chunho Lin (Scribe)
USC NetID: 3226964170
CSCI 455 Fall 2025

Name: Junhan Zhang (Driver)
USC NetID: 9250642107
CSCI 455 Fall 2025
Lab 2

Note: All students (or partnerships) should put their answers to the lab questions in this file.

## Exercise 1 (1 checkoff point)

Question 1.0 In the README file (or lab write-up), put the first and last names and the roles (driver/scribe) of each of the partners, the course (CSCI 455) and lab number (Lab 2).

Question 1.1 What import statement is necessary to use the LocalDate class?

import java.time.LocalDate

Question 1.2 In your README, write a statement to create a LocalDate for the date January 20, 1995:    put the date in a variable called myDate.

LocalDate myDate = LocalDate.of(1995, 1, 20);

Question 1.3 Write down a statement (or statements) to print out myDate: it should be formatted as follows: 1/20/1995

System.out.println(myDate.getMonthValue() + "/" + myDate.getDayOfMonth() + "/" + myDate.getYear());

Question 1.4 Write down a statement that creates a new date 20 days later than myDate. Call this date later. (We're looking for something that would work no matter what date we started with.)

LocalDate later = myDate.plusDays(20);

Question 1.5 Suppose, instead, you wanted to change myDate to one 20 days later, Write down a statement to accomplish this. (We're looking for something that would work no matter what the old value of the date was.)

myDate = myDate.plusDays(20);

## Exercise 2 (1 checkoff point)

Question 2.1 Describe two compile errors that you got while developing this code and their fixes. (It's ok if both errors had the same high-level message, e.g., "cannot find symbol".)

```
Test.java:5: error: cannot find symbol
     myDate = LocalDate.of(1995, 1, 20);
     ^
  symbol:   variable myDate
  location: class Test
1 error
```

The error is because We forgot to announce `myDate` as a `LocalDate` object. The fix is to add the `LocalDate` in front of `myDate`.

```
Test.java:9: error: cannot find symbol
    System.out.println(myDate.getMonthValue() + "/" + myDate.getDayOfMonth() + "/" + myDate.getYear);
                                                                                           ^
  symbol:   variable getYear
  location: variable myDate of type LocalDate
1 error
```

The error is because We forgot to add "()" after getYear. The fix is to change getYear to getYear().

## Exercise 3 (1 checkoff point)

Question 3.1 Describe two compile errors that you got and their fixes while developing this code.

Question 3.2 Devise three test cases (not the one above) for which you and the TA already know the answer, to help verify that your code is working correctly. Describe these test cases and the expected results in the README. Then try out your test cases to help verify your program works properly.

```
Enter your birth month [1..12]: 1
Enter your birth day of month: 1
Enter your birth year [4-digit year]: 1995
```

*Your birthday has already happened this year.*

```
Enter your birth month [1..12]: 9
Enter your birth day of month: 27
Enter your birth year [4-digit year]: 2026
```

*Your birthday has not yet happened this year.*

```
Enter your birth month [1..12]: 9
Enter your birth day of month: 27
Enter your birth year [4-digit year]: 2025
```

*Your birthday has not yet happened this year.*

```
Enter your birth month [1..12]: 9
Enter your birth day of month: 5
Enter your birth year [4-digit year]: 2025
```

*Your birthday has not yet happened this year.*

## Exercise 4 (1 checkoff point)

```
Enter your birth month [1..12]: 9
Enter your birth day of month: 30
Enter your birth year [4-digit year]: 1991
```

*Your birthday has not yet happened this year.*
*You are 33 years old.*

```
Enter your birth month [1..12]: 9
Enter your birth day of month: 8
Enter your birth year [4-digit year]: 2026
```

*Your birthday has not yet happened this year.*
*You are not born yet.*

```
Enter your birth month [1..12]: 9
Enter your birth day of month: 2
Enter your birth year [4-digit year]: 2024
```

*Your birthday has already happened this year.*
*You are 1 years old.*

```
Enter your birth month [1..12]: 9
Enter your birth day of month: 4
Enter your birth year [4-digit year]: 2025
```

*Your birthday has already happened this year.*
*You are 1 year old.*
*Happy birthday!*

