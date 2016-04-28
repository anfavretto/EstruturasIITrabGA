// Nós (Aline, Jonatan, Gabriel), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassificadorLiga {

	private static BufferedReader bufferArq;

	public static void main(String[] args) 
	{		
		String caminhoArquivo = "misc/E0.csv";

		if(args.length > 0)
			caminhoArquivo = args[0];

		Hash tabelaHash = new Hash();
		
		try{
			File arquivo = new File(caminhoArquivo);
			FileReader arquivoFileReader = new FileReader(arquivo);
			bufferArq = new BufferedReader(arquivoFileReader);
			String[] dados = new String[8];
						
			String linhaArquivo = bufferArq.readLine();
			
			while (linhaArquivo != null) {
				dados = linhaArquivo.split(",");
				linhaArquivo = bufferArq.readLine();
				SalvarTimes(dados, tabelaHash);				
			}
		} catch(IOException excep){
			System.out.println("Problema ao ler arquivo "+ caminhoArquivo +". "+ excep.getMessage());
		}
		
		Estatisticas estatisticas = new Estatisticas();
		
		System.out.println("Digite o que você deseja executar: \n 1- Pesquisar um time \n 2- Exibir e Salvar Classificação \n 3- Exibir e Salvar Time com menos derrotas  \n 0- Sair");
		BufferedReader leitura = new BufferedReader(new InputStreamReader(System.in));
		try {
			int valorSelecionado = Integer.parseInt(leitura.readLine());
			while(valorSelecionado > 0){
			
				switch(valorSelecionado){
				case(1):
					System.out.println("Informe o time que deseja pesquisar: ");
					String time = leitura.readLine();
					InfoTime timeBuscado = tabelaHash.busca(time);
					if(timeBuscado != null){
						System.out.println("                       - Home -		           - Away -		      - Total -");
						System.out.println("                  Pld   W  D  L   F:A           W  D  L   F:A              F:A     +/-   Pts");
						estatisticas.setTime(timeBuscado);
						estatisticas.exibeTime();
					}	
					break;
				case(2):
					estatisticas.exibeESalvaClassificacaoFullTime(tabelaHash);
					break;
				case(3):
					estatisticas.exibeESalvaMenorPerdedor(tabelaHash);
					break;
				}
				
				System.out.println("Digite o que você deseja executar: \n 1- Pesquisar um time \n 2- Exibir classificação \n 3- Exibir e Salvar Time com menos derrotas  \n 0- Sair");
				valorSelecionado = Integer.parseInt(leitura.readLine());
			}	
		} catch (IOException e) {
			System.out.println("Problema ao ler seleção "+ caminhoArquivo +". "+ e.getMessage());
		}
	}
	
	public static void SalvarTimes(String[] dados, Hash tabelaHash){
		if (dados[2].equalsIgnoreCase("HomeTeam") == false) {
			AdicionaAtualizaHomeTeam(dados, tabelaHash);
			AdicionaAtualizaAwayTeam(dados, tabelaHash);
		}
	}
	
	public static void AdicionaAtualizaHomeTeam(String[] dados, Hash tabelaHash){
		
		if(tabelaHash.busca(dados[2]) != null) {
			InfoTime homeTeam = tabelaHash.busca(dados[2]);
			AdicionaInformacoesHomeTeam(homeTeam, dados);
		}else{
			InfoTime homeTeam = new InfoTime();
			AdicionaInformacoesHomeTeam(homeTeam, dados);
			homeTeam.setNome(dados[2]);
			tabelaHash.add(homeTeam);
		}
	}
	
	private static void AdicionaInformacoesHomeTeam(InfoTime homeTeam, String[] dados){
		homeTeam.setGolsMarcadosNaPartidaEmCasaFullTime(Integer.parseInt(dados[4]));
		homeTeam.setGolsSofridosNaPartidaEmCasaFullTime(Integer.parseInt(dados[5]));
		if(dados[6].equalsIgnoreCase("H")) {
			homeTeam.setPontosVitoriaFullTime();
			homeTeam.addVitoriaEmCasaFullTime();
		} else if(dados[6].equalsIgnoreCase("D")) {
			homeTeam.setPontosEmpateFullTime();
			homeTeam.addEmpateEmCasaFullTime();
		} else {
			homeTeam.setPontosDerrotaFullTime();
			homeTeam.addDerrotaEmCasaFullTime();
		}
		homeTeam.setGolsMarcadosNaPartidaEmCasaHalfTime(Integer.parseInt(dados[7]));
		homeTeam.setGolsSofridosNaPartidaEmCasaHalfTime(Integer.parseInt(dados[8]));
		if(dados[9].equalsIgnoreCase("H")) {
			homeTeam.setPontosVitoriaHalfTime();
			homeTeam.addVitoriaEmCasaHalfTime();
		} else if(dados[6].equalsIgnoreCase("D")) {
			homeTeam.setPontosEmpateHalfTime();
			homeTeam.addEmpateEmCasaHalfTime();
		} else {
			homeTeam.setPontosDerrotaHalfTime();
			homeTeam.addDerrotaEmCasaHalfTime();
		}
		homeTeam.atualizaTotalDePartidasJogadas();
		homeTeam.setTotalChutesGol(Integer.parseInt(dados[13]));
	}
	
	public static void AdicionaAtualizaAwayTeam(String[] dados, Hash tabelaHash){
		if(tabelaHash.busca(dados[3]) != null) {
			InfoTime awayTeam = tabelaHash.busca(dados[3]);
			AdicionaInformacoesAwayTeam(awayTeam, dados);
		}else{
			InfoTime awayTeam = new InfoTime();
			awayTeam.setNome(dados[3]);
			AdicionaInformacoesAwayTeam(awayTeam, dados);
			tabelaHash.add(awayTeam);
		}
	}
	
	private static void AdicionaInformacoesAwayTeam(InfoTime awayTeam, String[] dados){
		awayTeam.setGolsMarcadosNaPartidaForaDeCasaFullTime(Integer.parseInt(dados[5]));
		awayTeam.setGolsSofridosNaPartidaForaDeCasaFullTime(Integer.parseInt(dados[4]));
		if(dados[6].equalsIgnoreCase("A")) {
			awayTeam.setPontosVitoriaFullTime();
			awayTeam.addVitoriaForaDeCasaFullTime();
		} else if(dados[6].equalsIgnoreCase("D")) {
			awayTeam.setPontosEmpateFullTime();
			awayTeam.addEmpateForaDeCasaFullTime();
		} else {
			awayTeam.setPontosDerrotaFullTime();
			awayTeam.addDerrotaForaDeCasaFullTime();
		}
		awayTeam.setGolsMarcadosNaPartidaForaDeCasaHalfTime(Integer.parseInt(dados[8]));
		awayTeam.setGolsSofridosNaPartidaEmCasaHalfTime(Integer.parseInt(dados[7]));
		if(dados[9].equalsIgnoreCase("A")) {
			awayTeam.setPontosVitoriaHalfTime();
			awayTeam.addVitoriaForaDeCasaHalfTime();
		} else if(dados[6].equalsIgnoreCase("D")) {
			awayTeam.setPontosEmpateHalfTime();
			awayTeam.addEmpateForaDeCasaHalfTime();
		} else {
			awayTeam.setPontosDerrotaHalfTime();
			awayTeam.addDerrotaForaDeCasaHalfTime();
		}
		awayTeam.atualizaTotalDePartidasJogadas();
		awayTeam.setTotalChutesGol(Integer.parseInt(dados[14]));
	}
}
