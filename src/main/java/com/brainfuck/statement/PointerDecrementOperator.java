package com.brainfuck.statement;

import com.brainfuck.MachineContext;

public class PointerDecrementOperator extends Operator {

    public PointerDecrementOperator(int nestDepth){
        super(nestDepth);
    }

    @Override
    public void execute(MachineContext context){
        context.setPointer(context.getPointer() - 1);
        context.incrementProgramCount();
    }
    
}
