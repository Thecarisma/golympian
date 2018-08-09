package gig.library.golympian.misc;

/**
 * Created by thecarisma on 12/22/2017.
 */

public class Filter {

    /**
     * remove all instance of numbers from a string variable
     *
     * @param text the string to strip off numbers
     * @return the param text with no number
     */
    public static String removeNumbers(String text) {
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"} ;
        for (int i = 0 ; i < numbers.length; i++) {
            text = text.replace(numbers[i], "");
        }
        return text ;
    }
}
