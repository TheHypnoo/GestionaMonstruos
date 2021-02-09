package Clases;

import java.util.ArrayList;

public class Orco extends Personaje {
    protected int potenciaAtaque;
    protected int numeroArmas;
    protected ArrayList<Armas> armas;
    protected int tenacidad;

    public Orco(String nombrePersonaje,String raza,String faccionPersonaje,int potenciaAtaque, int numeroArmas, ArrayList<Armas> armas, int tenacidad) {
        this.potenciaAtaque = potenciaAtaque;
        this.numeroArmas = numeroArmas;
        this.armas = armas;
        this.tenacidad = tenacidad;
        super.nombre = nombrePersonaje;
        super.raza = raza;
        super.faccion = faccionPersonaje;
    }

    public int getPotenciaAtaque() {
        return potenciaAtaque;
    }

    public void setPotenciaAtaque(int potenciaAtaque) {
        this.potenciaAtaque = potenciaAtaque;
    }

    public int getNumeroArmas() {
        return numeroArmas;
    }

    public void setNumeroArmas(int numeroArmas) {
        this.numeroArmas = numeroArmas;
    }

    public ArrayList<Armas> getArmas() {
        return armas;
    }

    public void setArmas(ArrayList<Armas> armas) {
        this.armas = armas;
    }

    public int getTenacidad() {
        return tenacidad;
    }

    public void setTenacidad(int tenacidad) {
        this.tenacidad = tenacidad;
    }

    @Override
    public int calculoMediaAtaque() {
        return getPotenciaAtaque() +((cuentaPoderArma() / getNumeroArmas()) * getTenacidad() / 2);
    }

    public int cuentaPoderArma(){
        int poderAtaqueArmas = 0;
        for (Armas arma : armas) {
            poderAtaqueArmas = arma.getPoderAtaque() + poderAtaqueArmas;
        }
        return poderAtaqueArmas;
    }

    public void muestraArmas() {
        for(int x = 0; x < armas.size(); x++) {
            System.out.println("\t\tNombre del Arma "+x+" : "+armas.get(x).getNombreArma());
            System.out.println("\t\tPoder de ataque del Arma "+x +" : "+armas.get(x).getPoderAtaque());
        }
    }

    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Potencia de Ataque del personaje: "+getPotenciaAtaque());
        System.out.println("Numero de Armas: "+getNumeroArmas());
        System.out.println("Armas:");
        muestraArmas();
        System.out.println("Tenacidad: "+getTenacidad());
        System.out.println("Media de Ataque: "+calculoMediaAtaque());
    }
}
