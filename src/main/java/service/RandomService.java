package service;

import java.util.Random;

public class RandomService {

    private static Random r;

    static{
        r = new Random();
    }

    /**
     * Metoda generująca przypadkową liczbę z określonego przedziału
     * @param from - jest dolną granicą przedziału
     * @param to - jest górną granicą przedziału
     * @return - zwraca int
     */
    public static int generateIntBetween(int from, int to) throws WrongRangeException{
        if(from < to){
            // Math.abs daje nam wartość bezwzględną
            return from + Math.abs(r.nextInt()) % (to + 1 - from);
        }else{
            throw new WrongRangeException(
                    "Bottom value of given range needs to be lower that the top value of given range. Your range is: " + "from " + from + " to: " + to);
        }
    }
}
