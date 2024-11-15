package services;

import world.Producto;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GestorProductos {

    public static final int TAM_MAX_ID = 8;
    public static final int TAM_MAX_NOM = 20;
    public static final int TAMANIO_REGISTRO = (TAM_MAX_ID + TAM_MAX_NOM + 10 + 6 + 10);// 10 de doble 6 de int
    private String path = "data\\producto.txt";


    public String setTamanioID(String cadena) {
        if (cadena.length() < TAM_MAX_ID) {
            int espFaltantes = TAM_MAX_ID - cadena.length();
            cadena = cadena + " ".repeat(espFaltantes);
        } else if (cadena.length() > TAM_MAX_ID) {
            cadena = cadena.substring(0, TAM_MAX_ID);
        }
        return cadena;
    }

    public String setTamanioMon(String cadena) {
        if (cadena.length() < TAM_MAX_NOM) {
            int espFaltantes = TAM_MAX_NOM - cadena.length();
            cadena = cadena + " ".repeat(espFaltantes);
        } else if (cadena.length() > TAM_MAX_NOM) {
            cadena = cadena.substring(0, TAM_MAX_NOM);
        }
        return cadena;
    }

    public void addProductos(Producto producto) {
        RandomAccessFile fileProducto = null;
        try {
            fileProducto = new RandomAccessFile(path, "rw");

            fileProducto.seek(fileProducto.length());

            if (producto.getId().length() > TAM_MAX_ID) {
                JOptionPane.showMessageDialog(null, "ID Demasiado larga (Máx. 8 caracteres)", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else if (producto.getNombre().length() > TAM_MAX_NOM) {
                JOptionPane.showMessageDialog(null, "Nombre del producto demasiado largo (Máx. 20 caracteres)", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }


            fileProducto.writeUTF(setTamanioID(producto.getId()));
            fileProducto.writeUTF(setTamanioMon(producto.getNombre()));
            fileProducto.writeDouble(producto.getValor());
            fileProducto.writeInt(producto.getUnidadesDisponibles());
            fileProducto.writeUTF(producto.getEstado());

            fileProducto.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarProducto(String idDelete){
        RandomAccessFile fileProducto = null;
        int cont = 0;
        try {
            fileProducto = new RandomAccessFile(path, "rw");

            String id;
            while(true){
                id = fileProducto.readUTF();
                fileProducto.readUTF();
                fileProducto.readDouble();
                fileProducto.readInt();
                fileProducto.readUTF();
                cont++;
                if (idDelete.trim().equals(id.trim())) {
                    fileProducto.seek((TAMANIO_REGISTRO * cont) - 10);
                    fileProducto.writeUTF(Producto.getEstadoInactivo());
                    fileProducto.close();
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileProducto.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void actualizarValor(String idSearch, double valNuevo){
        RandomAccessFile fileProducto = null;
        int cont = 0;
        try {
            fileProducto = new RandomAccessFile(path, "rw");
            fileProducto.seek(0);
            String id;
            while(true){
                id = fileProducto.readUTF();
                fileProducto.readUTF();
                fileProducto.readDouble();
                fileProducto.readInt();
                fileProducto.readUTF();
                cont++;
                if (idSearch.trim().equals(id.trim())) {
                    fileProducto.seek((TAMANIO_REGISTRO * cont) - 8 - 4 - 10);
                    fileProducto.writeDouble(valNuevo);
                    fileProducto.close();
                    return;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileProducto.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void readAllProductos() {
        RandomAccessFile fileProducto = null;


        try {
            fileProducto = new RandomAccessFile(path, "rw");
            fileProducto.seek(0);
            String id;
            String nombre;
            double valor;
            int cantidad;
            String estado;

            while (true) {
                id = fileProducto.readUTF();
                nombre = fileProducto.readUTF();
                valor = fileProducto.readDouble();
                cantidad = fileProducto.readInt();
                estado = fileProducto.readUTF();

                if (estado.equalsIgnoreCase("ACTIVO  ") ){
                    System.out.println("Id: " + id + " - Nombre: " + nombre + " - valor: " + valor + " - cantidad: " + cantidad + " - estado: " + estado);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error abriendo el archivo!" + e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("FIN DEL ARCHIVO!");
        } finally {
            try {
                fileProducto.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
