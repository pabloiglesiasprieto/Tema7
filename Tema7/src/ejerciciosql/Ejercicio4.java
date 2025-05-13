package ejerciciosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio4 {
	public static void main(String[] args) {
		/*
		 * Inserta los siguientes cursos en la base de datos institutodb: Historia 1º.
		 * Biología 1º. Educación Física 1º. Música 1º. Tecnología 1º.
		 */
		// Guardamos las credenciales.
		final String URL = "jdbc:mysql://localhost/institutodb";
		final String USERNAME = "root";
		final String PASSWD = "123";

		// Inicializamos una cadena que contendrá la creación de la tabla.
		String insertTablaString = "insert into cursos (id_curso,nombre,descripcion,año_escolar) values (3,'Historia 1º',null,2025),(4,'Biologia 1º',null,2025),(5,'Educación Física 1º',null,2025),(6,'Música 1º',null,2025),(7,'Técnología 1º',null,2025)";

		// Declaramos una variable int para mostrar la cantidad de valores insertados.
		int numRows = 0;

		// Creamos una conexión.
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWD)) {

			// Creamos un statement.
			Statement st = con.createStatement();

			// Ejecutamos el query.
			numRows = st.executeUpdate(insertTablaString);

			// Cogemos la excecpión.
		} catch (SQLException e) {

			// Imprimimos la excepción.
			System.out.println(e);
		}

		// Imprimimos las filas añadidas.
		System.out.println("Has añadido un total de " + numRows + " lineas añadidas.");

	}
}
