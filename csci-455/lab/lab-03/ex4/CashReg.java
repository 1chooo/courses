/**
 * A cash register totals up sales and computes change due.
 * 
 * Version for CS 455 lab 3. Modified from version from Big Java, 6th
 * ed.
 * 
 * Changes [made by CMB]:
 * 
 * This version of the class is called CashReg (instead of CashRegister)
 * Added getTotal() accessor function.
 * Made constants private.
 * 
 * Ex:
 * CashReg register = new CashReg();
 * register.recordPurchase(0.59); // ring something up
 * register.recordPurchase(1.99); // ring up another item
 * register.recordPurchase(5.0); // ring up a third item
 * double tot = register.getTotal(); // total of purchases so far: 7.58
 * register.receivePayment(10,0,0,0,0); // customer pays with a 10
 * int change = register.giveChange(); // compute change owed: 2.42
 * // and zeroes out register
 * 
 * register.recordPurchase(1.0); // now we start ringing up someone else . . .
 * 
 */
public class CashReg {
   private static final int DOLLAR_VALUE = 100;
   private static final int QUARTER_VALUE = 25;
   private static final int DIME_VALUE = 10;
   private static final int NICKEL_VALUE = 5;
   private static final int PENNY_VALUE = 1;

   private int purchase;
   private int payment;

   /**
    * Constructs a cash register with no money in it.
    */
   public CashReg() {
      purchase = 0;
      payment = 0;
   }

   /**
    * Records the purchase price of an item.
    * 
    * @param amount the price of the purchased item
    */
   public void recordPurchase(double amount) {
      purchase += Math.round(amount * DOLLAR_VALUE); // convert dollars to cents
      // purchase = (int) purchase + Math.round(amount * DOLLAR_VALUE); // error
   }

   /**
    * Gets total of all purchases made.
    */
   public double getTotal() {
      return (double) purchase / DOLLAR_VALUE;
   };

   /**
    * Enters the payment received from the customer.
    * 
    * @param money the change object representing the payment
    */
   public void receivePayment(Change money) {
        payment = money.totalValue();
   }

   /**
    * Computes the change due and resets the machine for the next customer.
    * 
    * @return the change due to the customer as a Change object
    */
   public Change giveChange() {
        int changeAmount = payment - purchase;
        
        // Calculate the number of each denomination
        int dollars = changeAmount / DOLLAR_VALUE;
        changeAmount = changeAmount % DOLLAR_VALUE;
        
        int quarters = changeAmount / QUARTER_VALUE;
        changeAmount = changeAmount % QUARTER_VALUE;
        
        int dimes = changeAmount / DIME_VALUE;
        changeAmount = changeAmount % DIME_VALUE;
        
        int nickels = changeAmount / NICKEL_VALUE;
        changeAmount = changeAmount % NICKEL_VALUE;
        
        int pennies = changeAmount / PENNY_VALUE;
        
        // Reset the register for the next customer
        purchase = 0;
        payment = 0;
        
        return new Change(dollars, quarters, dimes, nickels, pennies);
   }
}
