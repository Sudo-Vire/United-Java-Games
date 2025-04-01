package jpes;

import java.util.Scanner;

public class Ahorcado {

    public void jugar() {
        Scanner teclado = new Scanner(System.in);
        char[] progreso;
        int intentosFallidos = 0;
        final int intentosMaximos = 6;
        int jugadorGanador = 0;

        System.out.println("¿Cuántos verdugos se postulan?");
        int numJugador = teclado.nextInt();
        teclado.nextLine();
        String palabraSecreta = obtenerPalabraSecreta(teclado);
        limpiarPantalla();
        progreso = inicializarProgreso(palabraSecreta);

        mostrarMensajeBienvenida(intentosMaximos);

        while (intentosFallidos < intentosMaximos) {
            for (int jugador = 2; jugador <= numJugador + 1; jugador++) {
                mostrarProgreso(progreso);
                mostrarAhorcado(intentosFallidos);

                char letra = solicitarLetra(teclado, jugador);
                int letraEncontrada = actualizarProgreso(progreso, palabraSecreta, letra);

                if (letraEncontrada == 0) {
                    intentosFallidos++;
                    mostrarIntentoFallido(intentosFallidos, intentosMaximos);
                } else {
                    mostrarLetraEncontrada(letra);
                    jugadorGanador = jugador;
                }

                if (palabraCompletada(progreso)) {
                    mostrarVictoria(palabraSecreta, jugadorGanador);
                    return;
                }
            }
        }

        mostrarDerrota(palabraSecreta);
    }


    private static String obtenerPalabraSecreta(Scanner teclado) {
        String palabraSecreta = null;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Jugador 1, introduce la palabra secreta: ");
            palabraSecreta = teclado.nextLine();

            if (palabraSecreta.matches("[a-zA-Z]+")) {
                entradaValida = true;
            } else {
                System.out.println("Por favor, introduce solo letras, sin números.");
            }
        }

