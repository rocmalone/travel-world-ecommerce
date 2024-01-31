package com.example.demo.bootstrap;

import com.example.demo.dao.CountryRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.Country;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;
    private final CountryRepository countryRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository, CountryRepository countryRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrapping data ...");

        Division specialDivision = new Division();
        specialDivision.setCountry_id(1L); // US
        specialDivision.setDivision_name("Special Division");

        divisionRepository.save(specialDivision);

        Set<Cart> emptyCarts = new HashSet<Cart>();

        if(customerRepository.count() < 5) {
            // Add five sample customers programatically
            Customer cus1 = new Customer("James", "Hugh","7 Maple St", "73482", "123-456-7890", specialDivision, emptyCarts);
            customerRepository.save(cus1);

            Customer cus2 = new Customer("Aku", "Ma", "9 Riverblew", "34289", "123-456-7890", specialDivision, emptyCarts);
            customerRepository.save(cus2);

            Customer cus3 = new Customer("Ezekiel", "Tan", "8 Riverblew", "94328", "123-456-7890", specialDivision, emptyCarts);
            customerRepository.save(cus3);

            Customer cus4 = new Customer("Andiel", "Tan", "8 Riverblew", "94328", "234-567-7890", specialDivision, emptyCarts);
            customerRepository.save(cus4);

            Customer cus5 = new Customer("Mike", "Grizby", "483 Ave", "85324", "423-324-5324", specialDivision, emptyCarts);
            cus5.setDivision(specialDivision);
            customerRepository.save(cus5);
        }

    }
}
