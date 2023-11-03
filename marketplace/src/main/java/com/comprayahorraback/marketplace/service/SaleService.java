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
import com.comprayahorraback.marketplace.mappers.SaleEntityToResponse;
import com.comprayahorraback.marketplace.mappers.SaleRequestToEntity;
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

        SaleRequestToEntity saleMapper = new SaleRequestToEntity(); // to use the method toEntity
        Sale sale = saleMapper.toEntity(saleReq);

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

        SaleEntityToResponse saleEntityToResponse = new SaleEntityToResponse();

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

        saleResponse = saleEntityToResponse.toSaleResponse(sale, saleProducts, products);
        
        return saleResponse;

        // return saleRepository.findById(id).orElse(null);
    }


    // get all sales from the database
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }



    
}
