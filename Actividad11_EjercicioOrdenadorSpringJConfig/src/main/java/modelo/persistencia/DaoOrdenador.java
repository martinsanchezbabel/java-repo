package modelo.persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import modelo.entidad.Ordenador;

public class DaoOrdenador {

	public void guardarOrdenador(Ordenador o) throws IOException {
		FileWriter fichero = null;
		PrintWriter pw = null;

		String ruta = "src/main/resources/ordenador.txt";
		File archivo = new File(ruta);
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(archivo));
		bw.write(o.toString());

		bw.close();

	}
}
