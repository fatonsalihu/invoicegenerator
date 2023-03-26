package com.example.demo.transport;
import java.util.ArrayList;
public class Invoice {
    private ArrayList<Product> products;
    private double total;
    private double subTotal;
    private double vatTotal;
    public Invoice() {
        this.products = new ArrayList<>();
        this.total=0;
        this.subTotal=0;
        this.vatTotal=0;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public int howManyProductPerPrice(Product p){
        int howMany =(int)Math.floor((500-total)/p.getPricePerProduct());
        if(p.getQuantity()>50){
            return Math.min(howMany,50);
        }
        return Math.min(howMany,p.getQuantity());
    }
    public boolean addProduct(Product product) {
        if(product.getQuantity()<=50 && total+product.getPricePerNItems(product.getQuantity())<=500){
            products.add(product);
            total+=product.getPricePerNItems(product.getQuantity());
            subTotal+=product.getSubTotal();
            vatTotal+=product.getVATTotal();
            return true;
        }
        return false;
    }
    public boolean addOverLimitProducts(Product product){
        if(product.getPrice()>=500){
            products.add(product);
            total+=product.getPricePerNItems(1);
            subTotal+=product.getSubTotal();
            vatTotal+=product.getVATTotal();
            return true;
        }
        return false;
    }
    public double getTotal(){
        return total;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public double getVatTotal() {
        return vatTotal;
    }
}
