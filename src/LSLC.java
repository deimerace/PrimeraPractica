import javax.swing.*;

//Clase Lista Simplemente Ligada Circular
public class LSLC {
    //Privado
    private static nodoSimple primero;
    private static nodoSimple ultimo;

    //Público

    LSLC(){
        primero = null;
        ultimo = null;
    }

    public boolean esVacia(){
        return primero == null;
    }

    public nodoSimple primerNodo(){
        return primero;
    }

    public nodoSimple ultimoNodo(){
        return ultimo;
    }

   public nodoSimple anterior(nodoSimple x){
     nodoSimple p;
     p=primero;
     nodoSimple y;
     y=ultimo;
     while (p!=null && !p.equals(x)){
         y=p;
         p=p.retornaLiga();
     }
     return y;
     }

    public boolean finDeRecorrido(nodoSimple x){
        return (x == primero);
    }

    public void recorre() {
        nodoSimple p;
        p = primerNodo();
            do {
                JOptionPane.showMessageDialog(null, p.retornaDato());
                p = p.retornaLiga();
            } while (!finDeRecorrido(p));
        }

    public nodoSimple buscarDato(int d){
        nodoSimple p =primero;
        do{
            if (d == p.retornaDato()){return p;}
                p = p.retornaLiga();
        }while(p != primero);
        return null;
    }

    public void borrar(nodoSimple x, nodoSimple y){
        if (x == null){
        JOptionPane.showMessageDialog(null,"El dato no existe");
        return;
        }
        if (!x.equals(primero)) {
            JOptionPane.showMessageDialog(null,"El dato NO es el primero");
            y.asignaLiga(x.retornaLiga());
            if (x.equals(ultimo)) {
                JOptionPane.showMessageDialog(null,"El dato es el ultimo");
                ultimo = y;
            }
        } else
            JOptionPane.showMessageDialog(null,"El dato es el primero");
        if(!primero.equals(ultimo)) {
            JOptionPane.showMessageDialog(null,"primero es diferente a null"+primero.retornaDato()+ultimo.retornaDato());
            primero = primero.retornaLiga();
            ultimo.asignaLiga(primero);
        }
           else {
               primero = null;
                JOptionPane.showMessageDialog(null,"primero es null");
                ultimo = null;
            }

    }

    public void insertarAlFinal(int d){
        nodoSimple x = new nodoSimple(d);
        if (primero==null) {
            JOptionPane.showMessageDialog(null,"la lista está vacia al inicio");
            primero = x;
            ultimo = primero;
            ultimo.asignaLiga(x);

        } else{
            JOptionPane.showMessageDialog(null,"Se está asignando un segundo dato");
            ultimo.asignaLiga(x);
            x.asignaLiga(primero);
            ultimo = x;
        }
    }
    public void insertarAlInicio(int d){
        nodoSimple x = new nodoSimple(d);
        if (primero==null) {
            primero = x;
            ultimo = x;
            ultimo.asignaLiga(x);
        } else{
            x.asignaLiga(x);
            primero = x;
            ultimo.asignaLiga(x);
        }
    }
    public void insertarOrdenado(int d){

    }

    public void ordenaAscendentemente(){}

    public void eliminarLista(){
        primero=null;
        ultimo=null;
    }
}
