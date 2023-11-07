package com.comprayahorraback.marketplace.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprayahorraback.marketplace.dto_request.SaleRequest;
import com.comprayahorraback.marketplace.dto_response.SaleResponse;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.entity.Sale;
import com.comprayahorraback.marketplace.entity.SaleProduct;
import com.comprayahorraback.marketplace.mappers.SaleMapper;
import com.comprayahorraback.marketplace.repository.ProductRepository;
import com.comprayahorraback.marketplace.repository.SaleProductRepository;
import com.comprayahorraback.marketplace.repository.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleProductRepository saleProductRepository;

    @Autowired
    private ProductRepository productRepository;

    // Services
    // create a sale in the database
    public void createSale(SaleRequest saleReq){

        SaleMapper saleMapper = new SaleMapper(); // to use the method toEntity
        Sale sale = saleMapper.saleRequestToSaleEntity(saleReq);

        sale.setSale_date(
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

        saleRepository.save(sale);
    }

    
    // get a sale by id from the database 
    public SaleResponse getSale(Long id) {

        SaleMapper saleMapper = new SaleMapper();
        SaleResponse saleResponse = new SaleResponse();
        Sale sale = new Sale();

        List<Product> products = new ArrayList<Product>();
        List<SaleProduct> saleProducts = new ArrayList<SaleProduct>();
        

        sale = saleRepository.findById(id).orElse(null);
        saleProducts = saleProductRepository.findBySaleId(id);

        for(int i=0; i<saleProducts.size(); i++) {
            Product product = new Product();
            
            product = productRepository.findById(saleProducts.get(i).getProduct().getId()).orElse(null);
            
            products.add(product);
        }

        saleResponse = saleMapper.saleEntityToSaleResponse(sale, saleProducts, products);
        
        return saleResponse;

    }


    // get all sales from today
    public List<SaleResponse> getSalesFromToday() {
        
        List<Sale> sales = new ArrayList<Sale>();
        List<SaleResponse> salesResponses = new ArrayList<SaleResponse>();

        sales = saleRepository.findSalesBySaleDateToday();
        
        for(int i=0; i<sales.size(); i++){
            salesResponses.add(
                this.getSale(sales.get(i).getId())
            );
        }
        
        return salesResponses;
    }



    
}
