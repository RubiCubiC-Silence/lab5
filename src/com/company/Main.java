package com.company;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;


/*public class Main {

    public static void main(String[] args) {

        int n=0;
        boolean flag = false;
        Scanner in = new Scanner(System.in);

        while (flag == false)
        {
            System.out.print("Введите длину массива: ");
            try
            {
                n = in.nextInt();
                if (n > 0)
                    flag = true;
            }
            catch (Exception e)
            {
                System.out.println("Некорректный ввод");
                in.next();
            }
        }
        flag = false;
        float[] mas = new float[n];
        while (flag == false)
        {
            System.out.print("Введите элементы массива: ");
            try
            {
                for (int i = 0; i < n;i++)
                {
                    mas[i] = in.nextFloat();
                }
                flag = true;
            }
            catch (Exception e)
            {
                System.out.println("Некорректный ввод");
                in.nextLine();
            }
        }

        float[] sqrtmas = qwerty.dec(mas);

        String command = "";

        while (command.equals("exit") == false)
        {
            System.out.println();
            System.out.print("Массив: ");
            for(int i = 0; i<mas.length;i++)
            {
                System.out.print(mas[i] + " ");
            }
            System.out.println();
            System.out.print("Массив блоков: ");
            for(int i = 0; i<sqrtmas.length;i++)
            {
                System.out.print(sqrtmas[i] + " ");
            }
            System.out.println();
            System.out.println("'sum x y' - сумма на интервале [x,y]\n" +
                    "'change x y' - изменение значения с индексом y на x\n" +
                    "'interval x y z' - новое значение z на интервале [x,y]\n" +
                    "'exit' - выход");
            command = in.next();
            if (command.equals("sum"))
            {
                int l,r;
                float sum;
                try
                {
                    l = in.nextInt() - 1;
                    r = in.nextInt() - 1;
                    if (l>r || l<0 || r<0 || l>n || r > n)
                        System.out.println("Введены некорректные параметры");
                    else
                    {
                        sum = qwerty.sum(l, r, mas, sqrtmas);
                        System.out.println("Сумма на интервале = " + sum);
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Введены некорректные параметры");
                    in.nextLine();
                }
            }
            else if (command.equals("change"))
            {
                int x,i;
                float sum;
                try
                {
                    x = in.nextInt();
                    i = in.nextInt() - 1;
                    if (i<0 || i>n)
                        System.out.println("Введены некорректные параметры");
                    else
                        qwerty.change(x, i, mas, sqrtmas);
                }
                catch (Exception e)
                {
                    System.out.println("Введены некорректные параметры");
                    in.nextLine();
                };
            }
            else if (command.equals("interval"))
            {
                int l,r,x;
                try
                {
                    l = in.nextInt() - 1;
                    r = in.nextInt() - 1;
                    x = in.nextInt();
                    if (l>r || l<0 || r<0 || l>n || r > n)
                        System.out.println("Введены некорректные параметры");
                    else
                        qwerty.changeInterval(l, r, x, mas, sqrtmas);
                }
                catch (Exception e)
                {
                    System.out.println("Введены некорректные параметры.");
                    in.nextLine();
                };
            }
            else if (command.equals("exit"))
                ;
            else System.out.println("Неизвестная команда");
        }
        in.close();
    }
}*/

public class Main {

