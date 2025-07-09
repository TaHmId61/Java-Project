
package projectfiles;

import java.io.*;
import java.util.*;

public class Database {

    private static final String FILE_PATH = "users.dat";
    private static HashMap<String, User> users = new HashMap<>();

    public static void loadUsers() {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            StringBuilder sb = new StringBuilder();
            int ch;

            while ((ch = fis.read()) != -1) {
                sb.append((char) ch);
            }

            String content = sb.toString();
            String[] lines = content.split("\\n");

            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

              
                line = line.replace("User[", "").replace("]", "");
                String[] parts = line.split(", ");

                String number = "", pin = "", type = "";
                double balance = 0.0;

                for (String part : parts) {
                    String[] keyVal = part.split("=");
                    String key = keyVal[0].trim();
                    String value = keyVal[1].trim();

                    switch (key) {
                        case "number":
                            number = value;
                            break;
                        case "pin":
                            pin = value;
                            break;
                        case "balance":
                            balance = Double.parseDouble(value);
                            break;
                        case "type":
                            type = value;
                            break;
                    }
                }

                User user = new User(number, pin, balance, type);
                users.put(number, user);
            }

    
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }


    public static void saveUsers() {
    try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
        for (User user : users.values()) {
            String userLine = user.toString() + "\n"; 
            fos.write(userLine.getBytes()); 
        }
          } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static boolean isRegistered(String number) {
        return users.containsKey(number);
    }

    public static User getUser(String number) {
        return users.get(number);
    }

    public static void registerUser(User user) {
        users.put(user.getNumber(), user);
        saveUsers();
    }

    public static Collection<User> getAllUsers() {
        return users.values();
    }
}
