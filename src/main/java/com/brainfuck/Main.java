package com.brainfuck;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.brainfuck.statement.Operator;

public class Main {
    public static void main(String[] args) throws IOException {

        //ファイル名を取得
        String fileName = null;
        if(args.length > 0){
            fileName = args[0].trim();
        }else{
            try(Scanner scanner = new Scanner(System.in)){
                System.out.print("file name > ");
                fileName = scanner.nextLine().trim();
            }
        }

        //コードをパース
        Parser parser = new Parser();
        List<Operator> program = parser.parse(new FileInputStream(new File(fileName)));

        //brainfuck仮想マシンの初期設定
        MachineContext context = new MachineContext();
        context.setProgram(program);
        context.setRegister(new Register());
        context.setProgramCount(0);
        context.setPointer(0);

        //実行
        while(context.getProgramCount() < context.getProgram().size()){
            Operator operator = context.getProgram().get(context.getProgramCount());
            operator.execute(context);
        }

    }
}