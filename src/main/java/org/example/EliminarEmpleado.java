package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarEmpleado {

    //Método para eliminar empleado según el ID
    public static void eliminarEmpleado(int idEmpleado){
        try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()
        )) {
            String sql = "DELETE FROM empleado WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, idEmpleado);

            int filasActualizadas = preparedStatement.executeUpdate();
            System.out.println("Empleado eliminado.");

        }catch (SQLException e){
            System.out.println("Error --> "+e.getMessage());
        }
    }
}
