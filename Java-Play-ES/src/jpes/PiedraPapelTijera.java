package jpes;

import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {
	
	public void jugar() {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        int contadorUsuario1, contadorUsuario2, n1;
        String j1, j2, resultado;
        String continuar;

        System.out.println("Bienvenido al juego de Piedra, Papel o Tijera.");

        do {
            System.out.println("¿Cuántas personas van a jugar? (1/2)");
            int modo = teclado.nextInt();
            teclado.nextLine();

            if (modo == 1) {
                contadorUsuario1 = 0;
                contadorUsuario2 = 0;

                while (contadorUsuario1 < 3 && contadorUsuario2 < 3) {
                    System.out.println("Elige: piedra, papel o tijera");
                    j1 = teclado.nextLine();

                    if (j1.equals("piedra") || j1.equals("papel") || j1.equals("tijera")) {
                        n1 = random.nextInt(3);

                        if (n1 == 0) {
                            j2 = "piedra";
                        } else if (n1 == 1) {
                            j2 = "papel";
                        } else {
                            j2 = "tijera";
                        }

                        if (j1.equals(j2)) {
                            resultado = "Empate";
                        } else if ((j1.equals("piedra") && j2.equals("tijera")) ||
                                   (j1.equals("papel") && j2.equals("piedra")) ||
                                   (j1.equals("tijera") && j2.equals("papel")) ) {
                            resultado = "Ganaste";
                            contadorUsuario1++;
                        } else {
                            resultado = "Perdiste";
                            contadorUsuario2++;
                        }

                        System.out.println("Tu elección: " + j1);
                        System.out.println("CPU: " + j2);
                        System.out.println("Resultado: " + resultado);
                    } else {
                        System.out.println("Escribe correctamente la elección.");
                    }

                    System.out.println("J1: " + contadorUsuario1 + " - CPU: " + contadorUsuario2);
                }

                if (contadorUsuario1 == 3) {
                    System.out.println("¡Has ganado el juego!");
                } else {
                    System.out.println("La computadora ha ganado el juego.");
                }

            } else if (modo == 2) {
                contadorUsuario1 = 0;
                contadorUsuario2 = 0;

                while (contadorUsuario1 < 3 && contadorUsuario2 < 3) {
                    System.out.println("Jugador 1: piedra, papel o tijera");
                    j1 = teclado.nextLine();

                    if (j1.equals("piedra") || j1.equals("papel") || j1.equals("tijera")) {
                        // Oculta la elección del Jugador 1
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        System.out.println("Jugador 2: piedra, papel o tijera");
                        j2 = teclado.nextLine();

                        if (j2.equals("piedra") || j2.equals("papel") || j2.equals("tijera")) {
                            if (j1.equals(j2)) {
                                resultado = "Empate";
                            } else if ((j1.equals("piedra") && j2.equals("tijera")) ||
                                       (j1.equals("papel") && j2.equals("piedra")) ||
                                       (j1.equals("tijera") && j2.equals("papel"))) {
                                resultado = "Ganó Jugador 1";
                                contadorUsuario1++;
                            } else {
                                resultado = "Ganó Jugador 2";
                                contadorUsuario2++;
                            }

                            System.out.println("Jugador 1: " + j1);
                            System.out.println("Jugador 2: " + j2);
                            System.out.println("Resultado: " + resultado);
                        } else {
                            System.out.println("Jugador 2, escribe correctamente la elección.");
                        }
                    } else {
                        System.out.println("Jugador 1, escribe correctamente la elección.");
                    }

                    System.out.println("J1: " + contadorUsuario1 + " - J2: " + contadorUsuario2);
                }

                if (contadorUsuario1 == 3) {
                    System.out.println("¡Jugador 1 ha ganado el juego!");
                } else {
                    System.out.println("¡Jugador 2 ha ganado el juego!");
                }
            } else {
                System.out.println("Opción no válida. Por favor, elige 1 o 2.");
            }

            System.out.println("¿Quieres seguir jugando? (si/no)");
            continuar = teclado.nextLine();
        } while (continuar.equalsIgnoreCase("si"));

        teclado.close();
    }
}