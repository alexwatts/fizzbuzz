import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Formatter.java.
 */
public class Formatter {

    private NumberSequence numberSequence;

    private LinkedHashMap<Integer, FormatRule> formattedSequence =
            new LinkedHashMap<Integer, FormatRule>();

    private ArrayList<FormatRule> formatRules = new ArrayList<FormatRule>();

    public Formatter(NumberSequence numberSequence) {
        this.numberSequence = numberSequence;

        addKeysToFormattedSequenceMap();
    }

    public void registerFormatRuleInOrderOfPrecedence(FormatRule formatRule) {
        formatRules.add(formatRule);
    }

    public String getFormattedNumberSequence() {

        for (Integer numberInSequence: numberSequence.getNumberSequence()) {
            addApplicableFormatRulesToMap(numberInSequence);
        }

        return getFormattedSequenceOutput();

    }

    private void addKeysToFormattedSequenceMap() {
        for (Integer numberInSequence: numberSequence.getNumberSequence()) {
            formattedSequence.put(numberInSequence, null);
        }
    }

    private void addApplicableFormatRulesToMap(Integer i) {
        for (FormatRule rule :formatRules) {
            if (rule.shouldRuleBeAppliedToSequenceValue(i)) {
                formattedSequence.put(i, rule);
            }
        }
    }

    private String getFormattedSequenceOutput() {

        StringBuilder formattedOutput = new StringBuilder();

        for (Integer numberInSequence: formattedSequence.keySet()) {

            if (formattedSequence.get(numberInSequence) != null) {
                formattedOutput.append(formattedSequence.get(numberInSequence).format.name().toLowerCase());
            } else {
                formattedOutput.append(numberInSequence);
            }

            formattedOutput.append(", ");

        }

        //remove the final " ,"
        formattedOutput.setLength(formattedOutput.length() - 2);

        return formattedOutput.toString();
    }


}