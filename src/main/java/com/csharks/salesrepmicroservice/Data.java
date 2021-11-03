package com.csharks.salesrepmicroservice;

import com.csharks.salesrepmicroservice.dao.SalesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Data {

    @Autowired
    SalesRepRepository salesRepRepository;

    public void populate(){
//        List<SalesRep> opportunities = salesRepRepository.saveAll(List.of(
//                new SalesRep("Maddy"),
//                new SalesRep("Jegor"),
//                new SalesRep("Natalia"),
//                new SalesRep("Joao")
//        ));
        salesRepRepository.save(new SalesRep("Maddy"));
        salesRepRepository.save(new SalesRep("Jegor"));
        salesRepRepository.save(new SalesRep("Natalia"));
        salesRepRepository.save(new SalesRep("Joao"));
    }
}
