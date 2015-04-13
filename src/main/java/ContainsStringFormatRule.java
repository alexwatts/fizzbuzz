import java.util.regex.Pattern;

/**
 * ContainsStringFormatRule.java
 */
public class ContainsStringFormatRule extends FormatRule {

    private String string;

    public ContainsStringFormatRule(String string, Format format) {
        super(format);
        this.string = string;
    }

    protected boolean shouldRuleBeAppliedToSequenceValue(Integer numberInSequence) {
        return numberInSequence.toString().contains(string);
    }

}
