package ru.Khismatov.Cat;

public class MeowCounter implements Meowable {
    private int meowCount;
    private final Meowable cat;

    public MeowCounter(Meowable cat) {
        this.meowCount = 0;
        this.cat = cat;
    }

    public void meow() {
        meowCount++;
        cat.meow();
    }

    public int getMeowCount() {return meowCount;}
}
