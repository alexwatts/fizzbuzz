/**
 * DivisibleByThreeFormatRule.java
 */
public class DivisibleByFormatRule extends FormatRule {

    private Integer divisor;

    public DivisibleByFormatRule(Integer divisor, Format format) {
        super(format);
        this.divisor = divisor;
    }

    protected boolean shouldRuleBeAppliedToSequenceValue(Integer numberInSequence) {
        return numberInSequence % divisor == 0;
    }

}
