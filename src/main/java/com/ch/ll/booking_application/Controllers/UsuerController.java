package com.ch.ll.booking_application.Controllers;

import com.ch.ll.booking_application.Repository.CustomerRepository;
import com.ch.ll.booking_application.entitites.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class UsuerController {
    private CustomerRepository CustomerRepository;

    public UsuerController(CustomerRepository CustomerRepository) {
        this.CustomerRepository = CustomerRepository;
    }


    @GetMapping
    public List<Customer> getAllCustomers() {
        return CustomerRepository.findAll();
    }
    @PostMapping
    public Customer createCustomer(@RequestBody Customer newcustomer) {
        return CustomerRepository.save(newcustomer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) {

        //custom exception
        return CustomerRepository.findById(customerId).orElse(null);

    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Integer customerId, @RequestBody Customer newcustomer) {
        Customer exsistCustomer = CustomerRepository.findById(customerId).orElse(null);
        if (exsistCustomer != null) {
            newcustomer.setId(exsistCustomer.getId());
            newcustomer.setFirstName(exsistCustomer.getFirstName());
            newcustomer.setLastName(exsistCustomer.getLastName());
            newcustomer.setEmail(exsistCustomer.getEmail());
            newcustomer.setPhone(exsistCustomer.getPhone());
            return CustomerRepository.save(newcustomer);
        }else {
            System.out.println("Customer not found");
            return null;
        }
    }


    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId) {
        CustomerRepository.deleteById(customerId);
    }



}