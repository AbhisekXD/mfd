package com.cyfrifpro.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class FundHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "fundHouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Scheme> schemes = new ArrayList<>();

    // Constructors, getters, setters

    public FundHouse() {}

    public FundHouse(String name) {
        this.name = name;
    }

    public void addScheme(Scheme scheme) {
        schemes.add(scheme);
        scheme.setFundHouse(this);
    }

    // Getters and setters...
}
