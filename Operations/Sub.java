package Operations;

import OldValue.OldValue;

public class Sub implements OperationStrategy{
    @Override
    public OldValue doOperation(OldValue x, OldValue y) {
        int subResult;
        subResult = x.getValueInPence() - y.getValueInPence();
        OldValue valueSubResult = convertPenceToOldValue(Math.abs(subResult));
        if (subResult < 0) {
            valueSubResult = convertPenceToOldValue(0);
            valueSubResult.setRemainder(convertPenceToOldValue(Math.abs(subResult)));
        }
        return valueSubResult;
    }

    @Override
    public OldValue convertPenceToOldValue(int pences) {
        int pounds = pences/240;
        int shillings = (pences - pounds*240)/12;
        int remainingPences = (pences - (pounds*240 + shillings*12));
        return new OldValue(pounds + "p",shillings + "s", remainingPences + "d");
    }
}
