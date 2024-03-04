import java.util.Scanner;
import static java.lang.Double.NaN;

public class Main {
    public static void main(String[] args) {
        double[] ultimoRisultato = {0, 0};
        int selezioneMenu;

        while (true) {
            String[] operazioni = {"1) SOMMA (+)",
                    "2) SOTTRAZIONE (-)",
                    "3) MOLTIPLICAZIONE (*)",
                    "4) DIVISIONE (/)",
                    "5) POTENZA (^)",
                    "6) PARI O DISPARI (%)",
                    "0) ESCI (termina il programma)"};

            System.out.println("Seleziona l'operazione che vuoi eseguire scrivendo il rispettivo numero e premendo INVIO.");
            for (String operazione : operazioni) {
                System.out.println(operazione);
            }

            selezioneMenu = (int) richiediInput();

            double[] inputOperazioni = {0, 0};

            switch (selezioneMenu) {
                case 0:
                    System.out.println("Termino il programma.");
                    System.exit(0);

                case 1:
                    System.out.print("SOMMA\nInserisci il primo addendo: ");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci il secondo addendo: ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = somma(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(inputOperazioni[0] + " + " + inputOperazioni[1] + " = " + ultimoRisultato[0]);
                    break;

                case 2:
                    System.out.print("SOTTRAZIONE\nInserisci il minuendo: ");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci il sottraendo: ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = sottrazione(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(inputOperazioni[0] + " - " + inputOperazioni[1] + " = " + ultimoRisultato[0]);
                    break;

                case 3:
                    System.out.print("MOLTIPLICAZIONE\nInserisci il primo fattore: ");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci il secondo fattore: ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = moltiplicazione(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(inputOperazioni[0] + " * " + inputOperazioni[1] + " = " + ultimoRisultato[0]);
                    break;

                case 4:
                    System.out.print("DIVISIONE\nInserisci il dividendo: ");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci il divisore: ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = divisione(inputOperazioni[0], inputOperazioni[1])[0];
                    System.out.println(inputOperazioni[0] + " / " + inputOperazioni[1] + " = " + ultimoRisultato[0] + " con resto " + ultimoRisultato[1]);
                    break;

                case 5:
                    System.out.print("POTENZA\nInserisci la base: ");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci l'esponente: ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato[0] = potenza(inputOperazioni[0], (int) inputOperazioni[1]);
                    System.out.println(inputOperazioni[0] + " ^ " + inputOperazioni[1] + " = " + ultimoRisultato[0]);
                    break;

                case 6:
                    System.out.print("PARI O DISPARI\nInserisci un numero: ");
                    inputOperazioni[0] = richiediInput();
                    System.out.println(determinaPariODispari(inputOperazioni[0]));
                    break;

                default:
                    System.out.println("Valore non valido, riprova.");
                    main(args);
                    break;
            }
        }
    }

    public static double[] divisione(double num1, double num2) {
        /*
        divide due numeri dati come input e restituisce il quoziente e il resto.
        In caso il secondo numero inserito sia zero, restituisce NaN.
        */
        double[] result = new double[2];
        if (num2 != 0) {
            result[0] = num1 / num2;
            result[1] = num1 % num2;
        } else {
            result[0] = NaN;
            result[1] = NaN;
        }
        return result;
    }

    //Per poter determinare se anche un numero decimale è pari o dispari, la funzione converte il parametro
    // che passo alla funzione in stringa, dopodichè la funzione prende l'ultimo carattere di
    //questa stringa che verrà riconvertito in numero.
    public static String determinaPariODispari(double num1) {
        if (Character.getNumericValue((Double.toString(num1)).charAt(Double.toString(num1).length() - 1)) % 2 == 0) {
            return "Pari";
        } else {
            return "Dispari";
        }
    }

    public static double sottrazione(double num1, double num2) {
        return num1 - num2;
    }

    public static double somma(double num1, double num2) {
        return num1 + num2;
    }

    public static double moltiplicazione(double num1, double num2) {
        return num1 * num2;
    }

    public static double potenza (double base, int esponente) {
        if (base == 0) {
            if (esponente == 0) {
                System.out.println("0 elevato a 0 non avrebbe senso, ma restituisco 0.");
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
        // vengono considerati valori corretti i numeri scritti utilizzando la virgola (esempio: 2,13)
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