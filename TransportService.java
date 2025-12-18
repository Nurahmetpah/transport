public class TransportService {
    private int id;
    private String serviceName;

    public TransportService(int id, String serviceName) {
        this.id = id;
        this.serviceName = serviceName;
    }

    public String info() {
        return "TransportService: id=" + id + ", name=" + serviceName;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
}
