package tikaso.joosakur.homedoctor.domain;

import java.io.Serializable;
import javax.persistence.*;


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
    
    
    public Doctor() {
        rolename="doctor";
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
    
}