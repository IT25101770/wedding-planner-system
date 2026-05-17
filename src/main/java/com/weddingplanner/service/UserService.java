package com.weddingplanner.service;

import com.weddingplanner.model.Admin;
import com.weddingplanner.model.Customer;
import com.weddingplanner.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static final String USERS_FILE = "users.txt";
    private static final String ADMINS_FILE = "admins.txt";
    private static final String ADMIN_EMAIL = "rusithanuhas@gmail.com";
    private static final String ADMIN_PASSWORD = "12345";
    private final FileStorageService storage;

    public UserService(FileStorageService storage) {
        this.storage = storage;
    }

    public Customer registerCustomer(Customer customer) {
        customer.setId(storage.nextId("CUS"));
        customer.setRole("CUSTOMER");
        List<Customer> customers = findAllCustomers();
        customers.add(customer);
        saveCustomers(customers);
        return customer;
    }

    public Optional<Customer> authenticateCustomer(String email, String password) {
        return findAllCustomers().stream().filter(customer -> customer.authenticate(email, password)).findFirst();
    }

    public Optional<Admin> authenticateAdmin(String email, String password) {
        if (ADMIN_EMAIL.equalsIgnoreCase(email) && ADMIN_PASSWORD.equals(password)) {
            return Optional.of(new Admin("ADM-0001", "Rusith Anuhas", ADMIN_EMAIL, ADMIN_PASSWORD, "0710951040", "Operations"));
        }
        return Optional.empty();
    }

    public List<Customer> findAllCustomers() {
        return storage.readRecords(USERS_FILE).stream().map(this::toCustomer).collect(Collectors.toList());
    }

    public List<Admin> findAllAdmins() {
        return storage.readRecords(ADMINS_FILE).stream().map(this::toAdmin).collect(Collectors.toList());
    }

    public Optional<Customer> findCustomerById(String id) {
        return findAllCustomers().stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    public void updateCustomer(Customer updated) {
        List<Customer> customers = findAllCustomers().stream()
                .map(customer -> customer.getId().equals(updated.getId()) ? updated : customer)
                .collect(Collectors.toList());
        saveCustomers(customers);
    }

    public void deleteCustomer(String id) {
        List<Customer> customers = findAllCustomers().stream()
                .filter(customer -> !customer.getId().equals(id))
                .collect(Collectors.toList());
        saveCustomers(customers);
    }

    public void ensureDefaultAdmin() {
        List<Admin> admins = new ArrayList<>();
        admins.add(new Admin("ADM-0001", "Rusith Anuhas", ADMIN_EMAIL, ADMIN_PASSWORD, "0710951040", "Operations"));
        saveAdmins(admins);
    }

    private void saveCustomers(List<Customer> customers) {
        storage.writeRecords(USERS_FILE, customers.stream().map(this::fromCustomer).collect(Collectors.toList()));
    }

    private void saveAdmins(List<Admin> admins) {
        storage.writeRecords(ADMINS_FILE, admins.stream().map(this::fromAdmin).collect(Collectors.toList()));
    }

    private Customer toCustomer(String[] parts) {
        return new Customer(value(parts, 0), value(parts, 1), value(parts, 2), value(parts, 3), value(parts, 4), value(parts, 5));
    }

    private Admin toAdmin(String[] parts) {
        return new Admin(value(parts, 0), value(parts, 1), value(parts, 2), value(parts, 3), value(parts, 4), value(parts, 5));
    }

    private String fromCustomer(Customer customer) {
        return String.join("|", customer.getId(), customer.getName(), customer.getEmail(), customer.getPassword(), customer.getPhone(), customer.getAddress());
    }

    private String fromAdmin(Admin admin) {
        return String.join("|", admin.getId(), admin.getName(), admin.getEmail(), admin.getPassword(), admin.getPhone(), admin.getDepartment());
    }

    private String value(String[] parts, int index) {
        return index < parts.length ? parts[index] : "";
    }
}