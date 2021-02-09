package Clases;

import java.util.ArrayList;

public class Humano extends Personaje {

    protected int potenciaAtaque;
    protected int numeroArmas;
    protected ArrayList<Armas> armas;
    protected boolean inteligencia;

    public Humano(String nombrePersonaje,String faccionPersonaje,int potenciaAtaque, int numeroArmas, ArrayList<Armas> armas, boolean inteligencia) {
        this.potenciaAtaque = potenciaAtaque;
        this.numeroArmas = numeroArmas;
        this.armas = armas;
        this.inteligencia = inteligencia;
        super.nombre = nombrePersonaje;
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

    public boolean getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(boolean inteligencia) {
        this.inteligencia = inteligencia;
    }

    @Override
    public int calculoMediaAtaque() {
        double media = 0;
        if(getInteligencia()) {
          //average = (mAttack * 1,33) + (Σ mAttacPower de cada Weapon) / mNumWeapons
          media = (getPotenciaAtaque() * 1.33) + (cuentaPoderArma() / getNumeroArmas());
        } else {
            //average = mAttack + (Σ mAttacPower de cada Weapon) / mNumWeapons
            media = getPotenciaAtaque() + (cuentaPoderArma() / getNumeroArmas());
        }
        return (int) media;
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
        if(getInteligencia())System.out.println("Inteligencia: Si");
         else System.out.println("Inteligencia: No");

        System.out.println("Media de Ataque: "+calculoMediaAtaque());
    }

}
