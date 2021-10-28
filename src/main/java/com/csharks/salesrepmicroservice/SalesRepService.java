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
        SalesRepDTO convertedSalesRep = new SalesRepDTO(foundSalesRep.get().getId(), foundSalesRep.get().getRepName());
        return convertedSalesRep;
    }

}
