package modelo;

import modelo.figuras.IFigura;

import java.io.IOException;

public interface IModelo {
    IDibujo getDibujo();

    void agregarFigura(IFigura figura);

    void eliminarFigura(IFigura figura);

    IDibujo abrirDibujo() throws IOException;

    IDibujo nuevoDibujo();

    void guardarDibujo() throws IOException;
}
