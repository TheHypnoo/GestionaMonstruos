package Clases;

public abstract class Personaje {
    String nombre;
    String faccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFaccion() {
        return faccion;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }
    public abstract int calculoMediaAtaque();

    public void mostrarInfo(){
        System.out.println("+---------------------------------------+");
        System.out.println("Nombre del personaje: "+getNombre());
        System.out.println("Faccion del personaje: "+getFaccion());
    }
}
