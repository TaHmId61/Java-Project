
package projectfiles;

public class MerchantUser extends User {
    public MerchantUser(String number, String pin) {
        super(number, pin, "merchant");
    }
}
