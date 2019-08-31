import javax.swing.*;

//Clase Lista Simplemente Ligada Circular
public class LSLC {
    //Privado
    private nodoSimple primero;
    private nodoSimple ultimo;

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

//TODO colocar nodoSimple, lo puse en void para que el programa no mandara error y poder ejecutarlo
   /*TODO Kai
   *public void anterior(nodoSimple x){ }
   */
    public boolean finDeRecorrido(nodoSimple x){
        return x == primero;
    }

    public void recorre(){
        nodoSimple p;
        p = primerNodo();
        while (!finDeRecorrido(p));{
            JOptionPane.showMessageDialog(null,p.retornaDato());
            p=p.retornaLiga();
        }
    }

    public nodoSimple buscaDondeInsertar(String d){
        nodoSimple y;
        nodoSimple p;
        p = primerNodo();
        y = ultimoNodo();
        while ((!finDeRecorrido(p)) && (p.retornaDato().equals(d))){
            y = p;
            p = p.retornaLiga();
        }
        return y;
    }

    public void insertar(String d, nodoSimple y){
        nodoSimple x;
        x = new nodoSimple(d);
        conectar(x, y);
    }

    public void conectar(nodoSimple X, nodoSimple Y){
        if(Y!=null){
            X.asignaLiga(Y.retornaLiga());
            Y.asignaLiga(X);
            if (Y==ultimo){
                ultimo=X;
            }
            else{
                X.asignaLiga(primero);
                if (primero==null){
                    ultimo=X;
                }
                primero=X;
            }
        }
    }
    nodoSimple buscarDato(Object d) {
        nodoSimple x;
        x = primerNodo();;
        while (!finDeRecorrido(x) && (x.retornaDato()!=d)) {
            x = x.retornaLiga();
        }
         return (x);
    }
    public void borrar(nodoSimple x, nodoSimple y){
        if (x == null){
        JOptionPane.showMessageDialog(null,"dato no existe");
        return;
        }
        desconectar(x, y);
    }

    public void desconectar(nodoSimple x, nodoSimple y){
         if (x != primero) {
             y.asignaLiga(x.retornaLiga());
             if (x == ultimo) {
                 ultimo = y;
             } else
                 primero = primero.retornaLiga();
             if (primero == null) {
                 ultimo = null;
             }
         }
    }

    public void ordenaAscendentemente(){}

}
