
public class Estatisticas {
	public static void exibeTime(InfoTime time){
		String separadorVitoriasEmCasa = time.getTotalVitoriasEmCasaFullTime() > 9 ? "   " : "    ";
		String separadorPosVitoriasEmCasa = time.getTotalVitoriasEmCasaFullTime() > 9 ? "  " : "  ";
		String separadorDerrotasEmCasa = time.getTotalDerrotaEmCasaFullTime() > 9 ? " " : "  ";
		String separadorVitoriasForaCasa = time.getTotalVitoriasForaDeCasaFullTime() > 9 ?"         " : "          ";
		String separadorDerrotasForaCasa = time.getTotalDerrotaForaDeCasaFullTime() > 9 ? " " : "  ";
		
		System.out.println("                       - Home -		           - Away -		      - Total -");
		System.out.println("                  Pld   W  D  L   F:A           W  D  L   F:A              F:A     +/-   Pts");
		System.out.println(ObtemNomePadronizado(time.nome) + "    "
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
							+ time.getTotalGolsSofridosForaDeCasaFullTime() + "            "
							+ time.getTotalGolsMarcadosFullTime() + ":"
							+ time.getTotalGolsSofridosFullTime() + "    "
							+ time.getSaldoFullTime() + "     "
							+ time.getPontuacaoFullTime());
		
	}
	
	private static String ObtemNomePadronizado(String nomeTime){
		String separador = " ";
		while(nomeTime.length() < 14){
			nomeTime = separador + nomeTime;
		}
		return nomeTime;
	}
}
