/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectogrupo1;

import java.util.ArrayList;

/**
 *
 * @author joel
 */
public interface Facturacion {
    void cancelInvoice(int invoiceNumber);
    void addInvoice();
    ArrayList<Facturas> getInvoices(String fileName);
    void safeInvoices(String fileName);
}
