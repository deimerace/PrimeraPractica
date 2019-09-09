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
         System.out.println("Estoy en un ciclo xD");
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
        nodoSimple p;
        p=primerNodo();
        do{
            if (d == p.retornaDato()){
                return p;
            }
                p = p.retornaLiga();
        }while(!finDeRecorrido(p));
        return null;
    }

    public void borrar(nodoSimple x, nodoSimple y){
        if (!x.equals(primero)) {
            y.asignaLiga(x.retornaLiga());
            if (x.equals(ultimo)) {
                ultimo = y;
            }
        } else
        if(!primero.equals(ultimo)) {

            primero = primero.retornaLiga();
            ultimo.asignaLiga(primero);
        }
           else {
               primero = null;
                ultimo = null;
            }

    }

    public void insertarAlfinal(int d){
        nodoSimple x;
        x=new nodoSimple(d);
        insertarAlFinal(x);
    }
    public void insertarAlFinal(nodoSimple x){
        if (primero==null) {
            primero = x;
            ultimo = x;
            ultimo.asignaLiga(primero);

        } else{
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
            ultimo.asignaLiga(primero);
        } else{
            x.asignaLiga(primero);
            primero = x;
            ultimo.asignaLiga(primero);
        }
    }
    public void insertarOrdenado(int d){
        nodoSimple y=buscaDondeInsertar(d);
        insertar(d,y);
    }
    public nodoSimple buscaDondeInsertar(int d){
        nodoSimple p;
        nodoSimple y;
        p=primerNodo();
        if (p!=null){
            do{
                p=p.retornaLiga();
            }while (!finDeRecorrido(p) && p.retornaDato()<d);
        }
        y=anterior(p);
        return y;
    }
    public void insertar(int d,nodoSimple y){
        nodoSimple x;
        x=new nodoSimple(d);
        conectar(x,y);
    }
    public void conectar(nodoSimple x, nodoSimple y){
        if(y!=null){
            x.asignaLiga(y.retornaLiga());
            y.asignaLiga(x);
            if(y==ultimo){
                ultimo=x;
            }
        } else{
            x.asignaLiga(primero);
            if (primero==null){
                ultimo=x;
            }
            primero=x;
        }
    }
    public void ordenaAscendentemente(){}

    public void eliminarLista(){
        primero=null;
        ultimo=null;
    }
}
