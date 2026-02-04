package padre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Padre {
	/*
	 * Al final para este ejericio he elegido IOException , he intentado con throw
	 * and catch y creo que no vale la pena usarlo para este ejercicio.
	 */
	public static void main(String[] args) throws IOException {

		// lanzamos el proceso hijo usando el archivo jar que exportamos
		Process process = new ProcessBuilder("java", "-jar", "Hijo.jar").start();

		// configuramos el stream de entrada para leer lo que suelta el hijo
		// Leemos el hijo con los bytes
		InputStream is = process.getInputStream();
		// los pasamos a caracteres
		InputStreamReader isr = new InputStreamReader(is);
		// lo metemos en un buffer para leer por líneas
		BufferedReader brHijo = new BufferedReader(isr);

		// configuramos el stream de salida para enviarle datos al hijo
		PrintStream psHijo = new PrintStream(process.getOutputStream());

		// creamos un lector para capturar lo que escribimos nosotros en la consola
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		String num;
		System.out.println("Escribe algo para obtener un número aleatorio (o 'fin' para salir):");

		while ((num = teclado.readLine()) != null) {

			if (num.equalsIgnoreCase("fin")) {
				break;
			}

			// le enviamos al hijo lo que sea que hayamos escrito
			psHijo.println(num);

			// forzamos el envío de los datos por el stream para que no se queden atascados
			psHijo.flush();

			// leemos la respuesta que el hijo nos devuelve por su stream de salida
			String respuesta = brHijo.readLine();
			System.out.println(respuesta);
		}

		// Acá solo si el proceso del hijo está vivo lo destruimos para que no quede
		// flotnado como un proceso Zombie.
		if (process.isAlive()) {
			process.destroy();
			System.out.println("Proceso hijo finalizado correctamente.");
		}

		System.out.println("Proceso finalizado.");
	}
}
