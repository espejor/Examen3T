package controlador;

import modelo.IModelo;
import vista.IVista;

import javax.swing.*;
import java.io.IOException;

public class Controlador  implements IControlador{
    private final IModelo modelo;
    private final IVista vista;

    private String figuraSeleccionadaEnMenu = IVista.LINEA;

    public Controlador(IModelo modelo, IVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        setControllers();
        vista.setDibujo(modelo.getDibujo());

    }


    private void setControllers() {
        vista.setControladorMenu(new ControladorMenu(this));
        vista.setControladorRaton(new ControladorRaton(this));
    }

    public void updateVista() {
        vista.update();
    }

    /**
     * Getter de modelo
     * @return modelo
     */
    public IModelo getModelo() {
        return modelo;
    }



    public void guardarDibujo() {
        try {
            getModelo().guardarDibujo();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),
                    "Error de I/O",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void abrirDibujo() {
        try {
            vista.setDibujo(getModelo().abrirDibujo());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),
                    "Error de I/O",JOptionPane.ERROR_MESSAGE);
        }

        updateVista();
    }

    public void creaNuevoDibujo() {
        vista.setDibujo(getModelo().nuevoDibujo());
        updateVista();
    }


    public void creaDialogoAyuda() {
        String txt =
                "Examen 3T es un peque�o programa de dise�o\n" +
                        "de figuras geom�tricas. Para aprobar el curso\n" +
                        "se deben haber implementado correctamente las\n" +
                        "vistas y m�todos, as� como la estructura de\n" +
                        "clases e interfaces.";
        JOptionPane.showMessageDialog(null,txt);
    }



    /**
     * Setter de figuraSeleccionadaEnMenu
     * @param figuraSeleccionadaEnMenu del tipo java.lang.String
     */
    public void setFiguraSeleccionadaEnMenu(String figuraSeleccionadaEnMenu) {
        this.figuraSeleccionadaEnMenu = figuraSeleccionadaEnMenu;
    }

    /**
     * Getter de figuraSeleccionadaEnMenu
     * @return figuraSeleccionadaEnMenu
     */
    public String getFiguraSeleccionadaEnMenu() {
        return figuraSeleccionadaEnMenu;
    }

}
