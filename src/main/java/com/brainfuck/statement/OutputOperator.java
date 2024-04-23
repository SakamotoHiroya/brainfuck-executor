package com.brainfuck.statement;

import com.brainfuck.MachineContext;

public class OutputOperator extends Operator {

    public OutputOperator(int nestDepth) {
        super(nestDepth);
    }

    @Override
    public void execute(MachineContext context) {
        System.out.print((char)(context.getRegister().fetch(context.getPointer())));
        context.incrementProgramCount();
    }

}
