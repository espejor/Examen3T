package controlador;

import modelo.figuras.FactoryFigura;
import modelo.figuras.Figura;
import modelo.figuras.FiguraSeleccionable;
import modelo.figuras.IFigura;

import java.awt.*;

import java.awt.event.MouseEvent;


public class ControladorRaton implements IMouseAdapter {
    private final Controlador controlador;

    private IFigura figura;
    private Point puntoInicioFiguraSeleccionada;
    private boolean hePinchadoDentro;
    private FiguraSeleccionable figuraSeleccionada;

    public ControladorRaton(Controlador controlador) {
        this.controlador = controlador;
    }

    /**
     * {@inheritDoc}
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        figura = crearUnaFigura();
        figura.setPuntoInicial(e.getPoint());
        figura.setPuntoFinal(e.getPoint());

        checkSiHaPinchadoDentro(e.getPoint());

        agregarFigura(figura);
    }


    /**
     * {@inheritDoc}
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

        if (figura.esNula() && hePinchadoDentro) {
            figuraSeleccionada.rellenar();
            eliminarFigura(figura);
        }

        if (figura.esNula())
            eliminarFigura(figura);

        controlador.updateVista();
    }


    /**
     * {@inheritDoc}
     * @param e
     * @since 1.6
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (hePinchadoDentro && !figura.esNula()) {
            figuraSeleccionada.mover(puntoInicioFiguraSeleccionada,figura.getInicio(),e.getPoint());
            eliminarFigura(figura);
        }else
            figura.setPuntoFinal(e.getPoint());
        controlador.updateVista();
    }


    private void checkSiHaPinchadoDentro(Point point) {
        figuraSeleccionada = getFiguraPinchada(point);
        hePinchadoDentro = estaDentroElPunto(point);
        if (hePinchadoDentro) {
            puntoInicioFiguraSeleccionada = new Point(figuraSeleccionada.getInicio().x,figuraSeleccionada.getInicio().y);
        }
    }

    private Figura crearUnaFigura() {
        return FactoryFigura.getFigura(controlador.getFiguraSeleccionadaEnMenu());
    }

    private void agregarFigura(IFigura figura) {
        controlador.getModelo().agregarFigura(figura);
    }

    private boolean estaDentroElPunto(Point p){
        return getFiguraPinchada(p) != null;
    }

    private FiguraSeleccionable getFiguraPinchada(Point p) {
        return controlador.getModelo().getDibujo().hasPinchadoEnFigura(p);
    }

    private void eliminarFigura(IFigura figura) {
        controlador.getModelo().eliminarFigura(figura);
    }
}
