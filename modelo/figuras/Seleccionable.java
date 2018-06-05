package modelo.figuras;

import java.awt.*;

public interface Seleccionable extends IFigura{

    boolean contiene(Point punto);
    void rellenar();
    void mover(Point puntoInicioFiguraSeleccionada, Point puntoInicial, Point desplazamiento);
}
