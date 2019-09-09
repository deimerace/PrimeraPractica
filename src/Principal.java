import javax.swing.*;

public class Principal {
    public static LSLC lista= new LSLC();
    public static int c;


    public static void main(String[] args) {
        int n;

        //Ciclo para permanecer en el menú hasta que el usuario lo desee

        do {

            //Menú de inicio
            n=mostrarMenu();

            //Validar que haya una manera de ingresar los datos.
            if(n!=1 && c==0){

                JOptionPane.showMessageDialog(null,"Primero seleccione la opcion 1, para empezar a crear la lista.");
            }else{

            //Dependiendo de la desición tomada, se verifica la opcion correspondiente

            operacionARealizar(n);
            }
        }while(n!=13);
    }

    public static void operacionARealizar(int n){
        switch (n) {
            case 1://CREAR LISTA
                do {
                    if (c != 1 || c != 2 || c != 3) {
                        JOptionPane.showMessageDialog(null, "Ingrese el número antes del enunciado.");
                    }
                    actualizarFormaDeGuardarDatos();
                    if (c == 1 || c == 2 || c == 3) {
                        JOptionPane.showMessageDialog(null, "Comience a ingresar datos");
                    }
                }while(c != 1 && c != 2 && c != 3);
                break;
            case 2://COMPROBAR SI LA LISTA ESTÁ VACIA
                if (lista.esVacia()) {
                    JOptionPane.showMessageDialog(null, "La lista está vacia");
                } else {
                    JOptionPane.showMessageDialog(null, "La lista NO está vacia");
                }
                break;
            case 3://VER EL PRIMER NODO
                if (!lista.esVacia()) {
                    JOptionPane.showMessageDialog(null, lista.primerNodo().retornaDato());
                    break;
                }
                JOptionPane.showMessageDialog(null, "La lista está vacia");
                break;
            case 4://VER EL ULTIMO NODO
                if (!lista.esVacia()) {
                    JOptionPane.showMessageDialog(null, lista.ultimoNodo().retornaDato());
                    break;
                }
                JOptionPane.showMessageDialog(null, "La lista está vacia");
                break;
            case 5://MOSTRAR LA LISTA
                if (lista.esVacia()) {
                    JOptionPane.showMessageDialog(null, "La lista está vacia");
                    break;
                }
                lista.recorre();
                break;
            case 6://INSERTAR DATO EN UNA LISTA
                String dato = JOptionPane.showInputDialog(null, "¿Qué dato desea insertar?");
                //Mira si el usuario ingreso un dato o no, en caso de no ingresar nada, escribirá este mensaje y volverá al menú de inicio.
                if (dato.isEmpty()){
                JOptionPane.showMessageDialog(null, "Solamente puede ingresar un dato numerico");
                break;
                }
                //validar que "dato" sea una cadena de numeros.
                if(!esUnNumero(dato)){
                    JOptionPane.showMessageDialog(null, "Solamente puede ingresar un dato numerico");
                    break;
                }
                int  d=Integer.parseInt(dato);
                switch (c) {
                    case 1:
                        lista.insertarAlfinal(d);
                        break;
                    case 2:
                        lista.insertarAlInicio(d);
                        break;
                    case 3:
                        lista.insertarOrdenado(d);
                        break;
                }

                break;
            case 7://Busca un dato en la lista.
                if(lista.esVacia()){
                    JOptionPane.showMessageDialog(null,"La lista está vacia");
                    break;
                    }
                int datoABuscar=Integer.parseInt(JOptionPane.showInputDialog(null,"Inserte el dato que desea buscar en la lista"));
                nodoSimple datoEncontrado=lista.buscarDato(datoABuscar);
                if(datoEncontrado==null){
                    JOptionPane.showMessageDialog(null,"El dato no se encontró en la lista");
                    break;
                }
                JOptionPane.showMessageDialog(null,"El dato encontrado es:"+datoEncontrado.retornaDato()+"\nEstá antes de:"+datoEncontrado.retornaLiga().retornaDato());
                break;
            case 8: //BORRAR UN DATO DE LA LISTA
                if(lista.esVacia()){
                    JOptionPane.showMessageDialog(null,"la lista está vacia");
                    break;
                }
                nodoSimple datoAborrarX=lista.buscarDato( Integer.parseInt( JOptionPane.showInputDialog(null,"¿Que dato desea borrar?")));
                if (datoAborrarX == null){
                    JOptionPane.showMessageDialog(null,"El dato no existe");
                    break;
                }
                nodoSimple datoABorrarY;
                datoABorrarY=lista.anterior(datoAborrarX);
                lista.borrar(datoAborrarX, datoABorrarY);
                break;

            case 9: //TODO ORDENAR ASCENDENTEMENTE LA LISTA
                break;

            case 10://TODO INTERCAMBIAR EXTREMOS
                break;

            case 11://ELIMINAR LA LISTA
                lista.eliminarLista();
                break;

            case 12://ACTUALIZAR LA LISTA
                actualizarFormaDeGuardarDatos();
                break;
        }
    }

    public static int mostrarMenu(){

        int n=0;

                String m = (JOptionPane.showInputDialog("Bienvenido al menú de inicio \n" +
                "Ingrese el número correspondiente\n" +
                "1.Crear Lista\n" +
                "2.Ver si la lista está vacia\n" +
                "3.Ver el primer elemento de la lista\n" +
                "4.Ver el ultimo elemento de la lista\n" +
                "5.Mostrar la lista\n" +
                "6.Insertar nuevo dato a la lista\n" +
                "7.Buscar un dato de la lista\n" +
                "8.Borrar un dato de la lista\n" +
                "9.Ordenar ascendentemente la lista\n" +
                "10.Intercambiar extremos\n" +
                "11.Eliminar la lista\n" +
                "12.Actualizar la manera de ordenar la lista\n"+
                "13.Salir"));
        if(!esUnNumero(m)){
            JOptionPane.showMessageDialog(null, "Ingrese el dato numero al inicio del enunciado que desea seleccionar.");
            return n;
        }
        n=Integer.parseInt(m);
        return n;
    }

    public static void actualizarFormaDeGuardarDatos(){
        String m=(JOptionPane.showInputDialog(null, "¿Como desea que los datos se guarden?\n"
                +"1.Insertando datos al final\n"
                +"2.Insertando datos al inico\n"
                +"3.Insertando datos ordenados descendentemente"));
        if(!esUnNumero(m)){
            JOptionPane.showMessageDialog(null, "Ingrese el dato numero al inicio del enunciado que desea seleccionar.");
            return;
        }
        c=Integer.parseInt(m);
    }


    //valida si es un numero el dato ingresado, o no, en caso de serlo, retornará verdadero, en caso de lo contrario, retornará falso

    public static boolean esUnNumero(String d){
        try{
            Integer.parseInt(d);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }

}
