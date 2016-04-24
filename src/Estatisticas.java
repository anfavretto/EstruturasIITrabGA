
public class Estatisticas {
	
	public static void exibeTime(InfoTime time){
		System.out.println(ObtemLinhaExibicaoTimeFullTime(time, true));
	}
	
	private static String ObtemNomePadronizado(String nomeTime, boolean fgAdicionaEspacosInicio){
		String separador = " ";
		while(nomeTime.length() < 14){
			if(fgAdicionaEspacosInicio){
				nomeTime = separador + nomeTime;
			}else{
				nomeTime = nomeTime + separador;
			}
		}
		return nomeTime;
	}

	private static String ObtemLinhaExibicaoTimeFullTime(InfoTime time, boolean fgAdicionaEspacosInicioNome){
		String separadorVitoriasEmCasa = time.getTotalVitoriasEmCasaFullTime() > 9 ? "   " : "    ";
		String separadorPosVitoriasEmCasa = time.getTotalVitoriasEmCasaFullTime() > 9 ? "  " : "  ";
		String separadorDerrotasEmCasa = time.getTotalDerrotaEmCasaFullTime() > 9 ? " " : "  ";
		String separadorVitoriasForaCasa = time.getTotalVitoriasForaDeCasaFullTime() > 9 ?"         " : "          ";
		String separadorDerrotasForaCasa = time.getTotalDerrotaForaDeCasaFullTime() > 9 ? " " : "  ";
		String separadorGolsTotal = time.getTotalGolsMarcadosFullTime() > 99 ? "           " : "            ";
		String separadorSaldoGols = time.getSaldoFullTime() == 0 ? "      " : time.getSaldoFullTime() < 0 ?  time.getSaldoFullTime() < -9 ?  "    " : "     "   : time.getSaldoFullTime() < 9 ? "     +" : "    +";
		
		String retorno =  ObtemNomePadronizado(time.getNome(), fgAdicionaEspacosInicioNome) + "    "
							+ time.getTotalDePartidasJogadas() + separadorVitoriasEmCasa
							+ time.getTotalVitoriasEmCasaFullTime()  + separadorPosVitoriasEmCasa  
							+ time.getTotalEmpatesEmCasaFullTime() + separadorDerrotasEmCasa
							+ time.getTotalDerrotaEmCasaFullTime() + "  "
							+ time.getTotalGolsMarcadosEmCasaFullTime() + ":"
							+ time.getTotalGolsSofridosEmCasaFullTime() + separadorVitoriasForaCasa 
							+ time.getTotalVitoriasForaDeCasaFullTime() + "  " 
							+ time.getTotalEmpatesForaDeCasaFullTime() + separadorDerrotasForaCasa
							+ time.getTotalDerrotaForaDeCasaFullTime() + "  "
							+ time.getTotalGolsMarcadosForaDeCasaFullTime() + ":"
							+ time.getTotalGolsSofridosForaDeCasaFullTime() + separadorGolsTotal
							+ time.getTotalGolsMarcadosFullTime() + ":"
							+ time.getTotalGolsSofridosFullTime() + separadorSaldoGols
							+ time.getSaldoFullTime() + "     "
							+ time.getPontuacaoFullTime();
		
		return retorno;
	}
	
	private static String ObtemLinhaExibicaoTimeHalfTime(InfoTime time, boolean fgAdicionaEspacosInicioNome){
		String separadorVitoriasEmCasa = time.getTotalVitoriasEmCasaHalfTime() > 9 ? "   " : "    ";
		String separadorPosVitoriasEmCasa = time.getTotalVitoriasEmCasaHalfTime() > 9 ? "  " : "  ";
		String separadorDerrotasEmCasa = time.getTotalDerrotaEmCasaHalfTime() > 9 ? " " : "  ";
		String separadorVitoriasForaCasa = time.getTotalVitoriasForaDeCasaHalfTime() > 9 ?"         " : "          ";
		String separadorDerrotasForaCasa = time.getTotalDerrotaForaDeCasaHalfTime() > 9 ? " " : "  ";
		String separadorGolsTotal = time.getTotalGolsMarcadosEmCasaHalfTime() > 99 ? "           " : "            ";
		String separadorSaldoGols = time.getSaldoHalfTime() < 0 ? time.getSaldoHalfTime() < -9 ?  "    " : "     "  : time.getSaldoHalfTime() < 9 ? "     +" : "    +";
		
		String retorno =  ObtemNomePadronizado(time.getNome(), fgAdicionaEspacosInicioNome) + "    "
							+ time.getTotalDePartidasJogadas() + separadorVitoriasEmCasa
							+ time.getTotalVitoriasEmCasaHalfTime()  + separadorPosVitoriasEmCasa  
							+ time.getTotalEmpatesEmCasaHalfTime() + separadorDerrotasEmCasa
							+ time.getTotalDerrotaEmCasaHalfTime() + "  "
							+ time.getTotalGolsMarcadosEmCasaHalfTime() + ":"
							+ time.getTotalGolsSofridosEmCasaHalfTime() + separadorVitoriasForaCasa 
							+ time.getTotalVitoriasForaDeCasaHalfTime() + "  " 
							+ time.getTotalEmpatesForaDeCasaHalfTime() + separadorDerrotasForaCasa
							+ time.getTotalDerrotaForaDeCasaHalfTime() + "  "
							+ time.getTotalGolsMarcadosForaDeCasaHalfTime() + ":"
							+ time.getTotalGolsSofridosForaDeCasaHalfTime() + separadorGolsTotal
							+ time.getTotalGolsMarcadosHalfTime() + ":"
							+ time.getTotalGolsSofridosHalfTime() + separadorSaldoGols
							+ time.getSaldoHalfTime() + "     "
							+ time.getPontuacaoHalfTime();
		
		return retorno;
	}
	
	public static void exibeESalvaClassificacaoFullTime(Hash tabelaTimes){
		
		ObjetoOrdenado[] listaTotalDePontos = new ObjetoOrdenado[20];
		Times[] timesLiga = Times.values();
		
		for(Times timeAtual : timesLiga){
			InfoTime time = tabelaTimes.busca(timeAtual.getNome());
			
			ObjetoOrdenado novo = new ObjetoOrdenado();
			novo.setPropriedadeOrdenada(time.getPontuacaoFullTime());
			novo.setTime(time);
			
			listaTotalDePontos[timeAtual.getIndice()] = novo;
		}
		
		Heap hp1 = new MaxHeap();
		ObjetoOrdenado[] maxHeap = hp1.buildHeap(listaTotalDePontos);
		String conteudoMaxHeap = "";
		
		conteudoMaxHeap += "                           - Home -		       - Away -		          - Total -\n";
		conteudoMaxHeap += "                      Pld   W  D  L   F:A           W  D  L   F:A              F:A     +/-    Pts\n";
				
		String separadorInicial = " ";
		for(int i = 0; i < maxHeap.length; i++){
			separadorInicial = i >= 9 ? "" : " ";
			InfoTime time = maxHeap[i].getTime();
			String linhaExibicao = ObtemLinhaExibicaoTimeFullTime(time, false);
			conteudoMaxHeap += separadorInicial + (i + 1) + ". " + linhaExibicao + "\n";
		}
		System.out.println(conteudoMaxHeap);
	}
}
