import Clases.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    ArrayList<Personaje> personajes = new ArrayList<>();
    //Mejora añadir la raza

    public static void main(String[] args) {
        Main Start = new Main();
        Start.menuPrincipal();
    }

    public void menuPrincipal() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            System.out.println(Ansi.GREEN + "+-------    Gestiona Monstruos  --------+");
            System.out.println(Ansi.HIGH_INTENSITY+Ansi.YELLOW + "1."+Ansi.WHITE+"Añadir un personaje");
            System.out.println(Ansi.YELLOW +"2."+Ansi.WHITE+"Mostrar la información");
            System.out.println(Ansi.YELLOW +"3."+Ansi.WHITE+"Guerra de facciones");
            System.out.println(Ansi.YELLOW +"4."+Ansi.WHITE+"Salir");
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            try {
                System.out.println(Ansi.WHITE + "Escribe una de las opciones");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> creaPersonaje();
                    case 2 -> {
                        if(!personajes.isEmpty()) muestraPersonajes();
                        else System.out.println(Ansi.RED+"No hay ningun personaje creado"+Ansi.LOW_INTENSITY);
                    }
                    case 3 -> GuerraFacciones();
                    case 4 -> {
                        salir = true;
                        System.out.println("Te has salido.");
                        return;
                    }
                    default -> System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Error, vuelve a introducir el modo nuevamente.");

                }
            } catch (InputMismatchException e) {
                System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Debes insertar un número correspondiente al que se te indica.");
                sc.next();
            }
        }
    }

    public void creaPersonaje(){
        int raza;
        String faccion;
        System.out.println("Bienvenido a la creación de personaje");
        System.out.println("Escribe un nombre para el personaje: ");
        String nombre = sc.next();
        boolean faccionCorrecta = false;
        do {
            System.out.println("Que facción quiere el personaje?");
            System.out.println("Alliance");
            System.out.println("Horde");
            faccion = sc.next();
            if(faccion.equalsIgnoreCase("Horde") || faccion.equalsIgnoreCase("Alliance")) {
                faccionCorrecta = true;
            } else {
                System.out.println("La raza que has introducido no existe");
            }
        } while (!faccionCorrecta);
        boolean razaCorrecta = false;
        do {
        System.out.println("Escribe que raza del personaje desea: ");
        System.out.println("1. Humano");
        System.out.println("2. Orco");
        System.out.println("3. Elfo");
        raza = sc.nextInt();
        //Comprueba que lo escrito es correcto
            if(raza == 1 || raza == 2 || raza == 3) {
                razaCorrecta = true;
            } else {
                System.out.println("No has añadido una opción valida");
            }
        } while (!razaCorrecta);
        System.out.println("Escribe la potencia de ataque del personaje: ");
        int potenciaAtaque = sc.nextInt();
        System.out.println("Escoja cuantas armas tiene el personaje: ");
        int numeroArmas = sc.nextInt();
        ArrayList<Armas> armas = new ArrayList<>();
            for(int x = 0; x < numeroArmas; x++) {
                System.out.println("Nombre del arma "+x +" :");
                String nombreArma = sc.next();
                System.out.println("Poder de ataque del arma "+x +" :");
                int poderAtaqueArma = sc.nextInt();
                Armas Arma = new Armas(nombreArma,poderAtaqueArma);
                armas.add(Arma);
            }
        if(raza == 1) { //Humano
            boolean inteligenciaCorrecta = false;
            int tieneInteligencia;
            do {
                System.out.println("Tiene inteligencia el Humano?");
                System.out.println("1. Si");
                System.out.println("2. No");
                tieneInteligencia = sc.nextInt();
                if(tieneInteligencia == 1 || tieneInteligencia == 2) {
                    inteligenciaCorrecta = true;
                } else {
                    System.out.println("No has introducido una opción valida");
                }
            } while (!inteligenciaCorrecta);
            //Hacer la comprobacion
            boolean inteligencia;
            inteligencia = tieneInteligencia == 1;
            Humano humano = new Humano(nombre,faccion,potenciaAtaque,numeroArmas,armas,inteligencia);
            personajes.add(humano);
        } else if(raza == 2) { //Orco
            boolean tenacidadCorrecta = false;
            int tenacidad;
            do {
                System.out.println("Cuanta tenacidad tiene el Orco?");
                System.out.println("Minimo 1 y Maximo 3 de Tenacidad");
                tenacidad = sc.nextInt();
                if(tenacidad == 1 || tenacidad == 2 || tenacidad == 3) {
                    tenacidadCorrecta = true;
                } else {
                    System.out.println("La tenacidad que has introducido no es correcta para el personaje");
                }
            } while (!tenacidadCorrecta);
            //Hacer la comprobacion
            Orco orco = new Orco(nombre,faccion,potenciaAtaque,numeroArmas,armas,tenacidad);
            personajes.add(orco);
        } else { //Elfo
            boolean magiaCorrecta = false;
            double magia;
            do {
                System.out.println("Cuanta magia tiene el Elfo?");
                System.out.println("Minimo 0 y Maximo 0.99 de Magia (con ,)");
                magia = sc.nextDouble();
                if(magia >= 0 || magia <= 0.99) {
                    magiaCorrecta = true;
                } else {
                    System.out.println("La magia has introducido para el personaje no es correcta");
                }
            } while (!magiaCorrecta);
            //Hacer la comprobacion
            Elfo elfo = new Elfo(nombre,faccion,potenciaAtaque,numeroArmas,armas,magia);
            personajes.add(elfo);
        }
        System.out.println("El personaje ha sido creado correctamente");
    }

    public void muestraPersonajes(){
        for (Personaje listaPersonajes : personajes) {
           listaPersonajes.mostrarInfo();
        }
    }

    public void GuerraFacciones(){
        int sumaHorde = 0;
        int sumaAlliance = 0;
        for (Personaje personaje : personajes) {
            if (personaje.getFaccion().equalsIgnoreCase("Horde")) {
                sumaHorde = personaje.calculoMediaAtaque() + sumaHorde;
            } else if (personaje.getFaccion().equalsIgnoreCase("Alliance")) {
                sumaAlliance = personaje.calculoMediaAtaque() + sumaAlliance;
            }
        }
        System.out.println("La facción Alliance tiene "+sumaAlliance+" de poder de ataque");
        System.out.println("La faccion Horde tiene "+sumaHorde+" de poder de ataque");
        if(sumaAlliance > sumaHorde) {
            System.out.println("El ganador es Alliance!");
        } else {
            System.out.println("El ganador es Horde!");
        }
    }
}
