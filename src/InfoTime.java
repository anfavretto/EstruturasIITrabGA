// Nós (Aline, Jonatan, Gabriel), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código privateado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

public class InfoTime 
{
	public String nome;
	public int totalPartidasJogadas;
	
	// Em Casa
	private int totalVitoriasEmCasaFullTime;
	private int totalVitoriasEmCasaHalfTime;
	private int totalDerrotasEmCasaFullTime;
	private int totalDerrotasEmCasaHalfTime;
	private int totalEmpatesEmCasaFullTime;
	private int totalEmpatesEmCasaHalfTime;
	private int totalGolsFeitosEmCasaFullTime;
	private int totalGolsFeitosEmCasaHalfTime;
	private int totalGolsSofridosEmCasaFullTime;
	private int totalGolsSofridosEmCasaHalfTime;
	
	//Fora de Casa
	private int totalVitoriasForaDeCasaFullTime;
	private int totalVitoriasForaDeCasaHalfTime;
	private int totalDerrotasForaDeCasaFullTime;
	private int totalDerrotasForaDeCasaHalfTime;
	private int totalEmpatesForaDeCasaFullTime;
	private int totalEmpatesForaDeCasaHalfTime;
	private int totalGolsFeitosForaDeCasaFullTime;
	private int totalGolsFeitosForaDeCasaHalfTime;
	private int totalGolsSofridosForaDeCasaFullTime;
	private int totalGolsSofridosForaDeCasaHalfTime;
	
	private int totalDePontosHalfTime;
	private int totalDePontosFullTime;
	private int totalChutesGol;
	private int aproveitamentoChutes;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void atualizaTotalDePartidasJogadas() {
		totalPartidasJogadas++;
	}
	
	public int getTotalDePartidasJogadas() {
		return totalPartidasJogadas;
	}
	
	public void setGolsMarcadosNaPartidaEmCasaHalfTime(int quantidade) {
		totalGolsFeitosEmCasaHalfTime = totalGolsFeitosEmCasaHalfTime + quantidade; 
	}
	
	public int getTotalGolsMarcadosEmCasaHalfTime() {
		return totalGolsFeitosEmCasaHalfTime;
	}
	
	public void setGolsMarcadosNaPartidaEmCasaFullTime(int quantidade) {
		totalGolsFeitosEmCasaFullTime = totalGolsFeitosEmCasaFullTime + quantidade;
	}
	
	public int getTotalGolsMarcadosEmCasaFullTime() {
		return totalGolsFeitosEmCasaFullTime;
	}
	
	public void setGolsSofridosNaPartidaEmCasaHalfTime(int quantidade) {
		totalGolsSofridosEmCasaHalfTime = totalGolsSofridosEmCasaHalfTime + quantidade;
	}
	
	public int getTotalGolsSofridosEmCasaHalfTime() {
		return totalGolsSofridosEmCasaHalfTime;
	}
	
	public void setGolsSofridosNaPartidaEmCasaFullTime(int quantidade) {
		totalGolsSofridosEmCasaFullTime = totalGolsSofridosEmCasaFullTime + quantidade;
	}
	
	public int getTotalGolsSofridosEmCasaFullTime() {
		return totalGolsSofridosEmCasaFullTime;
	}
	
	public void setGolsMarcadosNaPartidaForaDeCasaHalfTime(int quantidade) {
		totalGolsFeitosForaDeCasaHalfTime = totalGolsFeitosForaDeCasaHalfTime + quantidade; 
	}
	
	public int getTotalGolsMarcadosForaDeCasaHalfTime() {
		return totalGolsFeitosForaDeCasaHalfTime;
	}
	
	public void setGolsMarcadosNaPartidaForaDeCasaFullTime(int quantidade) {
		totalGolsFeitosForaDeCasaFullTime = totalGolsFeitosForaDeCasaFullTime + quantidade;
	}
	
	public int getTotalGolsMarcadosForaDeCasaFullTime() {
		return totalGolsFeitosForaDeCasaFullTime;
	}
	
	public void setGolsSofridosNaPartidaForaDeCasaHalfTime(int quantidade) {
		totalGolsSofridosForaDeCasaHalfTime = totalGolsSofridosForaDeCasaHalfTime + quantidade;
	}
	
	public int getTotalGolsSofridosForaDeCasaHalfTime() {
		return totalGolsSofridosForaDeCasaHalfTime;
	}
	
	public void setGolsSofridosNaPartidaForaDeCasaFullTime(int quantidade) {
		totalGolsSofridosForaDeCasaFullTime = totalGolsSofridosForaDeCasaFullTime + quantidade;
	}
	
	public int getTotalGolsSofridosForaDeCasaFullTime() {
		return totalGolsSofridosForaDeCasaFullTime;
	}
	
	public void addVitoriaEmCasaHalfTime() {
		totalVitoriasEmCasaHalfTime++;
	}
	
	public int getTotalVitoriasEmCasaHalfTime() {
		return totalVitoriasEmCasaHalfTime;
	}
	
	public void addVitoriaEmCasaFullTime() {
		totalVitoriasEmCasaFullTime++;
	}
	
	public int getTotalVitoriasEmCasaFullTime() {
		return totalVitoriasEmCasaFullTime;
	}
	
