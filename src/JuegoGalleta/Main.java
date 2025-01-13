package JuegoGalleta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Jugador> jugadores = new ArrayList<>();


        System.out.println("=======================================");
        System.out.println("        El Juego de la Galleta         ");
        System.out.println("=======================================");

        // ASCII de la galleta
        String cookie =
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⠚⣉⡙⠲⠦⠤⠤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢀⣴⠛⠉⠉⠀⣾⣷⣿⡆⠀⠀⠀⠐⠛⠿⢟⡲⢦⡀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⣠⢞⣭⠎⠀⠀⠀⠀⠘⠛⠛⠀⠀⢀⡀⠀⠀⠀⠀⠈⠓⠿⣄⠀⠀⠀\n" +
                        "⠀⠀⠀⡜⣱⠋⠀⠀⣠⣤⢄⠀⠀⠀⠀⠀⠀⣿⡟⣆⠀⠀⠀⠀⠀⠀⠻⢷⡄⠀\n" +
                        "⠀⢀⣜⠜⠁⠀⠀⠀⢿⣿⣷⣵⠀⠀⠀⠀⠀⠿⠿⠿⠀⠀⣴⣶⣦⡀⠀⠰⣹⡆\n" +
                        "⢀⡞⠆⠀⣀⡀⠀⠀⠘⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣶⠇⠀⢠⢻⡇\n" +
                        "⢸⠃⠘⣾⣏⡇⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⣠⣤⣤⡉⠁⠀⠀⠈⠫⣧\n" +
                        "⡸⡄⠀⠘⠟⠀⠀⠀⠀⠀⠀⣰⣿⣟⢧⠀⠀⠀⠀⠰⡿⣿⣿⢿⠀⠀⣰⣷⢡⢸\n" +
                        "⣿⡇⠀⠀⠀⣰⣿⡻⡆⠀⠀⠻⣿⣿⣟⠀⠀⠀⠀⠀⠉⠉⠉⠀⠀⠘⢿⡿⣸⡞\n" +
                        "⠹⣽⣤⣤⣤⣹⣿⡿⠇⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡔⣽⠀\n" +
                        "⠀⠙⢻⡙⠟⣹⠟⢷⣶⣄⢀⣴⣶⣄⠀⠀⠀⠀⠀⢀⣤⡦⣄⠀⠀⢠⣾⢸⠏⠀\n" +
                        "⠀⠀⠘⠀⠀⠀⠀⠀⠈⢷⢼⣿⡿⡽⠀⠀⠀⠀⠀⠸⣿⣿⣾⠀⣼⡿⣣⠟⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⢠⡾⣆⠑⠋⠀⢀⣀⠀⠀⠀⠀⠈⠈⢁⣴⢫⡿⠁⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⣧⣄⡄⠴⣿⣶⣿⢀⣤⠶⣞⣋⣩⣵⠏⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢺⣿⢯⣭⣭⣯⣯⣥⡵⠿⠟⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀";

        System.out.println(cookie);

        // Preguntar por la cantidad de jugadores
        System.out.print("Introduce la cantidad de jugadores: ");
        int cantidadJugadores = scanner.nextInt();
        scanner.nextLine();

        // Preguntar los nombres de los jugadores
        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.print("Introduce el nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            Jugador jugador = new Jugador(nombre);
            jugadores.add(jugador);
        }

        Jugador.setJugadores(jugadores);

        // Iniciar los hilos de los jugadores
        for (Jugador jugador : jugadores) {
            jugador.start();
        }

        // Listado de jugadores que ya terminaron
        List<Jugador> jugadoresEliminados = new ArrayList<>();
        while (jugadores.size() > 1) {
            synchronized (jugadores) {
                Iterator<Jugador> iterator = jugadores.iterator();
                while (iterator.hasNext()) {
                    Jugador jugador = iterator.next();
                    if (jugador.isAlive()) {
                        continue;
                    } else {
                        jugadoresEliminados.add(jugador);
                        iterator.remove();
                        System.out.println(jugador.getNombre() + " ha terminado su turno.");
                    }
                }
            }

            // Hacer dormir el hilo principal para evitar CPU al máximo
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El juego ha terminado.");
    }
}