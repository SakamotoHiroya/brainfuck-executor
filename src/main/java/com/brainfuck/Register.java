package com.brainfuck;

import java.util.List;
import java.util.ArrayList;

public class Register {
    
    private List<Byte> data;

    public Register(){
        data = new ArrayList<>();
    }

    public byte fetch(int address){
        if(data.size() <= address){
            return (byte)0;
        }
        return data.get(address);
    }

    public void store(int address, byte value){
        while(data.size() <= address){
            data.add((byte)0);
        }
        data.set(address, value);
    }

}
