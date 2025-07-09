
package projectfiles;

import java.util.Scanner;

public class CashOut implements Transaction {
    Scanner input = new Scanner(System.in);

    
    @Override
     public void execute() {
        cashOut();
    }
     
    public void cashOut() {
        System.out.print("Enter Your Number: ");
        String userNum = input.next();
        if (!Database.isRegistered(userNum)) {
            System.out.println("Number not registered.");
            return;
        }

        User user = Database.getUser(userNum);

        System.out.print("Enter Agent Number: ");
        String agentNum = input.next();
        if (!Database.isRegistered(agentNum) || !Database.getUser(agentNum).getType().equals("agent")) {
            System.out.println("Invalid agent number.");
            return;
        }

        User agent = Database.getUser(agentNum);

        System.out.print("Enter Amount: ");
        double amount = input.nextDouble();
        double total = amount + 10.0;

        System.out.print("Enter PIN: ");
        String pin = input.next();
        if (!user.getPin().equals(pin)) {
            System.out.println("Wrong PIN.");
            return;
        }

        if (user.getBalance() < total) {
            System.out.println("Insufficient balance.");
            return;
        }

        user.deductBalance(total);
        agent.addBalance(amount);
        Admin.addCashOutFee();
        Database.saveUsers();

        System.out.println("Cash out of BDT " + amount + " completed. Confirmation from "+agentNum);
    }
}
