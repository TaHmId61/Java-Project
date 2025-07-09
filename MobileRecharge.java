
package projectfiles;

import java.util.Scanner;

public class MobileRecharge {
    Scanner input = new Scanner(System.in);

    public void mobileRecharge() {
        System.out.print("Enter Your Mobile Number: ");
        String number = input.next();
        if (!Database.isRegistered(number)) {
            System.out.println("Number not registered.");
            return;
        }

        User user = Database.getUser(number);

        System.out.print("Enter Recharge Amount: ");
        double amount = input.nextDouble();
        
        
        System.out.print("Enter Receiver Number: ");
        String receiverNum = input.next();
        if (!Database.isRegistered(receiverNum)) {
            System.out.println("Receiver not registered.");
            return;
        }  

        System.out.print("Enter PIN: ");
        String pin = input.next();

        if (!user.getPin().equals(pin)) {
            System.out.println("Wrong PIN.");
            return;
        }

        if (user.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        user.deductBalance(amount);
        Database.saveUsers();
        System.out.println("Recharge of BDT " + amount + " successful. Confirmation from "+receiverNum);
    }
}

