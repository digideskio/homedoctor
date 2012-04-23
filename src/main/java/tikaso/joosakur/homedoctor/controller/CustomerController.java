package tikaso.joosakur.homedoctor.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tikaso.joosakur.homedoctor.domain.Customer;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.domain.Report;
import tikaso.joosakur.homedoctor.domain.Reservation;
import tikaso.joosakur.homedoctor.formvalidation.DateAndDoctorFormObject;
import tikaso.joosakur.homedoctor.formvalidation.ReservationFormObject;
import tikaso.joosakur.homedoctor.service.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CredentialsService credentialsService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private DateService dateService;
    
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReportService reportService;
    
    @RequestMapping(value = "*")
    public String home() {
        return "customer/home";
    }
    
    @RequestMapping(value = "dayanddoctorselection", method= RequestMethod.GET)
    public String getDay(Model model) {
        //set default to next valid date for reservation (next business day)
        DateAndDoctorFormObject dateAndDoctorFormObject = new DateAndDoctorFormObject(dateService.nextWeekdayYear(), dateService.nextWeekdayMonth(), dateService.nextWeekdayDay());
        
        model.addAttribute("formobj", dateAndDoctorFormObject);
        model.addAttribute("doctors", doctorService.findAllDoctors());
                
        return "customer/dayanddoctorselection";
    }
    
    @RequestMapping(value = "dayanddoctorselection", method= RequestMethod.POST)
    public String postDay(@Valid @ModelAttribute("formobj") DateAndDoctorFormObject formObj, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors() || !dateService.isValidNewReservationDate(formObj.getYear(), formObj.getMonth(), formObj.getDay())) {
            model.addAttribute("formobj", formObj);
            model.addAttribute("doctors", doctorService.findAllDoctors());
            return "customer/dayanddoctorselection";
        }
        
        model.addAttribute("day", formObj.getDay());
        model.addAttribute("month", formObj.getMonth());
        model.addAttribute("year", formObj.getYear());
        model.addAttribute("doctor", formObj.getDoctor());
        
        return "redirect:reservation";
    }
    
    
    @RequestMapping(value = "reservation", method = RequestMethod.GET)
    public String getReservation(Model model, @RequestParam Integer day, @RequestParam Integer month, @RequestParam Integer year, @RequestParam Long doctor) {
        ReservationFormObject reservation = new ReservationFormObject(day, month, year, doctor);
        model.addAttribute("reservation", reservation);
        model.addAttribute("freetimes", doctorService.getFreeTimes(year, month, day, doctorService.findById(doctor)));
        return "customer/reservation";
    }
    
    @RequestMapping(value = "reservation", method= RequestMethod.POST)
    public String postReservation(@Valid @ModelAttribute("reservation") ReservationFormObject reservationFO, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("reservation", reservationFO);
            model.addAttribute("freetimes", doctorService.getFreeTimes(reservationFO.getYear(), reservationFO.getMonth(),
                                                   reservationFO.getDay(), doctorService.findById(reservationFO.getDoctorId())));
            return "customer/reservation";
        }
        
        Reservation reservation = new Reservation(reservationFO);
        Customer customer = customerService.find(credentialsService.getName());
        Doctor doctor = doctorService.findById(reservationFO.getDoctorId());
        reservationService.create(reservation, customer, doctor);
        
        return "redirect:reservations";
    }
    
    @RequestMapping(value = "reservations", method = RequestMethod.GET)
    public String getReservations(Model model){
        model.addAttribute("futureReservations", reservationService.findAllFutureReservations(customerService.find(credentialsService.getName()).getReservations()));
        model.addAttribute("pastReservations", reservationService.findAllPastReservations(customerService.find(credentialsService.getName()).getReservations()));
        
        return "customer/reservations";
    }

    
    @RequestMapping(value = "cancel/{id}")
    public String cancel(@PathVariable Long id) {
        Reservation reservation = reservationService.findById(id);
        if(reservation != null && reservation.getCustomer().getUsername().equals(credentialsService.getName()))
            reservationService.cancelReservation(id);
        
        return "redirect:/customer/reservations";
    }

    @RequestMapping(value = "report/{reservationId}", method = RequestMethod.GET)
    public String getReport(Model model, @PathVariable Long reservationId) {
        Reservation reservation = reservationService.findById(reservationId);
        //return if its not customers own reservation
        if(!reservation.getCustomer().getUsername().equals(credentialsService.getName())) return "redirect:/customer/home";
        
        Report report = reservation.getReport();
        if(report==null) return "redirect:/customer/home";
        
        model.addAttribute("report", report);
        return "customer/report";
    }

    
}
