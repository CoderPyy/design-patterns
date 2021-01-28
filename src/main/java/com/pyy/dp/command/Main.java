package com.pyy.dp.command;

import java.util.ArrayList;

/**
 * Command命令模式
 * @author PeiYY
 * @date 2021/1/28 20:13
 */
public class Main {
    public static void main(String[] args) {
        Content content = new Content();

        InsertCommand insertCommand = new InsertCommand(content);
        insertCommand.doit();
        insertCommand.undo();

        CopyCommand copyCommand = new CopyCommand(content);
        copyCommand.doit();
        copyCommand.undo();

        DeleteCommand deleteCommand = new DeleteCommand(content);
        deleteCommand.doit();
        deleteCommand.undo();

        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new InsertCommand(content));
        commands.add(new CopyCommand(content));

        for (Command command:commands){
            command.doit();
        }

        System.out.println(content.msg);

        for(int i=commands.size()-1;i>=0;i--){
            commands.get(i).undo();
        }

        System.out.println(content.msg);

    }
}
