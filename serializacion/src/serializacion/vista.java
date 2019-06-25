package serializacion;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class vista implements ActionListener{
    FileInputStream fis = null;
    ObjectInputStream entrada = null;
    serializa s = new serializa();
    Conexion cn = new Conexion();
    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    JMenu menu, subMenu;
    JMenuItem menuItem;
    JScrollPane scrollPanel;
    DefaultTableModel modeloTabla;
    JTable tablaContactos;
    JTabbedPane pestana;
    Container panelInformacion;
    JLabel labelId,labelNombre,labelNota1,labelNota2,
    labelNota3;
    JTextField textId,textNombre,textNota1,textNota2,textNota3;
    JButton botonNuevoContacto,botonGuardarContacto,botonEditarContacto,botonBorrarContacto;
    JButton botonPromedio;
    String[] columNames = {"id_estudiantes","Nombres","Nota1","Nota2","Nota3"};

    Estudiantes dbc = new Estudiantes();
    estudiante[] contactos;
    int estado=0;
    int fila;
    public vista() throws IOException {
        s.crea_todo();
        initComponents();
        
    }

    public void initComponents(){
        frame = new JFrame("Notas estudiantes");
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        frame.setSize((width/2)+20, (height/2)+20);		
        frame.setLocationRelativeTo(null);
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menu = new JMenu("Opciones");
        menuBar.add(menu);
        menuItem = new JMenuItem("Salir");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        panelInformacion = new JPanel(null);
        panelInformacion.setLayout(null);
        pestana = new JTabbedPane();
        pestana.addTab("Información de estudiante", panelInformacion);

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
        
        contactos = dbc.getContactos();
        Object[][] data = new Object[contactos.length][5];

        textNombre = new JTextField();
        textNombre.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textNombre);

        labelNota1 = new JLabel("Nota 1",SwingConstants.RIGHT);
        labelNota1.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelNota1);

        textNota1 = new JTextField();
        textNota1.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textNota1);
        y+=30;
        labelNota2 = new JLabel("Nota 2",SwingConstants.RIGHT);
        labelNota2.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelNota2);

        textNota2 = new JTextField();
        textNota2.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textNota2);

        labelNota3 = new JLabel("Nota 3",SwingConstants.RIGHT);
        labelNota3.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelNota3);

        textNota3 = new JTextField();
        textNota3.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textNota3);

        y+=30;

        y+=60;
        botonNuevoContacto = new JButton("Nuevo estudiante");
        botonNuevoContacto.setBounds(x,y,labelAncho-20,30);
        panelInformacion.add(botonNuevoContacto);
        botonNuevoContacto.addActionListener(this);

        botonGuardarContacto = new JButton("Guardar estudiante");
        botonGuardarContacto.setBounds(x+150,y,labelAncho-20,30);
        panelInformacion.add(botonGuardarContacto);
        botonGuardarContacto.addActionListener(this);
        botonEditarContacto = new JButton("Editar estudiante");
        botonEditarContacto.setBounds(x+300,y,labelAncho-20,30);
        panelInformacion.add(botonEditarContacto);
        botonEditarContacto.addActionListener(this);

        botonBorrarContacto = new JButton("Borrar estudiante");
        botonBorrarContacto.setBounds(x+450,y,labelAncho-20,30);
        panelInformacion.add(botonBorrarContacto);
        botonBorrarContacto.addActionListener(this);
        
        botonPromedio = new JButton("Promedio estudiante");
        botonPromedio.setBounds(x+600,y,labelAncho-20,30);
        panelInformacion.add(botonPromedio);
        botonPromedio.addActionListener(this);

        
        try {            
                fis = new FileInputStream("estudiantes.dat");
                entrada = new ObjectInputStream(fis);
                for (int c=0;c<contactos.length;c++){
                    data[c][0] = (Integer) entrada.readObject();
                    data[c][1] = (String) entrada.readObject();
                    data[c][2] = (Float) entrada.readObject();
                    data[c][3] = (Float) entrada.readObject();
                    data[c][4] = (Float) entrada.readObject();
                }
                System.out.println("Información extraida del archivo... Añadiendo a Vista");
                entrada.close();           
        } catch (FileNotFoundException e) {
            System.out.println("1"+e.getMessage());
        } catch (IOException e) {
            System.out.println("2"+e.getMessage());
        } catch (ClassNotFoundException ex){
            System.out.println("3"+ex.getMessage());
        }

    

    modeloTabla= new DefaultTableModel(data, columNames);

    tablaContactos = new JTable(modeloTabla);
    tablaContactos.setPreferredScrollableViewportSize(new Dimension(500, 150));

    scrollPanel = new JScrollPane(tablaContactos);

    tablaContactos.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
            fila = tablaContactos.rowAtPoint(e.getPoint());
            int columna = tablaContactos.columnAtPoint(e.getPoint());
            if ((fila > -1) && (columna > -1)){
                textId.setText(String.valueOf(tablaContactos.getValueAt(fila,0)));
                for(int i=0;i<contactos.length;i++){
                    if(String.valueOf(contactos[i].getId()).equals(
                    String.valueOf(tablaContactos.getValueAt(fila, 0)))){
                    textNombre.setText(contactos[i].getNombre());
                    textNota1.setText(Float.toString(contactos[i].getNota1()));
                    textNota2.setText(Float.toString(contactos[i].getNota2()));
                    textNota3.setText(Float.toString(contactos[i].getNota3()));
                    }

                }
                estado = 2;
                alterarEstado();
            }   
        }
    });

    frame.getContentPane().add(scrollPanel,BorderLayout.NORTH);
    frame.getContentPane().add(pestana,BorderLayout.CENTER);

    frame.pack();
    frame.setSize(800, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);

    alterarEstado();
    }

    public void alterarEstado(){
        switch(this.estado){
            case 0://estado por defecto
                botonNuevoContacto.setEnabled(true);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonGuardarContacto.setEnabled(false);
                botonPromedio.setEnabled(false);
                textId.setEditable(false);
                textNombre.setEditable(false);
                textNota1.setEditable(false);
                textNota2.setEditable(false);
                textNota3.setEditable(false);
                break;
            case 1://estado para un nuevo contacto
                botonNuevoContacto.setEnabled(false);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonPromedio.setEnabled(false);
                botonGuardarContacto.setEnabled(true);
                textId.setEditable(false);
                textNombre.setEditable(true);
                textNota1.setEditable(true);
                textNota2.setEditable(true);
                textNota3.setEditable(true);
                break;
            case 2://estado de carga de un contacto
                botonNuevoContacto.setEnabled(false);
                botonBorrarContacto.setEnabled(true);
                botonEditarContacto.setEnabled(true);
                botonPromedio.setEnabled(true);
                botonGuardarContacto.setEnabled(false);
                textId.setEditable(false);
                textNombre.setEditable(false);
                textNota1.setEditable(false);
                textNota2.setEditable(false);
                textNota3.setEditable(false);
                break;
            case 3://estado para editar un contacto
                botonNuevoContacto.setEnabled(false);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonPromedio.setEnabled(false);
                botonGuardarContacto.setEnabled(true);
                textId.setEditable(false);
                textNombre.setEditable(true);
                textNota1.setEditable(true);
                textNota2.setEditable(true);
                textNota3.setEditable(true);
            break;
        }
    }

    public void limpiarCampos(){
        textId.setText("");
        textNombre.setText("");
        textNota1.setText("");
        textNota2.setText("");
        textNota3.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        System.out.println(accion);
        if(accion.equals("Salir")){
            frame.dispose();
        }
        if(accion.equals("Nuevo estudiante")){
            limpiarCampos();
            this.estado=1;
        }
        if(accion.equals("Editar estudiante")){
            this.estado=3;
        }
    if(accion.equals("Guardar estudiante")){
        if(this.estado==1){
            estudiante c = new estudiante();
            c.setNombre(textNombre.getText());
            c.setNota1(Float.valueOf(textNota1.getText()));
            c.setNota2(Float.valueOf(textNota2.getText()));
            c.setNota3(Float.valueOf(textNota3.getText()));
            int r = dbc.insertarContacto(c);
            if(r>0){
                Object[] newRow={r,c.getNombre(),c.getNota1(),c.getNota2(),c.getNota3()};
                modeloTabla.addRow(newRow);
                JOptionPane.showMessageDialog(null, "Estudiante agregado");
            }
            
        }else if(this.estado==3){ 
            estudiante c = new estudiante();
            c.setId(Integer.parseInt(textId.getText(),10));
            c.setNombre(textNombre.getText());
            c.setNota1(Float.valueOf(textNota1.getText()));
            c.setNota2(Float.valueOf(textNota2.getText()));
            c.setNota3(Float.valueOf(textNota3.getText()));
            int r = dbc.actualizarContacto(c);
            if(r>0){
                modeloTabla.setValueAt(c.getNombre(), fila, 1);
                modeloTabla.setValueAt(c.getNota1(), fila, 2);
                modeloTabla.setValueAt(c.getNota2(), fila, 3);
                modeloTabla.setValueAt(c.getNota3(), fila, 4);
                JOptionPane.showMessageDialog(null, "Contacto actualizado");
            }
        }
        contactos = dbc.getContactos();
        try {
                s.crea_todo();
            } catch (IOException ex) {
                Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        limpiarCampos();
        this.estado=0;
    }
    //////////////////////////PROMEDIO//////////////////////////////
    if(accion.equals("Promedio estudiante")){
        estudiante c = new estudiante();
        c.setId(Integer.parseInt(textId.getText(),10));
        c.setNota1(Float.valueOf(textNota1.getText()));
        c.setNota2(Float.valueOf(textNota2.getText()));
        c.setNota3(Float.valueOf(textNota3.getText()));
        float promedio;
        promedio=(float) ((c.getNota1()*0.35)+(c.getNota2()*0.35)+(c.getNota3()*0.30));
        JOptionPane.showMessageDialog(null,"El promedio del estudiante es: "+promedio);        
        this.estado=0;
    }
    
    if(accion.equals("Borrar estudiante")){
        estudiante c = new estudiante();
        c.setId(Integer.parseInt(textId.getText(),10));
        int r = dbc.borrarContacto(c);
        if(r>0){
            modeloTabla.removeRow(fila);
            JOptionPane.showMessageDialog(null, "Contacto borrado");
            limpiarCampos();
        }
        contactos = dbc.getContactos();
        this.estado=0;
        try {
                s.crea_todo();
            } catch (IOException ex) {
                Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    alterarEstado();
    }
}
