package es.curso.negocio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.entidad.Coche;
import es.curso.persistencia.DaoCocheJPAData;

@Service
public class GestorCoche {

	@Autowired
	private DaoCocheJPAData cocheDao;

	@Transactional
	public String alta(Coche c) {
		if (c.getMatricula().length() == 7 && c.getMarca() != null && c.getModelo() != null) {
			System.out.println(c);
			Coche cAux = cocheDao.save(c);
			return cAux.getMatricula();
		}
		return "";
	}

	@Transactional
	public String modificar(Coche c) {
		if (c.getMatricula().length() == 7 && c.getMarca() != null && c.getModelo() != null) {
			System.out.println(c);
			Coche cAux = cocheDao.save(c);
			return cAux.getMatricula();
		}
		return "";
	}

	@Transactional
	public String baja(String matricula) {
		cocheDao.deleteById(matricula);
		return matricula;
	}

	public Coche obtener(String matricula) {
		Coche c = cocheDao.getOne(matricula);
		return c;
	}

	public List<Coche> listar() {
		List<Coche> lista = cocheDao.findAll();
		return lista;
	}

	public void imprimir() {
		List<Coche> lista = listar();

		// Creo la estructura
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "Hoja Excel");

		// Formato
		String headers[] = new String[] { "Matricula", "Marca", "Modelo", "Numero KM" };
		CellStyle headerStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
		headerStyle.setFont(font);

		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// Creacion de la tabla
		HSSFRow headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; ++i) {
			String header = headers[i];
			HSSFCell cell = headerRow.createCell(i);
			cell.setCellStyle(headerStyle);
			cell.setCellValue(header);
		}
		int contador = 0;
		for (Coche coche : lista) {
			HSSFRow dataRow = sheet.createRow(contador++);

			dataRow.createCell(0).setCellValue(coche.getMatricula());
			dataRow.createCell(1).setCellValue(coche.getMarca());
			dataRow.createCell(2).setCellValue(coche.getModelo());
			dataRow.createCell(3).setCellValue(coche.getNumeroKm());
		}

		FileOutputStream file;
		try {
			file = new FileOutputStream("data.xls");
			workbook.write(file);
			file.close();
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
