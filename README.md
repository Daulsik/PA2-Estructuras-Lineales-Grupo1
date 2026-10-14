# PA2-Estructuras-Lineales-Grupo1

## Objetivo del Trabajo
El equipo resolvió la gestión dinámica de una secuencia de solicitudes de atención utilizando estructuras de datos lineales dinámicas (listas enlazadas). El sistema permite manejar un registro que cambia constantemente —ingreso de nuevos casos, eliminaciones, reubicaciones y navegación estructurada— priorizando la claridad del modelado, la eficiencia algorítmica y la argumentación técnica.



#INTEGRANTES:

| Integrante | Aporte principal |
|---|---|---|
| [Huamancha Perez Jose Jossimar] | Integrador / Desarrollador | Actividad 3 Listas Simple y gestión del repositorio. |
| [Paco Becerra Juan Steve] | Desarrollador | Actividad 2 (Vectores - Búsqueda e Inserción). |
| Gabriel Valdiviezo Castillo | Analista / Documentador | Actividad 1 (Análisis teórico) y revisión general. |
| [Mucho Mamani Richard] | Analista / Documentador | Actividad 4 (Análisis teórico) y revisión general. |
| [Marvin Mora Mendieta] | Analista / Documentador | Actividad 1 (Análisis teórico) y revisión general. |



## Estructura del Repositorio
```
PA2-Estructuras-Lineales-Grupo1/
├── Actividad_1_Fundamentos/
├── Actividad_2_Recorrido_Insercion/
├── Actividad_3_Listas_Simples/
├── Actividad_4_Dobles_Circulares/
└── README.md
```







 

Actividad 1. Fundamentos y Representación de listas enlazadas

1.	¿Que es una lista enlazada?
Una lista enlazada es una estructura de datos la cual es dinámica, esta almacena elementos en nodos que están conectados por enlaces o referencias. Cada nodo de una lista contiene información que permite acceder al siguiente nodo, o incluso al anterior. La diferencia con un arreglo es que las listas permiten insertar, eliminar y reubicar sus elementos sin tener que desplazar los elementos posteriores.

2.	¿Como se clasifican las listas enlazadas?
Las listas enlazadas se califican en 3 tipos:
-	Lista simplemente enlazada: Cada nodo apunta al siguiente y esto solo permite que se recorra la lista hacia adelante.
-	Lista doblemente enlazada: Cada nodo contiene referencias al nodo anterior y al siguiente. Esto permitirá que se pueda recorrer en ambos sentidos.
-	Lista circular: El último nodo se enlaza con el primero, haciendo que se vuelva un ciclo continuo.

3.	Representación gráfica básica
Una lista enlazada simple se representa mediante sus nodos que contienen información y van acompañados de una flecha la cual indica su enlace con el siguiente nodo. La lista empieza con un puntero llamado HEAD y la lista termina cuando se llega a NULL.

4.	Representación de una lista enlazada
*Las listas enlazadas son adecuadas para el caso debido a que permiten administrar estas solicitudes de forma dinámica. Según se necesite se puede usar una lista simple con recorrido hacia adelante, una doble para navegar en ambos sentidos o incluso una circular para que se haga una revisión continua.


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

3- Algoritmo de Inserción al Final
Este algoritmo agrega un nuevo nodo al final de la lista. Su complejidad temporal es (O(n)), ya que, al no tener una referencia directa a la cola de la lista, requiere recorrer todos los elementos desde el inicio hasta encontrar el último nodo.

```java
   public void insertarAlFinal(int dato) {
    // Crear el nuevo nodo
    Nodo nuevoNodo = new Nodo(dato);

    // Si la lista está vacía, el nuevo nodo es la cabeza
    if (cabeza == null) {
        cabeza = nuevoNodo;
        return;
    }

    // Nodo temporal para recorrer la lista
    Nodo actual = cabeza;

    // Recorrer hasta encontrar el último nodo
    while (actual.siguiente != null) {
        actual = actual.siguiente; // Avanzar al siguiente nodo
    }

    // Apuntar el siguiente del último nodo al nuevo nodo
    actual.siguiente = nuevoNodo;
}
```    
Lógica:

Crear un nuevo nodo con el valor proporcionado.

Verificar si la lista está vacía (cuando cabeza es null). Si lo está, el nuevo nodo se convierte automáticamente en la cabeza.

Si no está vacía, inicializar un nodo temporal (actual) apuntando a la cabeza.

Crear un bucle que avance nodo por nodo hasta detenerse en el último (aquel cuyo puntero siguiente sea null).

Hacer que el puntero siguiente de ese último nodo apunte al nuevo nodo, agregándolo al final.

