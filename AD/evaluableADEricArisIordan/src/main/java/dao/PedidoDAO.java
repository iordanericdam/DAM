package dao;

import database.DBConnection;
import model.Empleado;
import model.Pedido;
import model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void showOrders() throws SQLException {
        String query = "SELECT * FROM pedidos";

        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);

        ResultSet result =  preparedStatement.executeQuery();

        while (result.next()) {

            int id = result.getInt("id");
            int idProducto = result.getInt("id_producto");
            String descripcion = result.getString("descripcion");
            double precioTotal = result.getDouble("precio_total");

            // Mostrar los datos en la consola
            System.out.println("ID: " + id + ", ID Producto: " + idProducto + ", Descripción: " + descripcion + ", Precio Total: " + precioTotal);
        }
    }



    public boolean createOrder(Pedido p1) throws SQLException {
        String query = "INSERT INTO pedidos (id_producto, descripcion, precio_total) VALUES ('"
                + p1.getId_producto() + "', '"
                + p1.getDescripcion() + "', '"
                + p1.getPrecio_total() + "');";

        connection = new  DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);

        return preparedStatement.execute();
    }

}
