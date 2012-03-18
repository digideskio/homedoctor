package tikaso.joosakur.homedoctor.formvalidation;

import javax.validation.constraints.*;

public class CustomerFormObject {

    @NotNull(message="Please insert your first name.")
    @Size(min=2, max=15, message="Name must be 2-15 characters long.")
    @Pattern(regexp="[a-zA-ZäöÄÖ][a-z A-ZäöÄÖ\\-]+", message="Name should start with an alphabet and contain only alphabets, spaces and hyphen.")
    private String firstName;
    
    @NotNull(message="Please insert your last name.")
    @Size(min=2, max=20, message="Name must be 2-20 characters long.")
    @Pattern(regexp="[a-zA-ZäöÄÖ][a-z A-ZäöÄÖ\\-]+", message="Name should start with an alphabet and contain only alphabets, spaces and hyphen.")
    private String lastName;
    
    @NotNull(message="Please insert the city.")
    @Size(min=2, max=20, message="City name must be 2-20 characters long.")
    @Pattern(regexp="[a-zA-ZäöÄÖ][a-z A-ZäöÄÖ\\-]+", message="Name should start with an alphabet and contain only alphabets, spaces and hyphen.")
    private String city;
    
    @NotNull(message="Please insert your street address.")
    @Size(min=2, max=25, message="Address must be 2-25 characters long.")
    @Pattern(regexp="[a-zA-ZäöÄÖ][a-z A-Z0-9äöÄÖ\\-]+", message="Name should start with an alphabet and contain only alphanumeric characters, spaces and hyphen.")
    private String streetAddress;
    
    @NotNull(message="Please insert your phone number.")
    @Size(min=6, max=13, message="Number must be 6-13 characters long.")
    @Pattern(regexp="(\\+)?[0-9]+", message="Invalid number. Please do not use spaces.")
    private String phoneNumber;
    
    @NotNull(message="Please insert day of birth.")
    @Digits(integer=2, fraction=0, message="Invalid day.")
    @Min(value=1, message="Invalid day.")
    @Max(value=31, message="Invalid day.")
    private int dayBorn;
    
    @NotNull(message="Please insert month of birth.")
    @Digits(integer=2, fraction=0, message="Invalid month.")
    @Min(value=1, message="Invalid month.")
    @Max(value=12, message="Invalid month.")
    private int monthBorn;
    
    @NotNull(message="Please insert year of birth.")
    @Digits(integer=4, fraction=0, message="Invalid year")
    @Min(value=1900, message="Invalid year.")
    @Max(value=2050, message="Invalid year.")
    private int yearBorn;

    @NotNull(message="Please choose a password.")
    @Size(min=6, max=15, message="Password must be 6-15 characters long.")
    @Pattern(regexp="[a-zA-Z0-9]+", message="Password should contain only alphanumeric characters.")
    private String password;
    
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDayBorn() {
        return dayBorn;
    }

    public void setDayBorn(int dayBorn) {
        this.dayBorn = dayBorn;
    }

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

    public int getMonthBorn() {
        return monthBorn;
    }

    public void setMonthBorn(int monthBorn) {
        this.monthBorn = monthBorn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }



}