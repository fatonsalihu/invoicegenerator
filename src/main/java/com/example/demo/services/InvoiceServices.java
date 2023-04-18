package com.example.demo.services;
import com.example.demo.transport.Invoice;
import com.example.demo.transport.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class InvoiceServices {
    public ArrayList<Invoice> getInvoices (List<Product> products){
        ArrayList<Invoice> invoices = new ArrayList<>();

        for(Product p : products){
            if(p.getPrice()>=500){
                for(int i = 0;i<p.getQuantity();i++){
                    Invoice invoice = new Invoice();
                    invoice.addOverLimitProducts(new Product(p.getName(),1,p.getPrice(),p.getDiscount(),p.getVAT()));
                    invoices.add(invoice);
                }
            }
            else{
                int index = 0;
                while(p.getQuantity()>0){
                    if(index==invoices.size()){
                        invoices.add(new Invoice());
                    }
                    int amount = invoices.get(index).howManyProductPerPrice(p);
                    if(amount==0 || invoices.get(index).getTotal()>=500){
                        index++;
                        continue;
                    }
                    invoices.get(index).addProduct(new Product(p.getName(),amount,p.getPrice(),p.getDiscount(),p.getVAT()));
                    p.substractQty(amount);
                    index++;
                }
            }
        }
        return invoices;
    }
}
