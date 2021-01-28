package com.pyy.dp.command;

/**
 * @author PeiYY
 * @date 2021/1/28 21:20
 */
public class CopyCommand extends Command {

    Content c;

    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + c.msg;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() / 2);
    }
}
