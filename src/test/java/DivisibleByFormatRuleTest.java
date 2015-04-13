import org.junit.Assert;
import org.junit.Test;

/**
 * FormatRuleTest.java
 */
public class DivisibleByFormatRuleTest {

    @Test
    public void testThatNumberDivisibleByThreeAreIdentifiedByRuleFormat() {
        //GIVEN
        DivisibleByFormatRule formatRule = new DivisibleByFormatRule(3, Format.FIZZ);

        //THEN
        boolean shouldFormatBeApplied = formatRule.shouldRuleBeAppliedToSequenceValue(6);

        //WHEN
        Assert.assertEquals(true, shouldFormatBeApplied);
    }

    @Test
    public void testThatNumberNotDivisibleByThreeIsNotIdentifiedByRuleFormat() {
        //GIVEN
        DivisibleByFormatRule formatRule = new DivisibleByFormatRule(3, Format.FIZZ);

        //THEN
        boolean shouldFormatBeApplied = formatRule.shouldRuleBeAppliedToSequenceValue(4);

        //WHEN
        Assert.assertEquals(false, shouldFormatBeApplied);
    }


    @Test
    public void testThatNumberDivisibleByFiveAreIdentifiedByRuleFormat() {
        //GIVEN
        DivisibleByFormatRule formatRule = new DivisibleByFormatRule(5, Format.BUZZ);

        //THEN
        boolean shouldFormatBeApplied = formatRule.shouldRuleBeAppliedToSequenceValue(10);

        //WHEN
        Assert.assertEquals(true, shouldFormatBeApplied);
    }

    @Test
    public void testThatNumberNotDivisibleByFiveIsNotIdentifiedByRuleFormat() {
        //GIVEN
        DivisibleByFormatRule formatRule = new DivisibleByFormatRule(5, Format.BUZZ);

        //THEN
        boolean shouldFormatBeApplied = formatRule.shouldRuleBeAppliedToSequenceValue(7);

        //WHEN
        Assert.assertEquals(false, shouldFormatBeApplied);
    }


    @Test
    public void testThatNumberDivisibleByFifteenAreIdentifiedByRuleFormat() {
        //GIVEN
        DivisibleByFormatRule formatRule = new DivisibleByFormatRule(15, Format.BUZZ);

        //THEN
        boolean shouldFormatBeApplied = formatRule.shouldRuleBeAppliedToSequenceValue(30);

        //WHEN
        Assert.assertEquals(true, shouldFormatBeApplied);
    }

    @Test
    public void testThatNumberNotDivisibleByFifteenIsNotIdentifiedByRuleFormat() {
        //GIVEN
        DivisibleByFormatRule formatRule = new DivisibleByFormatRule(15, Format.BUZZ);

        //THEN
        boolean shouldFormatBeApplied = formatRule.shouldRuleBeAppliedToSequenceValue(73);

        //WHEN
        Assert.assertEquals(false, shouldFormatBeApplied);
    }

}
