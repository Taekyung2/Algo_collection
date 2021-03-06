package ssafy_repeat;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {

    static class Student implements Comparable<Student> {
        int no, score;

        public Student(int no, int score) {
            super();
            this.no = no;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return this.no - o.no;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[] {
               new Student(1, 100),
               new Student(10, 50),
               new Student(5, 10)
        };


        // Comparable sorting
       Arrays.sort(students);
       for(Student student : students) {
            System.out.println(student);
       }


       // Comparator sorting
       Arrays.sort(students, new Comparator<Student>() {
           @Override
           public int compare(Student o1, Student o2) {
               return o2.score - o1.score;
           }
       });
       for(Student student : students) {
           System.out.println(student);
       }


       // lambda function sorting
       Arrays.sort(studetns, (o1, o2) -> o2.score - o1.score);
        for(Student student : students) {
            System.out.println(student);
        }
    }
}
