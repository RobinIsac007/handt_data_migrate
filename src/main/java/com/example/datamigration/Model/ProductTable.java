package com.example.datamigration.Model;

public class ProductTable {

    public Object id;
    public String producttype;
    public String transactiontype;
    public String autonumberfmt;
    public String productName;
    public String VAT;
    public String save_suppliername;
    public String description;
    public String inputQty;
    public String deliveredQty;
    public String purchaseAccount;
    public String purchasePrice;
    public String salesAccount;
    public String salesPrice;
    public String unitOfMeasurement;
    public String offeringType;
    public String product_category;
    public String delete_row;
    public String main_category;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public String getAutonumberfmt() {
        return autonumberfmt;
    }

    public void setAutonumberfmt(String autonumberfmt) {
        this.autonumberfmt = autonumberfmt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getSave_suppliername() {
        return save_suppliername;
    }

    public void setSave_suppliername(String save_suppliername) {
        this.save_suppliername = save_suppliername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputQty() {
        return inputQty;
    }

    public void setInputQty(String inputQty) {
        this.inputQty = inputQty;
    }

    public String getDeliveredQty() {
        return deliveredQty;
    }

    public void setDeliveredQty(String deliveredQty) {
        this.deliveredQty = deliveredQty;
    }

    public String getPurchaseAccount() {
        return purchaseAccount;
    }

    public void setPurchaseAccount(String purchaseAccount) {
        this.purchaseAccount = purchaseAccount;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getSalesAccount() {
        return salesAccount;
    }

    public void setSalesAccount(String salesAccount) {
        this.salesAccount = salesAccount;
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getOfferingType() {
        return offeringType;
    }

    public void setOfferingType(String offeringType) {
        this.offeringType = offeringType;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getDelete_row() {
        return delete_row;
    }

    public void setDelete_row(String delete_row) {
        this.delete_row = delete_row;
    }

    public String getMain_category() {
        return main_category;
    }

    public void setMain_category(String main_category) {
        this.main_category = main_category;
    }
//id	producttype	transactiontype	autonumberfmt
    // productName	VAT	save_suppliername	description	inputQty
    // deliveredQty	purchaseAccount	purchasePrice	salesAccount
    // salesPrice	unitOfMeasurement	offeringType
    // product_category	delete_row
}
