// Nós (Aline, Jonatan, Gabriel), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código privateado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

public class InfoTime {
	
	private String nome;
	private String leagueDivision;
	private int totalPartidasJogadas;
	
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
	
	private int totalDePontos;
	
	public void derrota() {
		totalDePontos = totalDePontos + 0;
	}
	
	public void empate() {
		totalDePontos = totalDePontos + 1;
	}
	
	public void vitoria() {
		totalDePontos = totalDePontos + 3;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLeagueDivision() {
		return leagueDivision;
	}

	public void setLeagueDivision(String leagueDivision) {
		this.leagueDivision = leagueDivision;
	}

	public int getTotalPartidasJogadas() {
		return totalPartidasJogadas;
	}

	public void setTotalPartidasJogadas(int totalPartidasJogadas) {
		this.totalPartidasJogadas = totalPartidasJogadas;
	}

	public int getTotalVitoriasEmCasaFullTime() {
		return totalVitoriasEmCasaFullTime;
	}

	public void setTotalVitoriasEmCasaFullTime(int totalVitoriasEmCasaFullTime) {
		this.totalVitoriasEmCasaFullTime = totalVitoriasEmCasaFullTime;
	}

	public int getTotalVitoriasEmCasaHalfTime() {
		return totalVitoriasEmCasaHalfTime;
	}

	public void setTotalVitoriasEmCasaHalfTime(int totalVitoriasEmCasaHalfTime) {
		this.totalVitoriasEmCasaHalfTime = totalVitoriasEmCasaHalfTime;
	}

	public int getTotalDerrotasEmCasaFullTime() {
		return totalDerrotasEmCasaFullTime;
	}

	public void setTotalDerrotasEmCasaFullTime(int totalDerrotasEmCasaFullTime) {
		this.totalDerrotasEmCasaFullTime = totalDerrotasEmCasaFullTime;
	}

	public int getTotalDerrotasEmCasaHalfTime() {
		return totalDerrotasEmCasaHalfTime;
	}

	public void setTotalDerrotasEmCasaHalfTime(int totalDerrotasEmCasaHalfTime) {
		this.totalDerrotasEmCasaHalfTime = totalDerrotasEmCasaHalfTime;
	}

	public int getTotalEmpatesEmCasaFullTime() {
		return totalEmpatesEmCasaFullTime;
	}

	public void setTotalEmpatesEmCasaFullTime(int totalEmpatesEmCasaFullTime) {
		this.totalEmpatesEmCasaFullTime = totalEmpatesEmCasaFullTime;
	}

	public int getTotalEmpatesEmCasaHalfTime() {
		return totalEmpatesEmCasaHalfTime;
	}

	public void setTotalEmpatesEmCasaHalfTime(int totalEmpatesEmCasaHalfTime) {
		this.totalEmpatesEmCasaHalfTime = totalEmpatesEmCasaHalfTime;
	}

	public int getTotalGolsFeitosEmCasaFullTime() {
		return totalGolsFeitosEmCasaFullTime;
	}

	public void setTotalGolsFeitosEmCasaFullTime(int totalGolsFeitosEmCasaFullTime) {
		this.totalGolsFeitosEmCasaFullTime = totalGolsFeitosEmCasaFullTime;
	}

	public int getTotalGolsFeitosEmCasaHalfTime() {
		return totalGolsFeitosEmCasaHalfTime;
	}

	public void setTotalGolsFeitosEmCasaHalfTime(int totalGolsFeitosEmCasaHalfTime) {
		this.totalGolsFeitosEmCasaHalfTime = totalGolsFeitosEmCasaHalfTime;
	}

	public int getTotalGolsSofridosEmCasaFullTime() {
		return totalGolsSofridosEmCasaFullTime;
	}

	public void setTotalGolsSofridosEmCasaFullTime(int totalGolsSofridosEmCasaFullTime) {
		this.totalGolsSofridosEmCasaFullTime = totalGolsSofridosEmCasaFullTime;
	}

	public int getTotalGolsSofridosEmCasaHalfTime() {
		return totalGolsSofridosEmCasaHalfTime;
	}

	public void setTotalGolsSofridosEmCasaHalfTime(int totalGolsSofridosEmCasaHalfTime) {
		this.totalGolsSofridosEmCasaHalfTime = totalGolsSofridosEmCasaHalfTime;
	}

	public int getTotalVitoriasForaDeCasaFullTime() {
		return totalVitoriasForaDeCasaFullTime;
	}

	public void setTotalVitoriasForaDeCasaFullTime(int totalVitoriasForaDeCasaFullTime) {
		this.totalVitoriasForaDeCasaFullTime = totalVitoriasForaDeCasaFullTime;
	}

	public int getTotalVitoriasForaDeCasaHalfTime() {
		return totalVitoriasForaDeCasaHalfTime;
	}

	public void setTotalVitoriasForaDeCasaHalfTime(int totalVitoriasForaDeCasaHalfTime) {
		this.totalVitoriasForaDeCasaHalfTime = totalVitoriasForaDeCasaHalfTime;
	}

	public int getTotalDerrotasForaDeCasaFullTime() {
		return totalDerrotasForaDeCasaFullTime;
	}

	public void setTotalDerrotasForaDeCasaFullTime(int totalDerrotasForaDeCasaFullTime) {
		this.totalDerrotasForaDeCasaFullTime = totalDerrotasForaDeCasaFullTime;
	}

	public int getTotalDerrotasForaDeCasaHalfTime() {
		return totalDerrotasForaDeCasaHalfTime;
	}

	public void setTotalDerrotasForaDeCasaHalfTime(int totalDerrotasForaDeCasaHalfTime) {
		this.totalDerrotasForaDeCasaHalfTime = totalDerrotasForaDeCasaHalfTime;
	}

	public int getTotalEmpatesForaDeCasaFullTime() {
		return totalEmpatesForaDeCasaFullTime;
	}

	public void setTotalEmpatesForaDeCasaFullTime(int totalEmpatesForaDeCasaFullTime) {
		this.totalEmpatesForaDeCasaFullTime = totalEmpatesForaDeCasaFullTime;
	}

	public int getTotalEmpatesForaDeCasaHalfTime() {
		return totalEmpatesForaDeCasaHalfTime;
	}

	public void setTotalEmpatesForaDeCasaHalfTime(int totalEmpatesForaDeCasaHalfTime) {
		this.totalEmpatesForaDeCasaHalfTime = totalEmpatesForaDeCasaHalfTime;
	}

	public int getTotalGolsFeitosForaDeCasaFullTime() {
		return totalGolsFeitosForaDeCasaFullTime;
	}

	public void setTotalGolsFeitosForaDeCasaFullTime(int totalGolsFeitosForaDeCasaFullTime) {
		this.totalGolsFeitosForaDeCasaFullTime = totalGolsFeitosForaDeCasaFullTime;
	}

	public int getTotalGolsFeitosForaDeCasaHalfTime() {
		return totalGolsFeitosForaDeCasaHalfTime;
	}

	public void setTotalGolsFeitosForaDeCasaHalfTime(int totalGolsFeitosForaDeCasaHalfTime) {
		this.totalGolsFeitosForaDeCasaHalfTime = totalGolsFeitosForaDeCasaHalfTime;
	}

	public int getTotalGolsSofridosForaDeCasaFullTime() {
		return totalGolsSofridosForaDeCasaFullTime;
	}

	public void setTotalGolsSofridosForaDeCasaFullTime(int totalGolsSofridosForaDeCasaFullTime) {
		this.totalGolsSofridosForaDeCasaFullTime = totalGolsSofridosForaDeCasaFullTime;
	}

	public int getTotalGolsSofridosForaDeCasaHalfTime() {
		return totalGolsSofridosForaDeCasaHalfTime;
	}

	public void setTotalGolsSofridosForaDeCasaHalfTime(int totalGolsSofridosForaDeCasaHalfTime) {
		this.totalGolsSofridosForaDeCasaHalfTime = totalGolsSofridosForaDeCasaHalfTime;
	}

	public int getTotalDePontos() {
		return totalDePontos;
	}

	public void setTotalDePontos(int totalDePontos) {
		this.totalDePontos = totalDePontos;
	}
	
}
