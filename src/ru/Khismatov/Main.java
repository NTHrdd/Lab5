package ru.Khismatov;

import ru.Khismatov.Cat.*;
import ru.Khismatov.Math.Fraction.FractionInterface;
import ru.Khismatov.Math.Geometry.Point;
import ru.Khismatov.Math.Geometry.Polyline;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

import static ru.Khismatov.Analys.TopStudents.*;
import static ru.Khismatov.Cat.CatFactory.createCat;
import static ru.Khismatov.CollectionUtils.CollectionUtils.*;
import static ru.Khismatov.Math.Fraction.FractionFactory.createFraction;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n;
        do{
            System.out.println("Enter number of task: ");
            n = scan.nextInt();
            switch(n){
                case 1:
                    System.out.println("Enter fraction in style(a b): ");
                    FractionInterface fraction = createFraction(scan.nextInt(), scan.nextInt());
                    System.out.println("Value of Fraction: " + fraction.getValue());
                    System.out.println("Enter new values of numerator and denominator: ");
                    fraction.setNumerator(scan.nextInt());
                    fraction.setDenominator(scan.nextInt());
                    System.out.println("Value of Fraction: " + fraction + " and " + fraction.getValue());
                    System.out.println("Value of Fraction: " + fraction + " and " + fraction.getValue());
                    break;
                case 2:
                    Meowable cat = createCat("Барсик");
                    cat.meow();
                    cat.meow();
                    cat.meow();
                    cat.meow();
                    System.out.println("Cat meows " + ((MeowCounter)cat).getMeowCount() + " times");
                    break;
                case 3:
                    scan.nextLine();
                    System.out.println("Enter 2 arrays: ");
                    List<Integer> l1 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).toList();
                    List<Integer> l2 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).toList();
                    System.out.println("List which contain elements of first array and doesnt contain elements of second array: " + formList(l1, l2));
                    break;
                case 4:
                    System.out.println("Enter path of file and number of school: ");
                    getBestScore(scanStudents("src/ru/Khismatov/task4.txt", scan.nextInt()));
                    break;
                case 5:
                    System.out.println("Enter path of file: ");
                    scan.nextLine();
                    System.out.println("Number russian letters which not found on text file: " + countCharNotInText("src/ru/Khismatov/task5.txt"));
                    break;
                case 6:
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(1);
                    queue.add(2);
                    queue.add(3);
                    queue.add(1);
                    System.out.println("The queue has 2 equal numbers in the neighborhood: " + hasNextEqual(queue));
                    break;
                case 7:
                    Polyline polyline = new Polyline(
                            Stream.of(
                                        new Point(1, -2),
                                        new Point(3, 4),
                                        new Point(1, 2),
                                        new Point(5, -6),
                                        new Point(3, 4),
                                        new Point(0, -3),
                                        new Point(5, 6))
                                    .map(p -> new Point(p.x(), Math.abs(p.y())))
                                    .distinct()
                                    .sorted(Comparator.comparingDouble(Point::x))
                                    .collect(Collectors.toList())
                    );
                    System.out.println(polyline);
                    break;
                case 8:
                    String filePath = "src/ru/Khismatov/task8.txt";
                    Map<Integer, List<String>> groupedPeople = Files.lines(Paths.get(filePath))
                            .map(line -> line.split(":"))
                            .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                            .collect(Collectors.groupingBy(
                                    parts -> Integer.parseInt(parts[1]),
                                    HashMap::new,
                                    Collectors.mapping(
                                            parts -> parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase(),
                                            Collectors.toList()
                                    )
                            ));
                    System.out.println(groupedPeople);
                    break;
            }
        } while (n != 9);
        scan.close();
    }
}