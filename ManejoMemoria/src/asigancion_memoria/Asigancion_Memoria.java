/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asigancion_memoria;

/**
 *
 * @author juane
 */


import asigancion_memoria.Modelo;
import asigancion_memoria.Vista;

public class Asigancion_Memoria {

    public static void main(String[] args) {
        Vista  v = new Vista();
        Modelo m = new Modelo();
        Controlador c = new Controlador(v,m);
        v.iniciarComponentes();
        v.oyentes(c);        
    }
    
}

