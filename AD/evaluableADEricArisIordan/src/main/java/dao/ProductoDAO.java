package dao;


import database.DBConnection;
import model.Producto;
import model.ProductoFav;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void importData(){

        String urlString = "https://dummyjson.com/products";
        URL url = null;
        try {
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = bufferedReader.readLine();
            JSONObject response = new JSONObject(linea);
            JSONArray products = response.getJSONArray("products");
            for(Object producto : products){
                if (producto instanceof JSONObject){
                    int id = ((JSONObject) producto).getInt("id");
                    String nombre = ((JSONObject) producto).getString("title");
                    String descripcion = ((JSONObject) producto).getString("description");
                    int cantidad = ((JSONObject) producto).getInt("stock");
                    double precio = ((JSONObject) producto).getDouble("price");

                    Producto p1 = new Producto(id, nombre, descripcion, cantidad, precio);
                    if (!productExists(p1.getId())) {
                        insertProduct(p1);
                    }
                }
            }


        } catch (MalformedURLException e) {
            System.out.println("La url ha fallado");
        } catch (IOException e) {
            System.out.println("Error de conexion");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void insertProduct(Producto p1) throws Exception {
        String query = "INSERT INTO productos (id, nombre, descripcion, cantidad, precio) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, p1.getId());
            stmt.setString(2, p1.getNombre());
            stmt.setString(3, p1.getDescripcion());
            stmt.setDouble(4, p1.getCantidad());
            stmt.setDouble(5, p1.getPrecio());
            stmt.executeUpdate();
            System.out.println("Producto con ID " + p1.getId() + " insertado correctamente.");
        }
    }

    private boolean productExists(int productId) throws Exception {
        String query = "SELECT 1 FROM productos WHERE id = ?";
        connection = new DBConnection().getConnection();
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, productId);
            try (ResultSet rs = prepareStatement.executeQuery()) {
                return rs.next();
            }
        }
    }

    public ResultSet selectProduct(int productId) throws Exception {
        String query = "SELECT * FROM productos WHERE id = ?";
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, productId);
        return preparedStatement.executeQuery();

    }

    public void showProducts() throws SQLException {
        String query = "SELECT * FROM productos";

        connection = new  DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);

        ResultSet result =  preparedStatement.executeQuery();

        while (result.next()) {

            int id = result.getInt("id");
            String nombre = result.getString("nombre");
            String descripcion = result.getString("descripcion");
            String cantidad = result.getString("cantidad");
            String precio = result.getString("precio");

            // Mostrar los datos en la consola
            System.out.println("ID: " + id + ", Nombre: " + nombre + ", Descripcion: " + descripcion + ", Cantidad: " + cantidad+ ", Precio: " + precio);
        }

    }

    public void showProductsBaratos() throws SQLException {
        String query = "SELECT * FROM productos WHERE precio < 600";

        connection = new  DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);

        ResultSet result =  preparedStatement.executeQuery();

        while (result.next()) {

            int id = result.getInt("id");
            String nombre = result.getString("nombre");
            String descripcion = result.getString("descripcion");
            String cantidad = result.getString("cantidad");
            String precio = result.getString("precio");

            // Mostrar los datos en la consola
            System.out.println("ID: " + id + ", Nombre: " + nombre + ", Descripcion: " + descripcion + ", Cantidad: " + cantidad+ ", Precio: " + precio);
        }

    }

    public ResultSet selectFavourite() throws SQLException {
        String query = "SELECT * FROM productos WHERE precio > 1000";

        connection = new  DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);

        return  preparedStatement.executeQuery();
    }
}
