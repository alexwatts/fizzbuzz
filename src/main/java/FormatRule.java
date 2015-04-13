/**
 * FormatRule.java
 */
public abstract class FormatRule {

    public Format format;

    private Integer countFired = 0;

    public FormatRule(Format format) {
        this.format = format;
    }

    protected abstract boolean shouldRuleBeAppliedToSequenceValue(Integer numberInSequence);

    protected void incrementCount() {
        countFired++;
    }

    protected Integer getCount() {
        return countFired;
    }

}
