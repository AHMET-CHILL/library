package com.ch.ll.booking_application.Repository;


import com.ch.ll.booking_application.entitites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


}
