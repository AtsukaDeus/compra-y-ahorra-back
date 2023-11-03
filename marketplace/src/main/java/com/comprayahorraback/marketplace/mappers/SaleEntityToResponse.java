package com.comprayahorraback.marketplace.mappers;


import java.util.ArrayList;
import java.util.List;

import com.comprayahorraback.marketplace.dto_response.ProductResponse;
import com.comprayahorraback.marketplace.dto_response.SaleResponse;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.entity.Sale;
import com.comprayahorraback.marketplace.entity.SaleProduct;

public class SaleEntityToResponse {
    
    
    public SaleResponse toSaleResponse(Sale sale, List<SaleProduct> saleProducts, List<Product> products){

        SaleResponse saleResponse = new SaleResponse();
        List<ProductResponse> productsResponses = new ArrayList<ProductResponse>();

        for(int i=0; i<saleProducts.size(); i++){
            ProductResponse productResponse = new ProductResponse();

            productResponse.setId(products.get(i).getId());
            productResponse.setName(products.get(i).getName());
            productResponse.setNet(products.get(i).getPrice());

            double iva = Math.round((products.get(i).getPrice() * 0.19));
            double gross = products.get(i).getPrice() + iva;

            productResponse.setIva(iva);
            productResponse.setGross(gross);
            productResponse.setQuantity(saleProducts.get(i).getQuantitySold()); 

            productsResponses.add(productResponse);
        }

        saleResponse.setSale_date(sale.getSale_date());

        saleResponse.setName_client(sale.getUserca().getName());
        saleResponse.setRun_client(sale.getUserca().getRun());

        saleResponse.setNet(sale.getNet());
        saleResponse.setIva(sale.getIva());
        saleResponse.setGross(sale.getGross());

        saleResponse.setId(sale.getId());
        

        saleResponse.setProducts_responses(productsResponses);

        return saleResponse;
    }

}
