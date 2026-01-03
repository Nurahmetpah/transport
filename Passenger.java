import java.util.Objects;

public class Passenger extends Entity { // inheritance
    private String name;
    private int age;

    public Passenger(int id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String info() {
        return "Passenger: id=" + getId() + ", name=" + name + ", age=" + age;
    }

    @Override
    public String toString() { // required override
        return info();
    }

    @Override
    public boolean equals(Object o) { // required override
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger p = (Passenger) o;
        return getId() == p.getId(); // compare by id
    }

    @Override
    public int hashCode() { // required override
        return Objects.hash(getId());
    }
}
