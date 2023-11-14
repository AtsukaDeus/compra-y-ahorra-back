package com.comprayahorraback.marketplace.mappers;

import java.util.ArrayList;
import java.util.List;

import com.comprayahorraback.marketplace.dto_request.ProductSaleRequest;
import com.comprayahorraback.marketplace.dto_request.SaleRequest;
import com.comprayahorraback.marketplace.dto_response.ProductResponse;
import com.comprayahorraback.marketplace.dto_response.SaleResponse;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.entity.Sale;
import com.comprayahorraback.marketplace.entity.SaleProduct;
import com.comprayahorraback.marketplace.entity.UserCa;


public class SaleMapper {

    /**
     * "This method receives a sale request from the front-end and converts it into a sale entity to store it in the database."
     * @param saleReq
     * @return sale
     */
    public Sale saleRequestToSaleEntity(SaleRequest saleReq){

        Sale sale = new Sale();
        UserCa userca = new UserCa();
        List<SaleProduct> sale_products = new ArrayList<SaleProduct>();

        List<ProductSaleRequest> productList = saleReq.getProducts_sold();

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



    /**
     * this method convert a sale entity from the data base to a saleResponse by id
     * @param sale
     * @param saleProducts
     * @param products
     * @return saleResponse
     */
    public SaleResponse saleEntityToSaleResponse(Sale sale, List<SaleProduct> saleProducts, List<Product> products){

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
