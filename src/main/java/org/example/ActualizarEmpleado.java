package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarEmpleado {
    //Método para actualizar el salario
    public static void actualizarEmpleadoSalario(int idEmpleado, double salario){
        try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()
        )) {
            String sql = "UPDATE empleado SET salario = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1, salario);
            preparedStatement.setInt(2, idEmpleado);

            int filasActualizadas = preparedStatement.executeUpdate();
            System.out.println("Datos actualizados. Filas afectadas: " + filasActualizadas);

        }catch (SQLException e){
            System.out.println("Error --> "+e.getMessage());
        }
    }

    //Método para actualizar el nombre
    public static void actualizarEmpleadoNombre(int idEmpleado, String nombre){
        try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()
        )) {
            String sql = "UPDATE empleado SET nombre = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, idEmpleado);

            System.out.println("Datos actualizados");

        }catch (SQLException e){
            System.out.println("Error --> "+e.getMessage());
        }
    }
}
