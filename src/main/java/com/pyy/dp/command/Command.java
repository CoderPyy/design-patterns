package com.pyy.dp.command;

/**
 * @author PeiYY
 * @date 2021/1/28 21:02
 */
public abstract class Command {
    public abstract void doit();
    public abstract void undo();
}
