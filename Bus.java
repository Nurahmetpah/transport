import java.util.Objects;

public class Bus extends Entity { // inheritance
    private String model;
    private int capacity;
    //private String condition;

    public Bus(int id, String model, int capacity) {
        super(id);
        this.model = model;
        this.capacity = capacity;
        //this.condition = condition;
    }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }


    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public String info() {
        return "Bus: id=" + getId() + ", model=" + model + ", capacity=" + capacity;
    }

    @Override
    public String toString() { // required override
        return info();
    }

    @Override
    public boolean equals(Object o) { // required override
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        Bus bus = (Bus) o;
        return getId() == bus.getId(); // compare by id
    }

    @Override
    public int hashCode() { // required override
        return Objects.hash(getId());
    }
}

