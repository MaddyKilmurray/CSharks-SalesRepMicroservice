package com.csharks.salesrepmicroservice.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sales_rep_name")
    private String repName;

    public SalesRep(String repName) {
        this.repName = repName;
    }

    public void setName(String repName) {
        if (repName.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No name input. Please try again.");
        }
        else if(!repName.matches("[a-zA-Z\\u00C0-\\u00FF\\s]+")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name can not contain numbers. Please try again.");
        } else if(repName.length()>43){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exceeds maximum value of 43 characters. Please try again.");
        }

        this.repName = repName;
    }
}
