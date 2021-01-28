package com.pyy.dp.command;

/**
 * @author PeiYY
 * @date 2021/1/28 21:22
 */
public class DeleteCommand extends Command{

    Content c;

    String deleted;

    public DeleteCommand(Content c){
        this.c=c;
    }

    @Override
    public void doit() {
        deleted=c.msg.substring(0,5);
        c.msg=c.msg.substring(5,c.msg.length());
    }

    @Override
    public void undo() {
        c.msg = deleted + c.msg;
    }
}
