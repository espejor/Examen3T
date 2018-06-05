package modelo.iterator;

import modelo.figuras.FiguraSeleccionable;
import modelo.figuras.IFigura;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDibujo implements Iterator<FiguraSeleccionable> {
    private int index;
    private final ArrayList<FiguraSeleccionable> figuras = new ArrayList<>();

    public IteratorDibujo(ArrayList<IFigura> figuras) {
        for (IFigura figura:figuras){
            if (figura instanceof FiguraSeleccionable)
                this.figuras.add((FiguraSeleccionable) figura);
        }
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return index < figuras.size();
    }

    /**
     * Returns the next element in the iteration.
     * @return the next element in the iteration
     */
    @Override
    public FiguraSeleccionable next() {
        return figuras.get(index++);
    }
}
