
package projectfiles;

import java.util.Scanner;

public class MyAccount {
    Scanner input = new Scanner(System.in);

    public void displayAccount() {
        System.out.print("Enter Your Number: ");
        String number = input.next();

        if (!Database.isRegistered(number)) {
            System.out.println("Number not registered.");
            return;
        }

        User user = Database.getUser(number);

        System.out.print("Enter PIN: ");
        String pin = input.next();

        if (!user.getPin().equals(pin)) {
            System.out.println("Wrong PIN. PLease Try Again..");
            return;
        }

        System.out.println("--- Account Info ---");
        System.out.println("Number: " + user.getNumber());
        System.out.println("Type: " + user.getType());
        System.out.println("Balance: BDT " + user.getBalance());
    }

    public void resetPIN() {
        System.out.print("Enter Number: ");
        String number = input.next();
        if (!Database.isRegistered(number)) {
            System.out.println("Not registered.");
            return;
        }

        User user = Database.getUser(number);

        System.out.print("Enter Old PIN: ");
        String oldPin = input.next();
        if (!user.getPin().equals(oldPin)) {
            System.out.println("Incorrect PIN.");
            return;
        }

        System.out.print("Enter New PIN: ");
        String newPin = input.next();
        user.setPin(newPin);
        Database.saveUsers();
        System.out.println("PIN updated.");
    }
}     