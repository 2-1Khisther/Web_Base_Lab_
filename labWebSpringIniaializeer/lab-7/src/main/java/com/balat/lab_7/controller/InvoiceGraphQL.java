package com.balat.lab_7.controller;

import com.balat.lab_7.entity.Invoice;
import com.balat.lab_7.sevice.InvoiceService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class InvoiceGraphQL {

    private final InvoiceService invoiceService;

    public InvoiceGraphQL(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @QueryMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @QueryMapping
    public Invoice getInvoiceById(@Argument Long id) {
        return invoiceService.getInvoiceById(id).orElse(null);
    }

    @MutationMapping
    public Invoice createInvoice(
            @Argument Long customerId,
            @Argument List<Long> productIds
    ) {
        return invoiceService.createInvoice(customerId, productIds).orElse(null);
    }
}