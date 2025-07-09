
package projectfiles;


import java.util.Scanner;

public class CashIn {
    Scanner input = new Scanner(System.in);

    public void cashIn() {
        System.out.print("Enter Your Number: ");
        String number = input.next();

        if (!Database.isRegistered(number)) {
            System.out.println("Number not registered.");
            return;
        }

        User user = Database.getUser(number);

        System.out.print("Enter Amount to Add: ");
        double amount = input.nextDouble();

        user.addBalance(amount);
        Database.saveUsers();

        System.out.println("Cash In Successful. BDT " + amount + " added to your account.");
    }
}
