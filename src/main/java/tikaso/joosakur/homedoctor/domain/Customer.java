package tikaso.joosakur.homedoctor.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import tikaso.joosakur.homedoctor.formvalidation.CustomerFormObject;


@Entity
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String rolename;
    private int customerNro;
    private String city;
    private String streetAddress;
    private String phoneNumber;
    private int dayBorn;
    private int monthBorn;
    private int yearBorn;

    @OneToMany(mappedBy="customer")
    private List<Reservation> reservations;
    
    public Customer() {
        rolename="customer";
        reservations = new ArrayList<Reservation>();
    }

    public Customer(CustomerFormObject formObj) {
        rolename="customer";
        reservations = new ArrayList<Reservation>();
        
        firstName=formObj.getFirstName();
        lastName=formObj.getLastName();
        city=formObj.getCity();
        streetAddress=formObj.getStreetAddress();
        phoneNumber=formObj.getPhoneNumber();
        dayBorn=formObj.getDayBorn();
        monthBorn=formObj.getMonthBorn();
        yearBorn=formObj.getYearBorn();
        password=formObj.getPassword();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCustomerNro() {
        return customerNro;
    }

    public void setCustomerNro(int customerNro) {
        this.customerNro = customerNro;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    public void solveCustomerNumberAndUsername() {
        customerNro = (int) (100102+31*id);
        username = String.valueOf(customerNro);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    
    
}