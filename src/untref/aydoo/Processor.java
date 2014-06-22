package untref.aydoo;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Processor {

	Logger logger = Logger.getLogger("log");

	public void processCsv(String csvFile, CalculadorEstadistico calculador) {
		logger.setLevel(Level.OFF);

		CsvReader reader = new CsvReader(csvFile);
		Prestamo prestamo = new Prestamo();
		String line;

		while ((line = reader.readLine()) != null) {
			try {
				prestamo.parse(line);
				logger.debug("Registro procesado" + prestamo.toString());
				calculador.addPrestamo(prestamo);
			} catch (RegistroInvalidoException e) {
				logger.error(e.getMessage());
			} catch (RegistroHeaderException e) {
				logger.debug("Se procesa el encabezado del archivo.");
			}
		}
	}

}
