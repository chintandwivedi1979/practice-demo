package com.example.demo.repository;

import com.example.demo.model.Employee;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

    @Query("select * from Employee e where e.firstName = :firstName and e.age = :age")
    Flux<Employee> findByNameAndAge(String firstName, Integer age);
}
