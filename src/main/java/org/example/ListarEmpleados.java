package org.example;

import java.sql.*;

public class ListarEmpleados {

    //Método para listar el empleado
    public static void listarEmpleados(){
        try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()
        ); Statement statement = connection.createStatement()) {

            String sql = "SELECT * from empleado ";
            ResultSet resultSet = statement.executeQuery(sql); //devuelve registros --> un "resultado"

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double salario = resultSet.getDouble("salario");
                System.out.println("\nID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Salario: " + salario);
            }
        } catch (SQLException e){
            System.out.println("ERROR --> "+e.getMessage());
        }
    }
}
