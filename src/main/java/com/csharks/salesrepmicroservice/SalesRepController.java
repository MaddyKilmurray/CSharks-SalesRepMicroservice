package com.csharks.salesrepmicroservice;

import com.csharks.salesrepmicroservice.dao.SalesRep;
import com.csharks.salesrepmicroservice.dto.SalesRepDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesRepController {

    @Autowired
    SalesRepService salesRepService;

    @GetMapping("/salesrep")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesRep> findAll() {
        return salesRepService.findAll();
    }

    @GetMapping("/salesrep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesRepDTO findById(@PathVariable(name = "id") Long id) {
        return salesRepService.findById(id);
    }

    @PostMapping("/salesrep")
    @ResponseStatus(HttpStatus.CREATED)
    public SalesRepDTO createSalesRep(@RequestBody SalesRepDTO salesRepDTO) {
        return salesRepService.create(salesRepDTO);
    }

    @DeleteMapping("/salesrep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "id") Long id) {
        salesRepService.delete(id);
    }
}
