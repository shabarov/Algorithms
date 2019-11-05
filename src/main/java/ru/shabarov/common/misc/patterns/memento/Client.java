package ru.shabarov.common.misc.patterns.memento;

public class Client {

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker(new Originator());
        caretaker.add("Hello");
        caretaker.add(", ");
        caretaker.save();

        caretaker.add("Emily");
        caretaker.restore();
        caretaker.add("Sue");

        System.out.println(caretaker.getText());
    }
}
