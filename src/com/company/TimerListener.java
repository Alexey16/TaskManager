package com.company;

import java.util.EventListener;

/**
 * Created by ������� on 01.12.2015.
 */
public interface TimerListener extends EventListener {
    void timesRun(Task task);
}
