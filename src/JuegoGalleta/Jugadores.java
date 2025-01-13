package JuegoGalleta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Jugador extends Thread {
    private String nombre;
    private int tiempo;
    private static List<Jugador> jugadores;

    public Jugador(String nombre) {
        this.nombre = nombre;
        Random random = new Random();
        this.tiempo = random.nextInt(1000) + 1000; // Tiempo aleatorio entre 1000ms y 2000ms
    }

    @Override
    public synchronized void run() {
        try {
            // Simulamos el tiempo en el que el jugador echa leche a la galleta
            Thread.sleep(tiempo);
            synchronized (jugadores) {
                // Imprimir mensaje de que el jugador se ha corrido
                System.out.println(nombre + ": Me he corrido!");
                jugadores.remove(this);
                // Si es el último jugador, muestra que tiene que comerse la galleta
                if (jugadores.size() == 0) {
                    System.out.println(nombre + " tiene que comerse la galleta.");

                    String cookieMilk =
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⠚⣉⡙⠲⠦⠤⠤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀⢀⣴⠛⠉⠉⠀⣾⣷⣿⡆⠀⠀⠀⠐⠛⠿⢟⡲⢦⡀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⣠⢞⣭⠎⠀⠀⠀⠀⠘⠛⠛⠀⠀⢀⡀⠀⠀⠀⠀⠈⠓⠿⣄⠀⠀⠀\n" +
                                    "⠀⠀⠀⡜⣱⠋⠀⠀⣠⣤⢄⠀⠀⠀⠀⠀⠀⣿⡟⣆⠀⠀⢀⣴⣿⣷⣤⣄⠀⠀\n" +
                                    "⠀⢀⣜⠜⠁⠀⠀⠀⢿⣿⣷⣵⠀⠀⠀⠀⠀⠿⠿⠿⠀⢀⣿⣿⣿⣿⣿⣿⡀⠀\n" +
                                    "⢀⡞⠆⠀⣀⡀⠀⠀⠘⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⠿⠿⠛⠉⠀⠀\n" +
                                    "⢸⠃⠘⣾⣏⡇⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⣤⣴⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀\n" +
                                    "⡸⡄⠀⠘⠟⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⣿⡇⠀⠀⠀⣰⣿⡻⡆⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⢀⣀⣀⣀⣀⡀⠀\n" +
                                    "⠹⣽⣤⣤⣤⣹⣿⡿⠇⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠁⠀⢀⣴⣿⣿⣿⣿⣿⡇⠀\n" +
                                    "⠀⠙⢻⡙⠟⣹⠟⢷⣶⣄⢀⣴⣶⣄⠀⠀⢀⣀⣤⣤⣴⣿⣿⣿⣿⣿⣿⡿⠀⠀\n" +
                                    "⠀⠀⠘⠀⠀⠀⠀⠀⠈⢷⢼⣿⡿⡽⠀⠠⠿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠁⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⢠⡾⣆⠑⠋⠀⢀⣀⣤⣾⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⣧⣄⡄⠴⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢺⣿⢯⣭⣭⣯⣯⣯⣭⣭⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀";

                    System.out.println(cookieMilk);
                    System.out.println("MMMMMM. QUE RICOOOO!!!");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setJugadores(List<Jugador> jugadores) {
        Jugador.jugadores = jugadores;
    }

    public String getNombre() {
        return nombre;
    }
}
