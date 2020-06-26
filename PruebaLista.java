import javax.swing.*;

public class PruebaLista {
    public static Nodo np;;
    public static Nodo nu;

    public static void main(String[] args) {
    // Modo aciclico de crear nodos de listas enlazadas
        np = new Nodo(1);
        // Al no estar enlazado con otro nodo el primero tambien es el ultimo
        nu = np;
/*       // Nuevo nodo 1
        Nodo nn1 = new Nodo(2);
        nu.siguiente = nn1;
        nu = nn1;

        // Nuevo nodo 2
        Nodo nn2 = new Nodo(3);
        nu.siguiente = nn2;
        nu = nn2;

        // Nuevo nodo 2
        Nodo nn3 = new Nodo(4);
        nu.siguiente = nn3;
        nu = nn3;*/
        Nodo aux;
        nu = nu.siguiente = new  Nodo(2);
        nu = nu.siguiente = new  Nodo(3);
        nu = nu.siguiente = new  Nodo(4);
        nu = nu.siguiente = new  Nodo(5);
        // UTILIZANDO SEGUNDO CONSTRUCTOR
        nu = nu.siguiente = new Nodo(6, nu.siguiente);
        nu = nu.siguiente = new Nodo(7, nu.siguiente);
        nu = nu.siguiente = new Nodo(8, nu.siguiente);


        /*System.out.format("valor = %d\tNodo primero = %s\tNodo nn1 = %s\n", np.valor, np.siguiente, nn1);
        System.out.format("valor = %d\tsiguiente = %s\tNodo nn2 = %s\n", nn1.valor, nn1.siguiente,nn2);
        System.out.format("valor = %d\tsiguiente = %s\n", nn2.valor, nu.siguiente);
        System.out.format("valor = %d\tsiguiente = %s\n", nn3.valor, nu.siguiente);*/

        System.out.println("-----------------------------------------------");
        //imprimirLista(np);
        System.out.println("----------------LISTAS ENLAZADAS---------------");
        //eliminarElementoFin(np, nu  );
        System.out.println("-----------------------------------------------");
        //imprimirLista(np);
        //eliminarElementoFin2();
        imprimirLista(np);
        System.out.println("-----------------------------------------------");
        eliminarElementos();
    }
    public static void imprimirLista(Nodo np){
        Nodo aux = np;
        while (aux != null){
            System.out.format("\tvalor = %d\tsiguiente = %s\n", aux.valor, aux.siguiente);
            aux = aux.siguiente;
        }

    }

    public static void eliminarElementoFin(Nodo np, Nodo nu){
        Nodo aux = np;
        while (aux != null){
            System.out.format("valor = %d\tsiguiente = %s\n", aux.valor, aux.siguiente);
            if (aux.siguiente.siguiente == null){
                System.out.println("VALOR ==== "+aux.valor);
                aux.siguiente = null;
                nu = aux;
                nu.siguiente = null;
                break;
            }
            aux = aux.siguiente;
        }
    }

    public static void eliminarElementoFin2(){
        Nodo na = np;
        while (na.siguiente.siguiente != null){
            na = na.siguiente;
        }
        System.out.println("VALOR ========= "+na.valor);
        nu = na;
        nu.siguiente = null;
    }
    // Eliminar cualquier nodo de la lista en base al dato o valor
    public static void eliminarElementos(){
        int dato_eliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato a eliminar"));
        // Apuntadores
        Nodo p = np; // nodo actual
        Nodo q = null; // nodo anterior

        boolean buscado = false;
        // Busqueda del nodo y recorrida de la lista
        while ((p != null) && (!buscado)){
            buscado = (p.valor == dato_eliminar);
            // Si no encuentra el valor buscado sigue iterando al siguiente nodo
            if (!buscado){
                q = p;
                p = p.siguiente;
            }
        }
        // Tras encontrar el elemento se procede a enlazar sin tomar el nodo a eliminar
        if (p != null){

            // Distingue entre el primer nodo o los demás nodos de la lista
            if (p == np){
                np = p.siguiente; // Enlazando con el siguiente
            }else{
                // Sino el anterior enlace es igual al siguiente enlace
                q.siguiente = p.siguiente;
            }
            p = null;
        }
        imprimirLista(np);
        System.out.println("\tElemento eliminado === "+ dato_eliminar);
    }
}

class Nodo {
    public int valor;
    public Nodo siguiente;

    public Nodo(int valor){
        // Referencia al constructor que recive 2 parámetros
        this(valor, null);
    }

    public Nodo(int valor, Nodo nodo){
        this.valor = valor;
        this.siguiente = nodo;
    }
}
