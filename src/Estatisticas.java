
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
		String separadorGolsSofridosForaCasa = time.getTotalGolsSofridosForaDeCasaFullTime() > 9 ? "" : " ";
		String separadorGolsMarcadosEmCasa = time.getTotalGolsMarcadosEmCasaFullTime() > 9 ? "  " : "   " ;
		String separadorGolsMarcadosForaCasa = time.getTotalGolsMarcadosForaDeCasaFullTime() > 9 ? "  " : "   " ;
		String separadorSaldoGols = time.getSaldoFullTime() == 0 ? "      " : time.getSaldoFullTime() < 0 ?  time.getSaldoFullTime() > -10 ? "     " : "    "  : time.getSaldoFullTime() < 9 ? "     +" : "    +";
		
		String retorno =  ObtemNomePadronizado(time.getNome(), fgAdicionaEspacosInicioNome) + "    "
							+ time.getTotalDePartidasJogadas() + separadorVitoriasEmCasa
							+ time.getTotalVitoriasEmCasaFullTime()  + separadorPosVitoriasEmCasa  
							+ time.getTotalEmpatesEmCasaFullTime() + separadorDerrotasEmCasa
							+ time.getTotalDerrotaEmCasaFullTime() + separadorGolsMarcadosEmCasa 
							+ time.getTotalGolsMarcadosEmCasaFullTime() + ":"
							+ time.getTotalGolsSofridosEmCasaFullTime() + separadorVitoriasForaCasa 
							+ time.getTotalVitoriasForaDeCasaFullTime() + "  " 
							+ time.getTotalEmpatesForaDeCasaFullTime() + separadorDerrotasForaCasa
							+ time.getTotalDerrotaForaDeCasaFullTime() + separadorGolsMarcadosForaCasa
							+ time.getTotalGolsMarcadosForaDeCasaFullTime() + ":"
							+ time.getTotalGolsSofridosForaDeCasaFullTime() + separadorGolsSofridosForaCasa + separadorGolsTotal
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
		String separadorGolsSofridosForaCasa = time.getTotalGolsSofridosForaDeCasaHalfTime() > 9 ? "" : " ";
		String separadorGolsTotal = time.getTotalGolsMarcadosEmCasaHalfTime() > 99  ? "           " : "            ";
		String separadorGolsMarcadosEmCasa = time.getTotalGolsMarcadosEmCasaHalfTime() > 9 ? "  " : "   " ;
		String separadorGolsMarcadosForaCasa = time.getTotalGolsMarcadosForaDeCasaHalfTime() > 9 ? "  " : "   " ;
		String separadorSaldoGols = time.getSaldoHalfTime() == 0 ? "      " : time.getSaldoHalfTime() < 0 ?  time.getSaldoHalfTime() > -10 ? "     " : "    "   : time.getSaldoHalfTime() <= 9 ? "     +" : "    +";
		
		String retorno =  ObtemNomePadronizado(time.getNome(), fgAdicionaEspacosInicioNome) + "    "
							+ time.getTotalDePartidasJogadas() + separadorVitoriasEmCasa
							+ time.getTotalVitoriasEmCasaHalfTime()  + separadorPosVitoriasEmCasa  
							+ time.getTotalEmpatesEmCasaHalfTime() + separadorDerrotasEmCasa
							+ time.getTotalDerrotaEmCasaHalfTime() + separadorGolsMarcadosEmCasa
							+ time.getTotalGolsMarcadosEmCasaHalfTime() + ":"
							+ time.getTotalGolsSofridosEmCasaHalfTime() + separadorVitoriasForaCasa 
							+ time.getTotalVitoriasForaDeCasaHalfTime() + "  " 
							+ time.getTotalEmpatesForaDeCasaHalfTime() + separadorDerrotasForaCasa
							+ time.getTotalDerrotaForaDeCasaHalfTime() + separadorGolsMarcadosForaCasa
							+ time.getTotalGolsMarcadosForaDeCasaHalfTime() + ":"
							+ time.getTotalGolsSofridosForaDeCasaHalfTime() + separadorGolsSofridosForaCasa + separadorGolsTotal
							+ time.getTotalGolsMarcadosHalfTime() + ":"
							+ time.getTotalGolsSofridosHalfTime() + separadorSaldoGols
							+ time.getSaldoHalfTime() + "     "
							+ time.getPontuacaoHalfTime();
		
		return retorno;
	}
	
	public static void exibeESalvaClassificacaoFullTime(Hash tabelaTimes){
		ObjetoOrdenado[] listaTotalDePontosFullTime = new ObjetoOrdenado[20];
		ObjetoOrdenado[] listaTotalDePontosHalfTime = new ObjetoOrdenado[20];
		Times[] timesLiga = Times.values();
		
		for(Times timeAtual : timesLiga){
			InfoTime time = tabelaTimes.busca(timeAtual.getNome());
			
			ObjetoOrdenado novo = new ObjetoOrdenado();
			novo.setPropriedadeOrdenada(time.getPontuacaoFullTime());
			novo.setTime(time);
			
			ObjetoOrdenado novoHalfTime = new ObjetoOrdenado();
			novoHalfTime.setPropriedadeOrdenada(time.getPontuacaoHalfTime());
			novoHalfTime.setTime(time);
			
			listaTotalDePontosFullTime[timeAtual.getIndice()] = novo;
			listaTotalDePontosHalfTime[timeAtual.getIndice()] = novoHalfTime;
		}
		
		ObjetoOrdenado[] maxHeapFullTime = HeapSort.HeapSort(listaTotalDePontosFullTime);
		AjusteClassificacaoFullTime(maxHeapFullTime);
		ObjetoOrdenado[] maxHeapHalfTime = HeapSort.HeapSort(listaTotalDePontosHalfTime);
		AjusteClassificacaoHalfTime(maxHeapHalfTime);
		String conteudoMaxHeapFullTime = "";
		String conteudoMaxHeapHalfTime = "";
		
		
		String cabecalho = "                           - Home -                   - Away -                    - Total -      \n";
		cabecalho       += "                      Pld   W  D  L   F:A           W  D  L   F:A              F:A     +/-    Pts\n";
				
		String separadorInicial = " ";
		int indice = 1;
		for(int i = maxHeapFullTime.length - 1; i >= 0 ; i--){
			separadorInicial = indice > 9 ? "" : " ";
			InfoTime time = maxHeapFullTime[i].getTime();
			
			String inicioLinha = separadorInicial + indice + ". ";
			conteudoMaxHeapFullTime += inicioLinha + ObtemLinhaExibicaoTimeFullTime(time, false) + "\n";
			
			indice++;
		}
		indice = 1;
		for(int i = maxHeapHalfTime.length - 1; i >= 0 ; i--){
			separadorInicial = indice > 9 ? "" : " ";
			InfoTime time = maxHeapHalfTime[i].getTime();
			
			String inicioLinha = separadorInicial + indice + ". ";
			conteudoMaxHeapHalfTime += inicioLinha + ObtemLinhaExibicaoTimeHalfTime(time, false) + "\n";
			indice++;
		}
		System.out.println(cabecalho + conteudoMaxHeapFullTime);
		Arquivo.SalvarArquivo("fixture.txt", cabecalho + conteudoMaxHeapFullTime);
		Arquivo.SalvarArquivo("fixture_ht.txt", cabecalho + conteudoMaxHeapHalfTime);
	}
	
	private static void AjusteClassificacaoFullTime(ObjetoOrdenado[] classificacao){
		int indice = classificacao.length - 1;
		while(indice > 0){
			if(classificacao[indice].getPropriedadeOrdenada() == classificacao[indice - 1].getPropriedadeOrdenada()){
				InfoTime timeAtual = classificacao[indice].getTime();
				InfoTime proximoTime = classificacao[indice - 1].getTime();
				if(timeAtual.getSaldoFullTime() < proximoTime.getSaldoFullTime()){
					ObjetoOrdenado atual = classificacao[indice];
					classificacao[indice] = classificacao[indice - 1];
					classificacao[indice - 1] = atual;
				}
			}
			indice--;
		}
	}
	private static void AjusteClassificacaoHalfTime(ObjetoOrdenado[] classificacao){
		int indice = classificacao.length - 1;
		while(indice > 0){
			if(classificacao[indice].getPropriedadeOrdenada() == classificacao[indice - 1].getPropriedadeOrdenada()){
				InfoTime timeAtual = classificacao[indice].getTime();
				InfoTime proximoTime = classificacao[indice - 1].getTime();
				if(timeAtual.getSaldoHalfTime() < proximoTime.getSaldoHalfTime()){
					ObjetoOrdenado atual = classificacao[indice];
					classificacao[indice] = classificacao[indice - 1];
					classificacao[indice - 1] = atual;
				}
			}
			indice--;
		}
	}
}
