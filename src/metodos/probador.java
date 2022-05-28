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
public class probador {
    public static void main(String args[]){
        Lista miLista=new Lista();
        int op;
        
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
            "Menú Principal. \n"+
            "1. Registrar Nodo empleado. \n"+
            "2. Buscar Nodo empleado por código. \n"+
            "3. Mostrar todos los empleados. \n"+
            "4. Eliminar nodo por código empleado. \n"+
            "5. Mostrar todos ordenados por código. \n"+ 
            "6. Invertir la lista \n"+
            "7. Salir. \n"+        
            "Entre su opción: ? \n"        
            ));
            
            switch(op){
                case 1:
                    miLista.setAddFinal();
                break;
                case 2:
                    miLista.getMostrarNodo();
                break;
                case 3:
                    miLista.getMostrarTodo();
                break;
                case 4:
                    miLista.setElimCodigo();
                break;
                case 5:
                    miLista.setOrdenarAsc();
                    miLista.getMostrarTodo();
                break;
                case 6:
                    miLista.setInvertir();
                    miLista.getMostrarTodo();
                break;
                case 7:
                    JOptionPane.showMessageDialog(null, 
                    "Adios!");
                break;
                default:
                    JOptionPane.showMessageDialog(null, 
                    "Opción invalida!");
            }
            
        }while(op!=7);
        System.exit(0);
    }
}
