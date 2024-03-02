public class Main {

    public static void main(String[] args) {
        System.out.println(determinaPariODispari(6.350));

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

}
