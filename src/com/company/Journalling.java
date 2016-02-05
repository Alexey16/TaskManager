package com.company;

import java.util.Date;

/**
 * Created by Алексей on 02.12.2015.
 */
public interface Journalling {

    void addTask(String description, Date date);

    boolean deleteTask(Task task);
}
