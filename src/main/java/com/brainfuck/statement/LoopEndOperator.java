package com.brainfuck.statement;

import java.util.List;

import com.brainfuck.MachineContext;

public class LoopEndOperator extends Operator{

    public LoopEndOperator(int nestDepth) {
        super(nestDepth);
    }

    @Override
    public void execute(MachineContext context) {
        List<Operator> program = context.getProgram();
        for(int i = context.getProgramCount() - 1;i >= 0;i--){
            Operator operator = program.get(i);
            if(operator instanceof LoopStartOperator){
                if(operator.getNestDepth() == this.nestDepth){
                    context.setProgramCount(i);
                    break;
                }
            }
        }
    }
    
}
