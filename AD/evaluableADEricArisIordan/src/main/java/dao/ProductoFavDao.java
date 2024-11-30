package dao;

import database.DBConnection;
import model.ProductoFav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoFavDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public void insertProduct(ProductoFav f1) throws SQLException {
        String query = "INSERT INTO productos_fav (id_producto) VALUES (?)";
        connection = new DBConnection().getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, f1.getId_producto());
            stmt.executeUpdate();
            System.out.println("Producto con ID " + f1.getId_producto() + " insertado correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showData() throws SQLException{
       String query = "SELECT * FROM `productos_fav`";

       connection = new  DBConnection().getConnection();
       preparedStatement = connection.prepareStatement(query);

        ResultSet result =  preparedStatement.executeQuery();

        while (result.next()) {

            int id = result.getInt("id");
            int id_producto = result.getInt("id_producto");

            // Mostrar los datos en la consola
            System.out.println("ID: " + id + ", Id producto: " + id_producto);
        }
    }
}
