public abstract class Entity {
    private int id; // encapsulation: private field

    public Entity(int id) { // constructor
        this.id = id;
    }

    public int getId() { return id; }       // getter
    public void setId(int id) { this.id = id; } // setter


    public abstract String info();
}
