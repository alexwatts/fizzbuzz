import org.junit.Assert;
import org.junit.Test;

/**
 * FormatRuleTest.java
 */
public class ContainsStringFormatRuleTest {

    @Test
    public void testThatSequenceValueContainingStringIsIdentifiedByRuleFormat() {
        //GIVEN
        ContainsStringFormatRule formatRule = new ContainsStringFormatRule("3", Format.LUCKY);

        //THEN
        boolean shouldFormatBeApplied = formatRule.shouldRuleBeAppliedToSequenceValue(13);

        //WHEN
        Assert.assertEquals(true, shouldFormatBeApplied);
    }

    @Test
    public void testThatSequenceValueWithoutStringIsNotIdentifiedByRuleFormat() {
        //GIVEN
        ContainsStringFormatRule formatRule = new ContainsStringFormatRule("3", Format.LUCKY);

        //THEN
        boolean shouldFormatBeApplied = formatRule.shouldRuleBeAppliedToSequenceValue(2);

        //WHEN
        Assert.assertEquals(false, shouldFormatBeApplied);
    }

}