    public static void main(String[] args) {

        int wWidth = 500, wHeight = 200;

        JFrame jframe = new JFrame() {};
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(wWidth, wHeight);
        jframe.setTitle("sqrt");

        JPanel label = new JPanel(new GridLayout(5,1,0,10));
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        label1.setText("input array");
        label2.setText("sum interval");
        label3.setText("change");
        label4.setText("change interval");
        label5.setText("result");
        label.add(label1);
        label.add(label2);
        label.add(label3);
        label.add(label4);
        label.add(label5);
        jframe.add(label, BorderLayout.WEST);

        JPanel button = new JPanel(new GridLayout(5,1,0,10));
        JButton but1 = new JButton("enter");
        JButton but2 = new JButton("sum");
        JButton but3 = new JButton("change");
        JButton but4 = new JButton("change");
        button.add(but1);
        button.add(but2);
        button.add(but3);
        button.add(but4);
        jframe.add(button, BorderLayout.EAST);

        JPanel input = new JPanel(new GridLayout(5,1,0,10));
        JTextField in1 = new JTextField();
        JTextField in2 = new JTextField();
        JTextField in3 = new JTextField();
        JTextField in4 = new JTextField();
        JTextField in5 = new JTextField();
        input.add(in1);
        input.add(in2);
        input.add(in3);
        input.add(in4);
        input.add(in5);
        in5.setEditable(false);
        jframe.add(input, BorderLayout.CENTER);
        input.revalidate();

        ArrayList<Float> mas = new ArrayList<Float>();
        ArrayList<Integer> gran = new ArrayList<Integer>();
        but1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String[] strMas = in1.getText().split("[ ]");
                    mas.clear();

                    float[] mas2 = new float[strMas.length];
                    for (int i = 0; i<strMas.length;i++)
                    {
                        mas.add(Float.parseFloat(strMas[i]));
                        mas2[i] = Float.parseFloat(strMas[i]);
                    }
                    in5.setText("array: [" + in1.getText() + "]");
                    qwerty.dec(mas2);
                }
                catch (Exception ee)
                {
                    JOptionPane.showMessageDialog(null, "error");
                    in5.setText("Error");
                }
            }
        });
        but2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String[] strMas = in2.getText().split("[ ]");
                    gran.clear();
                    for (int i = 0; i<strMas.length;i++)
                    {
                        gran.add(Integer.parseInt(strMas[i]));
                    }

                    float[] mas2 = new float[mas.size()];
                    for (int i = 0; i<mas.size();i++) {
                        mas2[i] = mas.get(i);
                    }

                    int l = gran.get(0), r = gran.get(1);
                    if ((gran.size()==2) && l<=r && l>0 && r - 1<= mas.size() && (mas.size()>0))
                    {
                        in5.setText(Float.toString(qwerty.sum(l-1, r-1, mas2)));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "error");
                        in5.setText("Error");
                    }
                }
                catch (Exception ee)
                {
                    JOptionPane.showMessageDialog(null, "error");
                    in5.setText("Error");
                }
            }
        });

        but3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String[] strMas = in3.getText().split("[ ]");
                    gran.clear();

                    for (int i = 0; i<strMas.length;i++)
                    {
                        gran.add(Integer.parseInt(strMas[i]));
                    }

                    float[] mas2 = new float[mas.size()];
                    for (int i = 0; i<mas.size();i++) {
                        mas2[i] = mas.get(i);
                    }


                    int i = gran.get(0);
                    float x = gran.get(1);
                    if ((gran.size()==2) && i>0 && i - 1< mas.size() && (mas.size()>0))
                    {
                        qwerty.change(x, i-1, mas2);

                        for (int j = 0; j<mas.size();j++) {
                            mas.set(j,mas2[j]);
                        }

                        in5.setText("" + mas);

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "error");
                        in5.setText("Error");
                    }
                }
                catch (Exception ee)
                {
                    JOptionPane.showMessageDialog(null, "error");
                    in5.setText("Error");
                }
            }
        });

        but4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String[] strMas = in4.getText().split("[ ]");
                    gran.clear();
                    for (int i = 0; i<strMas.length;i++)
                    {
                        gran.add(Integer.parseInt(strMas[i]));
                    }

                    float[] mas2 = new float[mas.size()];
                    for (int i = 0; i<mas.size();i++) {
                        mas2[i] = mas.get(i);
                    }

                    int l = gran.get(0), r = gran.get(1);
                    float x = gran.get(2);
                    if ((gran.size()==3) && l<=r && l>0 && r - 1< mas.size() && (mas.size()>0))
                    {
                        qwerty.changeInterval(l-1, r-1, x, mas2);
                        for (int j = 0; j<mas.size();j++) {
                            mas.set(j,mas2[j]);
                        }
                        in5.setText("" + mas);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "error");
                        in5.setText("Error");
                    }
                }
                catch (Exception ee)
                {
                    JOptionPane.showMessageDialog(null, "error");
                    in5.setText("Error");
                }
            }
        });

    }
}


