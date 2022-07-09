package com.example.SpringBootWebApi.Controller;

import com.example.SpringBootWebApi.Model.Employee;
import com.example.SpringBootWebApi.Model.MessageModel;
import com.example.SpringBootWebApi.Repository.EmployeeRepository;
import com.example.SpringBootWebApi.service.TwilloMessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
    @Autowired
    private TwilloMessageSenderService twilloService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees/ak")
    public String saySomething() {
        return "I am learning spring boot";
    }

    @GetMapping("/employees/default/values")
    public Employee getDefault() {
        Employee e = new Employee(1, UUID.randomUUID().toString(), "ALIMUR", "ABBAS");
        return e;
    }

    @GetMapping("/employees/{uuid}")
    // uuid is your resource identifier.
    public Employee getEmployeeByUid(@PathVariable("uuid") String uid) {
        return employeeRepository.selectByUid(uid);
    }

    @GetMapping("/employees/")
    public List<Employee> getAllEmployeeList() {
        return employeeRepository.selectAll();
    }

    @PostMapping("/employees/")
    public Employee saveEmployee(@RequestBody Employee e) {
        String uid = UUID.randomUUID().toString();
        e.setUid(uid);
        return employeeRepository.insert(e);
    }

    @PutMapping("/employees/{uuid}")
    public Employee updateEmployee(@RequestBody Employee e, @PathVariable("uuid") String uid) {
        e.setUid(uid);
        return employeeRepository.updateFirstName(e);
    }

    @DeleteMapping("/employees/{uuid}") // uuid is your resource identifier.
    public String deleteEmployeeByUid(@PathVariable("uuid") String uid) {
        employeeRepository.delete(uid);
        return "1 Row Deleted with uid:" + uid;
    }


    @PostMapping("/sendSMS")
    public String sendSMSByTwillo(@RequestBody MessageModel messageRequest) {
        String sendMessageResponse = twilloService.sendMessage(messageRequest);
        return sendMessageResponse;
    }
}


