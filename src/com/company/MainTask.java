package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Алексей on 03.12.2015.
 */
public class MainTask {

    JButton buttonName = new JButton("Name of the Task");
    JButton buttonDesc = new JButton("Task description");
    JButton buttonDate = new JButton("Date of notification");
    JButton buttonAdd = new JButton("Addition");
    JPanel windowContent = new JPanel();
    JTextField df1 = new JTextField();
    JTextField df2 = new JTextField();
    JTextField df3 = new JTextField();

    public MainTask() throws IOException {

        BorderLayout b1 = new BorderLayout();
        windowContent.setLayout(b1);

        JPanel p1 = new JPanel();
        GridLayout g1 = new GridLayout(3,2);

        p1.setLayout(g1);
        p1.add(buttonName);
        p1.add(df1);
        p1.add(buttonDesc);
        p1.add(df2);
        p1.add(buttonDate);
        p1.add(df3);

        windowContent.add("Center", p1);

        JPanel p2 = new JPanel();
        GridLayout g2 = new GridLayout(1,1);

        p2.setLayout(g2);
        p2.add(buttonAdd);

        windowContent.add("South", p2);

        JFrame frame = new JFrame("Task Manager");
        frame.setContentPane(windowContent);

        frame.pack();  //размер окна для размещения всех компонент
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        MainTaskEngine taskEngine = new MainTaskEngine(this);

        buttonName.addActionListener(taskEngine);
        buttonDesc.addActionListener(taskEngine);
        buttonDate.addActionListener(taskEngine);
        buttonAdd.addActionListener(taskEngine);

    }
}
