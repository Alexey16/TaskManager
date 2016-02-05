package com.company;

import java.io.IOException;
import java.util.List;

/**
 * Created by Алексей on 02.12.2015.
 */
public interface Journal {

    public void load() throws IOException;

    public void save() throws IOException;

    public void append(Task task) throws IOException;

    public void insert(Task task, int pos) throws IOException;

    public void insertAfter(Task task, int id) throws IOException;

    public boolean delete(int id) throws IOException;

    public List<Task> getTasksView();

}
