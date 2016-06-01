package uk.co.jamesmcguigan.rockpaperscissors.models;

public class Gesture {
    private String name;

    public Gesture() {
        this.name = "";
    }

    public Gesture(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object obj) {
        if(obj == null || obj.getClass() != Gesture.class) {
            return false;
        }
        if (Gesture.class.equals(obj.getClass())) {
            Gesture gesture = (Gesture) obj;
            return gesture.name.equals(name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
