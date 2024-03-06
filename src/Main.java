import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        double[] ultimoRisultato = {0, 0};
        int selezioneMenu;
        String avvisoNumeriDecimali = "Ricorda: per scrivere un numero decimale, utilizza la virgola e non il punto.";

        while (true) {
            String[] operazioni = {"1) SOMMA (+)",
                    "2) SOTTRAZIONE (-)",
                    "3) MOLTIPLICAZIONE (*)",
                    "4) DIVISIONE (/)",
                    "5) POTENZA (^)",
                    "6) PARI O DISPARI (%)",
                    "0) ESCI (termina il programma)",
                    "Oppure inserisci qualsiasi altro valore per resettare la calcolatrice."};

            System.out.println("\nSeleziona l'operazione che vuoi eseguire scrivendo il rispettivo numero e premendo INVIO.\n" +
                    "Se il risultato è diverso da 0, verrà salvato per essere utilizzato nell'operazione successiva.");

            for (String operazione : operazioni) {
                System.out.println(operazione);
            }

            if (ultimoRisultato[0] != 0) {
                System.out.println("Stai utilizzando l'ultimo risultato salvato: " + ultimoRisultato[0]);
            }

            selezioneMenu = (int) richiediInput();

            double[] inputOperazioni = {0, 0};

            switch (selezioneMenu) {
                case 0:
                    System.out.println("Termino il programma.");
                    return;

                case 1:
                    System.out.println("SOMMA\n" + avvisoNumeriDecimali);

                    if (ultimoRisultato[0] == 0) {
                        System.out.print("Inserisci il primo addendo: ");
                        inputOperazioni[0] = richiediInput();
                    } else {
                        System.out.println("Stai utilizzando l'ultimo risultato salvato: " + ultimoRisultato[0]);
                        inputOperazioni[0] = ultimoRisultato[0];
                    }

                    System.out.print("Inserisci il secondo addendo: ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = somma(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(inputOperazioni[0] + " + " + inputOperazioni[1] + " = " + ultimoRisultato[0]);
                    break;

                case 2:
                    System.out.println("SOTTRAZIONE\n" + avvisoNumeriDecimali);

                    if (ultimoRisultato[0] == 0) {
                        System.out.print("Inserisci il minuendo: ");
                        inputOperazioni[0] = richiediInput();
                    } else {
                        System.out.println("Stai utilizzando l'ultimo risultato salvato: " + ultimoRisultato[0]);
                        inputOperazioni[0] = ultimoRisultato[0];
                    }

                    System.out.print("Inserisci il sottraendo: ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = sottrazione(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(inputOperazioni[0] + " - " + inputOperazioni[1] + " = " + ultimoRisultato[0]);
                    break;

                case 3:
                    System.out.println("MOLTIPLICAZIONE\n" + avvisoNumeriDecimali);

                    if (ultimoRisultato[0] == 0) {
                        System.out.print("Inserisci il primo fattore: ");
                        inputOperazioni[0] = richiediInput();
                    } else {
                        System.out.println("Stai utilizzando l'ultimo risultato salvato: " + ultimoRisultato[0]);
                        inputOperazioni[0] = ultimoRisultato[0];
                    }

                    System.out.print("Inserisci il secondo fattore: ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = moltiplicazione(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(inputOperazioni[0] + " * " + inputOperazioni[1] + " = " + ultimoRisultato[0]);
                    break;

                case 4:
                    System.out.println("DIVISIONE\n" + avvisoNumeriDecimali);

                    if (ultimoRisultato[0] == 0) {
                        System.out.print("Inserisci il dividendo: ");
                        inputOperazioni[0] = richiediInput();
                    }  else {
                        System.out.println("Stai utilizzando l'ultimo risultato salvato: " + ultimoRisultato[0]);
                        inputOperazioni[0] = ultimoRisultato[0];
                    }

                    System.out.print("Inserisci il divisore: ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = divisione(inputOperazioni[0], inputOperazioni[1])[0];
                    System.out.println(inputOperazioni[0] + " / " + inputOperazioni[1] + " = " + ultimoRisultato[0] + " con resto " + ultimoRisultato[1]);
                    break;

                case 5:
                    System.out.println("POTENZA\n" + avvisoNumeriDecimali);

                    if (ultimoRisultato[0] == 0) {
                        System.out.print("Inserisci la base: ");
                        inputOperazioni[0] = richiediInput();
                    } else {
                        System.out.println("Stai utilizzando l'ultimo risultato salvato: " + ultimoRisultato[0]);
                        inputOperazioni[0] = ultimoRisultato[0];
                    }

                    System.out.print("Inserisci l'esponente (deve essere un intero, altrimenti verrà arrotondato per difetto): ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = potenza(inputOperazioni[0], (int) inputOperazioni[1]);
                    System.out.println(inputOperazioni[0] + " ^ " + (int) inputOperazioni[1] + " = " + ultimoRisultato[0]);
                    break;

                case 6:
                    System.out.println("PARI O DISPARI\n" + avvisoNumeriDecimali);

                    if (ultimoRisultato[0] == 0) {
                        System.out.print("Inserisci un numero intero (un numero con la virgola verrà arrotondato per difetto): ");
                        inputOperazioni[0] = richiediInput();
                    } else {
                        System.out.println("Stai utilizzando l'ultimo risultato salvato: " + ultimoRisultato[0]);
                        inputOperazioni[0] = ultimoRisultato[0];
                    }

                    System.out.println(determinaPariODispari((int) inputOperazioni[0]));
                    break;

                default:
                    System.out.println("Reset");
                    main(args);
                    break;
            }
        }
    }

    public static double[] divisione (double num1, double num2) {
        // Divide due numeri dati come input e restituisce il quoziente e il resto.
        // In caso di divisione per 0, avvisa l'utente e restituisce sia quoziente che resto uguali a 0.

        double[] result = new double[2];
        if (num2 != 0) {
            result[0] = num1 / num2;
            result[1] = num1 % num2;
        } else {
            System.out.println("Impossibile dividere per 0.");
        }
        return result;
    }

    public static String determinaPariODispari (int num1) {
        // Se il numero è intero, lo divide per due e stabilisce se questo è pari o dispari in base al resto.

        if (num1 % 2 == 0) {
            return "Pari";
        } else {
            return "Dispari";
        }
    }

    public static double sottrazione (double num1, double num2) {
        return num1 - num2;
    }

    public static double somma (double num1, double num2) {
        return num1 + num2;
    }

    public static double moltiplicazione (double num1, double num2) {
        return num1 * num2;
    }

    public static double potenza (double base, int esponente) {
        if (base == 0) {
            if (esponente == 0) {
                System.out.println("Impossibile elevare 0 a se stesso.");
            }
            return 0;
        } else {
            if (esponente == 0) {
                return 1;
            } else {
                if (base == 1) {
                    return 1;
                } else {
                    double risultato = base;

                    if (esponente > 0) {
                        for (int i = 1; i < esponente; i++) {
                            risultato *= base;
                        }

                        return risultato;
                    } else {
                        for (int i = -1; i > esponente; i--) {
                            risultato *= base;
                        }

                        return 1 / risultato;
                    }
                }
            }
        }
    }

    public static double richiediInput () {
        // A causa della localizzazione (non so se di IntelliJ o del sistema operativo
        // vengono considerati come valori corretti solo i numeri scritti utilizzando la virgola (esempio: 2,13)
        // mentre sono errati quelli con il punto (esempio: 2.13)
        double input = -1;
        boolean correctInput = false;

        while (!correctInput) {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextDouble();
                correctInput = true;
            } catch (Exception e) {
                System.out.println("Valore non valido, riprova.");
            }
        }

        return input;
    }
}