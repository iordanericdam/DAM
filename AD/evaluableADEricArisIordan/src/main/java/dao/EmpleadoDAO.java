package dao;

import database.DBConnection;
import model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public void registrarProducto(Producto producto) throws SQLException {
        connection = new  DBConnection().getConnection();
       // preparedStatement = connection.prepareStatement();
    }

}
