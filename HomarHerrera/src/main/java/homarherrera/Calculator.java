/**
 * Calculator package.
*/

package homarherrera;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Calculator {
    /**
     *This is a Javadoc.
     */
    private Calculator() { }
    /**
     *This is a Javadoc.
     */
    static final int INITIAL_VALUE = 1000;
    /**
     *This is a Javadoc.
     */
    static final int EXTRA_NEWYORK = 600;
    /**
     *This is a Javadoc.
     */
    static final int EXTRA_PARIS = 500;
    /**
     *This is a Javadoc.
     */
    static final int MAX_DAY_PROMO = 30;
    /**
     *This is a Javadoc.
     */
    static final int PROMO = 200;
    /**
     *This is a Javadoc.
     */
    static final int MIN_DISC_TRAVS = 4;
    /**
     *This is a Javadoc.
     */
    static final int LIMIT_DISC_TRAVS = 10;
    /**
     *This is a Javadoc.
     */
    static final double MIN_DISC = 0.9;
    /**
     *This is a Javadoc.
     */
    static final double MAX_DISC = 0.8;
    /**
     *This is a Javadoc.
     */
    static final int DAYS_PROMO = 7;
    /**
     * This is a Javadoc.
     */
    private static Scanner input;
    /**
     * This is a Javadoc.
     * @param args
     */
    public static void main(final String[] args) {
        try {
            System.out.println("Empezamos el programa");
            input = new Scanner(System.in);
            String destination = "";
            while (true) {
                System.out.print("Escogamos un destino: ");
                destination = input.nextLine();
                if (destination.length() > 2) {
                        break;
                }
                System.out.print("Ingrese un destino correcto: ");
            }
            int travelers = getTravelers();
            int days = getDays();
            double total = INITIAL_VALUE;
            if (destination.compareToIgnoreCase("Paris") == 0) {
                total += EXTRA_PARIS;
            } else if (destination.compareToIgnoreCase("New York") == 0) {
                total += EXTRA_NEWYORK;
            }
            if (travelers > MIN_DISC_TRAVS && travelers < LIMIT_DISC_TRAVS) {
                total = total * MIN_DISC;
            } else if (travelers >  LIMIT_DISC_TRAVS) {
                total = total * MAX_DISC;
            }
            if (days < DAYS_PROMO) {
                total += PROMO;
            }
            if (days > MAX_DAY_PROMO || travelers == 2) {
                total -= PROMO;
            }
            System.out.println("Valor total: ".concat(String.valueOf(total)));
         } catch (Exception e) {
             System.err.println("-1");
         }
    }
    private static int getTravelers() {
        int travelers = 0;
        while (true) {
            System.out.print("Ingrese el numero de viajeros: ");
            try {
                travelers = input.nextInt();
                final int minTravelers = 0;
                final int maxTravelers = 80;
                if (travelers > minTravelers && travelers <= maxTravelers) {
                    break;
                }
                System.err.println("Capacidad debe estar entre 1 y 80.");
            } catch (InputMismatchException ime) {
                input.nextLine();
                System.err.print("Solo puede ingresar valores numericos. ");
            }
        }
        return travelers;
    }
    private static int getDays() {
        int days = 0;
        while (true) {
            System.out.print("Ingrese el numero de dias: ");
            try {
                days = input.nextInt();
                break;
            } catch (InputMismatchException ime) {
                input.nextLine();
                System.err.println("Solo ingresar valores numericos.");
            }
        }
        return days;
    }
}
