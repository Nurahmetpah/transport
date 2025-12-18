public class Main {
    public static void main(String[] args) {

        Bus bus1 = new Bus(1, "Volvo", 40);
        Bus bus2 = new Bus(2, "Mercedes", 30);

        Passenger passenger1 = new Passenger(101, "Amina", 20);
        Passenger passenger2 = new Passenger(102, "Timur", 22);

        TransportService service1 = new TransportService(1, "City Transport");
        TransportService service2 = new TransportService(2, "Express Line");

        System.out.println(bus1.info());
        System.out.println(bus2.info());

        System.out.println(passenger1.info());
        System.out.println(passenger2.info());

        System.out.println(service1.info());
        System.out.println(service2.info());

        System.out.println("Same bus id? " + (bus1.getId() == bus2.getId()));
        System.out.println("Same passenger id? " + (passenger1.getId() == passenger2.getId()));
        System.out.println("Same service id? " + (service1.getId() == service2.getId()));
    }
}

