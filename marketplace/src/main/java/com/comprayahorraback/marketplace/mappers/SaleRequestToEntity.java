package com.comprayahorraback.marketplace.mappers;

import java.util.ArrayList;
import java.util.List;

import com.comprayahorraback.marketplace.dto_request.ProductRequest;
import com.comprayahorraback.marketplace.dto_request.SaleRequest;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.entity.Sale;
import com.comprayahorraback.marketplace.entity.UserCa;


public class SaleRequestToEntity {
    Sale sale = new Sale();
    UserCa userca = new UserCa();
    Product product = new Product();

    List<Product> products = new ArrayList<Product>();


    public Sale toEntity(SaleRequest saleReq){

        List<ProductRequest> productList = saleReq.getProducts_sold();

        for(ProductRequest prodReq : productList){
            product.setId(prodReq.getId());
            products.add(product);
        }

        sale.setProducts_sold(products);

        userca.setId(saleReq.getUser_id());
        sale.setUserca(userca);

        sale.setNet(saleReq.getNet());

        return sale;
    }
}
