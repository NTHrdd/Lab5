package ru.Khismatov.Cat;

public class CatFactory {
    public static Meowable createCat(String catName) {
        return new MeowCounter(new Cat(catName));
    }
}
