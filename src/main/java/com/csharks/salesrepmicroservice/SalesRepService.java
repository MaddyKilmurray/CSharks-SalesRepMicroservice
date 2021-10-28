package com.csharks.salesrepmicroservice;

import com.csharks.salesrepmicroservice.dao.SalesRep;
import com.csharks.salesrepmicroservice.dto.SalesRepDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;

    public List<SalesRep> findAll() {
        return salesRepRepository.findAll();
    }

    public SalesRepDTO findById(Long id) {
        Optional<SalesRep> foundSalesRep = salesRepRepository.findById(id);
        if (foundSalesRep.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested SalesRep could not be found");
        }
        return convertToDTO(foundSalesRep.get());
    }

    public SalesRepDTO create(SalesRepDTO salesRepDTO) {
        Optional<SalesRep> existingSalesRep = salesRepRepository.findById(salesRepDTO.getId());
        if (existingSalesRep.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"A SalesRep with id " + salesRepDTO.getId() + " already exists.");
        }
        salesRepRepository.save(convertToSalesRep(salesRepDTO));
        return salesRepDTO;
    }

    public void delete(Long id) {
        Optional<SalesRep> foundSalesRep = salesRepRepository.findById(id);
        salesRepRepository.delete(foundSalesRep.get());
    }

    public SalesRepDTO convertToDTO(SalesRep salesRep) {
        SalesRepDTO convertedSalesRep = new SalesRepDTO(salesRep.getId(), salesRep.getRepName());
        return convertedSalesRep;
    }

    public SalesRep convertToSalesRep(SalesRepDTO salesRepDTO) {
        SalesRep convertedSalesRep = new SalesRep(salesRepDTO.getId(), salesRepDTO.getRepName());
        return convertedSalesRep;
    }
}
