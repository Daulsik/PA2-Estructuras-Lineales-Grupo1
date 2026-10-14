public class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    public void insertar(int codigo, String descripcion, String estado) {
        Nodo nuevo = new Nodo(codigo, descripcion, estado);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    // BÚSQUEDA
    public Nodo buscarSolicitud(int codigoBuscado) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.codigo == codigoBuscado) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // MODIFICACIÓN
    public boolean modificarSolicitud(int codigoBuscado, String nuevoEstado) {
        Nodo nodoEncontrado = buscarSolicitud(codigoBuscado);
        if (nodoEncontrado != null) {
            nodoEncontrado.estado = nuevoEstado;
            return true;
        }
        return false;
    }

    // ELIMINACIÓN Y REAJUSTE DE ENLACES
    public void eliminarSolicitud(int codigoBuscado) {
        if (cabeza == null) return;

        if (cabeza.codigo == codigoBuscado) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;
        while (actual != null && actual.codigo != codigoBuscado) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            anterior.siguiente = actual.siguiente;
        }
    }

    public void mostrarLista() {
        Nodo actual = cabeza;
        System.out.println("--- SECUENCIA ACTUAL DE SOLICITUDES ---");
        while (actual != null) {
            System.out.println("[ID: " + actual.codigo + " | Desc: " + actual.descripcion + " | Estado: " + actual.estado + "]");
            actual = actual.siguiente;
        }
        System.out.println("----------------------------------------\n");
    }

    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        lista.insertar(101, "Falla en sistema de pagos", "Pendiente");
        lista.insertar(102, "Actualización de base de datos", "En proceso");
        lista.insertar(103, "Revisión de credenciales de acceso", "Pendiente");

        System.out.println("ESTADO INICIAL:");
        lista.mostrarLista();

        System.out.println(">> Ejecutando Búsqueda del ID 102...");
        Nodo encontrado = lista.buscarSolicitud(102);
        if (encontrado != null) {
            System.out.println("¡Encontrado! -> " + encontrado.descripcion + " | Estado: " + encontrado.estado + "\n");
        }

        System.out.println(">> Modificando estado del ID 101 a 'Resuelto'...");
        lista.modificarSolicitud(101, "Resuelto");
        lista.mostrarLista();

        System.out.println(">> Eliminando la solicitud con ID 103...");
        lista.eliminarSolicitud(103);
        lista.mostrarLista();
    }
}
