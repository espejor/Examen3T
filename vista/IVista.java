package vista;

import controlador.IMouseAdapter;
import modelo.IDibujo;

import java.awt.event.ActionListener;


public interface IVista {
    String ACERCADE = "Acerca de ...";
    String ABRIR = "Abrir";
    String GUARDAR = "Guardar";
    String SALIR = "Salir";
    String NUEVO = "Nuevo";
    String RECTANGULO = "Rectángulo";
    String CIRCULO = "Círculo";
    String LINEA = "Línea";
    String POLIGONO = "Polígono";

    void setControladorRaton(IMouseAdapter controlador);

    void setControladorMenu(ActionListener actionListener);

    void update();

    void initVista();

    void setDibujo(IDibujo dibujo);
}
