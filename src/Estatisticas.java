import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Nós (Aline, Jonatan, Gabriel), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

public class Estatisticas {
	private InfoTime time;
	
	public Estatisticas(InfoTime time){
		this.time = time;
	}
	
	public Estatisticas(){
		this.time = null;
	}
	
	public InfoTime getTime() {
		return time;
	}

	public void setTime(InfoTime time) {
		this.time = time;
	}

	public void exibeTime(){
		System.out.println(ObtemLinhaExibicaoTimeFullTime(true));
	}

	public void exibeESalvaClassificacaoFullTime(Hash tabelaTimes){
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
		
		HeapSort heapFullTime = new HeapSort(new MaxHeap());
		heapFullTime.HeapSortOrdenacao(listaTotalDePontosFullTime);
		ObjetoOrdenado[] maxHeapFullTime = heapFullTime.getHeap();
		AjusteClassificacaoFullTime(maxHeapFullTime);
		
		HeapSort heapHalfTime = new HeapSort(new MaxHeap());
		heapHalfTime.HeapSortOrdenacao(listaTotalDePontosHalfTime);
		ObjetoOrdenado[] maxHeapHalfTime = heapHalfTime.getHeap();
		AjusteClassificacaoHalfTime(maxHeapHalfTime);
		
		String conteudoMaxHeapFullTime = "";
		String conteudoMaxHeapHalfTime = "";
		
		
		String cabecalho = "                           - Home -                   - Away -                    - Total -      \n";
		cabecalho       += "                      Pld   W  D  L   F:A           W  D  L   F:A              F:A     +/-    Pts\n";
				
		String separadorInicial = " ";
		int indice = 1;
		for(int i = maxHeapFullTime.length - 1; i >= 0 ; i--){
			separadorInicial = indice > 9 ? "" : " ";
			
			setTime(maxHeapFullTime[i].getTime());
			
			String inicioLinha = separadorInicial + indice + ". ";
			conteudoMaxHeapFullTime += inicioLinha + ObtemLinhaExibicaoTimeFullTime(false) + "\n";
			
			indice++;
		}
		indice = 1;
		for(int i = maxHeapHalfTime.length - 1; i >= 0 ; i--){
			separadorInicial = indice > 9 ? "" : " ";
			setTime(maxHeapHalfTime[i].getTime());
			
			String inicioLinha = separadorInicial + indice + ". ";
			conteudoMaxHeapHalfTime += inicioLinha + ObtemLinhaExibicaoTimeHalfTime(false) + "\n";
			indice++;
		}
		System.out.println(cabecalho + conteudoMaxHeapFullTime);
		Arquivo.SalvarArquivo("fixture.txt", cabecalho + conteudoMaxHeapFullTime);
		Arquivo.SalvarArquivo("fixture_ht.txt", cabecalho + conteudoMaxHeapHalfTime);
	}
	
	public void exibeESalvaMenorPerdedor(Hash tabelaTimes){	
		ObjetoOrdenado[] listaTimesPorDerrotas = ObtemListaTimesPorTotalDerrotas(tabelaTimes);
		
		HeapSort heapDerrotas = new HeapSort(new MinHeap());
		heapDerrotas.HeapSortOrdenacao(listaTimesPorDerrotas);
		ObjetoOrdenado[] minHeapDerrotas = heapDerrotas.getHeap();
		AjusteClassificacaoDerrotas(minHeapDerrotas);
		
		int indice = 19;
		boolean fgValorDiferente = false;
		String conteudoArquivo = "";
		while(!fgValorDiferente){
			InfoTime time = minHeapDerrotas[indice].getTime();
			if(minHeapDerrotas[19].getPropriedadeOrdenada() == minHeapDerrotas[indice].getPropriedadeOrdenada())
				conteudoArquivo += time.getNome() +", "+ (int)minHeapDerrotas[indice].getPropriedadeOrdenada() +"\n";
			else
				fgValorDiferente = true;
			indice--;
		}
		
		System.out.println(conteudoArquivo);
		Arquivo.SalvarArquivo("less_defeats.txt", conteudoArquivo);
	}
	
	public void exibeESalvaChutesGol(Hash tabelaTimes){
		ObjetoOrdenado[] classificacao = ObtemClassificacaoChutesGol(tabelaTimes);
		String conteudoArquivo = "";
		
		for(int i = 0; i < classificacao.length; i++) {
			conteudoArquivo += i + 1 + ". " + classificacao[i].getTime().getNome() + ", "
					+ String.format("%.5f", classificacao[i].getTime().getAproveitamentoChutes()) + " chutes a gol para cada gol. \n";
		}
		
		System.out.println(conteudoArquivo);
		Arquivo.SalvarArquivo("best_strikers.txt", conteudoArquivo);
	}
	
