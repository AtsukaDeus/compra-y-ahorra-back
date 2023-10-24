package com.comprayahorraback.marketplace.controller;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comprayahorraback.marketplace.entity.Sale;
import com.comprayahorraback.marketplace.service.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/create")
    public ResponseEntity<?> createSale(@RequestBody Sale saleRequest) {
        try {
            Sale createdSale = saleService.createSale(saleRequest);
            return new ResponseEntity<>(createdSale, HttpStatus.CREATED);

        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Error de validación: " + e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSale(@PathVariable Long id){
        try{

            Sale sale = saleService.getSale(id);
            
            if(sale != null){
                return new ResponseEntity<>(sale, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }


        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Error de validación: " + e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getSales(){
        try{

            List<Sale> sales = saleService.getSales();
            return new ResponseEntity<>(sales, HttpStatus.OK);


        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Error de validación: " + e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }

    }




}


