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

public class ClassificadorLiga {

	private static BufferedReader bufferArq;

	public static void main(String[] args) 
	{		
		String caminhoArquivo = "misc/E0.csv";

		if(args.length > 0)
			caminhoArquivo = args[0];

		try{
			File arquivo = new File(caminhoArquivo);
			FileReader arquivoFileReader = new FileReader(arquivo);
			bufferArq = new BufferedReader(arquivoFileReader);
			String[] dados = new String[8];
			Hash tabelaHash = new Hash();
			String linhaArquivo = bufferArq.readLine();
			System.out.println("				- Home -		- Away -		- Total -");
			System.out.println("                            Pld  W  D  L  F:A         W  D  L  F:A           F:A   +/-   Pts");	
			while (linhaArquivo != null) {
				dados = linhaArquivo.split(",");
				linhaArquivo = bufferArq.readLine();				
				if (dados[2].equalsIgnoreCase("HomeTeam") == false) {
					if(tabelaHash.busca(dados[2]) == null) {
						InfoTime homeTeam = new InfoTime();
						homeTeam.setNome(dados[2]);
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
						tabelaHash.add(homeTeam);
						System.out.println(homeTeam.getNome() + "                      "
								+ homeTeam.getTotalDePartidasJogadas() + "   "
								+ homeTeam.getTotalVitoriasEmCasaFullTime() + "  "
								+ homeTeam.getTotalEmpatesEmCasaFullTime() + "  "
								+ homeTeam.getTotalDerrotaEmCasaFullTime() + "  "
								+ homeTeam.getTotalGolsMarcadosEmCasaFullTime() + ":"
								+ homeTeam.getTotalGolsSofridosEmCasaFullTime() + "         "
								+ homeTeam.getTotalVitoriasForaDeCasaFullTime() + "  "
								+ homeTeam.getTotalEmpatesForaDeCasaFullTime() + "  "
								+ homeTeam.getTotalDerrotaForaDeCasaFullTime() + "  "
								+ homeTeam.getTotalGolsMarcadosForaDeCasaFullTime() + ":"
								+ homeTeam.getTotalGolsSofridosForaDeCasaFullTime() + "           "
								+ homeTeam.getTotalGolsMarcadosFullTime() + ":"
								+ homeTeam.getTotalGolsSofridosFullTime() + "    "
								+ homeTeam.getSaldoFullTime() + "    "
								+ homeTeam.getPontuacaoFullTime());
					} else {
						InfoTime homeTeam = tabelaHash.busca(dados[2]);
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
						System.out.println(homeTeam.getNome() + "                      "
								+ homeTeam.getTotalDePartidasJogadas() + "   "
								+ homeTeam.getTotalVitoriasEmCasaFullTime() + "  "
								+ homeTeam.getTotalEmpatesEmCasaFullTime() + "  "
								+ homeTeam.getTotalDerrotaEmCasaFullTime() + "  "
								+ homeTeam.getTotalGolsMarcadosEmCasaFullTime() + ":"
								+ homeTeam.getTotalGolsSofridosEmCasaFullTime() + "         "
								+ homeTeam.getTotalVitoriasForaDeCasaFullTime() + "  "
								+ homeTeam.getTotalEmpatesForaDeCasaFullTime() + "  "
								+ homeTeam.getTotalDerrotaForaDeCasaFullTime() + "  "
								+ homeTeam.getTotalGolsMarcadosForaDeCasaFullTime() + ":"
								+ homeTeam.getTotalGolsSofridosForaDeCasaFullTime() + "           "
								+ homeTeam.getTotalGolsMarcadosFullTime() + ":"
								+ homeTeam.getTotalGolsSofridosFullTime() + "    "
								+ homeTeam.getSaldoFullTime() + "    "
								+ homeTeam.getPontuacaoFullTime());
					}

					if(tabelaHash.busca(dados[3]) == null) {
						InfoTime awayTeam = new InfoTime();
						awayTeam.setNome(dados[3]);
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
						tabelaHash.add(awayTeam);
						System.out.println(awayTeam.getNome() + "                      "
								+ awayTeam.getTotalDePartidasJogadas() + "   "
								+ awayTeam.getTotalVitoriasEmCasaFullTime() + "  "
								+ awayTeam.getTotalEmpatesEmCasaFullTime() + "  "
								+ awayTeam.getTotalDerrotaEmCasaFullTime() + "  "
								+ awayTeam.getTotalGolsMarcadosEmCasaFullTime() + ":"
								+ awayTeam.getTotalGolsSofridosEmCasaFullTime() + "         "
								+ awayTeam.getTotalVitoriasForaDeCasaFullTime() + "  "
								+ awayTeam.getTotalEmpatesForaDeCasaFullTime() + "  "
								+ awayTeam.getTotalDerrotaForaDeCasaFullTime() + "  "
								+ awayTeam.getTotalGolsMarcadosForaDeCasaFullTime() + ":"
								+ awayTeam.getTotalGolsSofridosForaDeCasaFullTime() + "           "
								+ awayTeam.getTotalGolsMarcadosFullTime() + ":"
								+ awayTeam.getTotalGolsSofridosFullTime() + "    "
								+ awayTeam.getSaldoFullTime() + "    "
								+ awayTeam.getPontuacaoFullTime());
					} else {
						InfoTime awayTeam = tabelaHash.busca(dados[3]);
						awayTeam.setGolsMarcadosNaPartidaForaDeCasaFullTime(Integer.parseInt(dados[5]));;
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
						System.out.println(awayTeam.getNome() + "                      "
								+ awayTeam.getTotalDePartidasJogadas() + "   "
								+ awayTeam.getTotalVitoriasEmCasaFullTime() + "  "
								+ awayTeam.getTotalEmpatesEmCasaFullTime() + "  "
								+ awayTeam.getTotalDerrotaEmCasaFullTime() + "  "
								+ awayTeam.getTotalGolsMarcadosEmCasaFullTime() + ":"
								+ awayTeam.getTotalGolsSofridosEmCasaFullTime() + "         "
								+ awayTeam.getTotalVitoriasForaDeCasaFullTime() + "  "
								+ awayTeam.getTotalEmpatesForaDeCasaFullTime() + "  "
								+ awayTeam.getTotalDerrotaForaDeCasaFullTime() + "  "
								+ awayTeam.getTotalGolsMarcadosForaDeCasaFullTime() + ":"
								+ awayTeam.getTotalGolsSofridosForaDeCasaFullTime() + "           "
								+ awayTeam.getTotalGolsMarcadosFullTime() + ":"
								+ awayTeam.getTotalGolsSofridosFullTime() + "    "
								+ awayTeam.getSaldoFullTime() + "    "
								+ awayTeam.getPontuacaoFullTime());
					}
				}
			}
		} catch(IOException excep){
			System.out.println("Problema ao ler arquivo "+ caminhoArquivo +". "+ excep.getMessage());
		}
	}
}
