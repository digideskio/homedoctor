package tikaso.joosakur.homedoctor.formvalidation;

import javax.validation.constraints.Digits;

public class DateAndDoctorFormObject {
    @Digits(integer=4, fraction=0)
    private int year;
    @Digits(integer=2, fraction=0)
    private int month;
    @Digits(integer=2, fraction=0)
    private int day;
    
    private Long doctor;

    public DateAndDoctorFormObject() {
    }

    public DateAndDoctorFormObject(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public DateAndDoctorFormObject(int year, int month, int day, Long doctor) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.doctor = doctor;
    }
    
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getDoctor() {
        return doctor;
    }

    public void setDoctor(Long doctor) {
        this.doctor = doctor;
    }
    
    
}
