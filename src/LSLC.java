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
        return primero == ultimo;
    }

    public nodoSimple primerNodo(){
        return primero;
    }

    public nodoSimple ultimoNodo(){
        return ultimo;
    }

    public nodoSimple anterior(nodoSimple x){


    }

    public boolean finDeReocrrido(nodoSimple x){
        return x == null;
    }

    public void recorre(){
        nodoSimple p;
        p = primero;
        while (!finDeReocrrido(p)){
            System.print.outln(p.retornaDato());
            p=p.retornaLiga();
        }
    }

    public nodoSimple buscaDondeInsertar(String d){
        nodoSimple y;
        nodoSimple p;
        p = primerNodo();
        y = anterior(p);
        while ((!finDeReocrrido(p)) && parse.Int(p.retornaDato()) < parse.Int(d)){
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

    public void conectar(nodoSimple x, nodoSimple y){

    }

    public void borrar(nodoSimple x, nodoSimple y){}

    public void desconectar(nodoSimple x, nodoSimple y){}

    public void ordenaAscendentemente(){}

}
