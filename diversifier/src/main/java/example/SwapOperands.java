package example;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtLocalVariableReference;

public class SwapOperands extends AbstractProcessor<CtElement> {
    @Override
    public boolean isToBeProcessed(CtElement candidate) {
        return true;
    }

    @Override
    public void process(CtElement candidate) {
        if ((candidate instanceof CtBinaryOperator<?>)) {
            System.out.println("Processing: " + candidate.prettyprint());
            CtExpression<?> left = ((CtBinaryOperator)candidate).getLeftHandOperand();
            CtExpression<?> right = ((CtBinaryOperator)candidate).getRightHandOperand();
            ((CtBinaryOperator)candidate).setLeftHandOperand(right);
            ((CtBinaryOperator)candidate).setRightHandOperand(left);
            System.out.println("Processing: " + candidate.prettyprint());
        }
//        CtBinaryOperator op = (CtBinaryOperator)candidate;
//        op.setKind(BinaryOperatorKind.GT);
    }
}
