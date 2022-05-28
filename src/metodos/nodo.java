/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class nodo {
    //Atributos: Información
    String cod;
    String noms;
    double nHorasT;
    double valorHora;
    double nHorasE;
    //Apuntador
    nodo sig;

    //Método constructor    
    public nodo(String cod, String noms, double nHorasT, double valorHora, double nHorasE) {
        this.cod = cod;
        this.noms = noms;
        this.nHorasT = nHorasT;
        this.valorHora = valorHora;
        this.nHorasE = nHorasE;
        sig = null;
    }
    
    //Métodos analizadores

    public String getCod() {
        return cod;
    }

    public String getNoms() {
        return noms;
    }

    public double getnHorasT() {
        return nHorasT;
    }

    public double getValorHora() {
        return valorHora;
    }

    public double getnHorasE() {
        return nHorasE;
    }
    
    public void getMostrarInfoNodo(){
        String info="La información del nodo es: \n";
        info+="Código empleado: "+cod+"\n";
        info+="Nombres: "+noms+"\n";
        info+="# Horas Trabajadas: "+nHorasT+"\n";
        info+="Valor hora trabajada: "+valorHora+"\n";
        info+="# Horas Extras: "+nHorasE+"\n";
        JOptionPane.showMessageDialog(null, info);
    }
    
    //Métodos modificadores
    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public void setnHorasT(double nHorasT) {
        this.nHorasT = nHorasT;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public void setnHorasE(double nHorasE) {
        this.nHorasE = nHorasE;
    }    
    
}