	public void addVitoriaForaDeCasaHalfTime() {
		totalVitoriasForaDeCasaHalfTime++;
	}
	
	public int getTotalVitoriasForaDeCasaHalfTime() {
		return totalVitoriasForaDeCasaHalfTime;
	}
	
	public void addVitoriaForaDeCasaFullTime() {
		totalVitoriasForaDeCasaFullTime++;
	}
	
	public int getTotalVitoriasForaDeCasaFullTime() {
		return totalVitoriasForaDeCasaFullTime;
	}
	
	public void addEmpateEmCasaHalfTime() {
		totalEmpatesEmCasaHalfTime++;
	}
	
	public int getTotalEmpatesEmCasaHalfTime() {
		return totalEmpatesEmCasaHalfTime;
	}
	
	public void addEmpateEmCasaFullTime() {
		totalEmpatesEmCasaFullTime++;
	}
	
	public int getTotalEmpatesEmCasaFullTime() {
		return totalEmpatesEmCasaFullTime;
	}
	
	public void addEmpateForaDeCasaHalfTime() {
		totalEmpatesForaDeCasaHalfTime++;
	}
	
	public int getTotalEmpatesForaDeCasaHalfTime() {
		return totalEmpatesForaDeCasaHalfTime;
	}
	
	public void addEmpateForaDeCasaFullTime() {
		totalEmpatesForaDeCasaFullTime++;
	}
	
	public int getTotalEmpatesForaDeCasaFullTime() {
		return totalEmpatesForaDeCasaFullTime;
	}
	
	public void addDerrotaEmCasaHalfTime() {
		totalDerrotasEmCasaHalfTime++;
	}
	
	public int getTotalDerrotaEmCasaHalfTime() {
		return totalDerrotasEmCasaHalfTime;
	}
	
	public void addDerrotaEmCasaFullTime() {
		totalDerrotasEmCasaFullTime++;
	}
	
	public int getTotalDerrotaEmCasaFullTime() {
		return totalDerrotasEmCasaFullTime;
	}
	
	public void addDerrotaForaDeCasaHalfTime() {
		totalDerrotasForaDeCasaHalfTime++;
	}
	
	public int getTotalDerrotaForaDeCasaHalfTime() {
		return totalDerrotasForaDeCasaHalfTime;
	}
	
	public void addDerrotaForaDeCasaFullTime() {
		totalDerrotasForaDeCasaFullTime++;
	}
	
	public int getTotalDerrotaForaDeCasaFullTime() {
		return totalDerrotasForaDeCasaFullTime;
	}
	
	public void setPontosDerrotaFullTime() {
		totalDePontosFullTime = totalDePontosFullTime + 0;
	}
	
	public void setPontosEmpateFullTime() {
		totalDePontosFullTime = totalDePontosFullTime + 1;
	}
	
	public void setPontosVitoriaFullTime() {
		totalDePontosFullTime = totalDePontosFullTime + 3;
	}
	
	public void setPontosDerrotaHalfTime() {
		totalDePontosHalfTime = totalDePontosHalfTime + 0;
	}
	
	public void setPontosEmpateHalfTime() {
		totalDePontosHalfTime = totalDePontosHalfTime + 1;
	}
	
	public void setPontosVitoriaHalfTime() {
		totalDePontosHalfTime = totalDePontosHalfTime + 3;
	}
	
	public int getPontuacaoFullTime() {
		return totalDePontosFullTime;
	}
	public int getPontuacaoHalfTime() {
		return totalDePontosHalfTime;
	}	
	
	public int getTotalGolsMarcadosFullTime() {
		int golsPro = totalGolsFeitosEmCasaFullTime + totalGolsFeitosForaDeCasaFullTime;
		return golsPro;
	}
	
	public int getTotalGolsMarcadosHalfTime() {
		int golsPro = totalGolsFeitosEmCasaHalfTime + totalGolsFeitosForaDeCasaHalfTime;
		return golsPro;
	}
	
	public int getTotalGolsSofridosFullTime() {
		int golsContra = totalGolsSofridosEmCasaFullTime + totalGolsSofridosForaDeCasaFullTime;
		return golsContra;
	}
	
	public int getTotalGolsSofridosHalfTime() {
		int golsContra = totalGolsSofridosEmCasaHalfTime + totalGolsSofridosForaDeCasaHalfTime;
		return golsContra;
	}
	
	public int getSaldoFullTime() {
		int saldo = getTotalGolsMarcadosFullTime() - getTotalGolsSofridosFullTime();
		return saldo;
	}
	
	public int getSaldoHalfTime() {
		int saldo = getTotalGolsMarcadosHalfTime() - getTotalGolsSofridosHalfTime();
		return saldo;
	}
	
	public void setTotalChutesGol(int chutes) {
		totalChutesGol = totalChutesGol + chutes;
	}
	
	public int getTotalChutesGol() {
		return totalChutesGol;
	}
	
	public void setAproveitamentoChutes() {
		aproveitamentoChutes = (totalChutesGol / getTotalGolsMarcadosFullTime()) + 1;
	}
	
	public int getAproveitamentoChutes() {
		return aproveitamentoChutes;
	}
}
