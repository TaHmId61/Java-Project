package projectfiles;

import java.util.Scanner;

public class MainMethod {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Database.loadUsers();
        Register register = new Register();
        SendMoney sendMoney = new SendMoney();
        MobileRecharge recharge = new MobileRecharge();
        CashOut cashOut = new CashOut();
        CashIn cashIn = new CashIn();
        MyAccount myAcc = new MyAccount();
        Merchant merchant = new Merchant();

        while (true) {
            System.out.println("");
            System.out.println("---------------------------------------");
            System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
            System.out.println("   ==== WELCOME TO NIRAPOD-PAY ====    ");
            System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
            System.out.println("---------------------------------------");

            System.out.println("1. Register Personal");
            System.out.println("2. Register Agent");
            System.out.println("3. Register Merchant");
            System.out.println("4. Send Money");
            System.out.println("5. Mobile Recharge");
            System.out.println("6. Cash Out");
            System.out.println("7. Cash In");
            System.out.println("8. My Account");
            System.out.println("9. Reset PIN");
            System.out.println("10. Pay Merchant");
            System.out.println("11. Admin Balance Info");
            System.out.println("12. Exit");
            System.out.print("Enter Choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1: {
                    register.registerUser("personal");
                    break;
                }
                case 2: {
                    register.registerUser("agent");
                    break;
                }
                case 3: {
                    register.registerUser("merchant");
                    break;
                }
                case 4: {
                    sendMoney.sendMoney();
                    break;
                }
                case 5: {
                    recharge.mobileRecharge();
                    break;
                }
                case 6: {
                    cashOut.cashOut();
                    break;
                }
                case 7: {
                    cashIn.cashIn();
                    break;
                }
                case 8: {
                    myAcc.displayAccount();
                    break;
                }
                case 9: {
                    myAcc.resetPIN();
                    break;
                }
                case 10: {
                    merchant.payMerchant();
                    break;
                }
                case 11: {
                    Admin.showAdminBalance();
                    break;
                }
                case 12: {
                    System.out.println("Thanks for using NirapodPay.");

                    return;
                }
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
