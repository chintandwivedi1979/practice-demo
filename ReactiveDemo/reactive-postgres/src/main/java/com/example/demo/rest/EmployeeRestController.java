package com.example.demo.rest;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/employees")
@AllArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @GetMapping(value = "/{id}")
    public Mono<Employee> getEmployee(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("")
    public Flux<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/{firstName}/{age}")
    public Flux<Employee> searchEmployees(@PathVariable String firstName, @PathVariable Integer age) {
        return employeeService.findEmployeesByFirstNameAndAge(firstName, age);
    }

}
