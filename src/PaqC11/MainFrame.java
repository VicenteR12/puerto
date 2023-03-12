package PaqC11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JTextField tfid;
    private JTextField tfPeso;
    private JTextArea tfDescripcion;
    private JTextField tfEnvia;
    private JTextField tfRecibe;
    private JPanel mainPanel;
    private JComboBox boxPais;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JCheckBox inspeccionadoEnAduanasCheckBox;
    private JTextArea mostrar;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JButton mostrarDatosDelContenedorButton;
    private JButton cuántosButton;
    private JComboBox comboBox2;
    private JTextField tfBuscarPais;
    private JTextField tfBuscar;
    private JTextField tfColumna;
    private JLabel lblogo;

    private int prio;

    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("Gestión de contenedores");
        setSize(new Dimension(1120, 660));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Hub hub = new Hub();
        lblogo.setIcon(new ImageIcon("imgs/logo.png"));

        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idn=0;
                int peson=0;
                try{
                    idn = Integer.parseInt(tfid.getText());
                    try {
                        peson = Integer.parseInt(tfPeso.getText());
                        Contenedor c = new Contenedor(idn, Integer.parseInt(tfPeso.getText()),
                                (String) boxPais.getSelectedItem(), inspeccionadoEnAduanasCheckBox.isSelected(), prio,
                                tfDescripcion.getText(), tfEnvia.getText(), tfRecibe.getText());
                        hub.apilar(c);
                        mostrar.setText(hub.toString());
                    }
                    catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "El peso no es un entero, vuelve a teclearlo");
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "El ID no es un entero, vuelve a teclearlo");
                }
            }
        });
        a1RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prio = 1;
            }
        });
        a2RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prio = 2;
            }
        });
        a3RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prio = 3;
            }
        });
        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int columnan=0;
                try {
                    columnan = Integer.parseInt(tfColumna.getText());
                    hub.desapilar(columnan);
                    mostrar.setText(hub.toString());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Introduce un número de columna válido.");
                }
            }
        });
        mostrarDatosDelContenedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int buscarn=0;
                try {
                    buscarn = Integer.parseInt(tfBuscar.getText());
                    ventanabuscar ventanabuscar = new ventanabuscar(hub.buscarContenedor(buscarn));
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Introduce un ID válido.");
                }
            }
        });
        cuántosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfBuscarPais.setText(Integer.toString(hub.buscarPais((String) comboBox2.getSelectedItem())));
            }
        });
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(myFrame.a1RadioButton);
        buttonGroup.add(myFrame.a2RadioButton);
        buttonGroup.add(myFrame.a3RadioButton);
    }
}
