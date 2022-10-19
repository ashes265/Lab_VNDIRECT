/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNDIRECT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 *
 * @author phung
 */
public class AwtExample1 extends Frame {

    public static List list;

    public AwtExample1() {
//        setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        final TextField text = new TextField();
//        add(text);
//        add(text,BorderLayout.CENTER);
        add(text, BorderLayout.PAGE_START);
        list = new List(4, true);
        IntStream.range(0, 10).forEach(i -> {
            list.add("Item " + i);
        });
        add(list, BorderLayout.CENTER);
        Button pushButton = new Button("press me");
//        add(pushButton,BorderLayout.LINE_END);
        add(pushButton, BorderLayout.PAGE_END);
//        pushButton.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(text.getText());
//                AwtExample1.this.setTitle(text.getText());
//            }
//            
//        });

//        pushButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String[]values=list.getSelectedItems();
//                StringBuilder builder=new StringBuilder();
//                Arrays.stream(values).forEach(value->{
//                    if(builder.length()>0){
//                        builder.append("; ");
//                    }
//                    builder.append(value);
//                });
//                text.setText(builder.toString());
//            }
//
//        });
        pushButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Supplier<StringBuilder> supplier = StringBuilder::new;
                BiConsumer<StringBuilder, String> consumer = (builder, value) -> {
                    if (builder.length() > 0) {
                        builder.append(", ");
                    }
                    builder.append(value);
                };
                BinaryOperator<StringBuilder> operator = StringBuilder::append;
                Function<StringBuilder, String> finisher = StringBuilder::toString;
                String[] values = list.getSelectedItems();
                //cach1
//                Collector<String, StringBuilder, String> collector = Collector.of(supplier, consumer, operator, finisher);
//                text.setText(Arrays.stream(values).collect(collector));

                //cach2
                Arrays.stream(values).collect(Collectors.joining(","));
                text.setText(Arrays.stream(values).collect(Collectors.joining(",")));
            }
        });
        //test by me
//        Button pushButton2 = new Button("For Test");
//        add(pushButton2,BorderLayout.PAGE_START);
//        pushButton2.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("OK");
//            }
//        });
        //page11
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);
        Menu menu = new Menu("File");
        menuBar.add(menu);
        MenuItem menuItem = new MenuItem("Exit", new MenuShortcut('X'));
        menu.add(menuItem);
        menuItem.addActionListener(e -> {
            System.exit(1);
        });
    }


    public static void main(String[] args) {
        AwtExample1 screen = new AwtExample1();
//        screen = new AwtExample1();
        screen.setSize(500, 500);
        screen.setVisible(true);

//        screen.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(1);
//            }
//        });
        screen.addWindowListener((WindowClosing) w -> System.exit(1));
    }
}
