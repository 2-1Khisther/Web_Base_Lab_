package com.balat.lab_7.sevice;

import com.balat.lab_7.entity.Customer;
import com.balat.lab_7.entity.Invoice;
import com.balat.lab_7.entity.Product;
import com.balat.lab_7.repository.CustomerRepository;
import com.balat.lab_7.repository.InvoiceRepository;
import com.balat.lab_7.repository.ProductRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.HashSet;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          CustomerRepository customerRepository,
                          ProductRepository productRepository) {
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Optional<Invoice> createInvoice(Long customerId, List<Long> productIds) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isEmpty()) return Optional.empty();

        List<Product> productsList = productRepository.findAllById(productIds);
        if (productsList.size() != productIds.size()) return Optional.empty();

        Invoice invoice = new Invoice(customerOpt.get());
        invoice.setProducts(new HashSet<>(productsList));

        return Optional.of(invoiceRepository.save(invoice));
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }
}
