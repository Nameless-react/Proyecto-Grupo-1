/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class Facturas implements Facturacion {
    private String user;
    private String date;
    private String descriptionAtraction;
    private int amount;
    private int invoiceNumber = 0;
    public static ArrayList<Facturas> invoices = new ArrayList<>();
    
    public static long totalMoneyEarn = 0;
    
    public Facturas(String user, String date, String descriptionAtraction, int amount, int invoiceNumber) {
        this.amount = amount;
        this.date = date;
        this.descriptionAtraction = descriptionAtraction;
        this.user = user;
        this.invoiceNumber = invoiceNumber;
    }
    
    public Facturas () {};
    
    @Override
    public void cancelInvoice(int invoiceNumber) {
        Handler handler = new Handler();
        totalMoneyEarn -= this.amount;
        
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getInvoiceNumber() == invoiceNumber) {
                invoices.remove(i);
                handler.showMessage("Factura anulada", "Número factura: " + String.valueOf(invoiceNumber), handler.INFORMATION);
                return;
            }
        }
        
        handler.showMessage("Número de factura no encontrado", "Error 404", handler.ERROR);
    }

    @Override
    public void addInvoice() {
        Handler handler = new Handler();
        totalMoneyEarn += this.amount;
        
        for (int i = 0; i < invoices.size(); i++) {
            if (this.equals(invoices.get(i))) {
                this.setInvoiceNumber(this.getInvoiceNumber() + 1);
            }
        }
        
        invoices.add(this);
        handler.showMessage("Factura guardada exitosamente", "Guardado", handler.INFORMATION);
    }
    
    @Override
    public ArrayList<Facturas> getInvoices(String fileName) {
        Handler handler = new Handler();
        String fileContent = "";
        
        if (!invoices.isEmpty()) return invoices;
        
        try {
            fileContent = handler.readFile(fileName);
        } catch (IOException ex01) {
            
            if (ex01.getMessage().matches("[0-9A-Za-z]*\\.txt \\(No such file or directory\\)")) {
              
              try {
                  BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                  writer.write("\n1\n" +
                            "Ignacio\n" +
                            "12/3/2023 12:30\n" +
                            "Atracciones de agua\n" +
                            "1000\n" +
                            "|");
                writer.close(); 
                
                
                
                invoices.add(new Facturas("Ignacio", "12/3/2023 12:30", "Atracciones de agua", 1000, invoices.size() + 1));
                return invoices;
                
              } catch (IOException ex02) {
                  handler.showMessage("Error al crear archivo: " + ex02.getMessage(), "Error", handler.ERROR);
                  return new ArrayList<>();
              }
            }
            
            
            
            
            handler.showMessage("Error al leer el archivo: " + ex01.getMessage(), "Error", handler.ERROR);
            return new ArrayList<>();
        }
        
        
        
        String[] fileContentList = fileContent.split("\\|");
       
        for (int i = 0; i < fileContentList.length; i++) {
            String[] invoice = fileContentList[i].trim().split("\n");
            if (invoice.length < 3) continue;
            
            try {
                invoices.add(new Facturas(invoice[1], invoice[2], invoice[3], Integer.parseInt(invoice[4]), Integer.parseInt(invoice[0]))); 
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                handler.showMessage("Error en la conversión de datos: " + e.getMessage(), "Error", handler.ERROR);
            }
        }
        return invoices;
    }
    

    @Override
    public void safeInvoices(String fileName) {
        Handler handler = new Handler();
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String data = "";
            for (Facturas invoice : invoices) {
                data += "\n"
                        + invoice.getInvoiceNumber()+ "\n"
                        + invoice.getUser() + "\n"
                        + invoice.getDate() + "\n"
                        + invoice.getDescriptionAtraction() + "\n"
                        + invoice.getAmount() + "\n"
                        + "|";                
            }
            
            writer.write(data);
            writer.close();
        } catch (IOException ex) {
            handler.showMessage("Error al guardar los datos", "Error", handler.ERROR);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.invoiceNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        
        final Facturas other = (Facturas) obj;
        return this.invoiceNumber == other.invoiceNumber;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescriptionAtraction() {
        return descriptionAtraction;
    }

    public void setDescriptionAtraction(String descriptionAtraction) {
        this.descriptionAtraction = descriptionAtraction;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}