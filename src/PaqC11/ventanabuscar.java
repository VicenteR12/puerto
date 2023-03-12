package PaqC11;

import javax.swing.*;
import java.awt.*;

public class ventanabuscar extends JFrame{
    private JTextField fid;
    private JTextField fpeso;
    private JTextArea fdesc;
    private JTextField fenvia;
    private JTextField frecibe;
    private JTextField fpais;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JCheckBox inspeccionadoEnAduanasCheckBox;
    private JPanel panel1;



    public ventanabuscar(Contenedor c){
        setContentPane(panel1);
        setTitle("Gestión de contenedores");
        setSize(new Dimension(800, 400));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);

        fid.setText(Integer.toString(c.getId()));
        fdesc.setText(c.getDescripcion());
        fpeso.setText(Integer.toString(c.getPeso()));
        fenvia.setText(c.getEnvia());
        frecibe.setText(c.getRecibe());

        if (c.getPrioridad()==1){
            a1RadioButton.setSelected(true);
        }
        if (c.getPrioridad()==2){
            a2RadioButton.setSelected(true);
        }
        if (c.getPrioridad()==3){
            a3RadioButton.setSelected(true);
        }

        if(c.getInspeccionado()){
            inspeccionadoEnAduanasCheckBox.setSelected(true);
        }

        fpais.setText(c.getPais());
    }


}
