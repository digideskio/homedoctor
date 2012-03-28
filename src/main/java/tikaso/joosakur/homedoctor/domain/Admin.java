package tikaso.joosakur.homedoctor.domain;

public class Admin {
    private static String username = "admin";
    private static String password = "adminpass";

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }
    
}
