package com.comprayahorraback.marketplace.mappers;

import java.util.ArrayList;
import java.util.List;

import com.comprayahorraback.marketplace.dto_request.ProductRequest;
import com.comprayahorraback.marketplace.dto_request.SaleRequest;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.entity.Sale;
import com.comprayahorraback.marketplace.entity.SaleProduct;
import com.comprayahorraback.marketplace.entity.Userca;


public class SaleRequestToEntity {
    Sale sale = new Sale();
    Userca userca = new Userca();

    List<SaleProduct> sale_products = new ArrayList<SaleProduct>();


    public Sale toEntity(SaleRequest saleReq){

        List<ProductRequest> productList = saleReq.getProducts_sold();

        for(int i=0; i<productList.size(); i++){
            Product product = new Product();
            product.setId(productList.get(i).getId());

            SaleProduct sale_product = new SaleProduct();
            sale_product.setQuantitySold(productList.get(i).getQuantity());
            sale_product.setProduct(product);
            sale_product.setSale(sale);
            sale_products.add(sale_product);
        }

        sale.setSaleProducts(sale_products);

        userca.setId(saleReq.getUser_id());
        sale.setUserca(userca);

        sale.setNet(saleReq.getNet());

        return sale;
    }
}
