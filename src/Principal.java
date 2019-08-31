import javax.swing.*;

public class Principal {
    public static LSLC lista= new LSLC();


    public static void main(String[] args) {
        int n;
        //Ciclo para permanecer en el menú hasta que el usuario lo desee
        do {
            //Menú de inicio
            n=mostrarMenu();
            //Dependiendo de la desición tomada, se verifica la opcion correspondiente
            operacionARealizar(n);
        }while(n!=13);
    }

    public static void operacionARealizar(int n){
        switch (n) {
            //TODO Hacer el metodo de crear lista
            case 1://CREAR LISTA
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
                    JOptionPane.showMessageDialog(null, lista.primerNodo());
                    break;
                }
                JOptionPane.showMessageDialog(null,"La lista está vacia");
                break;
            case 4://VER EL ULTIMO NODO
                if (!lista.esVacia()) {
                    JOptionPane.showMessageDialog(null, lista.ultimoNodo());
                    break;
                }
                JOptionPane.showMessageDialog(null,"La lista está vacia");
                break;
            case 5://MOSTRAR LA LISTA
                lista.recorre();
                break;
            case 6://TODO INSERTAR NUEVO DATO EN LA LISTA
                /* ESTA MALO, solo quería ver como funcionaba
                nodoSimple x= lista.buscaDondeInsertar(JOptionPane.showInputDialog(null,"Que dato desea insertar?"));
                nodoSimple y=new nodoSimple("x");
                lista.conectar(x,y);
                ESTA MALO, solo quería ver como funcionaba
                */
                break;
            case 7: //TODo BUSCAR DATO EN LA LISTA
                String datoABuscar=JOptionPane.showInputDialog(null,"Inserte el dato que desea buscar en la lista");
                lista.buscaDondeInsertar(datoABuscar);
                break;
            case 8: //TODO BORRAR UN DATO DE LA LISTA
                /* ESTA MALO, solo quería ver como funcionaba
                nodoSimple datoAborrar= lista.buscarDato(JOptionPane.showInputDialog(null,"¿Que dato desea borrar?"));
                *nodoSimple datoABorrarY= new nodoSimple("a");
                *lista.borrar(datoAborrar, datoABorrarY);
                */
                break;

            case 9: //TODO ORDENAR ASCENDENTEMENTE LA LISTA
                break;

            case 10://TODO INTERCAMBIAR EXTREMOS
                break;

            case 11://TODO ELIMINAR LA LISTA
                break;

            case 12://TODO ACTUALIZAR LA LISTA
                break;
        }
    }

    public static int mostrarMenu(){
        int n=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al menú de inicio \n" +
                "Ingrese el número correspondiente\n" +
                "1.Crear Lista\n" +
                "2.Ver si la lista está vacia\n" +
                "3.Ver el primer elemento de la lista\n" +
                "4.Ver el ultimo elemento de la lista\n" +
                "5.Mostrar la lista\n" +
                "6.Insertar nuevo dato a la lista\n" +
                "7.Bucar un dato en la lista\n" +
                "8.Borrar un dato de la lista\n" +
                "9.Ordenar ascendentemente la lista\n" +
                "10.Intercambiar extremos\n" +
                "11.Eliminar la lista\n" +
                "12.Actualizar la lista\n"+
                "13.Salir"));
        return n;
    }

}
