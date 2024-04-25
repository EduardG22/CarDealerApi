package com.cardealer.car.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "sale", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"car_id", "employee_id", "customer_id"})
})
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Sale {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(name = "saleDate", nullable = false)
    private String saleDate;

    @NonNull
    @Column(name = "totalPrice", nullable = false)
    private BigDecimal totalPrice;


    @ManyToOne
    @JoinColumn(name = "car_id",referencedColumnName = "id")
    private Car car;


    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
