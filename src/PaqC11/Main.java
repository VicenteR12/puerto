package PaqC11;

public class Main {
    public static void main(String[] args) {
        Hub muelle = new Hub();
        System.out.println(muelle.toString());
        Contenedor c1 = new Contenedor(11, 23, "España", false, 1, "Un contenedor", "Empresa 1", "Empresa 2");
        muelle.apilar(c1);
        muelle.apilar(c1);
        System.out.println(muelle.toString());
        muelle.desapilar(0);
        System.out.println(muelle.toString());
        System.out.println(muelle.buscarID(11));
        System.out.println(muelle.buscarID(2));
        muelle.apilar(c1);
        System.out.println(muelle.buscarPais("España"));
    }
}