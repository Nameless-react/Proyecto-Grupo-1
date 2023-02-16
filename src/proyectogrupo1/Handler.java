/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class Handler {
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
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
}
