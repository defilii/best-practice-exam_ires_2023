package Operations;

import OldValue.OldValue;

public interface OperationStrategy {
    OldValue doOperation(OldValue x, OldValue y);
    OldValue convertPenceToOldValue(int pences);
}
