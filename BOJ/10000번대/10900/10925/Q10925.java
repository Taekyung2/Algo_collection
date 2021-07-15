package boj;

import java.io.*;
import java.util.*;


public class Q10925 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        List<Student> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), stoi(st.nextToken()),
                    stoi(st.nextToken()), stoi(st.nextToken())));
        }

        list.stream()
                .sorted(Comparator.comparing(Student::getKo).reversed()
                        .thenComparing(Student::getEn)
                        .thenComparing(Comparator.comparing(Student::getMath).reversed())
                        .thenComparing(Student::getName))
                .map(Student::getName)
                .forEach(System.out::println);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Student {
        String name;
        int ko, en, math;

        Student(String name, int ko, int en, int math) {
            this.name = name;
            this.ko = ko;
            this.en = en;
            this.math = math;
        }

        public String getName() {
            return this.name;
        }

        public int getKo() {
            return this.ko;
        }

        public int getEn() {
            return this.en;
        }

        public int getMath() {
            return this.math;
        }
    }
}
