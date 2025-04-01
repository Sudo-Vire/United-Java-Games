package jpes;

import java.util.Scanner;

public class NumeroSecreto {
	
	public void jugar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Jugador 1, introduce un número del 1 al 100: ");
        int J1 = scanner.nextInt();

        while (J1 < 1 || J1 > 100) {
            System.out.print("Número inválido. Por favor, introduce un número del 1 al 100: ");
            J1 = scanner.nextInt();
        }

        for (int i=1; i<100; i++) {
        	System.out.println(" ");
        }
        
        System.out.println("Jugador 1 ha elegido un número. ¡Jugador 2, trata de adivinarlo!");

        int intentosMaximos = 10;

        for (int i = 1; i <= intentosMaximos; i++) {
            System.out.print("Intento " + i + ": Introduce tu número: ");
            int J2 = scanner.nextInt();

            if (J2 < 1 || J2 > 100) {
                System.out.println("Número inválido. Debe estar entre 1 y 100.");
                i--;
                continue;
            }

            if (J2 == J1) {
                System.out.println("¡Felicidades! Has adivinado el número secreto: " + J1);
                break;
            } else if (J2 < J1) {
                System.out.println("El número secreto es mayor.");
            } else {
                System.out.println("El número secreto es menor.");
            }

            if (i == intentosMaximos) {
                System.out.println("Lo siento, has perdido. El número secreto era: " + J1);
            }
        }

        scanner.close();
    }
}

