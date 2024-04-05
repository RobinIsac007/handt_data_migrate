package com.example.datamigration.Model;

public class Invoice {


    public Object ID;
    public String Invoice_id;
    public String Invoice_stage;
    public String Invoice_date;
    public String Customer_Name;
    public String Customer_id;
    public String Invoice_Netdate;
    public String Invoice_due_date;
    public String inv_memo_box;
    public String inv_sales_person;
    public String inv_created_on;
    public String inv_deleted_on;
    public String inv_modified_on;
    public String Totalamount;
    public String Dueamount;
    public String Deliverystatus;
    public String Payment;
    public String inv_del_status;
    //ID	Invoice_id	Invoice_stage	Invoice_date
    // Invoice_due_date	Invoice_Netdate	Customer_id	Customer_Name
    // inv_memo_box	inv_sales_person	inv_created_on	inv_deleted_on
    // inv_modified_on	Totalamount	Dueamount
    // Deliverystatus	Payment	inv_del_status

    public Object getID() {
        return ID;
    }

    public void setID(Object ID) {
        this.ID = ID;
    }

    public String getInvoice_id() {
        return Invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        Invoice_id = invoice_id;
    }

    public String getInvoice_stage() {
        return Invoice_stage;
    }

    public void setInvoice_stage(String invoice_stage) {
        Invoice_stage = invoice_stage;
    }

    public String getInvoice_date() {
        return Invoice_date;
    }

    public void setInvoice_date(String invoice_date) {
        Invoice_date = invoice_date;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    public String getInvoice_Netdate() {
        return Invoice_Netdate;
    }

    public void setInvoice_Netdate(String invoice_Netdate) {
        Invoice_Netdate = invoice_Netdate;
    }

    public String getInvoice_due_date() {
        return Invoice_due_date;
    }

    public void setInvoice_due_date(String invoice_due_date) {
        Invoice_due_date = invoice_due_date;
    }

    public String getInv_memo_box() {
        return inv_memo_box;
    }

    public void setInv_memo_box(String inv_memo_box) {
        this.inv_memo_box = inv_memo_box;
    }

    public String getInv_sales_person() {
        return inv_sales_person;
    }

    public void setInv_sales_person(String inv_sales_person) {
        this.inv_sales_person = inv_sales_person;
    }

    public String getInv_created_on() {
        return inv_created_on;
    }

    public void setInv_created_on(String inv_created_on) {
        this.inv_created_on = inv_created_on;
    }

    public String getInv_deleted_on() {
        return inv_deleted_on;
    }

    public void setInv_deleted_on(String inv_deleted_on) {
        this.inv_deleted_on = inv_deleted_on;
    }

    public String getInv_modified_on() {
        return inv_modified_on;
    }

    public void setInv_modified_on(String inv_modified_on) {
        this.inv_modified_on = inv_modified_on;
    }

    public String getTotalamount() {
        return Totalamount;
    }

    public void setTotalamount(String totalamount) {
        Totalamount = totalamount;
    }

    public String getDueamount() {
        return Dueamount;
    }

    public void setDueamount(String dueamount) {
        Dueamount = dueamount;
    }

    public String getDeliverystatus() {
        return Deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        Deliverystatus = deliverystatus;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String payment) {
        Payment = payment;
    }

    public String getInv_del_status() {
        return inv_del_status;
    }

    public void setInv_del_status(String inv_del_status) {
        this.inv_del_status = inv_del_status;
    }
}
