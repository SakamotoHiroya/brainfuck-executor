package com.brainfuck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.brainfuck.statement.LoopEndOperator;
import com.brainfuck.statement.LoopStartOperator;
import com.brainfuck.statement.Operator;
import com.brainfuck.statement.OutputOperator;
import com.brainfuck.statement.PointerDecrementOperator;
import com.brainfuck.statement.PointerIncrementOperator;
import com.brainfuck.statement.ValueDecrementOperator;
import com.brainfuck.statement.ValueIncrementOperator;

import java.util.ArrayList;

public class Parser {
    
    public List<Operator> parse(InputStream is) throws IOException {
        List<Operator> result = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        
        int nestDepth = 0;
        int ch;
        while((ch = reader.read()) >= 0){
            switch((char)ch){
                case '>':
                    result.add(new PointerIncrementOperator(nestDepth));
                    break;
                case '<':
                    result.add(new PointerDecrementOperator(nestDepth));
                    break;
                case '+':
                    result.add(new ValueIncrementOperator(nestDepth));
                    break;
                case '-':
                    result.add(new ValueDecrementOperator(nestDepth));
                    break;
                case '[':
                    result.add(new LoopStartOperator(nestDepth));
                    nestDepth++;
                    break;
                case ']':
                    nestDepth--;
                    result.add(new LoopEndOperator(nestDepth));
                    break;
                case '.':
                    result.add(new OutputOperator(nestDepth));
                    break;
            }
        }

        return result;
    }

}
