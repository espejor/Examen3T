package vista;


import javax.swing.*;
import java.awt.event.ActionListener;

public class BarraDeMenu extends JMenuBar implements IVistaActionListener {
    private JMenu archivo;
    private JMenu pintar;
    private JMenu ayuda;

    public BarraDeMenu() {
        add(crearOpcionArchivo());
        add(crearOpcionPintar());
        add(crearOpcionAyuda());
    }

    private JMenu crearOpcionArchivo(){
        archivo = new JMenu("Archivo");
        archivo.setMnemonic('A');

        String itemsNames[] = {IVista.NUEVO,IVista.ABRIR,IVista.GUARDAR,IVista.SALIR};
        int itemsMnemotecnicos[] = {'N','A','G','S'};
        OpcionMenu items [] = new OpcionMenu[itemsNames.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = new OpcionMenu(itemsNames[i],itemsMnemotecnicos[i]);
            archivo.add(items[i]);
        }

        return archivo;
    }


    private JMenu crearOpcionPintar() {
        pintar = new JMenu("Pintar");
        pintar.setMnemonic('P');

        ButtonGroup grupo = new ButtonGroup();

        String itemsNames[] = {IVista.LINEA,IVista.RECTANGULO,IVista.CIRCULO};
        OpcionRadioMenu items [] = new OpcionRadioMenu[itemsNames.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = new OpcionRadioMenu(itemsNames[i]);
            pintar.add(items[i]);
            grupo.add(items[i]);
        }
        items[0].setSelected(true);
        return pintar;
    }


    private JMenu crearOpcionAyuda() {
        ayuda = new JMenu("Ayuda");
        ayuda.setMnemonic('y');

        OpcionMenu acercaDe = new OpcionMenu(IVista.ACERCADE,'A');

        ayuda.add(acercaDe);

        return ayuda;
    }


    public void setListener(ActionListener listener) {
        for (int i = 0; i < archivo.getItemCount(); i++) {
            ((OpcionMenu)archivo.getItem(i)).setListener(listener);
        }
        for (int i = 0; i < pintar.getItemCount(); i++) {
            ((OpcionRadioMenu)pintar.getItem(i)).setListener(listener);
        }
        ((OpcionMenu)ayuda.getItem(0)).setListener(listener);
    }
}
