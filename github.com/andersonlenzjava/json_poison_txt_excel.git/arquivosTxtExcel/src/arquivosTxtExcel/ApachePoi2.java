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

//criando lista apartir da leitura de um arquivo excel com apache poi 16.6

public class ApachePoi2 {

	public static void main(String[] args) throws Exception {

		FileInputStream entrada = new FileInputStream(
				new File("C:\\workspace-curso-java\\arquivosTxtExcel\\src\\arquivosTxtExcel\\arquivo_excel.xls"));

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);// prepara a entrada do arquivo excel para ler
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);// pega a primeira planilha do nosso arquivo excel

		Iterator<Row> linhaIterator = planilha.iterator();// objeto para ler as linhas está alinhado com uma lista

		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();// cria uma lista de pessoas para receber as linhas

		while (linhaIterator.hasNext()) {// enquanto houver linhas na planilha

			Row linha = linhaIterator.next();// Dados da pessoa na linha
			Iterator<Cell> celulas = linha.iterator();// objeto para ler as celulas da linha

			Pessoa pessoa = new Pessoa();// instância uma pessoa para adicionar atributo

			while (celulas.hasNext()) {// enquanto houver celular pescorer
				Cell cell = celulas.next();// Variavel para receber os dados da celula

				switch (cell.getColumnIndex()) {// indice da colula
				case 0:
					pessoa.setNome(cell.getStringCellValue());// atribui a string da celula a pessoa
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;// recebe o valor em double numerico da celula e converte em int

				}
			} // fim das celulas da linha
			pessoas.add(pessoa);// dentro da interação da linha

		}
		
		entrada.close();// terminou de ler o arquivo excel

		for (Pessoa pessoa : pessoas) {//pode ser gravar em um banco de dados/mandar emails
			System.out.println(pessoa);
		}

	}

}
