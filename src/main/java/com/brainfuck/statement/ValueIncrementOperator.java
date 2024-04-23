package com.brainfuck.statement;

import com.brainfuck.MachineContext;
import com.brainfuck.Register;

public class ValueIncrementOperator extends Operator {

    public ValueIncrementOperator(int nestDepth){
        super(nestDepth);
    }

    @Override
    public void execute(MachineContext context) {
        Register register = context.getRegister();
        register.store(context.getPointer(), (byte)(register.fetch(context.getPointer()) + 1));
        context.incrementProgramCount();
    }
    
}
