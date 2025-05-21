package com.cyfrifpro.repositories;

import com.cyfrifpro.model.FATCA.Fatca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatcaRepo extends JpaRepository<Fatca, Long> {
}
