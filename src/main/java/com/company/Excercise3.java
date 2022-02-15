package com.company;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;


public class Excercise3 {
    static InvoiceService service;

    public Excercise3(InvoiceService service) {
        this.service = service;
    }
    public static final Cache<Object, Object> CACHE = CacheBuilder
            .newBuilder()
            .maximumSize(1000)
            .build();

    public static Invoice findInvoiceInCacheOrInDatabase(String number){
        Invoice invoice = (Invoice) CACHE.getIfPresent(number);
        if(invoice != null){
            return invoice;
        }
        invoice = service.getInvoice(number);
        CACHE.put(number, invoice);
        return invoice;
    }
}


class InvoiceService{
    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }
    public Invoice getInvoice(String invoiceNumber){
        return repository.find(invoiceNumber);
    }
}
interface InvoiceRepository{
    public Invoice find(final String inNumber);
}
class InvoiceJpaRepository implements  InvoiceRepository{

    @Override
    public Invoice find(String inNumber) {
        return null;
        //...impl
    }
}
class Invoice{
    private String invoiceNumber;
    private Object invoiceData;

    public Invoice(String invoiceNumber, Object invoiceData) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceData = invoiceData;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Object getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(Object invoiceData) {
        this.invoiceData = invoiceData;
    }
}
