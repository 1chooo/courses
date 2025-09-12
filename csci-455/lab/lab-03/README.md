Name: Chunho Lin (Driver)
USC NetID: 3226964170
CSCI 455 Fall 2025

Name: Junhan Zhang (Scribe)
USC NetID: 9250642107
CSCI 455 Fall 2025
Lab 3

Note: On-campus students can put their answers to the lab questions in this file, or in a text file created in another text editor, or use a piece of paper they can show to their lab TA.  DEN students will need to put their answers in this README, so they will get submitted.

## Exercise 1 (1 checkoff point)

Question 1.1. The first set of tests has a sequence of two purchases recorded, a payment given, and then change given for that payment. Show a formula that describes how the expected result for the change given was arrived at for this first sequence. Show all purchase amounts and the payment amount in this formula. You will need to look at the code in CashRegTester.java to do this.

```java
register.recordPurchase(0.75);
register.recordPurchase(2.25);
```

purchase = 0.75 + 1.50 = 2.25

```java
register.receivePayment(2, 0, 5, 0, 0);
```

payment = 2 * (1.00) + 0 * (0.25) + 5 * (0.10) + 0 * (0.05) + 0 * (0.01) = 2.50

```java
register.giveChange()
```

change = payment - purchase = 2.50 - 2.25 = 0.25

---

Question 1.2. You should have gotten a round-off error in your results. Why do you get such an error? (You don't have to do any computations, just explain the issue.) Hint: this is discussed in section 4.1.1 of the textbook.

```bash
java CashRegTester

Total: 4.35
Expected: 4.35

Change: 0.6500000000000004
Expected: 0.65

Total: 0.75
Expected: 0.75

Total: 2.25
Expected: 2.25

Change: 0.25
Expected: 0.25

Total: 2.25
Expected: 2.25

Total: 21.5
Expected: 21.5

Change: 2.0
Expected: 2.0
```

5 - 4.35 = 0.6500000000000004

The type of dollars is `int`, but the type of purchase, payment, and change is `double`.

The problem arises because computers represent numbers in the binary number system. In the binary number system, there is no exact representation of the fraction 1/10, just as there is no exact representa tion of the fraction 1/3 = 0.33333 in the decimal number system.

4.35 * 100 we expected as 435.0, but it is actually stored as 434.99999999999994.

When we subtract 4.35 from 5, we get 0.6500000000000004 instead of the expected 0.65.

## Exercise 2 (1 checkoff point)


Question 2.1. What results do you get for the test you added in exercise 1. Is this the right answer?

Not the correct answer.

```bash
diff ex2.out ../ex1.out

1c1
< Total: 4.34
---
> Total: 4.35
4c4
< Change: 0.66
---
> Change: 0.6500000000000004
```

## Exercise 3 (1 checkoff point)

Question 3.1. Stating what directory you are starting from, show a single Unix command to copy the files as described.

cp *.java ../ex3/

```bash
java CashRegTester3

Total: 4.35
Expected: 4.35

Change: 0.65
Expected: 0.65

Total: 0.75
Expected: 0.75

Total: 2.25
Expected: 2.25

Change: 0.25
Expected: 0.25

Total: 2.25
Expected: 2.25

Total: 21.5
Expected: 21.5

Change: 2.0
Expected: 2.0
```

## Exercise 4 [optional] (1 checkoff point)

Question 4.1. What parts of the results don't match the expected output?

In the stub version (ex4stub.out):
1. All change amounts show 0.0 instead of expected values (0.65, 0.25, 2.0)
2. Purchase totals keep accumulating instead of resetting after each transaction
3. Change objects always return all zeros: `Change[dollars=0,quarters=0,dimes=0,nickels=0,pennies=0]`

```bash
⚡ java CashRegTester4

Total: 4.35
Expected: 4.35

Payment given: Change[dollars=5,quarters=0,dimes=0,nickels=0,pennies=0]
Change[dollars=0,quarters=0,dimes=0,nickels=0,pennies=0]
Change total: 0.0
Expected: 0.65

Total: 5.1
Expected: 0.75

Total: 6.6
Expected: 2.25

Payment given: Change[dollars=2,quarters=0,dimes=5,nickels=0,pennies=0]
Change[dollars=0,quarters=0,dimes=0,nickels=0,pennies=0]
Change total: 0.0
Expected: 0.25

Total: 8.85
Expected: 2.25

Total: 28.1
Expected: 21.5

Payment given: Change[dollars=23,quarters=2,dimes=0,nickels=0,pennies=0]
Change[dollars=0,quarters=0,dimes=0,nickels=0,pennies=0]
Change total: 0.0
Expected: 2.0
```

```bash
⚡ java CashRegTester4
Total: 4.35
Expected: 4.35

Payment given: Change[dollars=5,quarters=0,dimes=0,nickels=0,pennies=0]
Change[dollars=0,quarters=2,dimes=1,nickels=1,pennies=0]
Change total: 0.65
Expected: 0.65

Total: 0.75
Expected: 0.75

Total: 2.25
Expected: 2.25

Payment given: Change[dollars=2,quarters=0,dimes=5,nickels=0,pennies=0]
Change[dollars=0,quarters=1,dimes=0,nickels=0,pennies=0]
Change total: 0.25
Expected: 0.25

Total: 2.25
Expected: 2.25

Total: 21.5
Expected: 21.5

Payment given: Change[dollars=23,quarters=2,dimes=0,nickels=0,pennies=0]
Change[dollars=2,quarters=0,dimes=0,nickels=0,pennies=0]
Change total: 2.0
Expected: 2.0
```


```bash
⚡ java ChangeTester
Total value[exp 0] = 0
Change[dollars=0,quarters=0,dimes=0,nickels=0,pennies=0]
Total value[exp 354] = 354
```
