public class Bus {
    private int id;
    private String model;
    private int capacity;

    public Bus(int id, String model, int capacity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
    }

    public String info() {
        return "Bus: id=" + id + ", model=" + model + ", capacity=" + capacity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}

