package com.company;

import java.util.Date;

/**
 * Created by Алексей on 01.12.2015.
 */
public class SimpleTask implements Task {


    private int id;
    private String description;
    private Date date;


    public SimpleTask(int id, String description, Date date) {

        this.id = id;
        this.description = description;
        this.date = date;
    }

    public SimpleTask(Task task) {

        this.id = task.getId();
        this.description = task.getDescriptionTask();
        this.date = task.getDateTask();

    }

    @Override
    public void setDateTask(Date date) {
        this.date = date;
    }

    @Override
    public void setDescriptionTask(String descriprion) {
        this.description = descriprion;
    }

    @Override
    public Date getDateTask() {
        return (Date) date.clone();
    }

    @Override
    public String getDescriptionTask() {
        return description;
    }

    @Override
    public int getId() {
        return id;
    }
}
