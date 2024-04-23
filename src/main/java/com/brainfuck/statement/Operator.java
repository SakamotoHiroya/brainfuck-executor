package com.brainfuck.statement;

import com.brainfuck.MachineContext;

public abstract class Operator {
    
    protected int nestDepth;

    public Operator(int nestDepth){
        this.nestDepth = nestDepth;
    }

    public abstract void execute(MachineContext context);
    
    public int getNestDepth(){
        return nestDepth;
    }

    public void setNestDepth(int nestDepth){
        this.nestDepth = nestDepth;
    }

}
