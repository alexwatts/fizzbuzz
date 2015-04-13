import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *FormatterTest.java
 */
public class FormatterTest {

    private NumberSequence oneToTwentySequence =
            new NumberSequence(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

    @Test
    public void testThatBasicSequenceFormatCorrectlyFormats() {
        //GIVEN
        Formatter numberSequenceFormatter = new Formatter(oneToTwentySequence);

        //WHEN
        String formattedNumberSequence = numberSequenceFormatter.getFormattedNumberSequence();

        //THEN
        Assert.assertEquals(
                "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20",
                formattedNumberSequence);
    }

    @Test
    public void testThatSequenceWithFormatRulesFormatCorrectlyFormats() {

        //GIVEN
        Formatter numberSequenceFormatter = new Formatter(oneToTwentySequence);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(new DivisibleByFormatRule(3, Format.FIZZ));
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(new DivisibleByFormatRule(5, Format.BUZZ));
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(new DivisibleByFormatRule(15, Format.FIZZBUZZ));

        //WHEN
        String formattedNumberSequence = numberSequenceFormatter.getFormattedNumberSequence();

        //THEN
        Assert.assertEquals(
                "1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16, 17, fizz, 19, buzz",
                formattedNumberSequence);
    }

    @Test
    public void testThatSequenceWithAllFormatRulesFormatCorrectlyFormats() {

        //GIVEN
        Formatter numberSequenceFormatter = new Formatter(oneToTwentySequence);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(new DivisibleByFormatRule(3, Format.FIZZ));
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(new DivisibleByFormatRule(5, Format.BUZZ));
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(new DivisibleByFormatRule(15, Format.FIZZBUZZ));
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(new ContainsStringFormatRule("3", Format.LUCKY));

        //WHEN
        String formattedNumberSequence = numberSequenceFormatter.getFormattedNumberSequence();

        //THEN
        Assert.assertEquals(
                "1, 2, lucky, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, lucky, 14, fizzbuzz, 16, 17, fizz, 19, buzz",
                formattedNumberSequence);
    }

    @Test
    public void testThatSequenceWithAllFormatRulesCorrectlyCountsFuzz() {

        //GIVEN
        Formatter numberSequenceFormatter = new Formatter(oneToTwentySequence);
        DivisibleByFormatRule divisibleByThreeRule = new DivisibleByFormatRule(3, Format.FIZZ);
        DivisibleByFormatRule divisibleByFiveRule = new DivisibleByFormatRule(5, Format.BUZZ);
        DivisibleByFormatRule divisibleByFifteenRule = new DivisibleByFormatRule(15, Format.FIZZBUZZ);
        ContainsStringFormatRule containsThreeRule = new ContainsStringFormatRule("3", Format.LUCKY);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByThreeRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByFiveRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByFifteenRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(containsThreeRule);

        //WHEN
        numberSequenceFormatter.getFormattedNumberSequence();

        //THEN
        Assert.assertEquals(4, divisibleByThreeRule.getCount());

    }

    @Test
    public void testThatSequenceWithAllFormatRulesCorrectlyCountsBuzz() {

        //GIVEN
        Formatter numberSequenceFormatter = new Formatter(oneToTwentySequence);
        DivisibleByFormatRule divisibleByThreeRule = new DivisibleByFormatRule(3, Format.FIZZ);
        DivisibleByFormatRule divisibleByFiveRule = new DivisibleByFormatRule(5, Format.BUZZ);
        DivisibleByFormatRule divisibleByFifteenRule = new DivisibleByFormatRule(15, Format.FIZZBUZZ);
        ContainsStringFormatRule containsThreeRule = new ContainsStringFormatRule("3", Format.LUCKY);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByThreeRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByFiveRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByFifteenRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(containsThreeRule);

        //WHEN
        numberSequenceFormatter.getFormattedNumberSequence();

        //THEN
        Assert.assertEquals(3, divisibleByFiveRule.getCount());

    }

    @Test
    public void testThatSequenceWithAllFormatRulesCorrectlyCountsFizzBuzz() {

        //GIVEN
        Formatter numberSequenceFormatter = new Formatter(oneToTwentySequence);
        DivisibleByFormatRule divisibleByThreeRule = new DivisibleByFormatRule(3, Format.FIZZ);
        DivisibleByFormatRule divisibleByFiveRule = new DivisibleByFormatRule(5, Format.BUZZ);
        DivisibleByFormatRule divisibleByFifteenRule = new DivisibleByFormatRule(15, Format.FIZZBUZZ);
        ContainsStringFormatRule containsThreeRule = new ContainsStringFormatRule("3", Format.LUCKY);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByThreeRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByFiveRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByFifteenRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(containsThreeRule);

        //WHEN
        numberSequenceFormatter.getFormattedNumberSequence();

        //THEN
        Assert.assertEquals(1, divisibleByFifteenRule.getCount());

    }

    @Test
    public void testThatSequenceWithAllFormatRulesCorrectlyCountsLucky() {

        //GIVEN
        Formatter numberSequenceFormatter = new Formatter(oneToTwentySequence);
        DivisibleByFormatRule divisibleByThreeRule = new DivisibleByFormatRule(3, Format.FIZZ);
        DivisibleByFormatRule divisibleByFiveRule = new DivisibleByFormatRule(5, Format.BUZZ);
        DivisibleByFormatRule divisibleByFifteenRule = new DivisibleByFormatRule(15, Format.FIZZBUZZ);
        ContainsStringFormatRule containsThreeRule = new ContainsStringFormatRule("3", Format.LUCKY);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByThreeRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByFiveRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(divisibleByFifteenRule);
        numberSequenceFormatter.registerFormatRuleInOrderOfPrecedence(containsThreeRule);

        //WHEN
        numberSequenceFormatter.getFormattedNumberSequence();

        //THEN
        Assert.assertEquals(2, containsThreeRule.getCount());

    }

}
