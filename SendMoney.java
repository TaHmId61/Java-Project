
package projectfiles;

import java.util.Scanner;

public class SendMoney implements Transaction {
    Scanner input = new Scanner(System.in);

    @Override
    public void execute() {
        sendMoney();
    }
    
    public void sendMoney() {
        System.out.print("Enter Sender Number: ");
        String senderNum = input.next();
        if (!Database.isRegistered(senderNum)) {
            System.out.println("Sender not registered.");
            return;
        }

        User sender = Database.getUser(senderNum);
     
        System.out.print("Enter PIN: ");
        String pin = input.next();
        if (!sender.getPin().equals(pin)) {
            System.out.println("Invalid PIN.");
            return;
        }

        System.out.print("Enter Receiver Number: ");
        String receiverNum = input.next();
        if (!Database.isRegistered(receiverNum)) {
            System.out.println("Receiver not registered.");
            return;
        }

        User receiver = Database.getUser(receiverNum);
      
        System.out.print("Enter Amount: ");
        double amount = input.nextDouble();

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        sender.deductBalance(amount);
        receiver.addBalance(amount);
        Admin.addSendFee();
        Database.saveUsers();

        System.out.println("Money sent successfully from " + senderNum + " to " + receiverNum);
    }
}
