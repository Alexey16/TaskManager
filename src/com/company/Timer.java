package com.company;

import java.util.*;

/**
 * Created by ������� on 01.12.2015.
 */
public class Timer implements ListTimer {
    private class ScheduleTask extends TimerTask{

        private Task task;

        @Override
        public void run() {
            for(TimerListener listener : listeners) {
                listener.timesRun(task);
            }
        }
        ScheduleTask(Task task){
            super();
            this.task = task;
        }
    }
    private java.util.Timer timer;
    private HashMap<Integer, TimerTask> timerTasks = new HashMap<Integer, TimerTask>();
    private List<TimerListener> listeners = new LinkedList<TimerListener>();

    @Override
    public void addListen(TimerListener listener) {
        listeners.add(listener);
    }

    @Override
    public void schedule(Task task) {
        TimerTask timerTask = new ScheduleTask(task);
        timerTasks.put(task.getId(), timerTask);
        timer.schedule(timerTask, task.getDateTask());
    }

    @Override
    public void removeTask(int id) {
        TimerTask removeTask = timerTasks.remove(id);
        if(removeTask == null) {
            throw new NoSuchElementException();
        }
        removeTask.cancel();
    }

    Timer(boolean isDaemon) {
        timer = new java.util.Timer(isDaemon);
    }
}
