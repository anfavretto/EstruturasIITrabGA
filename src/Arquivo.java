import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	
	public static void SalvarArquivo(String nomeArquivo, String conteudoArquivo){
		FileWriter arq;
		try {
			arq = new FileWriter("misc/" + nomeArquivo);
			PrintWriter gravarArq = new PrintWriter(arq); 
			gravarArq.printf(conteudoArquivo); 
			arq.close();
		} catch (IOException e) {
			System.out.println("Problema ao criar arquivo "+ nomeArquivo + e.getMessage());
		} 
	}
}
