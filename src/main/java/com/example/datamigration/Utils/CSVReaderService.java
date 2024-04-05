package com.example.datamigration.Utils;


import com.example.datamigration.Model.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderService {



    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public CSVReaderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MigrationData> readDataFromCSV(MultipartFile file,MultipartFile file2,MultipartFile file3,MultipartFile file4,
    MultipartFile file5,MultipartFile file6,MultipartFile file7,MultipartFile file8,MultipartFile file9) {
        try {
            List<MigrationData> migrationData = new ArrayList<>();
            MigrationData migrationData1 = new MigrationData();
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            CsvToBean<ProductItems> csvToBean = new CsvToBeanBuilder<ProductItems>(reader)
                    .withType(ProductItems.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            migrationData1.setProductItems(csvToBean.parse());

            BufferedReader reader1 = new BufferedReader(new InputStreamReader(file2.getInputStream()));

            CsvToBean<SupplierItemsModel> csvToBean1 = new CsvToBeanBuilder<SupplierItemsModel>(reader1)
                    .withType(SupplierItemsModel.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            migrationData1.setSupplierItemsModels(csvToBean1.parse());

            BufferedReader reader2 = new BufferedReader(new InputStreamReader(file3.getInputStream()));

            CsvToBean<ReceiptModel> csvToBean2 = new CsvToBeanBuilder<ReceiptModel>(reader2)
                    .withType(ReceiptModel.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            migrationData1.setReceiptModels(csvToBean2.parse());

            BufferedReader reader3 = new BufferedReader(new InputStreamReader(file4.getInputStream()));

            CsvToBean<PurchaseItemsModel> csvToBean3 = new CsvToBeanBuilder<PurchaseItemsModel>(reader3)
                    .withType(PurchaseItemsModel.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            migrationData1.setPurchaseItemsModels(csvToBean3.parse());


            //PurchaseIn
            BufferedReader reader4 = new BufferedReader(new InputStreamReader(file5.getInputStream()));

            CsvToBean<PurchaseInvoice> csvToBean4 = new CsvToBeanBuilder<PurchaseInvoice>(reader4)
                    .withType(PurchaseInvoice.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            migrationData1.setPurchaseInvoices(csvToBean4.parse());

            //ProductT
            BufferedReader reader5 = new BufferedReader(new InputStreamReader(file6.getInputStream()));

            CsvToBean<ProductTable> csvToBean5 = new CsvToBeanBuilder<ProductTable>(reader5)
                    .withType(ProductTable.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            migrationData1.setProductTables(csvToBean5.parse());

            //pAYMENT]
            BufferedReader reader6 = new BufferedReader(new InputStreamReader(file7.getInputStream()));

            CsvToBean<Payment> csvToBean6 = new CsvToBeanBuilder<Payment>(reader6)
                    .withType(Payment.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            migrationData1.setPayments(csvToBean6.parse());

            //Invoice
            BufferedReader reader7 = new BufferedReader(new InputStreamReader(file8.getInputStream()));

            CsvToBean<Invoice> csvToBean7 = new CsvToBeanBuilder<Invoice>(reader7)
                    .withType(Invoice.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            migrationData1.setInvoices(csvToBean7.parse());

            //Cust
            BufferedReader reader8 = new BufferedReader(new InputStreamReader(file9.getInputStream()));

            CsvToBean<Customer> csvToBean8 = new CsvToBeanBuilder<Customer>(reader8)
                    .withType(Customer.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            migrationData1.setCustomers(csvToBean8.parse());
            migrationData.add(migrationData1);


           insertData(migrationData);

            return migrationData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertData(List<MigrationData> migrationData){

        if (migrationData.size()>0){
            for (int i=0; i<migrationData.size(); i++){
                insertCustomer(migrationData.get(i).getCustomers());
                insertInvoice(migrationData.get(i).getInvoices());
                insertProduct(migrationData.get(i).getProductTables());
            }
        }

    }

    public void insertCustomer(List<Customer> customers){


        if (customers.size()>0){
            for (int i=0; i<customers.size(); i++){

                String phone_number = customers.get(i).getPhone_number();
                if (phone_number!=null){
                    if (phone_number.contains("971")){
                        phone_number.replace("971","").trim();
                    }
                }
                int customer_category =0;
                String catgory =  customers.get(i).getGst_treatment();
                String[] catgory_array = catgory.split("-");
                if (catgory_array!=null && catgory_array.length>0){
                    String cat = catgory_array[1];
                    if (cat!=null && cat.equalsIgnoreCase("Walk in Customer")){
                        customer_category =1;
                    }else if (cat!=null && cat.equalsIgnoreCase("Regular Customer")){
                        customer_category =2;
                    }else if (cat!=null && cat.equalsIgnoreCase("Office Clients")){
                        customer_category =3;
                    }else if (cat!=null && cat.equalsIgnoreCase("VIP")){
                        customer_category =4;
                    }else if (cat!=null && cat.equalsIgnoreCase("Others")){
                        customer_category =5;
                    }
                }
                int getCustomerId = getLastId();
                String userName = getUniqueIds(getCustomerId,2,"");
                String address2 = customers.get(i).getContact_name()+","+customers.get(i).getAddress2();

                String queryCustomerInsert = "INSERT INTO `customers` (`name`, `businessTypeId`, `isRegistered`, `trnNo`, `jobPosition`, `phone`, `mobile`, `email`, `website`, `title`, `userName`, `customerCategoryId`, `paymentTerm`, `createdBy`) VALUES ('" + customers.get(i).getName() + "', '" + 1 + "', '" +"" + "', '" + "" + "', '" + "" + "','" + "" + "', '" + phone_number + "', '" + customers.get(i).getEmail() + "', '" + "" + "', '" + "" + "','" + userName + "', '" + customer_category + "', '" + "" + "', '" + "" + "')";

                jdbcTemplate.execute(queryCustomerInsert);
                int country_id =0;
                String country = customers.get(i).getCountry();
                if (country!=null && country.equalsIgnoreCase("IN")){
                    country_id =1;
                }else if (country!=null && country.equalsIgnoreCase("UAE")){
                    country_id =2;
                }
                insertAddress(customers.get(i).getId(),customers.get(i).getAddress1(),address2,customers.get(i).getState(),customers.get(i).getCity(),customers.get(i).getPostal_code(),country_id);
            }
        }

    }

    public void insertSupplier(List<SupplierItemsModel> customers){


        if (customers.size()>0){
            for (int i=0; i<customers.size(); i++){

                String phone_number = customers.get(i).getPhone_number();
                if (phone_number!=null){
                    if (phone_number.contains("971")){
                        phone_number.replace("971","").trim();
                    }
                }
                int customer_category =0;
                String catgory =  customers.get(i).getGst_treatment();
                String[] catgory_array = catgory.split("-");
                if (catgory_array!=null && catgory_array.length>0){
                    String cat = catgory_array[1];
                    if (cat!=null && cat.equalsIgnoreCase("Walk in Customer")){
                        customer_category =1;
                    }else if (cat!=null && cat.equalsIgnoreCase("Regular Customer")){
                        customer_category =2;
                    }else if (cat!=null && cat.equalsIgnoreCase("Office Clients")){
                        customer_category =3;
                    }else if (cat!=null && cat.equalsIgnoreCase("VIP")){
                        customer_category =4;
                    }else if (cat!=null && cat.equalsIgnoreCase("Others")){
                        customer_category =5;
                    }
                }
                int getCustomerId = getLastId();
                String userName = getUniqueIds(getCustomerId,3,"");
                String address2 = customers.get(i).getContact_name()+","+customers.get(i).getAddress2();

                String queryCustomerInsert = "INSERT INTO `customers` (`name`, `businessTypeId`, `isRegistered`, `trnNo`, `jobPosition`, `phone`, `mobile`, `email`, `website`, `title`, `userName`, `customerCategoryId`, `paymentTerm`, `createdBy`) VALUES ('" + customers.get(i).getName() + "', '" + 1 + "', '" +"" + "', '" + "" + "', '" + "" + "','" + "" + "', '" + phone_number + "', '" + customers.get(i).getEmail() + "', '" + "" + "', '" + "" + "','" + userName + "', '" + customer_category + "', '" + "" + "', '" + "" + "')";

                jdbcTemplate.execute(queryCustomerInsert);
                int country_id =0;
                String country = customers.get(i).getCountry();
                if (country!=null && country.equalsIgnoreCase("IN")){
                    country_id =1;
                }else if (country!=null && country.equalsIgnoreCase("UAE")){
                    country_id =2;
                }
                insertAddress(customers.get(i).getId(),customers.get(i).getAddress1(),address2,customers.get(i).getState(),customers.get(i).getCity(),customers.get(i).getPostal_code(),country_id);
            }
        }

    }

    public void insertProduct(List<ProductTable> productTables){

        if (productTables.size()>0){
            for (int i=0; i>productTables.size(); i++){
                String productName = productTables.get(i).getProductName();
                int productId = getProductId();
                String productUniqueId = getUniqueIds(productId,Constant.PRODUCT,productName);
                String description = productTables.get(i).getDescription();
                String main_cat = productTables.get(i).getMain_category();
                String productUrl = "";
                int productType =0;
                int supplierId =0;
                int createdBy =0;
                if (main_cat!=null && main_cat.equalsIgnoreCase("HT Ticket")){
                    productType =3;
                }else if (main_cat!=null && main_cat.equalsIgnoreCase("HT Ticket")){
                    productType =1;
                }
                if (productType!=0){
                    String query =  "Insert INTO product (supplierId,productName,productType,productId,productDescription,productUrl, createdBy) VALUES ('"+supplierId+"','"+productName+"','"+productType+"','"+productUniqueId+"','"+description+"','"+productUrl+"', '" + createdBy + "')";
                    jdbcTemplate.execute(query);
                }

            }
        }

    }

    public int getProductId() {
        String query = "SELECT id FROM product ORDER BY id DESC LIMIT 1";


        return jdbcTemplate.query(query, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return rs.getInt("id");
                }
                return 0;
            }
        });
    }


    public void insertInvoice(List<Invoice> invoices){

        if (invoices.size()>0){
            for (int i=0; i<invoices.size(); i++){
                int customer_Id = getCustomerId(invoices.get(i).getCustomer_Name());
                String invoice_due_date = invoices.get(i).getInvoice_due_date();
                if (invoice_due_date!=null && invoice_due_date.equalsIgnoreCase("0000-00-00")){
                    invoice_due_date = invoices.get(i).getInvoice_date();
                }
                int isDraft = 0;
                if (invoices.get(i).getInvoice_stage()!=null && invoices.get(i).getInvoice_stage().equalsIgnoreCase("Invoice")){
                    isDraft =0;
                }else {
                    isDraft = 1;
                }
                String invoiceOrderId = "";
                int getInvoiceId = getInvoiceOrderId();
                if(isDraft==0){
                    invoiceOrderId = getUniqueIds(getInvoiceId,Constant.INVOICE,null);
                } else {
                    invoiceOrderId = getUniqueIds(getInvoiceId,Constant.INVOICE_DRAFTER,null);
                }

                int createdBy =0;
                String createInvoiceQuery = "INSERT INTO `invoice` (`createdBy`, `customerId`, `invoiceDate`, `dueDate`, `net`, `referenceNumber`, `memo`, `globalDiscount`, `invoiceOrderId`, `isTaxInvoice`, `isDrafted`) VALUES ('"+createdBy+"', '"+customer_Id+"', '"+invoices.get(i).getInvoice_date()+"', '"+invoice_due_date+"', '0', '', '', '0', '"+invoiceOrderId+"', '0', "+isDraft+")";
                jdbcTemplate.execute(createInvoiceQuery);

            }
        }

    }

    public int getCustomerId(String name) {
        String query = null;
        query = "SELECT id FROM customers where name='"+name+"'";
        return jdbcTemplate.query(query, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return rs.getInt("id");
                }
                return 0;
            }
        });
    }

    public int getInvoiceOrderId() {
        String query = "SELECT id FROM invoice ORDER BY id DESC LIMIT 1";
        return jdbcTemplate.query(query, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return rs.getInt("id");
                }
                return 0;
            }
        });
    }


    public void insertAddress(Object customerId,String address1,String address2,String state,String city,String zipcode,int country){
        String addCustomerAddressQuery = "INSERT INTO `address` (`customerId`, `addressLine1`, `addressLine2`, `city`, `state`, `country`, `zipcode`, `landmark`, `addressTypeId`) VALUES ('"+customerId+"', '"+address1+"', '"+address2+"', '"+city+"', '"+state+"', '"+country+"', '"+zipcode+"', '"+"', 1)";
        jdbcTemplate.execute(addCustomerAddressQuery);
    }

    public int getLastId() {
        String query = null;
        query = "SELECT id FROM customers ORDER BY id DESC LIMIT 1";
        return jdbcTemplate.query(query, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return rs.getInt("id");
                }
                return 0;
            }
        });
    }

    public static String getUniqueIds(int id,int type,String name){
        String unique_id ="";
        String formattedProductId ="";
        int incrementedId =0;
        if (String.valueOf(id).length()>4){
            incrementedId = id + 1;
            formattedProductId = String.valueOf(incrementedId);
        }else {
            incrementedId = id + 1;
            formattedProductId = String.format("%04d", incrementedId);
        }


        String result ="";

        switch (type){
            case Constant.PRODUCT:
                result = name+"-"+ Year.now().getValue()+"/"+formattedProductId;
                //Nick Shoe-2024/0102
                break;
            case Constant.CUSTOMER_1:
                result = "C"+"-"+ Year.now().getValue()+"/"+formattedProductId;
                break;
            case Constant.CUSTOMER_2:
                result = "C"+"-"+ Year.now().getValue()+"/"+formattedProductId;
                //C-2024/0176
                break;
            case Constant.SUPPLIER:
                result = "SV"+"-"+ Year.now().getValue()+"/"+formattedProductId;
                //SV-2024/0182
                break;
            case Constant.PURCHASE_ORDER:
                result = "PO"+"-"+ Year.now().getValue()+"/"+formattedProductId;
                //SV-2024/0182
                break;
            case Constant.INVOICE:
                result = "INV"+"-"+ Year.now().getValue()+"/"+formattedProductId;
                break;
            case Constant.INVOICE_DRAFTER:
                result = "INV-DR"+"-"+ Year.now().getValue()+"/"+formattedProductId;
                break;
            case Constant.PAYMENT_ID:
                result = "PV"+"-"+ Year.now().getValue()+"/"+formattedProductId;
                break;
            case Constant.RECEIPT_ID:
                result = "REC"+"-"+ Year.now().getValue()+"/"+formattedProductId;
                break;
            case Constant.INCOME_ID:
                result = "INC"+"-"+ Year.now().getValue()+"/"+formattedProductId;
                break;
            default:
                break;
        }
        return result;
    }
}
