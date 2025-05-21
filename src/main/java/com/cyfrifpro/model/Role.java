package com.cyfrifpro.model;

import java.util.ArrayList;
import java.util.List;

import com.cyfrifpro.model.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "roles")
@RequiredArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleEnum roleName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parent_role_id", nullable = true)
    private Role parent;

    @JsonBackReference
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Role> children = new ArrayList<>();
}
