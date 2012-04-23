package tikaso.joosakur.homedoctor.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tikaso.joosakur.homedoctor.domain.Customer;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.domain.Report;
import tikaso.joosakur.homedoctor.domain.Reservation;
import tikaso.joosakur.homedoctor.formvalidation.ReportFormObject;
import tikaso.joosakur.homedoctor.service.CredentialsService;
import tikaso.joosakur.homedoctor.service.CustomerService;
import tikaso.joosakur.homedoctor.service.DoctorService;
import tikaso.joosakur.homedoctor.service.ReportService;
import tikaso.joosakur.homedoctor.service.ReservationService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    
    @Autowired
    private CredentialsService credentialsService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private ReportService reportService;
    
    @RequestMapping(value = "*")
    public String any() {
        return "redirect:doctor/home";
    }
    
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String getHome(Model model) {
        Doctor doctor = doctorService.find(credentialsService.getName());
        model.addAttribute("futureReservations", reservationService.findAllFutureReservations(doctor.getReservations()));
        return "doctor/home";
    }

    @RequestMapping(value = "reservation/{id}", method = RequestMethod.GET)
    public String getReservation(Model model, @PathVariable Long id) {
        Reservation reservation = reservationService.findById(id);
        if(reservation==null) return "doctor/home";
        
        model.addAttribute("reservation", reservation);
        return "doctor/reservation";
    }

    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String getHistory(Model model){
        Doctor doctor = doctorService.find(credentialsService.getName());
        model.addAttribute("reservations", reservationService.findAllPastReservations(doctor.getReservations()));
        return "doctor/history";
    }
    
    @RequestMapping(value = "report/{id}", method = RequestMethod.GET)
    public String getReport(Model model, @PathVariable Long id) {
        Report report = reportService.findById(id);
        if(report==null) return "redirect:/doctor/home";
        
        model.addAttribute("report", report);
        return "doctor/report";
    }
    
    @RequestMapping(value = "newreport/{id}", method = RequestMethod.GET)
    public String getNewReport(Model model, @PathVariable Long id) {
        Reservation reservation = reservationService.findById(id);
        if(reservation==null) return "doctor/home";
        
        
        ReportFormObject reportFO = new ReportFormObject();
        model.addAttribute("report", reportFO);
        return "doctor/newreport";
    }
    
    @RequestMapping(value = "newreport/{id}", method= RequestMethod.POST)
    public String postNewReport(@Valid @ModelAttribute("report") ReportFormObject reportFO, BindingResult bindingResult, Model model, @PathVariable Long id) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("report", reportFO);
            return "doctor/newreport";
        }
        
        Report report = new Report(reportFO);
        report = reportService.createOrUpdate(report);
        
        Reservation reservation = reservationService.findById(id);
        if(reservation!=null){
            reservation.setReport(report);
            reservation = reservationService.createOrUpdate(reservation);
            return "redirect:/doctor/report/"+Long.toString(report.getId());
        }
        
        return "redirect:history";
    }

    @RequestMapping(value = "mycustomers", method = RequestMethod.GET)
    public String getMyCustomers(Model model){
        Doctor doctor = doctorService.find(credentialsService.getName());
        model.addAttribute("customers", customerService.findCustomers(doctor));
        return "doctor/mycustomers";
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.GET)
    public String getCustomer(Model model, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if(customer==null) return "redirect:/doctor/home";
        
        model.addAttribute("customer", customer);
        model.addAttribute("reservations", reservationService.findAllPastReservations(customer.getReservations()));
        model.addAttribute("myId", doctorService.find(credentialsService.getName()).getId());
        return "doctor/customer";
    }

}
