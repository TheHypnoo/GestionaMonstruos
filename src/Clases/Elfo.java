package Clases;

import java.util.ArrayList;

public class Elfo extends Personaje {
    protected int potenciaAtaque;
    protected int numeroArmas;
    protected ArrayList<Armas> armas;
    protected double magia;

    public Elfo(String nombrePersonaje,String raza,String faccionPersonaje,int potenciaAtaque, int numeroArmas, ArrayList<Armas> armas, double magia) {
        this.potenciaAtaque = potenciaAtaque;
        this.numeroArmas = numeroArmas;
        this.armas = armas;
        this.magia = magia;
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

    public double getMagia() {
        return magia;
    }

    public void setMagia(double magia) {
        this.magia = magia;
    }

    @Override
    public int calculoMediaAtaque() {
        //average = mAttack + (Σ (mAttacPower de cada Weapon * (1 + magia))) / mNumWeapons
        return (int) (getPotenciaAtaque() + (cuentaPoderArma() * (1 + getMagia()) / getNumeroArmas()));
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
        System.out.println("Magia: "+getMagia());
        System.out.println("Media de Ataque: "+calculoMediaAtaque());
    }
}
