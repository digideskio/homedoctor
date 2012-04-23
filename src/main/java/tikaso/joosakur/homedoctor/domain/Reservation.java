package tikaso.joosakur.homedoctor.domain;

import java.io.Serializable;
import javax.persistence.*;
import tikaso.joosakur.homedoctor.formvalidation.ReservationFormObject;

@Entity
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Doctor doctor;
    
    //date
    @Column(name="o_year")
    private int orderYear;
    @Column(name="o_month")
    private int orderMonth; //0-11
    @Column(name="o_day")
    private int orderDay; //1-31
    @Column(name="o_hour")
    private int startHour; //8-15. in this prototype all visits are 1 hour long including travels

    private String message;
    
    @OneToOne
    private Report report;

    public Reservation() {
    }

    public Reservation(ReservationFormObject reservationFormObject) {
        orderDay=reservationFormObject.getDay();
        orderMonth=reservationFormObject.getMonth();
        orderYear=reservationFormObject.getYear();
        startHour=reservationFormObject.getStartHour();
        message=reservationFormObject.getMessage();
    }
    
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(int orderDay) {
        this.orderDay = orderDay;
    }

    public int getOrderMonth() {
        return orderMonth;
    }

    public void setOrderMonth(int orderMonth) {
        this.orderMonth = orderMonth;
    }

    public int getOrderYear() {
        return orderYear;
    }

    public void setOrderYear(int orderYear) {
        this.orderYear = orderYear;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
    
    
    
}
