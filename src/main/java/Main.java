import java.util.Arrays;

/**
 * Main.java
 */
public class Main {

    public static void main(String[] args) {

        NumberSequence oneToTwentySequence =
                new NumberSequence(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        Formatter numberSequenceFormatter = new Formatter(oneToTwentySequence);
        DivisibleByFormatRule fizzRule = new DivisibleByFormatRule(3, Format.FIZZ);
        DivisibleByFormatRule buzzRule = new DivisibleByFormatRule(5, Format.BUZZ);
        DivisibleByFormatRule fizzBuzzRule = new DivisibleByFormatRule(15, Format.FIZZBUZZ);
        ContainsStringFormatRule luckyRule = new ContainsStringFormatRule("3", Format.LUCKY);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(fizzRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(buzzRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(fizzBuzzRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(luckyRule);

        System.out.println(numberSequenceFormatter.getFormattedNumberSequence());

        System.out.println("fizz:" + fizzRule.getCount());
        System.out.println("buzz:" + buzzRule.getCount());
        System.out.println("fizzbuzz:" + fizzBuzzRule.getCount());
        System.out.println("lucky:" + luckyRule.getCount());

        int integerCount = oneToTwentySequence.getNumberSequence().size() -
                fizzRule.getCount() - buzzRule.getCount() -
                fizzBuzzRule.getCount() - luckyRule.getCount();

        System.out.println("integer:" + integerCount);


    }
}
