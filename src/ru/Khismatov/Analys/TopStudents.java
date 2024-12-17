package ru.Khismatov.Analys;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TopStudents {
    public static TreeMap<Integer, List<Student>> scanStudents(String filePath, int neededSchool) throws IOException {
        TreeMap<Integer, List<Student>> schoolMap = new TreeMap<>();
        Files.lines(Paths.get(filePath)).skip(1).forEach(line -> {
                    String[] input = line.split(" ");
                    if (Integer.parseInt(input[2]) == neededSchool) {
                        schoolMap.putIfAbsent(Integer.parseInt(input[3]), new ArrayList<>());
                        schoolMap.get(Integer.parseInt(input[3])).add(new Student(input[0], input[1]));
                    }
                });
        return schoolMap;
    }


    public static void getBestScore(TreeMap<Integer, List<Student>> students) {
        int maxScore = students.lastKey();
        List<Student> topStudents = students.get(maxScore);
        if (topStudents.size() > 2) {
            System.out.println("Number of students who scored the best score:");
            System.out.println(topStudents.size());
        } else if (topStudents.size() == 1 && students.size() > 1) {
            System.out.println("Best score:");
            Student student = topStudents.get(0);
            System.out.println(student.surname() + " " + student.name());
        } else {
            System.out.println("Best score:");
            for (Student student : topStudents) {
                System.out.println(student.surname() + " " + student.name());
            }
        }
    }
}

