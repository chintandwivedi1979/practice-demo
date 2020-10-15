package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Transactional
    public Mono<Employee> saveEmployee(Employee employee) {
        return Mono.just(employee)
                .flatMap(employeeRepository::save);
    }

    public Mono<Employee> findEmployeeById(Long id) {
        return Mono.just(id).flatMap(employeeRepository::findById);
    }

    public Flux<Employee> findEmployeesByFirstNameAndAge(String firstName, Integer age) {
        return employeeRepository.findByNameAndAge(firstName, age);
    }

    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
