package com.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Model;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ModelRepository extends JpaRepository<Model, Long> {
	

	
	@Query(value="SELECT * FROM Models WHERE seg_id = :seg_id AND manu_id = :manu_id",nativeQuery = true)
	List<Model> findByManufacturerIdAndSegmentId(@Param("seg_id")long segId, @Param("manu_id")long manuId);
}
