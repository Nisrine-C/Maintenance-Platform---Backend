package com.enset.maintenance_backend.repositories;

import com.enset.maintenance_backend.entities.Failure;
import com.enset.maintenance_backend.entities.Prediction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FailureRepository extends BaseRepository<Failure,Long> {
}




