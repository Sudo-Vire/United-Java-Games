package jpes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("A qué juego quieres jugar?");
            System.out.println("1) Blackjack");
            System.out.println("2) Ahorcado");
            System.out.println("3) Piedra papel tijera");
            System.out.println("4) Siete y media");
            System.out.println("5) Numero secreto");
            System.out.println("6) Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = teclado.nextInt();
            switch (opcion) {
            	case 1:
            		Blackjack bl = new Blackjack();
            		bl.jugar();
            		break;
            	case 2:
                    Ahorcado ah = new Ahorcado();
                    ah.jugar();
                    break;
                case 3:
                    PiedraPapelTijera ppt = new PiedraPapelTijera();
                    ppt.jugar();
                    break;
                case 4:
                    SieteYMedia sm = new SieteYMedia();
                    sm.jugar();
                    break;
                case 5:
                    NumeroSecreto ns = new NumeroSecreto();
                    ns.jugar();
                    break;
                case 6:
                    salir = true;
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no válida, inténtalo de nuevo.");
            }
        }

        teclado.close();
    }
}
