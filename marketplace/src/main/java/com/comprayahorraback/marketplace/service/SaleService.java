package com.comprayahorraback.marketplace.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprayahorraback.marketplace.entity.Sale;
import com.comprayahorraback.marketplace.repository.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    // Services
    // create a sale in the database
    public Sale createSale(Sale sale){

        sale.setSaleDate(
            LocalDate.now()
        );
        
        sale.setIva(
            Math.round(sale.getNet() * 0.19)
        );

        sale.setGross(
            Math.round(
                sale.getIva() + sale.getNet()
            )
        );

        return saleRepository.save(sale);
    }

    // get a sale by id from the database 
    public Sale getSale(Long id) {
        return saleRepository.findById(id).orElse(null);
    }


    // get all sales from the database
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }



    
}
