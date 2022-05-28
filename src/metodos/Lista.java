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
public class Lista {
    //Definimos la cabecera de la lista
    nodo cab;
    
    //Se crea la lista vacía
    public Lista(){
        cab=null;
    }
    
    //Buscar si un código de empleado se encuentra
    //en la lista.  Este método retorna un nodo
    //apuntando a donde se encuentre la información o
    //de lo contrario retorna null.
    public nodo getBuscarCod(String codg){
        if(cab==null)
            return null;
        else{
            nodo p = cab;
            while(p!=null){
                if((p.cod).equals(codg))
                    return p;
                else
                    p=p.sig;  //Avanza un posición en la lista
            }
            return null;
        }
    }
    
    //Método que retorna true si la lista
    //esta vacía dlc (de lo contrario) retorna null
    public boolean getEsVacia(){
        return cab==null?true:false;
        /*
        if(cab==null)return true;else return false;
        */
    }
    
    //Método para determinar el número de elementos de 
    //la lista
    public int getLongLista(){
        int cont=0;
        nodo p=null;
        if(cab==null)
            return 0;
        else{
            p=cab;
            while(p!=null){
                cont++;
                p=p.sig;
            }
            return cont;
        }
    }
    
    //Este método crea un nuevo nodo sin código de 
    //empleado repetido en la lista.
    public nodo getCrearNodo(){
        nodo buscar = null;
        String cod;
        try {
            do {
                cod = JOptionPane.showInputDialog(
                        "Entre el código del empleado: ");
                buscar = getBuscarCod(cod);
                if (buscar != null) {
                    JOptionPane.showMessageDialog(null,
                            "Error: Este código ya se encuentra "
                            + "registrado.  Intente nuevamente!");
                }
            } while (buscar != null);
            String noms = JOptionPane.showInputDialog(
                    "Entre los nombres del empleado: ");
            double NHorasT = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Entre el # Horas Trabajadas: "));
            double VHoraT = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Entre el valor Hora Trabajada: "));
            double NHorasE = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Entre el # Horas Extras: "));
            //Una vez capturados los datos, se crea en memoria el nodo
            nodo info = new nodo(cod, noms, NHorasT, VHoraT, NHorasE);
            return info;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
            return null;
        }
    }
    
