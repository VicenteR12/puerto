package PaqC11;

public class Contenedor {
    private int id;
    private int peso;
    private String pais;
    private boolean inspeccionado;
    private int prioridad;
    private String descripcion;
    private String envia;
    private String recibe;

    public Contenedor(int id, int peso, String pais,
                      boolean inspeccionado, int prioridad,
                      String descripcion, String envia, String recibe) {
        this.id = id;
        if (peso>0) {
            this.peso = peso;
        }
        this.pais = pais;
        this.inspeccionado = inspeccionado;
        if (prioridad>=1&&prioridad<=3) {
            this.prioridad = prioridad;
        }
        if(descripcion.length()<=100) {
            this.descripcion = descripcion;
        }
        if(envia.length()<=20) {
            this.envia = envia;
        }
        if(recibe.length()<=20) {
            this.recibe = recibe;
        }
    }

    public int getId() {
        return id;
    }

    public int getPeso() {
        return peso;
    }

    public boolean getInspeccionado(){
        return inspeccionado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEnvia() {
        return envia;
    }

    public String getPais() {
        return pais;
    }

    public String getRecibe() {
        return recibe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrioridad(int prioridad) {
        if(prioridad>=1&&prioridad<=3) {
            this.prioridad = prioridad;
        }
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEnvia(String envia) {
        this.envia = envia;
    }

    public void setInspeccionado(boolean inspeccionado) {
        this.inspeccionado = inspeccionado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setRecibe(String recibe) {
        this.recibe = recibe;
    }
}
