package ejerciciosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio5 {
	public static void main(String[] args) {
		/*
		 * Añade notas a los distintos alumnos de la base de datos para las distintas
		 * asignaturas.
		 */
		// Declaramos las credenciales.
		final String URL = "jdbc:mysql://localhost/institutodb";
		final String USERNAME = "root";
		final String PASSWD = "123";

		// Declaramos la variable que mostrará las filas modificadas.
		int modRows = 0;

		// Declaramos la cadena que almacenará el query.
		String query = "insert into calificaciones (id_estudiante,id_curso,id_profesor,tipo_evaluacion,nota,fecha_evaluacion) values (1,4,1,'No se', 7, CURRENT_DATE()),(1,5,1,'No se', 7, CURRENT_DATE()),(1,6,1,'No se', 7, CURRENT_DATE()),(1,7,1,'No se', 7,CURRENT_DATE()),(2,4,1,'No se', 7, CURRENT_DATE()),(2,5,1,'No se', 7, CURRENT_DATE()),(2,6,1,'No se', 7, CURRENT_DATE()),(2,7,1,'No se', 7, CURRENT_DATE()),(3,4,1,'No se', 7, CURRENT_DATE()),(3,5,1,'No se', 7, CURRENT_DATE()),(3,6,1,'No se', 7, CURRENT_DATE()),(3,7,1,'No se', 7, CURRENT_DATE())";

		// Iniciamos la conexión.
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWD)) {

			// Creamos la sentencia.
			Statement st = con.createStatement();

			// Ejecutamos la sentencia.
			modRows = st.executeUpdate(query);

			// Cogemos la excepción.
		} catch (SQLException e) {

			// Imprimimos la excepción.
			System.out.println(e);
		}

		// Imprimimos las filas añadidas.
		System.out.println("Has añadido un total de " + modRows + " lineas añadidas.");

	}
}
