public class nodoSimple {

    //Privado
    private String dato;
    private nodoSimple liga;

    //Público
    public nodoSimple(String d){       //Constructor
        dato = d;
        liga = null;
    }

    public String retornaDato(){
        return dato;
    }

    public nodoSimple retornaLiga(){
        return liga;
    }

    public void asignaDato(String d){
        dato = d;
    }

    public void asignaLiga(nodoSimple x){
        liga = x;
    }

}
