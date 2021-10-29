package com.csharks.salesrepmicroservice;

import com.csharks.salesrepmicroservice.dao.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {
    List<SalesRep> findAll();
    Optional<SalesRep> findById(Long id);
}
