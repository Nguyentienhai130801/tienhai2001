package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

public interface CustomerService {
    Page<Customer> getAll(Pageable pageable);

    Customer findById(String id);

    void save(Customer customer);

    void delete(String id);
}