    public void setAddInicio(){
        //Creamos el nodo que se desea registrar
        //en la lista
        nodo info = getCrearNodo();
        if (info != null) {
            if (cab == null) {
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento "
                        + "a la lista.  La lista estaba vacía.");
            } else {
                //Enlazamos el nuevo nodo a la lista
                info.sig = cab;
                //Ahora se debe mover cab al primer 
                //nuevo elemento
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento al "
                        + "inicio de la lista.");
            }
        }else{
            JOptionPane.showMessageDialog(null,
                    "Ocurrio algún error al crear el nodo, "
                    + "intente nuevamente!");
        }
    }
    
    //Este método agrega un nuevo nodo al final de la lista.
    public void setAddFinal(){
        nodo info = getCrearNodo();
        nodo p;
        if (info != null) {
            if (cab == null) {
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento "
                        + "a la lista.  La lista estaba vacía.");
            } else {
                p = cab;
                while (p.sig != null) {
                    p = p.sig;
                }
                p.sig = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento al "
                        + "final de la lista.");
            }
        }else{
            JOptionPane.showMessageDialog(null,
                    "Ocurrio algún error al crear el nodo, "
                    + "intente nuevamente!");
        }
    }
    
    //Este método dado un código, lo busca y si existe
    //lo elimina de la lista.
    public void setElimCodigo( ){
        if(getEsVacia()){
            JOptionPane.showMessageDialog(null, 
                "La lista no tiene elementos!");
        }else{
            nodo p, q;
            String cod = JOptionPane.showInputDialog(
               "Entre código empleado a buscar: ");
            p=getBuscarCod(cod);
            if(p==null)
               JOptionPane.showMessageDialog(null, 
                "El código buscado para eliminar NO"
                + " se encuentra registrado!");
            else{
                if((p==cab)&&(cab.sig==null)){
                    cab=null;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado, la lista esta vacía!");
                }
                else if((p==cab)&&(cab.sig!=null)){
                    cab=cab.sig;
                    p.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado, en el inicio de la"
                    + " lista!");
                }
                else if(p.sig==null){
                    q=cab;
                    while(q.sig!=p)
                        q=q.sig;
                    q.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado, al final de la"
                    + " lista!");
                }else{
                    q=cab;
                    while(q.sig!=p)
                        q=q.sig;
                    q.sig=p.sig;
                    p.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado!");
                }
            }
        }
    }

    public void getMostrarNodo( ){
        String cod = JOptionPane.showInputDialog(
               "Entre código empleado a buscar: ");
        nodo info=getBuscarCod(cod);
        if(getEsVacia())
            JOptionPane.showMessageDialog(null, 
            "La lista esta vacía!");
        else{
            if(info==null)
                JOptionPane.showMessageDialog(null, 
                "El código de empleado no esta registrado!");
            else
                info.getMostrarInfoNodo();
        }
    }
    
    public void getMostrarTodo(){
        if(cab==null)
            JOptionPane.showMessageDialog(null, 
            "La lista esta vacía!");
        else{
            nodo q=cab;
            while(q!=null){
                q.getMostrarInfoNodo();
                q=q.sig;
            }
        }
    }
    
    //Método: setAddDespuesCod
    //Este método dado un código de producto, registra
    //un nuevo nodo en la posición siguiente.
    public void setAddDespuesCod(){
        try{
            String cod=JOptionPane.showInputDialog(
            "Entre código de empleado de referencia: "
            );
            nodo buscar=getBuscarCod(cod);
            if(cab==null)
                JOptionPane.showMessageDialog(null, 
                "La lista se encuentra vacía");
            else{
                if(buscar==null)
                    JOptionPane.showMessageDialog(null, 
                    "Error: el código de empleado de referencia "
                    +"no se encuentra registrado!");
                else{
                    nodo info=getCrearNodo();
                    if((buscar==cab)&&(cab.sig==null)){
                        cab.sig=info;
                        JOptionPane.showMessageDialog(null,
                        "Elemento agregado, después de la "
                        + "cabecera, la lista tiene 2 elementos.");
                    }
                    else if((buscar==cab)&&(cab.sig!=null)){
                        info.sig=cab.sig;
                        cab.sig=info;
                        JOptionPane.showMessageDialog(null,
                        "Elemento agregado, después de la "
                        + "cabecera.");
                    }
                    else if(buscar.sig==null){
                        buscar.sig=info;
                        JOptionPane.showMessageDialog(null,
                        "Elemento agregado, en la último nodo "
                        + "de la lista.");
                    }else{
                        info.sig=buscar.sig;
                        buscar.sig=info;
                        JOptionPane.showMessageDialog(null,
                        "Elemento agregado, entre dos nodos.");
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
    //Método: setOrdenarAsc
    //Este método ordena ascendentemente los nodos
    //de la lista a partir del código de empleado.
    public void setOrdenarAsc(){
        nodo p, q, temp=null;
        p=cab;
        while(p!=null){
            q=cab;
            while(q.sig!=null){
                if((q.cod).compareTo(q.sig.cod)>0){
                    //Realizamos la copia del nodo siguiente
                    temp = new nodo(
                    q.sig.cod,
                    q.sig.noms,
                    q.sig.nHorasT,
                    q.sig.valorHora,
                    q.sig.nHorasE
                    );
                    //Intercambiamos el nodo siguiente 
                    //por el nodo anterior
                    q.sig.cod=q.cod;
                    q.sig.noms=q.noms;
                    q.sig.nHorasT=q.nHorasT;
                    q.sig.valorHora=q.valorHora;
                    q.sig.nHorasE=q.nHorasE;
                    //Intercambios en el nodo anterior
                    //su información por la nodo siguiente(temp)
                    q.cod=temp.cod;
                    q.noms=temp.noms;
                    q.nHorasT=temp.nHorasT;
                    q.valorHora=temp.valorHora;
                    q.nHorasE=temp.nHorasE;                    
                }
                q=q.sig;
            }
            p=p.sig;
        }
    }

    //Método: getUltimo
    //Este método coloca un apuntador en el último
    //nodo de la lista
    public nodo getUltimo(){
        if(cab==null) return null;
        else{
            nodo ultimo=cab;
            while(ultimo.sig!=null)
                ultimo=ultimo.sig;
            return ultimo;
        }
    }
    
    //Método: setEliminarNodo
    //Este método dado un nodo lo elimina de la lista
    public void setEliminarNodo(nodo info){
        if(cab==null)
            JOptionPane.showMessageDialog(null, 
            "Lista vacía!");
        else{
            nodo q=null;
            nodo buscar=getBuscarCod(info.cod);
            if(buscar==null)
                JOptionPane.showMessageDialog(null, 
                "La información del nodo no existe en la lista!");
            else{
                if((buscar==cab)&&(cab.sig==null)){
                    cab=null;                    
                }
                else if((buscar==cab)&&(cab.sig!=null)){
                    cab=cab.sig;
                    buscar.sig=null;
                    buscar=null;                    
                }
                else if(buscar.sig==null){
                    q=cab;
                    while(q.sig!=buscar)
                        q=q.sig;
                    q.sig=null;
                    buscar=null;                    
                }else{
                    q=cab;
                    while(q.sig!=buscar)
                        q=q.sig;
                    q.sig=buscar.sig;
                    buscar.sig=null;
                    buscar=null;                    
                }
            }
        }
    }
    
    //Este método agrega un nuevo nodo copia al final de la lista.
    public void setAddFinalC(nodo info){        
        nodo p;
        if (info != null) {
            if (cab == null) {
                cab = info;                
            } else {
                p = cab;
                while (p.sig != null) {
                    p = p.sig;
                }
                p.sig = info;                
            }
        }else{
            JOptionPane.showMessageDialog(null,
                    "Ocurrio algún error al crear el nodo, "
                    + "intente nuevamente!");
        }
    }
    
    //Método: setInvertir
    //Este método invierte los nodos registrados en la lista.
    public void setInvertir(){
        if(cab==null){
            JOptionPane.showMessageDialog(null, 
            "La lista esta vacía!");
        }else{
            Lista listAux=new Lista();
            int tam = getLongLista();
            int i=0;
            nodo u=null, temp=null;
            while(i<tam){
                //Colomamos un apuntador en el último nodo
                u=getUltimo();
                //Copiamos la información del último nodo
                temp=new nodo(u.cod, u.noms, u.nHorasT,
                u.valorHora, u.nHorasE);
                //Agrego la información copiada en
                //una lista auxiliar
                listAux.setAddFinalC(temp);
                //Eliminar el último nodo
                setEliminarNodo(u);
                //Incrementamos el índice para copia 
                //el siguiente nodo
                i++;
            }
            cab=listAux.cab;
        }
    }
}
