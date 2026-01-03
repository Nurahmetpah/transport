import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {


    public void insertBus(Bus bus) throws SQLException {
        String sql = "INSERT INTO bus (id, model, capacity) VALUES (?, ?, ?)";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bus.getId());
            ps.setString(2, bus.getModel());
            ps.setInt(3, bus.getCapacity());
            ps.executeUpdate();
        }
    }

    public List<Bus> getAllBuses() throws SQLException {
        String sql = "SELECT id, model, capacity FROM bus ORDER BY id";
        List<Bus> result = new ArrayList<>();

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String model = rs.getString("model");
                int capacity = rs.getInt("capacity");
                result.add(new Bus(id, model, capacity));
            }
        }
        return result;
    }


    public Bus getBusById(int id) throws SQLException {
        String sql = "SELECT id, model, capacity FROM bus WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Bus(
                            rs.getInt("id"),
                            rs.getString("model"),
                            rs.getInt("capacity")
                    );
                }
            }
        }
        return null;
    }


    public void updateBus(Bus bus) throws SQLException {
        String sql = "UPDATE bus SET model = ?, capacity = ? WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bus.getModel());
            ps.setInt(2, bus.getCapacity());
            ps.setInt(3, bus.getId());
            ps.executeUpdate();
        }
    }


    public void deleteBus(int id) throws SQLException {
        String sql = "DELETE FROM bus WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
