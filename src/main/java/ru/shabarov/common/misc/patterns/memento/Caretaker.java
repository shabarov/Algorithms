package ru.shabarov.common.misc.patterns.memento;

public class Caretaker {

    private Originator originator;

    private Originator.Memento memento;

    public Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void add(String token) {
        originator.add(token);
    }

    public void save() {
        memento = originator.save();
    }

    public void restore() {
        originator.undo(memento);
    }

    public String getText() {
        return originator.save().getState();
    }
}
