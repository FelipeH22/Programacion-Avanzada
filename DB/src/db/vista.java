package db;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class vista implements ActionListener{
    DBConexion cn = new DBConexion();
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

    DBEstudiantes dbc = new DBEstudiantes();
    estudiante[] contactos;
    int estado=0;
    int fila;
    public vista() {
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
        menuItem = new JMenuItem("Borrar Tabla");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Borrar Base de Datos");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Crear Base de Datos");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Crear Tabla");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Salir");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        panelInformacion = new JPanel(null);
        panelInformacion.setLayout(null);
        pestana = new JTabbedPane();
        pestana.addTab("Información de contacto", panelInformacion);

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
        botonNuevoContacto = new JButton("Nuevo Contacto");
        botonNuevoContacto.setBounds(x,y,labelAncho,50);
        panelInformacion.add(botonNuevoContacto);
        botonNuevoContacto.addActionListener(this);

        botonGuardarContacto = new JButton("Guardar Contacto");
        botonGuardarContacto.setBounds(x+200,y,labelAncho,50);
        panelInformacion.add(botonGuardarContacto);
        botonGuardarContacto.addActionListener(this);
        botonEditarContacto = new JButton("Editar Contacto");
        botonEditarContacto.setBounds(x+400,y,labelAncho,50);
        panelInformacion.add(botonEditarContacto);
        botonEditarContacto.addActionListener(this);

        botonBorrarContacto = new JButton("Borrar Contacto");
        botonBorrarContacto.setBounds(x+600,y,labelAncho,50);
        panelInformacion.add(botonBorrarContacto);
        botonBorrarContacto.addActionListener(this);

        contactos = dbc.getContactos();
        Object[][] data = new Object[contactos.length][5];
        for (int c=0;c<contactos.length;c++){
            data[c][0]=contactos[c].getId();
            data[c][1]=contactos[c].getNombre();
            data[c][2]=contactos[c].getNota1();
            data[c][3]=contactos[c].getNota2();
            data[c][4]=contactos[c].getNota3();
        }

    String[] columNames = {"id_estudiantes","Nombres","Nota1","Nota2","Nota3"};

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
    JFrame.setDefaultLookAndFeelDecorated(true);

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
        if(accion.equals("Borrar Tabla")){
            String password = JOptionPane.showInputDialog(null, "Password");
            if(password.equals(DBConexion.password))
            {
                JOptionPane.showMessageDialog(null, "Eliminando Tabla");
                try{
                    PreparedStatement pstm;
                    pstm = cn.getConexion().prepareStatement("drop table estudiantes");
                    int res = pstm.executeUpdate();                
                }catch(SQLException h){
                    System.out.println(h);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Acceso Denegado");
            }            
        }
        if(accion.equals("Borrar Base de Datos")){
            String password2 = JOptionPane.showInputDialog(null, "PasswordDB");
            if(password2.equals(DBConexion.password))
            {
                JOptionPane.showMessageDialog(null, "Eliminando Base de datos");
                try{
                    PreparedStatement pstm;
                    pstm = cn.getConexion().prepareStatement("drop database estudiantes");
                    int res = pstm.executeUpdate();                
                }catch(SQLException h){
                    System.out.println(h);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Acceso Denegado");
            }            
        }
        /////////////////////Crear Base de Datos////////////////////////////////////////////////////////////////////////////////////////
        if(accion.equals("Crear Base de Datos")){
            String password2 = JOptionPane.showInputDialog(null, "PasswordDB");
            if(password2.equals(DBConexion.password))
            {
                String Nombre_base = JOptionPane.showInputDialog(null, "Nombre DB");
                try{
                    PreparedStatement pstm;
                    pstm = cn.getConexion().prepareStatement("create database "+Nombre_base);
                    int res = pstm.executeUpdate();                
                }catch(SQLException h){
                    System.out.println(h);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Acceso Denegado");
            }            
        }
        //////////////////////////////////////Crea Tabla//////////////////////////////////////////////////////////////////////////////
        if(accion.equals("Crear Tabla")){
            String password3 = JOptionPane.showInputDialog(null, "PasswordDB");
            if(password3.equals(DBConexion.password))
            {
                String Nombre_DB = JOptionPane.showInputDialog(null, "Nombre DB a insertar");
                String Nombre_Tabla = JOptionPane.showInputDialog(null, "Nombre Tabla");
                try{
                    PreparedStatement pstm,pstm2;
                    pstm2 = cn.getConexion().prepareStatement("use "+Nombre_DB);
                    int res2 = pstm2.executeUpdate();
                    pstm = cn.getConexion().prepareStatement("CREATE TABLE "+ Nombre_Tabla +"( id INT PRIMARY KEY, nombre VARCHAR(20) );");
                    int res = pstm.executeUpdate();   
                    JOptionPane.showMessageDialog(null, "Tabla Creada");
                }catch(SQLException h){
                    System.out.println(h);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Acceso Denegado");
            }            
        }
        /////////////////////////
        if(accion.equals("Nuevo Contacto")){
            limpiarCampos();
            this.estado=1;
        }
        if(accion.equals("Editar Contacto")){
            this.estado=3;
        }
    if(accion.equals("Guardar Contacto")){
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
                JOptionPane.showMessageDialog(null, "Contacto agregado");
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
        limpiarCampos();
        this.estado=0;
    }
    if(accion.equals("Borrar Contacto")){
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
    }
    alterarEstado();
    }
}
