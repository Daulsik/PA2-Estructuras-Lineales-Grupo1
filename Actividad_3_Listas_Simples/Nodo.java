public class Nodo {
    int codigo;
    String descripcion;
    String estado;
    Nodo siguiente;

    public Nodo(int codigo, String descripcion, String estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.siguiente = null;
    }
}
