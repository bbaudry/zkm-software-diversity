package example;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLiteral;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtLocalVariableReference;
import spoon.support.reflect.code.CtInvocationImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;

public class MutateHu extends AbstractProcessor<CtElement> {
    Random rand;

    @Override
    public boolean isToBeProcessed(CtElement candidate) {
        return true;
    }

    @Override
    public void process(CtElement candidate) {
        if ((candidate instanceof CtInvocationImpl<?>)) {
            if(((CtInvocationImpl)candidate).getExecutable().getSimpleName().equals("fill")){
                System.out.println(((CtInvocationImpl)candidate).getArguments().get(0));
                rand = new Random();
                int newHu = rand.nextInt(360);
                CtExpression<Integer> un = (CtExpression)((CtInvocationImpl)candidate).getArguments().get(1);
                CtExpression<Integer> deux = (CtExpression)((CtInvocationImpl)candidate).getArguments().get(2);
                
                ArrayList args = new ArrayList<CtLiteral>();
                System.out.println(((CtInvocationImpl)candidate));
                args.add(((CtInvocationImpl)candidate).getFactory().createLiteral(new Integer(newHu)));
                args.add( un);
                args.add( deux);
                ((CtInvocationImpl)candidate).setArguments(args);   
            }
        }
//        CtBinaryOperator op = (CtBinaryOperator)candidate;
//        op.setKind(BinaryOperatorKind.GT);
    }
}
