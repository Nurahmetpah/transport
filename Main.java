import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BusDAO busDAO = new BusDAO();

        while (true) {
            System.out.println("\n--- BUS CRUD MENU ---");
            System.out.println("1) Add bus");
            System.out.println("2) Show all buses");
            System.out.println("3) Update bus");
            System.out.println("4) Delete bus");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            try {
                if (choice == 0) break;

                if (choice == 1) {
                    System.out.print("id: ");
                    int id = sc.nextInt();
                    System.out.print("model: ");
                    String model = sc.next();
                    System.out.print("capacity: ");
                    int cap = sc.nextInt();

                    busDAO.insertBus(new Bus(id, model, cap));
                    System.out.println("Inserted.");

                } else if (choice == 2) {
                    List<Bus> buses = busDAO.getAllBuses();
                    for (Bus b : buses) System.out.println(b.info());

                } else if (choice == 3) {
                    System.out.print("id to update: ");
                    int id = sc.nextInt();
                    Bus existing = busDAO.getBusById(id);
                    if (existing == null) {
                        System.out.println("Not found.");
                    } else {
                        System.out.print("new model: ");
                        String model = sc.next();
                        System.out.print("new capacity: ");
                        int cap = sc.nextInt();

                        existing.setModel(model);
                        existing.setCapacity(cap);
                        busDAO.updateBus(existing);
                        System.out.println("Updated.");
                    }

                } else if (choice == 4) {
                    System.out.print("id to delete: ");
                    int id = sc.nextInt();
                    busDAO.deleteBus(id);
                    System.out.println("Deleted.");

                } else {
                    System.out.println("Wrong option.");
                }

            } catch (SQLException e) {
                System.out.println("DB error: " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("Bye!");
    }
}
