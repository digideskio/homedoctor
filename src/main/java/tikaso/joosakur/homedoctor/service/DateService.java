package tikaso.joosakur.homedoctor.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;

@Service
public class DateService {
    
    private static boolean testMode = true;
    
    public boolean isValidNewReservationDate(int year, int month, int day){
        GregorianCalendar calendar = new GregorianCalendar();
        try {
            calendar.setLenient(false);
            calendar.set(year, month-1, day);
            calendar.getTime();
        } catch (Exception e) {
            return false;
        }
        
        if(testMode) return true; //hyväksyy myös menneet ajat testauksen helpottamiseksi
        
        int dayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);
        if(dayOfWeek == GregorianCalendar.SATURDAY || dayOfWeek == GregorianCalendar.SUNDAY) 
            return false;
        
        GregorianCalendar nextValidDate = nextWeekday();
        
        if(calendar.before(nextValidDate)) return false; //valid reservations starting from tomorrow
        
        return true;
    }
    
    public GregorianCalendar nextWeekday(){
        GregorianCalendar nextWeekday = new GregorianCalendar();
        nextWeekday.add(Calendar.DATE, 1);
        nextWeekday.set(Calendar.HOUR_OF_DAY, 0);
        nextWeekday.set(Calendar.MINUTE, 0);
        
        int dayOfWeek = nextWeekday.get(GregorianCalendar.DAY_OF_WEEK);
        while (dayOfWeek == GregorianCalendar.SATURDAY || dayOfWeek == GregorianCalendar.SUNDAY) {
            nextWeekday.add(Calendar.DATE, 1);
            dayOfWeek = nextWeekday.get(GregorianCalendar.DAY_OF_WEEK);
        }
            
        return nextWeekday;
    }
    
    public int nextWeekdayYear(){
        return nextWeekday().get(Calendar.YEAR);
    }
    
    public int nextWeekdayMonth(){
        return nextWeekday().get(Calendar.MONTH)+1;
    }
    
    public int nextWeekdayDay(){
        return nextWeekday().get(Calendar.DATE);
    }
    
    public boolean isInFuture(int year, int month, int day, int hour){
        GregorianCalendar currentTime = new GregorianCalendar();
        
        GregorianCalendar givenTime = new GregorianCalendar();
        try {
            givenTime.setLenient(false);
            givenTime.set(year, month-1, day, hour, 0);
            givenTime.getTime();
        } catch (Exception e) {
            System.out.println("Invalid time.");
            return false;
        }
        
        return givenTime.after(currentTime);
    }
    
    public boolean isInPast(int year, int month, int day, int hour){
        return !isInFuture(year, month, day, hour);
    }
    
    
    
}
