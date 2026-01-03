import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TransportService extends Entity {
    private String serviceName;

    private List<Bus> buses = new ArrayList<>();            // data pool
    private List<Passenger> passengers = new ArrayList<>(); // data pool

    public TransportService(int id, String serviceName) {
        super(id);
        this.serviceName = serviceName;
    }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public void addBus(Bus bus) { buses.add(bus); }
    public void addPassenger(Passenger passenger) { passengers.add(passenger); }

    public Bus findBusById(int id) { // searching
        for (Bus b : buses) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public Passenger findPassengerById(int id) { // searching
        for (Passenger p : passengers) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public List<Bus> filterBusesByMinCapacity(int minCapacity) { // filtering
        List<Bus> result = new ArrayList<>();
        for (Bus b : buses) {
            if (b.getCapacity() >= minCapacity) result.add(b);
        }
        return result;
    }

    public void sortBusesByCapacity() { // sorting
        buses.sort(Comparator.comparingInt(Bus::getCapacity));
    }

    public void sortPassengersByName() { // sorting
        passengers.sort(Comparator.comparing(Passenger::getName));
    }

    // polymorphism: return everything as base type Entity
    public List<Entity> getAllEntities() {
        List<Entity> all = new ArrayList<>();
        all.addAll(buses);
        all.addAll(passengers);
        return all;
    }

    @Override
    public String info() {
        return "TransportService: id=" + getId() + ", name=" + serviceName +
                " | buses=" + buses.size() + ", passengers=" + passengers.size();
    }

    @Override
    public String toString() { // required override
        return info();
    }

    @Override
    public boolean equals(Object o) { // required override
        if (this == o) return true;
        if (!(o instanceof TransportService)) return false;
        TransportService s = (TransportService) o;
        return getId() == s.getId();
    }

    @Override
    public int hashCode() { // required override
        return Objects.hash(getId());
    }

    // simple printing helpers
    public void printBuses() {
        for (Bus b : buses) System.out.println(b);
    }

    public void printPassengers() {
        for (Passenger p : passengers) System.out.println(p);
    }
}
