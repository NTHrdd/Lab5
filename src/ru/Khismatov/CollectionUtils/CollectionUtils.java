package ru.Khismatov.CollectionUtils;

import java.io.*;
import java.util.*;


public class CollectionUtils {
    public static <T> List<T> formList(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<T>();
        for (T t : list1) {
            if (!(list2.contains(t) || result.contains(t))) {result.add(t);}
        }
        return result;
    }

    public static int countCharNotInText(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            text.append(line);
        }
        reader.close();
        HashSet<Character> rusAlphabet = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ((c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я')) rusAlphabet.add(c);
        }
        int count = 0;
        for (char i = 'а'; i <= 'я'; i++) {
            if (!(rusAlphabet.contains(i) || rusAlphabet.contains(Character.toUpperCase(i)))) {count++;}
        }
        return count;
    }

    public static <T> boolean hasNextEqual(Queue<T> queue){
        if (queue.isEmpty()) return false;
        Iterator<T> iterator = queue.iterator();
        T firstElement = iterator.next();
        T previousElement = firstElement;
        while (iterator.hasNext()){
            T currentElement = iterator.next();
            if (previousElement.equals(currentElement)) return true;
            previousElement = currentElement;
        }
        return previousElement.equals(firstElement);
    }
}
