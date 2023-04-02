/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class Handler {
    public final int ERROR = JOptionPane.ERROR_MESSAGE; 
    public final int QUESTION = JOptionPane.QUESTION_MESSAGE; 
    public final int PLAIN = JOptionPane.PLAIN_MESSAGE; 
    public final int INFORMATION = JOptionPane.INFORMATION_MESSAGE; 
    
    public void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(null, message, title, type);
    }
            
    public int inputInt(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, message));
    }
    
    public float inputFloat(String message) {
        return Float.parseFloat(JOptionPane.showInputDialog(null, message));
    }
    
    public String inputString(String message) {
        return JOptionPane.showInputDialog(null, message);
    }
    
    public byte inputByte(String message) {
        return Byte.parseByte(JOptionPane.showInputDialog(null, message));
    }
    
    public long inputLong(String message) {
        return Long.parseLong(JOptionPane.showInputDialog(null, message));
    }
    
    public String capitalize(String text) {
        return text.substring(0,1).toUpperCase() + text.substring(1, text.length());
    }
    
    public String readFile(String fileName) throws IOException {
        String fileContent = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        
            
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            fileContent += line + "\n";
        }

        bufferedReader.close();
        return fileContent;
    }
}
