public class nodoSimple {

    //Privado
    private int dato;
    private nodoSimple liga;

    //Público
    public nodoSimple(int dato){       //Constructor
        this.dato=dato;
        liga = null;
    }

    public int retornaDato(){
        return dato;
    }                //Metodos de la clase nodo simple

    public nodoSimple retornaLiga(){
        return liga;
    }

    public void asignaDato(int dato){
        this.dato = dato;
    }

    public void asignaLiga(nodoSimple liga){
        this.liga = liga;
    }

}
