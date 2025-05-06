package ejerciciosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		/*
		 * Realiza diversas inserciones en las distintas tablas de la base de datos
		 * institutodb.
		 */
		// Declaramos las variables para las credenciales de la BBDD.
		final String URL = "jdbc:mysql://localhost/institutodb";
		final String USERNAME = "root";
		final String PASSWD = "123";

		// Creamos un Scanner.
		Scanner sc = new Scanner(System.in);

		// Declaramos una variable para una consulta.
		String query = "select * from estudiantes";

		// Declaramos variables para insertar datos.
		String nombre = "";
		String apellido = "";
		String fecha = "";
		String email = "";
		int telefono;

		// Declaramos una variable para ver las filas modificadas.
		int modRows;

		// Creamos una conexión.
		try (Connection conex = DriverManager.getConnection(URL, USERNAME, PASSWD)) {

			// Creamos un Statement.
			Statement st = conex.createStatement();

			// Preguntamos los datos.
			System.out.println("Introduce el nombre.");

			// Leemos entrada de teclado.
			nombre = sc.nextLine();

			// Preguntamos los datos.
			System.out.println("Introduce el primer apellidos.");

			// Leemos entrada de teclado.
			apellido = sc.nextLine();

			// Preguntamos los datos.
			System.out.println("Introduce la fecha de nacimiento.");

			// Leemos entrada de teclado.
			fecha = sc.nextLine();

			// Preguntamos los datos.
			System.out.println("Introduce el email.");

			// Leemos entrada de teclado.
			email = sc.nextLine();

			// Preguntamos los datos.
			System.out.println("Introduce el telefono.");

			// Leemos entrada de teclado.
			telefono = sc.nextInt();

			// Limpiamos el buffer.
			sc.nextLine();

			// Definimos la consulta.
			query = "INSERT INTO ESTUDIANTES (nombre, apellido, fecha_nacimiento, email, telefono) VALUES (" + "'"
					+ nombre + "'" + "," + "'" + apellido + "'" + "," + "'" + fecha + "'" + "," + "'" + email + "'"
					+ "," + "'" + telefono + "'" + ")";

			// Ejecutamos la consulta.
			modRows = st.executeUpdate(query);

			// Imprimimos el resultado.
			System.out.println("Has insertado un total de: " + modRows + " filas");

			// Cogemos la excepción.
		} catch (SQLException e) {

			// Imprimimos el error.
			System.out.println(e.getMessage());

		}
		// Cerramos el Scanner.
		sc.close();
	}
}
