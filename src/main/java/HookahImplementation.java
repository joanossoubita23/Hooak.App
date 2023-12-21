import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HookahImplementation  implements HookahDao {
    private Connection connection;

    public HookahImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addHookah(Hookah hookah) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Hookah(name,quantity,price) VALUES(?,?,?)")) {
            statement.setString(1, hookah.getName());
            statement.setInt(2, hookah.getQuantity());
            statement.setDouble(3, hookah.getPrice());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void UpdateHookah(Hookah hookah) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Hookah SET name=?,quantity=?,price=? WHERE id=?")) {
            statement.setString(1, hookah.getName());
            statement.setInt(2, hookah.getQuantity());
            statement.setDouble(3, hookah.getPrice());
            statement.setInt(4, hookah.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteHookahByid(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE Hookah WHERE id=?")) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Hookah getHookahByid(int id) throws SQLException {
        Hookah hookah = null;
        try (PreparedStatement statement = connection.prepareStatement("DELETE Hookah WHERE id=?")) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt("id");
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    hookah = new Hookah(id, name, quantity, price);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return hookah;
        }
    }

    @Override
    public List<Hookah> getAllHookahs() throws SQLException {
        List<Hookah> hookahs = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Hookah")) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    Hookah hookah = new Hookah(id, name, quantity, price);
                    hookahs.add(hookah);


                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return hookahs;
        }
    }
}

