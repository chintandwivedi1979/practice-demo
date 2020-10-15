package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("employee")
public class Employee {

    @Id
    private Long id;

    @Column(value = "firstname")
    private String firstName;

    @Column(value = "lastname")
    private String lastName;

    @Column(value = "age")
    private Integer age;

    @Column(value = "martialstatus")
    private String martialStatus;
}
