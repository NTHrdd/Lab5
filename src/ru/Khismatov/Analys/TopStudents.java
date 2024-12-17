package ru.Khismatov.Analys;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TopStudents {
    public static Map<Integer, List<Student>> scanStudents(String filePath) throws IOException {
        Map<Integer, List<Student>> schoolMap = new HashMap<>();
        Files.lines(Paths.get(filePath)).skip(1).forEach(line -> {
                    String[] input = line.split(" ");
                    schoolMap.putIfAbsent(Integer.parseInt(input[2]), new ArrayList<>());
                    schoolMap.get(Integer.parseInt(input[2])).add(new Student(input[0], input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3])));
                });
        return schoolMap;
    }

    public static List<Student> getStudentsOfNeededSchool(int school, Map<Integer, List<Student>> schoolMap) {
        List<Student> schoolStudents = schoolMap.getOrDefault(school, new ArrayList<>());
        schoolStudents.sort((s1, s2) -> Integer.compare(s2.score(), s1.score()));
        return schoolStudents;
    }

    public static void getBestScore(List<Student> students) {
        int maxScore = students.get(0).score();
        int countMaxScore = 0;
        for (Student s : students) {
            if (s.score() == maxScore) {countMaxScore++;}
            else {break;}
        }
        if (countMaxScore > 2) {
            System.out.println("Number of students who scored the best score : ");
            System.out.println(countMaxScore);
        } else if (countMaxScore == 1 && students.size() > 1) {
            System.out.println("Best score: ");
            System.out.println(students.get(0).surname() + " " + students.get(0).name());
        } else {
            System.out.println("Best score: ");
            System.out.println(students.get(0).surname() + " " + students.get(0).name());
            System.out.println(students.get(1).surname() + " " + students.get(1).name());
        }
    }
}

