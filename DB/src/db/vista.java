package db;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class vista implements ActionListener{
    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    JMenu menu, subMenu;
    JMenuItem menuItem;
    JScrollPane scrollPanel,scrollPanel2;
    DefaultTableModel modeloTabla, modeloTablaCita;
    JTable tablaContactos, tablaCitas;
    JTabbedPane pestana;
    Container panelInformacion;
    JLabel labelId,labelNombre,labelNota1,labelNota2,
    labelNota3,labelDireccionDomicilio,labelDireccionOficina,
    labelCelular,labelCorreo;
    
    JLabel labelIdCita,labelPersona,labelLugar,labelFecha,labelHora, labelDescripcion;
        
    JTextField textId,textNombre,textNota1,textNota2,textNota3,
    textDireccionDomicilio,textDireccionOficina,textCelular,textCorreo;
    
    JTextField textIdCita, textPersona, textLugar, textFecha,textHora;
    JTextArea textDescripcion;    

      
    conexion_tablas dbc = new conexion_tablas();
    estudiantes[] estudiantes;
    int estado=0;
    int estado_cita=0;
    int fila;
    
    public vista() {
        initComponents();
    }

    public void initComponents(){
        frame = new JFrame("Estudiantes");    
        frame.setSize(750,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        panelInformacion = new JPanel(null);
        panelInformacion.setLayout(null);
        pestana = new JTabbedPane();
        pestana.addTab("Información de contacto", panelInformacion);
        frame.getContentPane().add(panelInformacion);
        panelInformacion.add(pestana);

        int y = 5;
        int x = 10;
        int labelAncho = 150;
        int labelAlto = 20;
        int textAncho = 200;
        int textAlto = 20;

        labelId = new JLabel("Id");
        labelId.setBounds(x,y,20,20);
        panelInformacion.add(labelId);
        
        textId = new JTextField();
        textId.setBounds(x+30,y,50,20);
        panelInformacion.add(textId);
        
        y+=30;
        labelNombre = new JLabel("Nombre",SwingConstants.RIGHT);
        labelNombre.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelNombre);

        textNombre = new JTextField();
        textNombre.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textNombre);

        labelNota1 = new JLabel("Nota1",SwingConstants.RIGHT);
        labelNota1.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelNota1);

        textNota1 = new JTextField();
        textNota1.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textNota1);
        y+=30;
        labelNota2 = new JLabel("Nota2",SwingConstants.RIGHT);
        labelNota2.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelNota2);

        textNota2 = new JTextField();
        textNota2.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textNota2);

        labelNota3 = new JLabel("Nota3",SwingConstants.RIGHT);
        labelNota3.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelNota3);

        textNota3 = new JTextField();
        textNota3.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textNota3);

        estudiantes = dbc.getContactos();
        Object[][] data = new Object[estudiantes.length][5];
        for (int c=0;c<estudiantes.length;c++){
        data[c][0]=estudiantes[c].getId();
        data[c][1]=estudiantes[c].getNombre();
        data[c][2]=estudiantes[c].getNota1();
        data[c][3]=estudiantes[c].getNota2();
        data[c][4]=estudiantes[c].getNota3();
                
             
    /*Contactos*/
    String[] columNames = {"id","nombres","nota1","nota2","nota3"};
   
    modeloTabla= new DefaultTableModel(data, columNames);

    tablaContactos = new JTable(modeloTabla);
    tablaContactos.setPreferredScrollableViewportSize(new Dimension(1500, 150));

    scrollPanel = new JScrollPane(tablaContactos);
    

    tablaContactos.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
            fila = tablaContactos.rowAtPoint(e.getPoint());
            int columna = tablaContactos.columnAtPoint(e.getPoint());
            if ((fila > -1) && (columna > -1)){
                textId.setText(String.valueOf(tablaContactos.getValueAt(fila,0)));
                for(int i=0;i<estudiantes.length;i++){
                    if(String.valueOf(estudiantes[i].getId()).equals(
                    String.valueOf(tablaContactos.getValueAt(fila, 0)))){
                    textNombre.setText(estudiantes[i].getNombre());
                    textNota1.setText(Float.toString(estudiantes[i].getNota1()));
                    textNota2.setText(Float.toString(estudiantes[i].getNota2()));
                    textNota3.setText(Float.toString(estudiantes[i].getNota3()));
                    }

                }
            }   
        }
    });
    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}