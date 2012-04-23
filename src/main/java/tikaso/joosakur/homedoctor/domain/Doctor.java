package tikaso.joosakur.homedoctor.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import tikaso.joosakur.homedoctor.formvalidation.DoctorFormObject;


@Entity
public class Doctor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String rolename;

    @OneToMany(mappedBy="doctor")
    private List<Reservation> reservations;
    
    
    public Doctor() {
        rolename="doctor";
        reservations = new ArrayList<Reservation>();
    }

    public Doctor(DoctorFormObject formObj) {
        rolename="doctor";
        reservations = new ArrayList<Reservation>();
        
        firstName=formObj.getFirstName();
        lastName=formObj.getLastName();
        username=formObj.getUsername();
        password=formObj.getPassword();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    
    
}