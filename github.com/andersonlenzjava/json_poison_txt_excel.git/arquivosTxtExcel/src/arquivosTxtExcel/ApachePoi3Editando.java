package arquivosTxtExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

//adicionar uma coluna no arquivo 16.7
//poderia ser a consulta a uma planilha de dados editar e enviar para algum lugar 

public class ApachePoi3Editando {

	public static void main(String[] args) throws Exception {

		File file = new File("C:\\Users\\ander\\git\\repository12\\github.com\\andersonlenzjava\\json_poison_txt_excel.git\\arquivosTxtExcel\\src\\arquivosTxtExcel\\arquivo_excel.xls");

		FileInputStream entrada = new FileInputStream(file);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);// prepara a entrada do arquivo excel para ler
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);// pega a primeira planilha do nosso arquivo excel

		Iterator<Row> linhaIterator = planilha.iterator();// objeto para ler as linhas está alinhado com uma lista

		while (linhaIterator.hasNext()) {// enquanto houver linhas
			Row linha = linhaIterator.next();// pega os dados da primeira linha

			int numeroCelulas = linha.getPhysicalNumberOfCells();// traz o numero de linhas

			Cell cell = linha.createCell(numeroCelulas);// cria uma celula a mais em cada linha
			cell.setCellValue("5.888,20");
		}

		entrada.close();

		FileOutputStream saida = new FileOutputStream(file);// seta no arquivo file a saida
		hssfWorkbook.write(saida);// escreve a saida
		saida.flush();
		saida.close();

		System.out.println("Planilha atualizada");

	}

}
