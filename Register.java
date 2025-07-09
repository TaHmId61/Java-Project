package projectfiles;

import java.util.Scanner;

public class Register {

    Scanner input = new Scanner(System.in);

    public void registerUser(String type) {
        System.out.print("Enter Mobile Number: ");
        String number = input.next();

        if (Database.isRegistered(number)) {
            System.out.println("This number is already registered.");
            return;
        }

        System.out.print("Set PIN: ");
        String pin = input.next();

        User user;
        
        if (type.equals("personal")) {
            user = new PersonalUser(number, pin);
        } else if (type.equals("agent")) {
            user = new AgentUser(number, pin);
        } else if (type.equals("merchant")) {
            user = new MerchantUser(number, pin);
        } else {
            System.out.println("Invalid user type.");
            return;
        }

        Database.registerUser(user);
        System.out.println("Registration successful.");
    }
}
