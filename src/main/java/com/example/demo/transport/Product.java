package com.example.demo.transport;

public class Product {
    private String name;
    private int quantity;

    private double price;
    private double discount;
    private int VAT;

    public Product(String name, int quantity, double price, double discount, int VAT){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.discount=discount;
        this.VAT = VAT;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public int getVAT() {
        return VAT;
    }

    public double getPrice() {
        return price;
    }

    public void substractQty(int n){
        this.quantity-=n;
    }

    public double getSubTotal(){
        return quantity*(this.price-this.discount);
    }

    public double getVATTotal(){
        return getSubTotal()*((double)this.VAT/100);
    }

    public double getTotal(){
        return getSubTotal()+getVATTotal();
    }

    public double getPricePerNItems(int n){
        double beforeVAT = (Math.min(n,quantity))*(this.price-this.discount);
        double afterVAT = beforeVAT*((double)this.VAT/100);
        return beforeVAT+afterVAT;
    }

    public double getPricePerProduct(){
        double beforeVAT = (this.price-this.discount);
        double afterVAT = beforeVAT*((double)this.VAT/100);
        return beforeVAT+afterVAT;
    }

    public void resetQuantity(){
        this.quantity=0;
    }

    public String toString(){
        return this.name+" "+this.quantity+" "+this.price;
    }
}
