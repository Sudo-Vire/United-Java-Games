package jpes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    private ArrayList<Integer> cartasUsadas = new ArrayList<>();

    public void jugar() {
        Random random = new Random();
        Scanner teclado = new Scanner(System.in); 
        int puntuacionJugador = 0, puntuacionBanca = 0;
        String continuar = "si";
        
        System.out.println("Bienvenido al Blackjack clásico contra la banca.");

        do {
            puntuacionJugador = 0;
            puntuacionBanca = 0;
            continuar = "si";
            cartasUsadas.clear(); 

            System.out.println("Turno del Jugador:");
            while (continuar.equals("si")) {
                puntuacionJugador += darCarta(random, teclado, "jugador");
                System.out.println("Tu puntuación actual es: " + puntuacionJugador);

                if (puntuacionJugador > 21) {
                    System.out.println("¡Te has pasado! La banca gana.");
                    break;
                }

                System.out.println("¿Quieres otra carta? (si/no)");
                continuar = teclado.next().toLowerCase();
                while (!continuar.equals("si") && !continuar.equals("no")) {
                    System.out.println("Por favor, responde con 'si' o 'no'.");
                    continuar = teclado.next().toLowerCase();
                }
            }

            if (puntuacionJugador <= 21) {
                System.out.println("Turno de la banca:");
                while (puntuacionBanca < 18) {
                    puntuacionBanca += darCarta(random, null, "banca");
                }

                System.out.println("La banca tiene una puntuación de: " + puntuacionBanca);

                if (puntuacionBanca > 21 || puntuacionJugador > puntuacionBanca) {
                    System.out.println("¡Felicidades! Has ganado.");
                } else if (puntuacionJugador == puntuacionBanca) {
                    System.out.println("Es un empate.");
                } else {
                    System.out.println("Lo siento, la banca ha ganado.");
                }
            }

            System.out.println("¿Quieres jugar otra partida? (si/no)");
            continuar = teclado.next().toLowerCase();
            while (!continuar.equals("si") && !continuar.equals("no")) {
                System.out.println("Por favor, responde con 'si' o 'no'.");
                continuar = teclado.next().toLowerCase();
            }
        } while (continuar.equals("si"));

        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
    }

    private int darCarta(Random random, Scanner teclado, String jugador) {
        int numeroCarta = random.nextInt(13) + 1;
        int valorCarta = 0;
        int puntuacionBanca = 0;
        String palo = switch (random.nextInt(4)) {
            case 0 -> "Treboles";
            case 1 -> "Diamantes";
            case 2 -> "Corazones";
            default -> "Picas";
        };

        while (cartasUsadas.contains(numeroCarta)) {
            numeroCarta = random.nextInt(13) + 1;
        }

        cartasUsadas.add(numeroCarta); 

        if (numeroCarta >= 11 || numeroCarta == 1) {
            String figura = switch (numeroCarta) {
                case 1 -> "As";
                case 11 -> "Jack";
                case 12 -> "Reina";
                default -> "Rey";
            };

            System.out.println("Ha salido un " + figura + " de " + palo);
            if (numeroCarta == 1 && jugador.equals("jugador")) {
                System.out.println("¿Cuánto quieres que valga el As? (1/11)");
                valorCarta = teclado.nextInt();
                while (valorCarta != 1 && valorCarta != 11) {
                    System.out.println("Por favor, elige 1 o 11.");
                    valorCarta = teclado.nextInt();
                }
            } else {
                if (numeroCarta == 1) {

                    if (jugador.equals("banca")) {
						valorCarta = (puntuacionBanca >= 18 && puntuacionBanca <= 21) ? 11 : 1;
                    } else {
                        valorCarta = 11; 
                    }
                } else {
                    valorCarta = 10; 
                }
            }
        } else {
            System.out.println("Ha salido un " + numeroCarta + " de " + palo);
            valorCarta = numeroCarta;
        }

        return valorCarta;
    }
}


