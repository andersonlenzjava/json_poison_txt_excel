package arquivosTxtExcel;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//primeiro a gerar arquivos 16.1

public class Arquivos1 {
	
	public static void main(String[] args) throws IOException {
		
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
		
		//pode vir de um banco de dados ou qualquer outra fonte de dados 
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();//criar uma lista com as pessoas 
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		//clase file para trabalhar com arquivos com o objeto arquivo, cria o objeto
		File arquivo = new File("C:\\workspace-curso-java\\arquivosTxtExcel\\src\\arquivosTxtExcel\\arquivo.txt");
		
		if(!arquivo.exists()) {//se o arquivo não existir, pq tem a negação 
			arquivo.createNewFile();
		}
		//Objeto que escreve no arquivo
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
	
		//for (int i = 1 ; i <= 10 ; i++) {
			
		//	escrever_no_arquivo.write("Texto da linha "+ i + "\n");
			
		//}
		
		for (Pessoa p : pessoas) {
			
			escrever_no_arquivo.write(p.getNome() + ";" + p.getIdade() + ";" + p.getEmail() + "\n");
			
		}
		
		escrever_no_arquivo.flush();//para "PERSISTIR" as alterações 
		escrever_no_arquivo.close();
		
	}

}
