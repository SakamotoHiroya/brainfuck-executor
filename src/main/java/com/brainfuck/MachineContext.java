package com.brainfuck;

import java.util.List;
import com.brainfuck.statement.Operator;

public class MachineContext {

    private Register register;
    private int pointer;
    private int programCount;
    private List<Operator> program;

    public Register getRegister(){
        return register;
    }

    public void setRegister(Register register){
        this.register = register;
    }

    public int getPointer(){
        return pointer;
    }

    public void setPointer(int pointer){
        this.pointer = pointer;
    }

    public int getProgramCount(){
        return programCount;
    }

    public void setProgramCount(int programCount){
        this.programCount = programCount;
    }

    public void incrementProgramCount(){
        programCount++;
    }

    public List<Operator> getProgram(){
        return program;
    }

    public void setProgram(List<Operator> program){
        this.program = program;
    }

}
