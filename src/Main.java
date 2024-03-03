import java.io.Console;
import java.util.Scanner;
import static java.lang.Double.NaN;
import static java.lang.Double.valueOf;

public class Main {
    public static void main(String[] args) {
        double ultimoRisultato = 0;
        int selezioneMenu = -1;

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

            selezioneMenu = richiediInput();

            double[] inputOperazioni = {0, 0};

            switch (selezioneMenu) {
                case 0:
                    System.out.println("Termino il programma.");
                    System.exit(0);

                case 1:
                    System.out.println("SOMMA\nInserisci il primo addendo:");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci il secondo addendo:\n" + inputOperazioni[0] + " + ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato = somma(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(" = " + ultimoRisultato);
                    break;

                case 2:
                    System.out.println("SOTTRAZIONE\nInserisci il minuendo:");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci il sottraendo:\n" + inputOperazioni[0] + " - ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato = sottrazione(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(" = " + ultimoRisultato);
                    break;

                case 3:
                    System.out.println("MOLTIPLICAZIONE\nInserisci il primo fattore:");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci il secondo fattore:\n" + inputOperazioni[0] + " * ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato = moltiplicazione(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(" = " + ultimoRisultato);
                    break;

                case 4:
                    System.out.println("DIVISIONE\nInserisci il primo dividendo:");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci il divisore:\n" + inputOperazioni[0] + " / ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato = divisione(inputOperazioni[0], inputOperazioni[1])[0];
                    System.out.println(" = " + ultimoRisultato + " con resto di " + divisione(inputOperazioni[0], inputOperazioni[1])[1]);
                    break;

                case 5:
                    System.out.println("POTENZA\nInserisci la base:");
                    inputOperazioni[0] = richiediInput();
                    System.out.print("Inserisci l'esponente:\n" + inputOperazioni[0] + " ^ ");
                    inputOperazioni[1] = richiediInput();
                    ultimoRisultato = potenza(inputOperazioni[0], inputOperazioni[1]);
                    System.out.println(" = " + ultimoRisultato);
                    break;

                case 6:
                    System.out.println("PARI O DISPARI\nInserisci un numero:");
                    inputOperazioni[0] = richiediInput();
                    System.out.println(determinaPariODispari(inputOperazioni[0]));
                    break;

                default:
                    System.out.println("RESET");
                    main(args);
                    break;
            }
        }
    }

    /*divide due numeri dati come input e restituisce il quoziente e il resto.
      In caso il secondo numero inserito sia zero, restituisce NaN.
     */
    public static double[] divisione(double num1, double num2) {
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

        //se il numero è intero, determina se è pari o dispari con l'operazione del resto diviso 2
        if (num1 == (int) num1) {
            if (num1 % 2 == 0) {
                return "Pari";
            } else {
                return "Dispari";
            }

        } else {

            if (Character.getNumericValue((Double.toString(num1)).charAt(Double.toString(num1).length() - 1)) % 2 == 0) {
                return "Pari";
            } else {
                return "Dispari";
            }
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