	private String ObtemNomePadronizado(String nomeTime, boolean fgAdicionaEspacosInicio){
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

	private void AjusteClassificacaoDerrotas(ObjetoOrdenado[] listaTimes){
		int indice = listaTimes.length - 1;
		while(indice > 0){
			if(listaTimes[indice].getPropriedadeOrdenada() == listaTimes[indice - 1].getPropriedadeOrdenada()){
				InfoTime timeAtual = listaTimes[indice].getTime();
				InfoTime proximoTime = listaTimes[indice - 1].getTime();
				if(timeAtual.getTotalDerrotaEmCasaFullTime() > proximoTime.getTotalDerrotaEmCasaFullTime()){
					ObjetoOrdenado atual = listaTimes[indice];
					listaTimes[indice] = listaTimes[indice - 1];
					listaTimes[indice - 1] = atual;
				}
			}
			indice--;
		}
	}
	
	private String ObtemLinhaExibicaoTimeFullTime(boolean fgAdicionaEspacosInicioNome){
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
	
	private String ObtemLinhaExibicaoTimeHalfTime(boolean fgAdicionaEspacosInicioNome){
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
	
	private ObjetoOrdenado[] ObtemListaTimesPorTotalDerrotas(Hash tabelaTimes){
		ObjetoOrdenado[] listaTotalDerrotas = new ObjetoOrdenado[20];
		Times[] timesLiga = Times.values();
		
		for(Times timeAtual : timesLiga){
			InfoTime time = tabelaTimes.busca(timeAtual.getNome());
			
			ObjetoOrdenado novo = new ObjetoOrdenado();
			int totalDerrotas = time.getTotalDerrotaEmCasaFullTime() + time.getTotalDerrotaForaDeCasaFullTime();
			novo.setPropriedadeOrdenada(totalDerrotas);
			novo.setTime(time);
									
			listaTotalDerrotas[timeAtual.getIndice()] = novo;
		}
		return listaTotalDerrotas;
	}
	
	private void AjusteClassificacaoFullTime(ObjetoOrdenado[] classificacao){
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
	private void AjusteClassificacaoHalfTime(ObjetoOrdenado[] classificacao){
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
		
	private ObjetoOrdenado[] ObtemClassificacaoChutesGol(Hash hash) {
		ObjetoOrdenado[] array = new ObjetoOrdenado[20];
		Times[] times = Times.values();
		
		for(Times timeAtual : times){
			InfoTime time = hash.busca(timeAtual.getNome());			
			ObjetoOrdenado novo = new ObjetoOrdenado();
			novo.setPropriedadeOrdenada(time.getAproveitamentoChutes());
			novo.setTime(time);
			array[timeAtual.getIndice()] = novo;
		}
		
		HeapSort heapChutesGol = new HeapSort(new MaxHeap());
		heapChutesGol.HeapSortOrdenacao(array);
		ObjetoOrdenado[] classificacao = heapChutesGol.getHeap();
		return classificacao;
	}
	
	public void printlnClassificacaoChutesGol(ObjetoOrdenado[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(i + 1 + ". " + array[i].getTime().getNome() + ", "
					+ array[i].getTime().getAproveitamentoChutes() + " chutes a gol para cada gol.");
		}
	}

    public void exibeSalvaTimeArtilheiro (Hash tabelaTimes)
    {
        ObjetoOrdenado[] listaTimesMarcadores = ObtemListaTimesMarcadores (tabelaTimes);
        HeapSort hMarcador = new HeapSort(new MaxHeap());
        hMarcador.HeapSortOrdenacao(listaTimesMarcadores);
        ObjetoOrdenado[] marcadores = hMarcador.getHeap();

        InfoTime time = marcadores[19].getTime();
        String conteudoArquivo = time.getNome() +", " + 
                                 (int)marcadores[19].getPropriedadeOrdenada();
        System.out.println(conteudoArquivo);
        Arquivo.SalvarArquivo("top_scorer.txt", conteudoArquivo);
    }
    private ObjetoOrdenado[] ObtemListaTimesMarcadores (Hash tabelaTimes)
    {
        ObjetoOrdenado[] lista = new ObjetoOrdenado [20];
        Times[] timesLiga = Times.values ();
        for (Times timeAtual : timesLiga)
        {
            InfoTime time = tabelaTimes.busca (timeAtual.getNome ());
            ObjetoOrdenado novo = new ObjetoOrdenado ();
            int gols = time.getTotalGolsMarcadosEmCasaFullTime () + 
                       time.getTotalGolsMarcadosForaDeCasaFullTime ();
            novo.setPropriedadeOrdenada (gols);
            novo.setTime(time);
            lista [timeAtual.getIndice ()] = novo;
        }
        return lista;
    }

    private void printMarcadores (ObjetoOrdenado[] om)
    {
        for (int i = 0; i < 20; i++)
        {
            InfoTime t = om[i].getTime ();
            System.out.println ("Time: " + t.getNome () +
                                " Gols marcados: " + (t.getTotalGolsMarcadosForaDeCasaFullTime() + 
                                                      t.getTotalGolsMarcadosEmCasaFullTime())
                               );
        }
    }
}
