package PaqC11;

public class Hub {
    private Contenedor[][] contenedores;
    public Hub(){
        contenedores = new Contenedor[10][12];
    }

    public String toString(){
        String s = "";
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j <=11; j++){
                if(contenedores[i][j] == null){
                    s+="-  ";
                }
                else {
                    s+="[] ";
                }
            }
            s+="\n";
        }
        return s;
    }

    public void apilar(Contenedor contenedor){
        if(contenedor.getPrioridad()==1){
            for(int i = 9; i>=0; i--){
                if (contenedores[i][0]==null){
                    contenedores[i][0]=contenedor;
                    return;
                }
            }
        }
        if(contenedor.getPrioridad()==2){
            for(int i = 9; i>=0; i--){
                if (contenedores[i][1]==null){
                    contenedores[i][1]=contenedor;
                    return;
                }
            }
        }
        if(contenedor.getPrioridad()==3){
            for(int j = 2; j<11; j++) {
                for (int i = 9; i >= 0; i--) {
                    if (contenedores[i][j] == null) {
                        contenedores[i][j] = contenedor;
                        return;
                    }
                }
            }
        }
    }

    public void desapilar(int columna){
            for (int i = 0; i < contenedores.length; i++){
                if (contenedores[i][columna]!=null){
                    contenedores[i][columna]=null;
                    return;
                }
            }
    }

    public String buscarID(int id){
        for(int j = 0; j<11; j++) {
            for (int i = 9; i >= 0; i--) {
                if (contenedores[i][j]!=null) {
                    if (contenedores[i][j].getId() == id) {
                        return "ID: " + contenedores[i][j].getId() +
                                "\nPeso: " + contenedores[i][j].getPeso() +
                                "\nPais: " + contenedores[i][j].getPais() +
                                "\nInspeccionado: " + contenedores[i][j].getInspeccionado() +
                                "\nPrioridad: " + contenedores[i][j].getPrioridad() +
                                "\nDescripcion: " + contenedores[i][j].getDescripcion() +
                                "\nEnvia: " + contenedores[i][j].getEnvia() +
                                "\nRecibe: " + contenedores[i][j].getRecibe();
                    }
                }
            }
        }
        return "El contenedor con ID "+ id + " no está en el hub.";
    }

    public Contenedor buscarContenedor(int ID){
        for(int j = 0; j<11; j++) {
            for (int i = 9; i >= 0; i--) {
                if (contenedores[i][j]!=null) {
                    if (contenedores[i][j].getId() == ID) {
                        return contenedores[i][j];
                    }
                }
            }
        }
        return null;
    }

    public int buscarPais(String pais){
        int n=0;
        for(int j = 0; j<11; j++) {
            for (int i = 9; i >= 0; i--) {
                if (contenedores[i][j]!=null) {
                    if (contenedores[i][j].getPais().equals(pais)) {
                        n++;
                    }
                }
            }
        }
        return n;
    }
}
