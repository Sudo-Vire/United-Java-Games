package jpes;

import java.util.Random;
import java.util.Scanner;

public class SieteYMedia {
	
	public void jugar() {
        Random random = new Random();
        Scanner Teclado = new Scanner(System.in);
        double p1 = 0, p2, p3 = 0;
        String cartas = "si";
        String dificultad = "";
        String palo = "";
        int j;

        System.out.println("Bienvenido al juego de las 7 y media. Presiona Enter para comenzar.");
        Teclado.nextLine();

        do {
            System.out.println("¿Cuántas personas van a jugar, 1 o 2?");
            j = Teclado.nextInt();
            if (j != 1 && j != 2) {
                System.out.println("Solo pueden jugar 1 o 2 personas.");
            }
        } while (j != 1 && j != 2);

        if (j == 1) {
            do {
                System.out.println("Selecciona una dificultad: facil, normal, dificil, imposible");
                dificultad = Teclado.next().toLowerCase();
                if (!dificultad.equals("facil") && !dificultad.equals("normal") && !dificultad.equals("dificil") && !dificultad.equals("imposible")) {
                    System.out.println("Escribe una dificultad válida.");
                }
            } while (!dificultad.equals("facil") && !dificultad.equals("normal") && !dificultad.equals("dificil") && !dificultad.equals("imposible"));
        }

        while (cartas.equals("si")) {
            p1 = 0;
            p3 = 0;

            System.out.println("Turno de Jugador 1 (J1):");
            do {
                int numeroCarta = random.nextInt(10) + 1;
                p2 = numeroCarta >= 8 ? 0.5 : numeroCarta;

                int numeroPalo = random.nextInt(3);
                palo = switch (numeroPalo) {
                    case 0 -> "oros";
                    case 1 -> "copas";
                    case 2 -> "espadas";
                    default -> "bastos";
                };

                p1 += p2;
                if (p2 == 0.5) {
                    String figura = switch (random.nextInt(3) + 8) {
                        case 8 -> "Sota";
                        case 9 -> "Caballo";
                        default -> "Rey";
                    };
                    System.out.println("Ha salido un " + figura + " de " + palo);
                } else {
                    System.out.println("Ha salido un " + (int) p2 + " de " + palo);
                }

                System.out.println("J1: Tu puntuación actual es: " + p1);

                if (p1 > 7.5) {
                    System.out.println("J1 se ha pasado de 7.5. Fin del juego.");
                    return;
                }

                System.out.println("¿Quieres otra carta, J1? (si/no)");
                cartas = Teclado.next().toLowerCase();

            } while (cartas.equals("si"));

            if (j == 1) {
                double limiteBanca = switch (dificultad) {
                    case "facil" -> 5;
                    case "normal" -> 6;
                    case "dificil" -> 7;
                    default -> 7.5;
                };

                while (p3 < limiteBanca) {
                    int numeroCarta = random.nextInt(10) + 1;
                    p3 += numeroCarta >= 8 ? 0.5 : numeroCarta;
                }

                System.out.println("La banca tiene una puntuación de: " + p3);
                if (p1 > p3 && p1 <= 7.5) {
                    System.out.println("¡Felicidades! Has ganado.");
                } else {
                    System.out.println("Lo siento, la banca ha ganado.");
                }
            } else {
                System.out.println("Turno de Jugador 2 (J2):");
                double p2Jugador = 0;
                do {
                    int numeroCarta = random.nextInt(10) + 1;
                    p2 = numeroCarta >= 8 ? 0.5 : numeroCarta;

                    int numeroPalo = random.nextInt(4);
                    palo = switch (numeroPalo) {
                        case 0 -> "oros";
                        case 1 -> "copas";
                        case 2 -> "espadas";
                        default -> "bastos";
                    };

                    p2Jugador += p2;
                    if (p2 == 0.5) {
                        String figura = switch (random.nextInt(3) + 8) {
                            case 8 -> "Sota";
                            case 9 -> "Caballo";
                            default -> "Rey";
                        };
                        System.out.println("Ha salido un " + figura + " de " + palo);
                    } else {
                        System.out.println("Ha salido un " + (int) p2 + " de " + palo);
                    }

                    System.out.println("J2: Tu puntuación actual es: " + p2Jugador);

                    if (p2Jugador > 7.5) {
                        System.out.println("J2 se ha pasado de 7.5. Fin del juego.");
                        return;
                    }

                    System.out.println("¿Quieres otra carta, J2? (si/no)");
                    cartas = Teclado.next().toLowerCase();
                } while (cartas.equals("si"));

                if (p1 > p2Jugador) {
                    System.out.println("¡Jugador 1 ha ganado!");
                } else if (p2Jugador > p1) {
                    System.out.println("¡Jugador 2 ha ganado!");
                } else {
                    System.out.println("Es un empate.");
                }
            }

            System.out.println("¿Quieres jugar otra partida? (si/no)");
            cartas = Teclado.next().toLowerCase();
            Teclado.close();
        }
    }
}