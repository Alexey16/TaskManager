package com.company;

/**
 * Created by ������� on 01.12.2015.
 */
public interface ListTimer {

    void addListen(TimerListener listener);

    void schedule(Task task);

    void removeTask(int id);
}
