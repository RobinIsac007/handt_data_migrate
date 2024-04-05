package com.example.datamigration.Utils;

import com.example.datamigration.Model.*;

import java.util.ArrayList;
import java.util.List;

public class MigrationData {

    public List<ProductItems> productItems = new ArrayList<>();
    public List<SupplierItemsModel> supplierItemsModels = new ArrayList<>();
    public List<ReceiptModel> receiptModels = new ArrayList<>();
    public List<PurchaseItemsModel> purchaseItemsModels = new ArrayList<>();
    public List<PurchaseInvoice> purchaseInvoices = new ArrayList<>();
    public List<ProductTable> productTables = new ArrayList<>();
    public List<Payment> payments = new ArrayList<>();
    public List<Invoice> invoices = new ArrayList<>();
    public List<Customer> customers = new ArrayList<>();

    public List<ProductItems> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItems> productItems) {
        this.productItems = productItems;
    }

    public List<SupplierItemsModel> getSupplierItemsModels() {
        return supplierItemsModels;
    }

    public void setSupplierItemsModels(List<SupplierItemsModel> supplierItemsModels) {
        this.supplierItemsModels = supplierItemsModels;
    }

    public List<ReceiptModel> getReceiptModels() {
        return receiptModels;
    }

    public void setReceiptModels(List<ReceiptModel> receiptModels) {
        this.receiptModels = receiptModels;
    }

    public List<PurchaseItemsModel> getPurchaseItemsModels() {
        return purchaseItemsModels;
    }

    public void setPurchaseItemsModels(List<PurchaseItemsModel> purchaseItemsModels) {
        this.purchaseItemsModels = purchaseItemsModels;
    }

    public List<PurchaseInvoice> getPurchaseInvoices() {
        return purchaseInvoices;
    }

    public void setPurchaseInvoices(List<PurchaseInvoice> purchaseInvoices) {
        this.purchaseInvoices = purchaseInvoices;
    }

    public List<ProductTable> getProductTables() {
        return productTables;
    }

    public void setProductTables(List<ProductTable> productTables) {
        this.productTables = productTables;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
