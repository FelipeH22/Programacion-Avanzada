package db;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormAgenda implements ActionListener{
    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    JMenu menu, subMenu;
    JMenuItem menuItem;
    JScrollPane scrollPanel;
    DefaultTableModel modeloTabla;
    JTable tablaContactos;
    JTabbedPane pestana;
    Container panelInformacion,panelCitas;
    JLabel labelId,labelNombre,labelApellido,labelTelefonoDomicilio,
    labelTelefonoOficina,labelDireccionDomicilio,labelDireccionOficina,
    labelCelular,labelCorreo;
    JTextField textId,textNombre,textNota1,textNota2,textNota3,
    textDireccionDomicilio,textDireccionOficina,textCelular,textCorreo;
    JButton botonNuevoContacto,botonGuardarContacto,botonEditarContacto,botonBorrarContacto;

    DBContactos dbc = new DBContactos();
    Contacto[] contactos;
    int estado=0;
    int fila;
    public FormAgenda() {
        initComponents();
    }

    public void initComponents(){
        frame = new JFrame("Agenda de Contactos");
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menu = new JMenu("Opciones");
        menuBar.add(menu);
        menuItem = new JMenuItem("Acerca de ...");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Salir");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        panelInformacion = new JPanel(null);
        panelInformacion.setLayout(null);
        panelCitas = new JPanel(null);
        panelCitas.setLayout(null);
        pestana = new JTabbedPane();
        pestana.addTab("Información de contacto", panelInformacion);
        pestana.addTab("Citas",panelCitas);

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

        labelApellido = new JLabel("Apellido",SwingConstants.RIGHT);
        labelApellido.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelApellido);

        textNota1 = new JTextField();
        textNota1.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textNota1);
        y+=30;
        labelTelefonoDomicilio = new JLabel("Telefono Domicilio",SwingConstants.RIGHT);
        labelTelefonoDomicilio.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelTelefonoDomicilio);

        textNota2 = new JTextField();
        textNota2.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textNota2);

        labelTelefonoOficina = new JLabel("Telefono Oficina",SwingConstants.RIGHT);
        labelTelefonoOficina.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelTelefonoOficina);

        textNota3 = new JTextField();
        textNota3.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textNota3);

        y+=30;
        labelDireccionDomicilio = new JLabel("Dirreción Domicilio",SwingConstants.RIGHT);
        labelDireccionDomicilio.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelDireccionDomicilio);

        textDireccionDomicilio = new JTextField();
        textDireccionDomicilio.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textDireccionDomicilio);

        labelDireccionOficina = new JLabel("Dirección Oficina",SwingConstants.RIGHT);
        labelDireccionOficina.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelDireccionOficina);

        textDireccionOficina = new JTextField();
        textDireccionOficina.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textDireccionOficina);

        y+=30;
        labelCelular = new JLabel("Celular",SwingConstants.RIGHT);
        labelCelular.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelCelular);

        textCelular = new JTextField();
        textCelular.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textCelular);

        labelCorreo = new JLabel("Correo",SwingConstants.RIGHT);
        labelCorreo.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelCorreo);

        textCorreo = new JTextField();
        textCorreo.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textCorreo);

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

    String[] columNames = {"id","nombres","nota1","nota2","nota3"};

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
                textDireccionDomicilio.setEditable(false);
                textDireccionOficina.setEditable(false);
                textCorreo.setEditable(false);
                textCelular.setEditable(false);
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
                textDireccionDomicilio.setEditable(true);
                textDireccionOficina.setEditable(true);
                textCorreo.setEditable(true);
                textCelular.setEditable(true);
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
                textDireccionDomicilio.setEditable(false);
                textDireccionOficina.setEditable(false);
                textCorreo.setEditable(false);
                textCelular.setEditable(false);
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
                textDireccionDomicilio.setEditable(true);
                textDireccionOficina.setEditable(true);
                textCorreo.setEditable(true);
                textCelular.setEditable(true);
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
            System.exit(-1);
        }
        if(accion.equals("Acerca de ...")){
        }
        if(accion.equals("Nuevo Contacto")){
            limpiarCampos();
            this.estado=1;
        }
        if(accion.equals("Editar Contacto")){
            this.estado=3;
        }
    if(accion.equals("Guardar Contacto")){
        if(this.estado==1){
            Contacto c = new Contacto();
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
            Contacto c = new Contacto();
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
        Contacto c = new Contacto();
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
