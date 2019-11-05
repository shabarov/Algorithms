package ru.shabarov.common.misc.patterns.memento;

public class Originator {

    private StringBuilder text;
    private StringBuilder securedText;

    public Originator() {
        this.text = new StringBuilder();
        this.securedText = new StringBuilder();
    }

    public void add(String token) {
        this.text.append(token);
        this.securedText.append(token.toLowerCase());
    }

    public Memento save() {
        return new Memento(this.securedText.toString(), this.text.toString());
    }

    public void undo(Memento memento) {
        this.text = new StringBuilder(memento.getState());
        this.securedText = new StringBuilder(memento.getSecuredState());
    }


    static class Memento {
        private String securedState;
        private String state;

        private Memento(String securedState, String state) {
            this.securedState = securedState;
            this.state = state;
        }

        private String getSecuredState() {
            return securedState;
        }

        String getState() {
            return state;
        }
    }

}
