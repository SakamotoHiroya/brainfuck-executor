package com.brainfuck.statement;

import java.util.List;

import com.brainfuck.MachineContext;

public class LoopStartOperator extends Operator {

    public LoopStartOperator(int nestDepth){
        super(nestDepth);
    }

    @Override
    public void execute(MachineContext context) {

        if(context.getRegister().fetch(context.getPointer()) == 0){
            List<Operator> program = context.getProgram();
            for(int i = context.getProgramCount() + 1;i < program.size();i++){
                Operator operator = program.get(i);
                if(operator instanceof LoopEndOperator){
                    if(operator.getNestDepth() == this.nestDepth){
                        context.setProgramCount(i + 1);
                        break;
                    }
                }
            }
        }else{
            context.incrementProgramCount();
        }

    }
    
}