        return palabraSecreta;
    }

    private static void limpiarPantalla() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private static char[] inicializarProgreso(String palabraSecreta) {
        char[] progreso = new char[palabraSecreta.length()];
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }
        return progreso;
    }

    private static void mostrarMensajeBienvenida(int intentosMaximos) {
        System.out.println("Bienvenido al ahorcado pequeño verdugo");
        System.out.println("Tienes un máximo de " + intentosMaximos + " intentos fallidos");
    }

    private static void mostrarProgreso(char[] progreso) {
        System.out.print("Palabra: ");
        for (char c : progreso) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static char solicitarLetra(Scanner teclado, int jugador) {
        char letra = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Jugador " + jugador + ", ingresa una letra: ");
            String entrada = teclado.next();

            if (entrada.length() == 1 && entrada.matches("[a-zA-Z]")) {
                letra = entrada.charAt(0);
                entradaValida = true;
            } else {
                System.out.println("Por favor, ingresa solo una letra, sin números.");
            }
        }
        return letra;
    }

    private static int actualizarProgreso(char[] progreso, String palabraSecreta, char letra) {
        int letraEncontrada = 0;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progreso[i] = letra;
                letraEncontrada = 1;
            }
        }
        return letraEncontrada;
    }

    private static void mostrarIntentoFallido(int intentosFallidos, int intentosMaximos) {
        System.out.println("Letra incorrecta. Intentos fallidos: " + intentosFallidos + "/" + intentosMaximos);
    }

    private static void mostrarLetraEncontrada(char letra) {
        System.out.println("La letra '" + letra + "' está en la palabra.");
    }

    private static void mostrarAhorcado(int intentosFallidos) {
        switch(intentosFallidos) {
            case 0:
                break;
            case 1:
                System.out.println(" O");
                break;
            case 2:
                System.out.println(" O");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 3:
                System.out.println(" O");
                System.out.println("/|");
                System.out.println(" |");
                break;
            case 4:
                System.out.println(" O");
                System.out.println("/|\\");
                System.out.println(" |");
                break;
            case 5:
                System.out.println(" O");
                System.out.println("/|\\");
                System.out.println(" |");
                System.out.println("/");
                break;
            case 6:
                System.out.println(" O");
                System.out.println("/|\\");
                System.out.println(" |");
                System.out.println("/ \\");
                break;
        }
    }

    private static boolean palabraCompletada(char[] progreso) {
        for (char c : progreso) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private static void mostrarVictoria(String palabraSecreta, int jugadorGanador) {
    	System.out.println("\n\n\n\n\n");
    	System.out.println("Muy mal jugador " + jugadorGanador + " has adivinado la palabra: " + palabraSecreta + ", ... muy mal, no sabes hacer tu trabajo");
        System.out.println("  ////");
        System.out.println(" (ºvº)");
        System.out.println("\\__|__/");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n\n\n");
    	System.out.println("Muy mal jugador " + jugadorGanador + " has adivinado la palabra: " + palabraSecreta + ", ... muy mal, no sabes hacer tu trabajo");
    	System.out.println("  ////");
        System.out.println("\\(ºvº)/");
        System.out.println(" \\_|_/");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }System.out.println("\n\n\n\n\n");
    	System.out.println("Muy mal jugador " + jugadorGanador + " has adivinado la palabra: " + palabraSecreta + ", ... muy mal, no sabes hacer tu trabajo");
        System.out.println("  ////");
        System.out.println(" (ºvº)");
        System.out.println("\\__|__/");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n\n\n");
    	System.out.println("Muy mal jugador " + jugadorGanador + " has adivinado la palabra: " + palabraSecreta + ", ... muy mal, no sabes hacer tu trabajo");
    	System.out.println("  ////");
        System.out.println("\\(ºvº)/");
        System.out.println(" \\_|_/");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }System.out.println("\n\n\n\n\n");
    	System.out.println("Muy mal jugador " + jugadorGanador + " has adivinado la palabra: " + palabraSecreta + ", ... muy mal, no sabes hacer tu trabajo");
        System.out.println("  ////");
        System.out.println(" (ºvº)");
        System.out.println("\\__|__/");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n\n\n");
    	System.out.println("Muy mal jugador " + jugadorGanador + " has adivinado la palabra: " + palabraSecreta + ", ... muy mal, no sabes hacer tu trabajo");
    	System.out.println("  ////");
        System.out.println("\\(ºvº)/");
        System.out.println(" \\_|_/");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }System.out.println("\n\n\n\n\n");
    	System.out.println("Muy mal jugador " + jugadorGanador + " has adivinado la palabra: " + palabraSecreta + ", ... muy mal, no sabes hacer tu trabajo");
        System.out.println("  ////");
        System.out.println(" (ºvº)");
        System.out.println("\\__|__/");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n\n\n");
    	System.out.println("Muy mal jugador " + jugadorGanador + " has adivinado la palabra: " + palabraSecreta + ", ... muy mal, no sabes hacer tu trabajo");
    	System.out.println("  ////");
        System.out.println("\\(ºvº)/");
        System.out.println(" \\_|_/");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
    }

    private static void mostrarDerrota(String palabraSecreta) {
    	
        System.out.println("\n\n\n\n\n");
    	System.out.println("Perfecto. La palabra correcta era: " + palabraSecreta + " ... has matado al hereje");
        System.out.println("  _ ");
        System.out.println("_|_|_              ////");
        System.out.println("(^3^)|⁻)          (ºnº)");
        System.out.println(" /|\\ ||            /|\\");
        System.out.println("/ | \\||           / | \\");
        System.out.println(" | \\               / \\");
        System.out.println("/   \\             /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n\n\n");
    	System.out.println("Perfecto. La palabra correcta era: " + palabraSecreta + "... has matado al hereje");
        System.out.println("   _ ");
        System.out.println(" _|_|_             ////");
        System.out.println(" (^3^)|⁻)         (ºnº)");
        System.out.println("  /|\\ ||           /|\\");
        System.out.println(" / | \\||          / | \\");
        System.out.println("  | \\              / \\");
        System.out.println(" /  |             /   \\");
    	try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("\n\n\n\n\n");
    	System.out.println("Perfecto. La palabra correcta era: " + palabraSecreta + "... has matado al hereje");
        System.out.println("    _ ");
        System.out.println("  _|_|_            ////");
        System.out.println("  (^3^)|⁻)        (ºnº)");
        System.out.println("   /|\\ ||          /|\\");
        System.out.println("  / | \\||         / | \\");
        System.out.println("    |\\             / \\");
        System.out.println("   / |            /   \\");
    	try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("\n\n\n\n\n");
    	System.out.println("Perfecto. La palabra correcta era: " + palabraSecreta + "... has matado al hereje");
        System.out.println("     _ ");
        System.out.println("   _|_|_           ////");
        System.out.println("   (^3^)|⁻)       (ºnº)");
        System.out.println("    /|\\ ||         /|\\");
        System.out.println("   / | \\||        / | \\");
        System.out.println("    | \\            / \\");
        System.out.println("   /  |           /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n\n\n");
    	System.out.println("Perfecto. La palabra correcta era: " + palabraSecreta + " ... has matado al hereje");
        System.out.println("      _ ");
        System.out.println("    _|_|_          ////");
        System.out.println("    (^3^)|⁻)      (ºnº)");
        System.out.println("     /|\\ ||        /|\\");
        System.out.println("    / | \\||       / | \\");
        System.out.println("     | \\           / \\");
        System.out.println("    /   \\         /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("\n\n\n\n\n");
    	System.out.println("Perfecto. La palabra correcta era: " + palabraSecreta + " ... has matado al hereje");
        System.out.println("       _ ");
        System.out.println("     _|_|_         ////");
        System.out.println("     (^3^)|⁻)     (ºnº)");
        System.out.println("      /|\\ ||       /|\\");
        System.out.println("     / | \\||      / | \\");
        System.out.println("      | \\          / \\");
        System.out.println("     /  |         /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("\n\n\n\n\n");
    	System.out.println("Perfecto. La palabra correcta era: " + palabraSecreta + "... has matado al hereje");
        System.out.println("        _ ");
        System.out.println("      _|_|_        ////");
        System.out.println("      (^3^)|⁻)    (ºnº)");
        System.out.println("       /|\\ ||      /|\\");
        System.out.println("      / | \\||     / | \\");
        System.out.println("        |\\         / \\");
        System.out.println("       / |        /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("\n\n\n\n\n");
    	System.out.println("Perfecto. La palabra correcta era: " + palabraSecreta + "... has matado al hereje");
        System.out.println("        _ ");
        System.out.println("      _|_|_        ////");
        System.out.println("      (^3^)  /--) (ºnº)");
        System.out.println("       /|\\  / /    /|\\");
        System.out.println("      / | \\/_/    / | \\");
        System.out.println("       / \\         / \\");
        System.out.println("      /   \\       /   \\");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n\n\n");
    	System.out.println("Perfecto. La palabra correcta era: " + palabraSecreta + "... has matado al hereje");
        System.out.println("  ____   ___  ____   __ __   ___");
        System.out.println(" |  _ \\ / _ \\|    \\ |  |  | /  /");
        System.out.println(" | |_) | / \\ |     \\|  |  |/  /");
        System.out.println(" |  _ <| | | |         |     /");
        System.out.println(" | |_) | \\_/ |   |\\    |  |\\  \\");
        System.out.println(" |____/ \\___/|___| \\___|__| \\__\\");
    }
}

