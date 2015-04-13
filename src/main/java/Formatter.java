import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Formatter.java.
 */
public class Formatter {

    private NumberSequence numberSequence;

    private LinkedHashMap<Integer, String> formattedSequence =
            new LinkedHashMap<Integer, String>();

    private ArrayList<FormatRule> formatRules = new ArrayList<FormatRule>();

    public Formatter(NumberSequence numberSequence) {
        this.numberSequence = numberSequence;

        addKeysToFormattedSequenceMap();
    }

    public void registerFormatRule(FormatRule formatRule) {
        formatRules.add(formatRule);
    }

    public String getFormattedNumberSequence() {

        StringBuilder formattedOutput = new StringBuilder();

        for (Integer numberInSequence: numberSequence.getNumberSequence()) {
            addFormattedValueToMapIfApplicable(numberInSequence);
        }

        for (Integer numberInSequence: numberSequence.getNumberSequence()) {
            addOriginalValueToMapIfNoFormatApplicable(numberInSequence);
        }

        for (Integer numberInSequence: formattedSequence.keySet()) {
            formattedOutput.append(formattedSequence.get(numberInSequence));
            formattedOutput.append(", ");
        }

        //remove the final " ,"
        formattedOutput.setLength(formattedOutput.length() - 2);

        return formattedOutput.toString();

    }

    private void addKeysToFormattedSequenceMap() {
        for (Integer numberInSequence: numberSequence.getNumberSequence()) {
            formattedSequence.put(numberInSequence, null);
        }
    }

    private void addFormattedValueToMapIfApplicable(Integer i) {
        for (FormatRule rule :formatRules) {
            if (rule.shouldRuleBeAppliedToSequenceValue(i)) {
                formattedSequence.put(i, rule.format.name().toLowerCase());
            }
        }
    }

    private void addOriginalValueToMapIfNoFormatApplicable(Integer i) {
        if (formattedSequence.get(i) == null) {
            formattedSequence.put(i, i.toString());
        }
    }

}