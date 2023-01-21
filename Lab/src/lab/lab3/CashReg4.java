package lab.lab3;

/**
 A cash register totals up sales and computes change due.
 Version for CS 455 lab 3.  Modified from version from Big Java, 4th
 ed.  Note: in the 5th edition of the textbook the code is virtually
 the same except that the method called enterPayment here, is called
 receivePayment in the 5th edition.
 Changes [made by CMB]:
 Added getTotal() accessor function.
 Made constants private.
 Ex:
 CashReg register = new CashReg();
 register.recordPurchase(0.59);  // ring something up
 register.recordPurchase(1.99);  // ring up another item
 register.recordPurchase(5.0);   // ring up a third item
 double tot = register.getTotal();    // total of purchases so far: 7.58
 register.enterPayment(10,0,0,0,0);  // customer pays with a 10
 int change = register.giveChange();  // compute change owed: 2.42
 // and zeroes out register
 register.recordPurchase(1.0);  // now we start ringing up someone else . . .
 */
public class CashReg4 {

    private int purchase;
    private Change payment;

    /**
     Constructs a cash register with no money in it.
     */
    public CashReg4() {
        purchase = 0;
        payment = new Change();
    }

    /**
     Records the purchase price of an item.
     @param amount the price of the purchased item
     */
    public void recordPurchase(double amount) {
        purchase += Math.round(amount * 100);
    }

    /**
     Gets total of all purchases made.
     */
    public double getTotal() {
        return purchase / 100.0;
    };

    /**
     * Receive payment
     * @param change
     */
    public void receivePayment(Change change) {
        payment = change;
    }

    /**
     Computes the change due and resets the machine for the next customer.
     @return the change due to the customer
     */
    public Change giveChange() {
        int changeTotal = this.payment.totalValue() - purchase;
        int dollars = 0, quarters = 0, dimes = 0, nickels = 0, pennies = 0;
        while(changeTotal > 0){
            if(changeTotal >= Change.DOLLAR_VALUE){
                changeTotal -= Change.DOLLAR_VALUE;
                dollars++;
            }
            else if(changeTotal >= Change.QUARTER_VALUE){
                changeTotal -= Change.QUARTER_VALUE;
                quarters++;
            }
            else if(changeTotal >= Change.DIME_VALUE){
                changeTotal -= Change.DIME_VALUE;
                dimes++;
            }
            else if(changeTotal >= Change.NICKEL_VALUE){
                changeTotal -= Change.NICKEL_VALUE;
                nickels++;
            }
            else{
                changeTotal -= Change.PENNY_VALUE;
                pennies++;
            }
        }
        purchase = 0;
        return new Change(dollars, quarters, dimes, nickels, pennies);
    }

}
