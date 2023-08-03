package OldValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OldValue {

    private String pound; //240 pence
    private String shilling; //12 pence
    private String pence; //1 pence

    private OldValue remainder;

    public OldValue(String pound, String shilling, String pence) {
        if (areParametersValid(pound, shilling, pence)) {
            this.pound = pound;
            this.shilling = shilling;
            this.pence = pence;
        } else throw new IllegalArgumentException();
    }

    private boolean areParametersValid(String pound, String shilling, String pence) {
        Matcher p = Pattern.compile("(\\d+[p])").matcher(pound);
        Matcher s = Pattern.compile("(\\d+[s])").matcher(shilling);
        Matcher d = Pattern.compile("(\\d+[d])").matcher(pence);
        if (p.matches() && s.matches() && d.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public int getValueInPence() {
        int penceValue = extractValueFromString(pence);
        int shillingValue = extractValueFromString(shilling);
        int poundValue = extractValueFromString(pound);
        return penceValue + shillingValue * 12 + poundValue * 240;
    }

    public int extractValueFromString(String value) {
        Pattern pattern = Pattern.compile("(\\d+)([psd]?)");
        Matcher valued = pattern.matcher(value);
        if (valued.matches()) {
            return Integer.parseInt(valued.group(1));
        } else throw new IllegalArgumentException();
    }

    public OldValue convertPencesToString(int pences) {
        int pounds = pences / 240;
        int shillings = (pences - pounds * 240) / 12;
        int remainingPences = (pences - (pounds * 240 + shillings * 12));
        return new OldValue(pounds + "p", shillings + "s", remainingPences + "d");
    }

    @Override
    public String toString() {
        String toString = pound + '\t' + shilling + '\t' + pence;
        if (remainder == null) {
            return toString;
        } else {
            return toString + "\t(" + remainder + ")";
        }
    }

    public OldValue getRemainder() {
        return remainder;
    }

    public void setRemainder(OldValue remainder) {
        this.remainder = remainder;
    }
}
