package modelo.ficheros;

import modelo.IDibujo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardarDibujoEnFichero {
    private final File archivo= new File("src/archivos/figuras.ser");
    private ObjectOutputStream salida; // envía los datos a un archivo

    public GuardarDibujoEnFichero(IDibujo dibujo) throws IOException{
        abrirArchivo();
        agregarRegistro(dibujo);
        cerrarArchivo();
    }

    private void abrirArchivo() throws IOException{
        try {
            salida = new ObjectOutputStream(new FileOutputStream(archivo));
        } catch (IOException e) {
            throw new IOException("Error al abrir el archivo");
        }
    }

    private void agregarRegistro(IDibujo dibujo) throws IOException {
        try {
            salida.writeObject(dibujo);
        } catch (IOException e) {
            throw new IOException("Error al guardar el archivo");
        }
    }

    private void cerrarArchivo() throws IOException {
        try {
            if(salida != null)
            salida.close();
        } catch (IOException e) {
            throw new IOException("Error al cerrar el archivo");
        }
    }

}
