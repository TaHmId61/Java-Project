
package projectfiles;

public class Admin {
    private static double adminBalance = 0;

    public static void addSendFee() {
        adminBalance += 5;
    }

    public static void addCashOutFee() {
        adminBalance += 10;
    }

    public static void showAdminBalance() {
        System.out.println("Admin Total Earnings: BDT " + adminBalance);
    }
    
     public static void saveAdminBalance() {
        Database.saveUsers();
    }
     
     public static void loadAdminBalance() {
        Database.loadUsers();
    }
}
