import static java.lang.Double.NaN;

public class Main {

    public static void main(String[] args) {
        System.out.println("Calculator");
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

}
