package arquivosTxtExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

//criando planilha com apache poi 16.5 

public class ApachePoi {

	public static void main(String[] args) throws Exception {

		File file = new File("C:\\workspace-curso-java\\arquivosTxtExcel\\src\\arquivosTxtExcel\\arquivo_excel.xls");

		if (!file.exists()) {// se o arquivo não existir cria ele
			file.createNewFile();
		}

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setIdade(50);
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setNome("joao");

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setIdade(44);
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setNome("caio");

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setIdade(33);
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setNome("Marco");

		// pode vir de um banco de dados ou qualquer outra fonte de dados
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();// criar uma lista com as pessoas
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();// usado par escrever a planilha, carregar os métodos
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("Planilha de pessoas Jdev Treinamento");// cria a planilha

		int numeroLinha = 0;

		for (Pessoa p : pessoas) {// cada pessoa é uma linha, cada coluna é um atributo
			Row linha = linhaPessoa.createRow(numeroLinha++);

			int celula = 0;

			Cell cellNome = linha.createCell(celula++);// cria uma celula 1
			cellNome.setCellValue(p.getNome());

			Cell cellemail = linha.createCell(celula++);// cria uma celula 2
			cellemail.setCellValue(p.getEmail());

			Cell cellidade = linha.createCell(celula++);// cria uma celula 3
			cellidade.setCellValue(p.getIdade());

		} // Termino da montagem da planilha

		FileOutputStream saida = new FileOutputStream(file);// cria um instânica de saida no arquivo inicial
		hssfWorkbook.write(saida);// escreve no arquivo
		saida.flush();// grava
		saida.close();// fecha

		System.out.println("Planilha foi criada");
	}

}
