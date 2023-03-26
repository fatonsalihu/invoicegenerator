package com.example.demo.controller;

import com.example.demo.services.InvoiceServices;
import com.example.demo.transport.Invoice;
import com.example.demo.transport.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceServices invoiceServices;

    public InvoiceController(InvoiceServices invoiceServices) {
        this.invoiceServices = invoiceServices;
    }

    @PostMapping
    public ArrayList<Invoice> getInvoices(@RequestBody Product[] products){
        return this.invoiceServices.getInvoices(Arrays.asList(products));
    }

}
