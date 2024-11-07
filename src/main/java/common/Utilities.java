//package common;
//
//public class Utilities {
//    public static String getProjectPath() {
//        return "path của project là đây";
//    }
//}
package common;

import java.util.Random;

public class Utilities {

    public static String getRandomEmail() {
        String email = "user" + getRandomString(5) + "@example.com";
        return email;
    }

    public static String getRandomPassword() {
        return getRandomString(10); // Random password of 10 characters
    }

    private static String getRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < length) {
            int index = (int) (rnd.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static String getConfirmationLink(String email) {
        // Implement logic to retrieve confirmation link from email, e.g., from a mock email service
        return "http://example.com/confirm?token=12345";
    }

    public static String getResetPasswordLink(String email) {
        // Implement logic to retrieve reset password link from email, e.g., from a mock email service
        return "http://example.com/reset?token=12345";
    }
}
