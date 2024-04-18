package com.cardealer.car.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cars",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"registration_plate"})
})
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Cars {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "model", nullable = false)
    private String model;

    @NonNull
    @Column(name = "type", nullable = false)
    private String type;

    @NonNull
    @Column(name = "color", nullable = false)
    private String color;

    @NonNull
    @Column(name = "registration_plate", nullable = false)
    private String registration;

    @NonNull
    @Column(name = "availability", nullable = false)
    private Boolean isAvailable;


    @JsonIgnore
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Sale> sales;

}
