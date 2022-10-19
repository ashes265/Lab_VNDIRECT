package intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {

    public static List<Student> filter(List<Student> students, Filter<Student> pred) {
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (pred.valie(student)) {
                list.add(student);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, 23, "Tran Van A"));
        students.add(new Student(2, 34, "Nguyen Thi B"));
        students.add(new Student(3, 15, "Nguyen Thi C"));
        students.add(new Student(4, 46, "Ta Van C"));
        //use stream
        Stream<Student> stream = students.stream().filter(stu -> stu.getAge() >= 30);
        stream.forEach(stu -> {
            System.out.println(stu);
        });

        Stream<Student> stream2 = students.stream().sorted((stu1, stu2) -> stu1.getAge() - stu2.getAge());
//        Stream<Student> stream2 = students.stream().sorted((Student t1, Student t2) -> t1.getAge() - t2.getAge());

        //user collections
//        Collections.sort(students, (Student t1, Student t2)->{return t1.getAge()-t2.getAge();});
//        students.forEach(stu->{
//            System.out.println(stu);
//        });
//        Filter<Student> older = student -> student.getAge() >= 30;
//        List<Student> filtered = filter(students, older);
        //cach1
//        for(Student stu:filtered){
//            System.out.println(stu);
//        }
        //cach2
//        filtered.forEach(stu -> {
//            System.out.println(stu);
//        });
        //Do TEST
        Comparator<Student> compare = (Student t1, Student t2) -> t1.getAge() - t2.getAge();
        Stream<Student> streamTest = students.stream().sorted(compare);
        System.out.println("Max is "+students.stream().max(compare));
        int sum=students.stream().mapToInt(Student::getAge).sum();
        System.out.println("Average of age is : "+sum/students.size());
        students.parallelStream().forEach((it)->System.out.println(Thread.currentThread().getName()+" hello "+it.getName()));
    }
}
