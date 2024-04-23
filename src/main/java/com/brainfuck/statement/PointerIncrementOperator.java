package com.brainfuck.statement;

import com.brainfuck.MachineContext;

public class PointerIncrementOperator extends Operator{
    
    public PointerIncrementOperator(int nestDepth){
        super(nestDepth);
    }

    @Override
    public void execute(MachineContext context){
        context.setPointer(context.getPointer() + 1);
        context.incrementProgramCount();
    }

}
