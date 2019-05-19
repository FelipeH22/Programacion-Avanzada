package rsa;

public class vista extends vista_abstract implements vista_interface{
    
    public vista(){
        this.setSize(500,500);
        this.setTitle("Encriptación con RSA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    @Override
    public void componentes(){
        this.setVisible(true);
        panel();
        this.getContentPane().add(panel);
        crea_labels();
        crea_boton();
        crea_textField();
        resultados();
    }
    
    @Override
    public void panel(){
        panel.setLayout(null);
        panel.setSize(500,500);
    }

    @Override
    public void crea_labels() {
        titulo.setBounds(210,10,150,20);
        titulo.setText("Encriptacion");
        panel.add(titulo);
        palabra_label.setBounds(10, 50, 180, 20);
        panel.add(palabra_label);
        p_label.setBounds(10,80,50,20);
        p_label.setText("p");
        panel.add(p_label);
        q_label.setBounds(10,110,50,20);
        q_label.setText("q");
        panel.add(q_label);
        n_label.setBounds(10,140,50,20);
        n_label.setText("n");
        panel.add(n_label);       
    }

    @Override
    public void crea_boton() {
        boton.setBounds(10,190,100,20);
        boton.setText("Encriptar");
        panel.add(boton);
    }

    @Override
    public void crea_textField() {
        palabra.setBounds(200,50,100,20);
        panel.add(palabra);
        p.setBounds(60, 80, 50, 20);
        panel.add(p);
        q.setBounds(60,110,50,20);
        panel.add(q);
        n.setBounds(60,140,50,20);
        panel.add(n);        
    }
    
    @Override
    public void resultados(){
        z.setBounds(10, 250, 150, 20);
        panel.add(z);
        s.setBounds(10, 280, 150, 20);
        panel.add(s);
        num_palabra.setBounds(10, 310, 150, 20);
        panel.add(num_palabra);
    }
    
    public void oyentes(controlador c){
        boton.addActionListener(c);
    }
}
