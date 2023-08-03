package Operations;

import OldValue.OldValue;

public class Div implements OperationStrategy {

    @Override
    public OldValue doOperation(OldValue x, OldValue y) {
        int divResult;
        int divRemainder;
        divResult = x.getValueInPence() / y.getValueInPence();
        divRemainder = x.getValueInPence() % y.getValueInPence();
        OldValue oldValueResult = convertPenceToOldValue(divResult);
        oldValueResult.setRemainder(convertPenceToOldValue(divRemainder));
        return oldValueResult;
    }

    @Override
    public OldValue convertPenceToOldValue(int pences) {
        int pounds = pences / 240;
        int shillings = (pences - pounds * 240) / 12;
        int remainingPences = (pences - (pounds * 240 + shillings * 12));
        return new OldValue(pounds + "p", shillings + "s", remainingPences + "d");
    }
}
