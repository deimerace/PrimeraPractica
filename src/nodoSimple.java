public class nodoSimple {

    //Privado
    private Object dato;
    private nodoSimple liga;

    //Público
    public nodoSimple(Object dato){       //Constructor
        this.dato=dato;
        liga = null;
    }

    public Object retornaDato(){
        return dato;
    }                //Metodos de la clase nodo simple

    public nodoSimple retornaLiga(){
        return liga;
    }

    public void asignaDato(Object dato){
        this.dato = dato;
    }

    public void asignaLiga(nodoSimple liga){
        this.liga = liga;
    }

}
