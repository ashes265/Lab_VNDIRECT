/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author phung
 */
public class FunctionTest {

    public static void main(String[] args) {
//        List<Student> stus = new ArrayList<>();
//        Consumer<Student> c1 = (Student stu) -> {
//            if (stu.getAge() > 23) {
//                stu.setAge(23);
//                stus.add(stu);
//            }
//        };
//        c.accept(new Student(1, 26, "Nguyen B"));
//        System.out.println(stus.get(0));


        String []names={"Tran Van A","Nguyen Thi B","Nguyen Thi C","Ta Van C"};
        int ages[]={23,45,12,67};
        int ids[]={1,2,3,4};
        IntStream intStream=IntStream.range(0, names.length-1);
        Stream stream=intStream.mapToObj(value->new Student(ids[value], ages[value], names[value]));
        Consumer<Student> c=(Student student)->{
            System.out.println(student);
        };
//        stream.forEach(c);
        Function<Student,String>jsonToFunction=(Student student)->{
            StringBuilder builder=new StringBuilder();
            builder.append("student{\n");
            builder.append("\tid:").append(student.getId()).append("\n");
            builder.append("\tname:").append(student.getId()).append("\n");
            builder.append("\tage:").append(student.getAge()).append("\n");
            builder.append("}");
            return builder.toString();
        };
        c=(Student student)->{
            System.out.println((jsonToFunction.apply(student)));
        };
//        stream.forEach(c);
        Predicate<Student> predicate=(Student student)->{return student.getAge()>30;};
        Stream<Student> older=stream.filter(predicate);
        older.forEach(c);
    }
}