4- Algoritmo de Inserción en una Posición Indicada
Este algoritmo inserta un nuevo nodo en un índice o posición específica de la lista. Su complejidad temporal en el peor de los casos es (O(n)), ya que requiere recorrer la estructura hasta encontrar el nodo inmediatamente anterior a la posición deseada.

```java
    public void insertarEnPosicion(int dato, int posicion) {
    // Si la posición es 0, es equivalente a insertar al inicio
    if (posicion == 0) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        return;
    }

    Nodo actual = cabeza;
    int contador = 0;

    // Recorrer hasta llegar al nodo ANTERIOR a la posición
    while (actual != null && contador < posicion - 1) {
        actual = actual.siguiente;
        contador++;
    }

    // Validar que la posición no exceda el tamaño de la lista
    if (actual == null) {
        throw new IllegalArgumentException("Posición fuera de rango");
    }

    // Crear el nuevo nodo y reconectar los enlaces
    Nodo nuevoNodo = new Nodo(dato);
    nuevoNodo.siguiente = actual.siguiente;
    actual.siguiente = nuevoNodo;
}
```
Lógica:

Validar si la posición solicitada es 0; de ser así, se inserta directamente al inicio de la lista.

Inicializar un nodo temporal (actual) en la cabeza y un contador en 0.

Crear un bucle para avanzar por la lista hasta detenerse exactamente un nodo antes de la posición donde se desea insertar (posicion - 1).

Validar que el nodo actual no sea nulo, lo cual indicaría que la posición solicitada es mayor al tamaño de la lista.

Crear el nuevo nodo.

Actividad 3: Lista enlazada simple (Búsqueda, modificación y eliminación)
**Responsable:** Jossimar Huamancha

En esta sección se desarrolló la implementación algorítmica y orientada a objetos en Java para la gestión dinámica de solicitudes de atención mediante una **lista enlazada simple**. El código se encuentra modularizado en dos archivos dentro de la carpeta `Actividad_3_Listas_Simples/`:
- `Nodo.java`: Define la estructura base del nodo (`codigo`, `descripcion`, `estado` y el puntero `siguiente`).
- `ListaSimple.java`: Contiene la lógica de control, los métodos operativos y el método `main` de pruebas.

#### Operaciones Implementadas:
1. **Algoritmo de Búsqueda secuencial ($\mathcal{O}(n)$):**
   - Recorre la estructura nodo por nodo desde la `cabeza`  evaluando el atributo `codigo` hasta encontrar la coincidencia exacta, debido a la ausencia de acceso directo por índices en memoria dinámica.
2. **Algoritmo de Modificación:**
   - Utiliza el resultado de la búsqueda para acceder directamente a la referencia en memoria del nodo localizado, permitiendo actualizar sus atributos (por ejemplo, cambiar el estado de la solicitud a *Resuelto*).
3. **Algoritmo de Eliminación y Reajuste de Enlaces:**
   - Gestiona la desconexión de nodos evaluando tres escenarios críticos:
     - *Eliminación de la cabeza:* Desplaza el puntero principal al siguiente nodo (`cabeza = cabeza.siguiente`).
     - *Eliminación intermedia o final:* Emplea un puntero `anterior` para aplicar el reajuste estructural clave `anterior.siguiente = actual.siguiente`, "saltando" y liberando el nodo objetivo.

#### Análisis de Eficiencia:
- **Operaciones al inicio ($\mathcal{O}(1)$):** La inserción y eliminación al principio son de orden constante ya que solo reasignan el puntero principal sin requerir un recorrido previo.
- **Operaciones al final o posiciones intermedias ($\mathcal{O}(n)$):** Las búsquedas, modificaciones y eliminaciones fuera del inicio exigen un recorrido secuencial obligatorio, elevando el costo computacional de manera lineal respecto al número total de nodos ($n$).



Hacer que el puntero siguiente del nuevo nodo apunte al nodo que originalmente ocupaba esa posición (actual.siguiente).

Resumen de la Actividad 3:
Implementación de algoritmos de búsqueda secuencial O(n), modificación y eliminación con reajuste de punteros en lista simple (anterior.siguiente = actual.siguiente), analizando la eficiencia de cada operación.

Actualizar el puntero siguiente del nodo actual (el anterior) para que apunte al nuevo nodo, intercalándolo exitosamente.



Hacer que el puntero siguiente del nuevo nodo apunte al nodo que originalmente ocupaba esa posición (actual.siguiente).

Actualizar el puntero siguiente del nodo actual (el anterior) para que apunte al nuevo nodo, intercalándolo exitosamente.

