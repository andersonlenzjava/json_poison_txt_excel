package arquivosTxtExcel;

import java.awt.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

//usando json 16.9

public class EscrevJSON {

	public static void main(String[] args) throws IOException {

		Usuario usuario1 = new Usuario();
		usuario1.setNome("Anderson");
		usuario1.setLogin("Ander");
		usuario1.setSenha("123123");
		usuario1.setCpf("334334334");

		Usuario usuario2 = new Usuario();
		usuario2.setNome("Caio");
		usuario2.setLogin("Caio");
		usuario2.setSenha("123123");
		usuario2.setCpf("334111");

		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);

		// cria o objeto gson para manipular as listas e criar uma organização pretty em
		// linhas
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// escreve no objeto json os dados da lista usuarios com uma caracteristica
		String jsonUser = gson.toJson(usuarios);

		System.out.println(jsonUser);// passa a lista de dados via este objeto json

		FileWriter fileWriter = new FileWriter(// escreve no arquivo
				"C:\\workspace-curso-java\\arquivosTxtExcel\\src\\arquivosTxtExcel\\filejson.json");

		fileWriter.write(jsonUser);// escreve no arquivo
		fileWriter.flush();
		fileWriter.close();

//------------------------------------LENDO O ARQUIVO JSON-------------------------------//

		FileReader fileReader = new FileReader(
				"C:\\workspace-curso-java\\arquivosTxtExcel\\src\\arquivosTxtExcel\\filejson.json");

		// transfere o arquivo json para o array jason
		JsonArray jsArray = (JsonArray) JsonParser.parseReader(fileReader);

		// cria a lista de usuários para receber o array jason, e transferir para um
		// manipulavel
		ArrayList<Usuario> listUsuarios = new ArrayList<Usuario>();

		// rotina para varer esta lista de json array e ai para cada objeto jsonelement faz algo 
		for (JsonElement jsonElement : jsArray) {

			//transfere para o usuário os dados do jsonelement
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usuario);
		}
		
		System.out.println("Leitura do arquivo JSON: " + listUsuarios);

	}

}
