package OldValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OldValue {

    private String pound; //240 pence
    private String shilling; //12 pence
    private String pence; //1 pence

    public OldValue(String pound, String shilling, String pence) {
        this.pound = pound;
        this.shilling = shilling;
        this.pence = pence;
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
        }
        else throw new IllegalArgumentException();
    }

    public OldValue convertPencesToString(int pences){
        int pounds = pences/240;
        int shillings = (pences - pounds*240)/12;
        int remainingPences = (pences - (pounds*240 + shillings*12));
        return new OldValue(pounds + "p",shillings + "s", remainingPences + "d");
    }

    public String getPound() {
        return pound;
    }

    public String getShilling() {
        return shilling;
    }

    public String getPence() {
        return pence;
    }

    @Override
    public String toString() {
        return '\n' + pound + '\t' + shilling + '\t' + pence;
    }
}
