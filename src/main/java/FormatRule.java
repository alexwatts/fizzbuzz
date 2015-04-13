/**
 * FormatRule.java
 */
public abstract class FormatRule {

    public Format format;

    public FormatRule(Format format) {
        this.format = format;
    }

    protected abstract boolean shouldRuleBeAppliedToSequenceValue(Integer numberInSequence);

}
