package dao;

import database.DBConnection;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public ResultSet mostrarEmpleados() throws SQLException {
        String query = "SELECT * FROM empleados";

        connection = new  DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);

        return preparedStatement.executeQuery();
    }

    public boolean crearEmpleado(Empleado empleado) throws SQLException {
        String query = "INSERT INTO empleados (nombre, correo, apellidos) VALUES ('"
                + empleado.getNombre() + "', '"
                + empleado.getCorreo() + "', '"
                + empleado.getApellidos() + "');";

        connection = new  DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);

        return preparedStatement.execute();
    }



}
