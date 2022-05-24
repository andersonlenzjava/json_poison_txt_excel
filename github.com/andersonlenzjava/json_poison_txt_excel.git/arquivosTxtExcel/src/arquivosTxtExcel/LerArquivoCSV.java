package arquivosTxtExcel;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//le o arquivo e guarda em uma lista  16.4

public class LerArquivoCSV {

	public static void main(String[] args) throws FileNotFoundException {

		// *é possivel editar o arquivo aqui dentro
		// entrada de dados apontada para o objeto
		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\workspace-curso-java\\arquivosTxtExcel\\src\\arquivosTxtExcel\\arquivo.csv"));

		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");// o arquivo para ler e o sinal para codificar, envia
																	// para a variavel os dados
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();//Cria uma lista de pessoas 
		
		while (lerArquivo.hasNext()) {// enquanto houver dados no arquivo

			String linha = lerArquivo.nextLine();

			if (linha != null && !linha.isEmpty()) {// (diferente de null, e diferente de vazia) se tiver dados dentro
													// da linha pode imprimir
				System.out.println(linha);
				
				String[] dados = linha.split("\\;");//dados recebe a string, separada por tal dado split
				
				Pessoa pessoa = new Pessoa();//instância a pessoa
				pessoa.setNome(dados[0]); // da posição 0 pega o nome
				pessoa.setIdade(Integer.parseInt(dados[1]));// da posição 1 pega a idade
				pessoa.setEmail(dados[2]);// da posição 2 pega o email

				pessoas.add(pessoa); //adiciona uma pessoa a lista de pessoas
			}

		}
		for (Pessoa pessoa : pessoas) {//poderia gravar em um banco, gerar boleto
			
			System.out.println(pessoa);
		}

	}

}
