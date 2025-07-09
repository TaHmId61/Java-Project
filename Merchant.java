package projectfiles;

import java.util.Scanner;

public class Merchant implements Transaction {

    Scanner input = new Scanner(System.in);

    @Override
    public void execute() 
    {
        payMerchant();
    }

    public void payMerchant() {
        System.out.print("Enter Your Number: ");
        String userNum = input.next();

        if (!Database.isRegistered(userNum)) 
        {
            System.out.println("User not registered.");
            return;
        }

        User user = Database.getUser(userNum);

        System.out.print("Enter Merchant Number: ");
        String merchNum = input.next();

        if (!Database.isRegistered(merchNum) || !Database.getUser(merchNum).getType().equals("merchant")) 
        {
            System.out.println("Invalid merchant.");
            return;
        }

        User merchant = Database.getUser(merchNum);

        System.out.print("Enter Amount: ");
        double amount = input.nextDouble();

        System.out.print("Enter PIN: ");
        String pin = input.next();
        if (!user.getPin().equals(pin)) 
        {
            System.out.println("Wrong PIN.");
            return;
        }

        if (user.getBalance() < amount)
        {
            System.out.println("Insufficient balance.");
            return;
        }

        user.deductBalance(amount);
        merchant.addBalance(amount);
        Database.saveUsers();
        System.out.println("Payment of BDT " + amount + " to Merchant successful. Confirmation from "+merchNum);
    }
}
