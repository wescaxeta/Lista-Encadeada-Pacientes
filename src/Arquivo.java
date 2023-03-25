
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Arquivo {

	static final String arquivo = "pacientes.txt";
	
	
	public static ListaEncadeada lerArquivo() throws FileNotFoundException, IOException {
		ListaEncadeada lista = new ListaEncadeada();
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Paciente> arrayPacientes = new ArrayList<Paciente>();

		while (br.ready()) {
			String linha = br.readLine();                          
			String dados[] = linha.split(";");                     
			Paciente p = new Paciente(dados[0], Long.parseLong(dados[1]), Long.parseLong(dados[2]), Integer.parseInt(dados[3])); 
			lista.adicionaOrdenado(p);                              
			arrayPacientes.add(p);                                   
		}
		                            
		br.close();
		fr.close();
		return lista;
	}

	public static void salvarArquivo(ListaEncadeada lista, boolean append) throws IOException {
		FileWriter fw = new FileWriter(arquivo, append);       
		BufferedWriter bw = new BufferedWriter(fw);                
		String aux = lista.montarArquivo();                               
		bw.write(aux);                                             
		bw.close();
		fw.close();
	}

	public static String getNomeArq() {
		return arquivo;
	}
}