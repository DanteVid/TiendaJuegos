package services;

import world.Administrador;

import javax.swing.*;
import java.io.RandomAccessFile;

public class GestorAdministrador {

    public static final int TAM_MAX_ID = 8;
    public static final int TAM_MAX_USERNAME = 15;
    public static final int TAM_MAX_PASSWORD = 15;
    public static final int TAM_REGISTRO = (TAM_MAX_ID + TAM_MAX_USERNAME + TAM_MAX_PASSWORD + 8 + 10 + 6); //8 del salario(double), 10 del estado, 6 de los bytes extras
    private String path = "data\\administrador.txt";


    public String setTamanioID(String cadena) {
        if (cadena.length() < TAM_MAX_ID) {
            int espFaltantes = TAM_MAX_ID - cadena.length();
            cadena = cadena + " ".repeat(espFaltantes);
        } else if (cadena.length() > TAM_MAX_ID) {
            cadena = cadena.substring(0, TAM_MAX_ID);
        }
        return cadena;
    }
    public String setTamanioUsername(String cadena) {
        if (cadena.length() < TAM_MAX_USERNAME) {
            int espFaltantes = TAM_MAX_USERNAME - cadena.length();
            cadena = cadena + " ".repeat(espFaltantes);
        } else if (cadena.length() > TAM_MAX_USERNAME) {
            cadena = cadena.substring(0, TAM_MAX_USERNAME);
        }
        return cadena;
    }
    public String setTamanioPassword(String cadena) {
        if (cadena.length() < TAM_MAX_PASSWORD) {
            int espFaltantes = TAM_MAX_PASSWORD - cadena.length();
            cadena = cadena + " ".repeat(espFaltantes);
        } else if (cadena.length() > TAM_MAX_PASSWORD) {
            cadena = cadena.substring(0, TAM_MAX_PASSWORD);
        }
        return cadena;
    }
    
    public void addAdmin(Administrador administrador) {
        RandomAccessFile fileAdmin = null;
        try {
            fileAdmin = new RandomAccessFile(path, "rw");

            fileAdmin.seek(fileAdmin.length());

            if(administrador.getId().length()>TAM_MAX_ID){
                JOptionPane.showMessageDialog(null, "ID Demasiado larga (Máx. 8 caracteres)", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }else if(administrador.getUsername().length()>TAM_MAX_USERNAME){
                JOptionPane.showMessageDialog(null, "Nombre de usuario demasiado largo (Máx. 15 caracteres)", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else if(administrador.getPassword().length()>TAM_MAX_PASSWORD){
                JOptionPane.showMessageDialog(null, "Contraseña demasiado larga (Máx. 15 caracteres)", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            fileAdmin.writeUTF(setTamanioID(administrador.getId()));
            fileAdmin.writeUTF(setTamanioUsername(administrador.getUsername()));
            fileAdmin.writeUTF(setTamanioPassword(administrador.getPassword()));
            fileAdmin.writeDouble(administrador.getSalario());
            fileAdmin.writeUTF(administrador.getEstado());

            fileAdmin.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
