package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("product1");
        Item item1 = new Item(BigDecimal.TEN, 5, BigDecimal.ONE);
        Item item2 = new Item(BigDecimal.TEN, 5, BigDecimal.ONE);
        Item item3 = new Item(BigDecimal.TEN, 5, BigDecimal.ONE);

        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product1.getItems().add(item3);
        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product1);

        Invoice invoice = new Invoice("1");

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        invoiceDao.save(invoice);
        int id = invoice.getId();

        Assert.assertNotEquals(0, id);

        //CleanUp
        invoiceDao.delete(invoice);
    }
}
