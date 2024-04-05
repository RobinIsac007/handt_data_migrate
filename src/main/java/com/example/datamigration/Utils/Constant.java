package com.example.datamigration.Utils;

public class Constant {

    /**
     * NEVER MODIFY THIS QURIES UNTIL PROPERLY TEST
     */

    /**
     * DANGER
     */
    public static final String INVOICE_SUMMARY_BASED_ON_PRODUCT_TYPE = "SELECT *, (select sum(invc.finalAmount) from invoiceProducts invc inner join product product on invc.productId=product.id inner join handtCategories hat on product.productType=hat.id where hat.id = handt.id) as totalInvoiceAmount, (select invc.finalAmount from invoiceProducts invc inner join product product on invc.productId=product.id inner join handtCategories hat on product.productType=hat.id where hat.id = handt.id ORDER BY invc.id DESC LIMIT 1) as lastInvoiceAmount, (select invc.invoiceOrderId from invoiceProducts invc inner join product product on invc.productId=product.id inner join handtCategories hat on product.productType=hat.id where hat.id = handt.id ORDER BY invc.id DESC LIMIT 1) as lastInvoiceId FROM handtCategories handt";
    public static final String PURCHASE_ORDER_BASED_ON_PRODUCT_TYPE = "SELECT *, (select sum(pop.finalAmount) from purchaseOrderProducts pop inner join product product on pop.productId=product.id inner join handtCategories hat on product.productType=hat.id where hat.id = handt.id) as totalPurchaseAmount, (select pop.finalAmount from purchaseOrderProducts pop inner join product product on pop.productId=product.id inner join handtCategories hat on product.productType=hat.id where hat.id = handt.id ORDER BY pop.id DESC LIMIT 1) as lastPurchaseAmount, (select pop.purchaseOrderId from purchaseOrderProducts pop inner join product product on pop.productId=product.id inner join handtCategories hat on product.productType=hat.id where hat.id = handt.id ORDER BY pop.id DESC LIMIT 1) as lastPurchaseId FROM handtCategories handt";

    public static final String GET_ALL_INVOICES_BASED_ON_PRODUCT_TYPE = "select hat.businessType, prod.productName, invc.invoiceOrderId, invc.totalAmount, invc.invoiceUrl, invc.createdAt, cus.name from handtCategories hat inner join product prod on prod.productType=hat.id inner JOIN invoiceProducts invcProd on invcProd.productId=prod.id inner JOIN invoice invc on invc.invoiceOrderId=invcProd.invoiceOrderId INNER JOIN customers cus on cus.id = invc.customerId where  invc.isDrafted=false and hat.id=";

    public static final String GET_ALL_PURCHASE_ORDERS_BASED_ON_PRODUCT_TYPE = "select hat.businessType, prod.productName, porder.purchaseOrderId, porder.totalAmount, porder.supplierPOUrl, porder.createdAt, cus.name from handtCategories hat inner join product prod on prod.productType=hat.id inner JOIN purchaseOrderProducts pop on pop.productId=prod.id inner JOIN purchaseOrder porder on porder.purchaseOrderId=pop.purchaseOrderId INNER JOIN customers cus on cus.id = porder.supplierId where hat.id=";
    public static final int CUSTOMER_1 = 1;
    public static final int CUSTOMER_2 = 2;
    public static final int SUPPLIER = 3;
    public static final int PRODUCT = 4;
    public static final int PURCHASE_ORDER = 5;
    public static final int INVOICE = 6;
    public static final int INVOICE_DRAFTER = 7;
    public static final int PAYMENT_ID = 8;
    public static final int RECEIPT_ID = 9;
    public static final int INCOME_ID = 10;
}
