package org.example;

import java.sql.*;

public class CrearEmpleado {

    //Método para crear el empleado
    public static void crearEmpleado(String nombre, int id, double salario){
        try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()
        ); Statement statement = connection.createStatement()) {

            String sql = "INSERT INTO empleado(id, nombre, salario) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nombre);
            preparedStatement.setDouble(3, salario);

            preparedStatement.executeUpdate();
            System.out.println("Registro insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("ERROR --> " + e.getMessage());
        }
    }
}