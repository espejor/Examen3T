package modelo;

import modelo.figuras.FiguraSeleccionable;
import modelo.figuras.IFigura;

import java.awt.*;

public interface IDibujo {
    void dibujar(Graphics g);
    void agregarFigura(IFigura figura);

    FiguraSeleccionable hasPinchadoEnFigura(Point p) ;

    void eliminarFigura(IFigura figura) ;
}
