package com.company;

import java.util.Date;

/**
 * Created by Алексей on 01.12.2015.
 */
public interface Task {

    void setDateTask(Date date);

    void setDescriptionTask(String descriprion);

    Date getDateTask();

    String getDescriptionTask();

    int getId();

}
