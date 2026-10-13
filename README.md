# PA2-Estructuras-Lineales-Grupo1





Actividad 2: Recorrido e Inserción
Para implementar los algoritmos de recorrido completo e inserción al inicio en una lista enlazada simple en Java, primero definiremos la estructura básica de un Nodo y luego la clase de la Lista Enlazada.
-Estructura base del Nodo
 

    class Nodo {
       int dato;
       Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
        }
    }

Cada elemento de la lista contiene un valor (dato) y una referencia al siguiente nodo (siguiente).


1- Algoritmo de Inserción al Inicio  
Este algoritmo agrega un nuevo nodo al comienzo de la lista. Su complejidad temporal es (O(1)) porque solo requiere reasignar punteros directamente, sin recorrer toda la lista.


    public void insertarAlInicio(int dato) {
        // Crear el nuevo nodo
        Nodo nuevoNodo = new Nodo(dato);
    
        // Apuntar el nuevo nodo a la cabeza actual
        nuevoNodo.siguiente = cabeza;
    
         // Actualizar la cabeza de la lista
         cabeza = nuevoNodo;
    }

Lógica:
-Crear un nuevo nodo con el valor proporcionado.

-Hacer que el puntero siguiente del nuevo nodo apunte a la cabeza actual (cabeza) de la lista.

-Actualizar la cabeza de la lista para que sea el nuevo nodo.


2- Algoritmo de Recorrido Completo
Este algoritmo visita cada uno de los nodos desde el inicio hasta el final de la lista para procesar o mostrar su información. Su complejidad temporal es (O(n)), donde $n$ es el número de elementos.


    public void recorrer() {
        Nodo actual = cabeza;
    
        System.out.print("Lista: ");
        while (actual != null) {
        System.out.print(actual.dato + " -> ");
        actual = actual.siguiente; // Avanzar al siguiente nodo
        }
        System.out.println("null");
    }

Lógica:
-Inicializar un nodo temporal (actual) apuntando a la cabeza de la lista.

-Crear un bucle que se ejecute mientras actual sea diferente de null.

-Procesar el dato del nodo actual (imprimir).
-Avanzar al siguiente nodo haciendo actual = actual.siguiente.
    


