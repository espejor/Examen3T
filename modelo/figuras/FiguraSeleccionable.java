package modelo.figuras;

import java.awt.*;

public abstract class FiguraSeleccionable extends Figura implements Seleccionable {
    protected boolean relleno = false;

    public void mover(Point puntoInicioFiguraSeleccionada, Point puntoInicialDesplazamiento, Point puntoFinalDesplazamiento) {
        this.inicio.x = puntoInicioFiguraSeleccionada.x + puntoFinalDesplazamiento.x - puntoInicialDesplazamiento.x;
        this.inicio.y = puntoInicioFiguraSeleccionada.y +puntoFinalDesplazamiento.y - puntoInicialDesplazamiento.y;
    }

    @Override
    public void rellenar() {
        relleno = !relleno;
    }
}
