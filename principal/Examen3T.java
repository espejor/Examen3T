package principal;

import controlador.Controlador;
import controlador.IControlador;
import modelo.IModelo;
import modelo.Modelo;
import vista.IVista;
import vista.Vista;

public class Examen3T {
    public static void main(String args[]) {
        IVista vista = new Vista();
        IModelo modelo = new Modelo();
        new Controlador(modelo,vista);

        vista.initVista();
    }
}
