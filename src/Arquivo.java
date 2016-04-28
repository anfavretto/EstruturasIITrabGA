// Nós (Aline, Jonatan, Gabriel), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

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
