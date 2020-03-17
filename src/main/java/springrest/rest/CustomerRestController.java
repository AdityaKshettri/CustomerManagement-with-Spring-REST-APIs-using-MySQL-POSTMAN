package springrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springrest.entity.Customer;
import springrest.error.CustomerNotFoundException;
import springrest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController 
{
    @Autowired
    private CustomerService customerService;
    
    //get all customers
    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        return customerService.getCustomers();
    }
    
    //get a customer
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId)
    {
        Customer theCustomer = customerService.getCustomer(customerId);
        if(theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        } 
        return theCustomer;
    }
    
    //add a customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer)
    {
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }
    
    //update a customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer)
    {
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }
    
    //delete a customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId)
    {
        Customer theCustomer = customerService.getCustomer(customerId);
        if(theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }
        customerService.deleteCustomer(customerId);
        return "Deleted Customer id - " + customerId;
    }
}
