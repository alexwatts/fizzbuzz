/**
 * FormatRule.java
 */
public abstract class FormatRule {

    private Format format;

    public FormatRule(Format format) {
        this.format = format;
    }

    protected abstract boolean shouldRuleBeAppliedToSequenceValue(Integer numberInSequence);

    public String getFormattedValue(Integer numberInSequence) {
        return null;
    }

}
