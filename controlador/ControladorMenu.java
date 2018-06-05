package controlador;

import vista.IVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorMenu implements ActionListener{
    private final Controlador controlador;


    public ControladorMenu(Controlador controlador) {
        this.controlador = controlador;
    }


    /**
     * Invoked when an action occurs.
     * @param e evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(IVista.NUEVO)){
            controlador.creaNuevoDibujo();
            return;
        }

        if (e.getActionCommand().equals(IVista.ABRIR)){
            controlador.abrirDibujo();
            return;
        }

        if (e.getActionCommand().equals(IVista.GUARDAR)){
            controlador.guardarDibujo();
            return;
        }

        if (e.getActionCommand().equals(IVista.SALIR)){
            System.exit(0);
            return;
        }

        if (e.getActionCommand().equals(IVista.ACERCADE)){
            controlador.creaDialogoAyuda();
            return;
        }
        controlador.setFiguraSeleccionadaEnMenu(e.getActionCommand());
    }

}
