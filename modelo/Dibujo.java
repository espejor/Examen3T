package modelo;

import modelo.figuras.FiguraSeleccionable;
import modelo.figuras.IFigura;
import modelo.iterator.IteratorDibujo;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Dibujo implements Serializable,IDibujo,Iterable<FiguraSeleccionable> {
    private final ArrayList<IFigura> figuras = new ArrayList<IFigura>();

    public void dibujar(Graphics g){
        for (IFigura figura : figuras){
            figura.pintar(g);
        }
    }

    public void agregarFigura(IFigura figura){
        figuras.add(figura);
    }

    public FiguraSeleccionable hasPinchadoEnFigura(Point p) {
//        for (IFigura figura: figuras){
//            if (figura instanceof Seleccionable)
//                if (((Seleccionable) figura).contiene(p))
//                    return figura;
//        }
        Iterator<FiguraSeleccionable> it = iterator();
        while(it.hasNext()){
            FiguraSeleccionable figura = it.next();
            if (figura.contiene(p))
                return figura;
        }
        return null;
    }

    public void eliminarFigura(IFigura figura) {
        if (figuras.contains(figura))
            figuras.remove(figura);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<FiguraSeleccionable> iterator() {
        return new IteratorDibujo(figuras);
    }
}
