package tikaso.joosakur.homedoctor.formvalidation;

import javax.validation.constraints.*;

public class DoctorFormObject {

    @NotNull(message="Please insert first name.")
    @Size(min=2, max=15, message="Name must be 2-15 characters long.")
    @Pattern(regexp="[a-zA-ZäöÄÖ][a-z A-ZäöÄÖ\\-]+", message="Name should start with an alphabet and contain only alphabets, spaces and hyphen.")
    private String firstName;
    
    @NotNull(message="Please insert last name.")
    @Size(min=2, max=20, message="Name must be 2-20 characters long.")
    @Pattern(regexp="[a-zA-ZäöÄÖ][a-z A-ZäöÄÖ\\-]+", message="Name should start with an alphabet and contain only alphabets, spaces and hyphen.")
    private String lastName;

    @NotNull(message="Please choose a username.")
    @Size(min=4, max=15, message="username must be 4-15 characters long.")
    @Pattern(regexp="[a-zA-Z][a-zA-Z0-9]+", message="Username should contain only alphanumeric characters and start with a letter.")
    private String username;
    
    @NotNull(message="Please choose a password.")
    @Size(min=6, max=15, message="Password must be 6-15 characters long.")
    @Pattern(regexp="[a-zA-Z0-9]+", message="Password should contain only alphanumeric characters.")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}