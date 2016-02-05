package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ������� on 03.12.2015.
 */
public class MainTaskEngine implements ActionListener {

    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static com.company.Timer timer = new com.company.Timer(false);
    MainTask maintask;
    Journal journal = new SimpleJournal("journal.txt");
    Controller jc = new Controller(journal,timer);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

    MainTaskEngine(MainTask maintask) throws IOException {
        this.maintask = maintask;
        this.journal = journal;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();
        Object src = e.getSource();

        if (src == maintask.buttonName) {
            JOptionPane.showMessageDialog(null, "Enter the name of your task");

        } else if (src == maintask.buttonDesc) {
            JOptionPane.showMessageDialog(null, "Enter the description of your task");
        } else if (src == maintask.buttonDate) {
            JOptionPane.showMessageDialog(null, "Enter the alarm time of your task");
        } else if (src == maintask.buttonAdd) {

            if (!"".equals(maintask.df1) || !"".equals(maintask.df2) || !"".equals(maintask.df3)) {
                String ndate = maintask.df3.getText();
                String ndesc = maintask.df2.getText();
                try {
                    jc.addTask(ndesc,dateFormat.parse(ndate));
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

                timer.addListen(new TimerListener() {
                    @Override
                    public void timesRun(Task task) {
                        toolkit.beep();
                        System.out.print(task.getDescriptionTask());
                        JOptionPane.showMessageDialog(null, task.getDescriptionTask());
                    }
                });

                System.out.println(ndate + ndesc);

            } else {
                JOptionPane.showMessageDialog(null, "The field is not filled!");
            }


        }
    }
}
