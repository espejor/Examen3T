package modelo.ficheros;

import modelo.Dibujo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CargarDibujoDeFichero {
    private final File archivo= new File("src/archivos/figuras.ser");
    private ObjectInputStream entrada; // envía los datos a un archivo
    private Dibujo dibujo;

    public CargarDibujoDeFichero() throws IOException {
        abrirArchivo();
        leerRegistro();
        cerrarArchivo();
    }


    private void abrirArchivo() throws IOException {
        try {
            entrada = new ObjectInputStream(new FileInputStream(archivo));
        } catch (IOException e) {
            throw new IOException("Error al abrir el archivo");
        }
    }

    private void leerRegistro() throws IOException {
        try {
            dibujo = (Dibujo) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Error al leer el archivo");
        }

    }

    private void cerrarArchivo() throws IOException {
        try {
            entrada.close();
        } catch (IOException e) {
            throw new IOException("Error al cerrar el archivo");
        }
    }

    /**
     * Getter de dibujo
     * @return dibujo
     */
    public Dibujo getDibujo() {
        return dibujo;
    }
}
