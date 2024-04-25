package com.cardealer.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "employee")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces")
    @Column(name = "name", nullable = false)
    private String name;
    @NonNull
    @Column(name = "position", nullable = false)
    private String position;
    @NonNull
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Sale> sales;
}
