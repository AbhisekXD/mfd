package com.cyfrifpro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cyfrifpro.model.client.AUMData;

@Repository
public interface AUMDataRepository extends JpaRepository<AUMData, Long> {

	List<AUMData> findByEmailId(String email);
	
	List<AUMData> findByClosingAssetsAndCostValueAndUnits(double closingAssets, double costValue, double units);
	
	List<AUMData> findByClosingAssetsNotAndCostValueNotAndUnitsNot(double closingAssets, double costValue, double units);
	
	// Custom query to find by brokDlrCode after ARN-
	// Custom query to find by brokDlrCode
    @Query("SELECT a FROM AUMData a WHERE a.brokDlrCode LIKE %:arnNumber%")
    List<AUMData> findByBrokDlrCode(String arnNumber);
}
