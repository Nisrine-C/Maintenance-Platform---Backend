package com.enset.maintenance_backend.repositories;

import com.enset.maintenance_backend.entities.Prediction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository extends BaseRepository<Prediction,Long>{
    @Query("SELECT p FROM Prediction p " +
            "WHERE p.confidence >= :minConfidence AND p.machine.id = :machineId")
    List<Prediction> findHighConfidencePredictions(
            @Param("machineId") Long machineId,
            @Param("minConfidence") double minConfidence);
    @Query("SELECT AVG(p.predictedRulHours) FROM Prediction p " +
            "WHERE p.machine.id = :machineId")
    Double calculateAverageRUL(@Param("machineId") Long machineId);
}

