import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TransportService service = new TransportService(1, "City Transport");

        // starter data
        service.addBus(new Bus(1, "Volvo", 40));
        service.addBus(new Bus(2, "Mercedes", 30));
        service.addPassenger(new Passenger(101, "Amina", 20));
        service.addPassenger(new Passenger(102, "Timur", 22));

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Show buses");
            System.out.println("2) Show passengers");
            System.out.println("3) Search bus by id");
            System.out.println("4) Filter buses by min capacity");
            System.out.println("5) Sort buses by capacity");
            System.out.println("6) Polymorphism demo (print all entities)");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            if (choice == 0) break;

            if (choice == 1) {
                service.printBuses();
            } else if (choice == 2) {
                service.printPassengers();
            } else if (choice == 3) {
                System.out.print("Enter bus id: ");
                int id = sc.nextInt();
                Bus b = service.findBusById(id);
                System.out.println(b == null ? "Not found" : b);
            } else if (choice == 4) {
                System.out.print("Min capacity: ");
                int minCap = sc.nextInt();
                List<Bus> filtered = service.filterBusesByMinCapacity(minCap);
                for (Bus b : filtered) System.out.println(b);
            } else if (choice == 5) {
                service.sortBusesByCapacity();
                System.out.println("Sorted.");
                service.printBuses();
            } else if (choice == 6) {
                // polymorphism: Bus and Passenger treated as Entity
                List<Entity> all = service.getAllEntities();
                for (Entity e : all) {
                    System.out.println(e.info()); // calls correct subclass info()
                }
            } else {
                System.out.println("Wrong option.");
            }
        }

        sc.close();
        System.out.println("Bye!");
    }
}

