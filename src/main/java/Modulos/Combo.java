package modulos;

public class Combo {
    private Object id;
    private String descripcion;

    public Combo(Object id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    @Override
    public boolean equals(Object o) {
        return this.id == ((Combo) o).id;
    }
    
}
