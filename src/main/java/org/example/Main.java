package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()
        )) {
            System.out.println("Conectado con Oracle.");
        } catch (SQLException e){
            System.out.println("ERROR --> "+e.getMessage());
        }*/

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Crear empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Actualizar datos empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese el ID del empleado: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese el nombre del empleado: ");
                    String nombre = sc.nextLine();

                    System.out.println("Ingrese el salario del empleado: ");
                    double salario = sc.nextDouble();

                    CrearEmpleado.crearEmpleado(nombre,id,salario);
                    break;

                case 2:
                    System.out.println("--EMPLEADOS--");
                    ListarEmpleados.listarEmpleados();
                    break;

                case 3:
                    //Switch para escoger si actualizar el salario o el nombre
                    int opcion2;
                    do {
                        System.out.println("1. Actualizar salario empleado.");
                        System.out.println("2. Actualizar nombre empleado.");
                        System.out.print("Opción: ");
                        opcion2 = sc.nextInt();
                        sc.nextLine();

                        switch(opcion2){
                            case 1:
                                System.out.println("Ingrese el ID del empleado: ");
                                int idEmpleado = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Ingrese el salario del empleado: ");
                                double salarioEmpleado = sc.nextDouble();

                                ActualizarEmpleado.actualizarEmpleadoSalario(idEmpleado,salarioEmpleado);
                                break;
                            case 2:
                                System.out.println("Ingrese ID del empleado: ");
                                int idEmpleado2 = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Ingrese el nombre del empleado: ");
                                String nombreEmpleado = sc.nextLine();

                                ActualizarEmpleado.actualizarEmpleadoNombre(idEmpleado2,nombreEmpleado);
                                break;

                            default:
                                System.out.println("Escoja una opción correcta.");
                                break;
                        }
                    } while (opcion2 != 1 && opcion2 != 2);
                    break;

                case 4:
                    System.out.println("ID del empleado: ");
                    int idEmpleado2 = sc.nextInt();
                    sc.nextLine();

                    EliminarEmpleado.eliminarEmpleado(idEmpleado2);
                    break;

                case 0:
                    System.out.println("Has salido.");
                    break;

                default:
                    System.out.println("Escoge una opción válida.");
                    break;
            }
        } while (opcion!=0);
    }
}
