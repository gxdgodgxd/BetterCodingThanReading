package com.gxd.Concurrent.s9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gxdgodgxd on 18/1/26.
 */
public class SwingTest {
    // TODO: 18/1/26 swing多线程,子线程中计算耗时操作
    public static ExecutorService es = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createUI();
            }
        });
    }

    public static void createUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jFrame = new JFrame("my swing~");
        jFrame.setSize(600,200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);

        JLabel jLabel = new JLabel("init");
        jLabel.setBounds(0, 100, 600, 100);
        jPanel.add(jLabel);

        class MyTask extends BackgroundTask<String> {

            @Override
            public String compute() throws InterruptedException {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    sb.append(i);
                    Thread.sleep(1000);
                    jLabel.setText(String.valueOf(i));
                }
                return sb.toString();
            }

            @Override
            public void onCompletion(String s, boolean cancelled, Throwable throwable) {
                if (s != null) {
                    jLabel.setText(s);
                } else if (cancelled == true) {
                    jLabel.setText("cancelled");
                } else {
                    jLabel.setText("throwable : " + throwable.toString());
                }
            }

        };

        MyTask task = new MyTask();
        JButton start = new JButton("start");
        start.setBounds(0,0,100,100);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel.setText("computing");
                SwingTest.es.execute(task);
            }

        });
        jPanel.add(start);
        JButton cancel = new JButton("cancel");
        cancel.setBounds(200,0,100,100);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task.cancel(true);
            }
        });
        jPanel.add(cancel);

        jFrame.setVisible(true);
    }
}
