// Nós (Aline, Jonatan, Gabriel), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.


public class Hash 
{
	private InfoTime[] tabelaHash = new InfoTime[20];
	
	
	public void add(InfoTime time)
	{
		int posicao = hashFunction(time.getNome());
		tabelaHash[posicao] = time;
	}
	
	public InfoTime remove(String nomeTime)
	{
		int posicao = hashFunction(nomeTime);
		InfoTime timeExcluido = tabelaHash[posicao];
		tabelaHash[posicao] = null;
		return timeExcluido;
	}
	
	public InfoTime busca(String nomeTime)
	{
		int posicao = hashFunction(nomeTime);
		if(tabelaHash[posicao] == null) {
			return null;
		} else {
			return tabelaHash[posicao];
		}
	}
	
	private int hashFunction(String nomeTime)
	{
		return Times.BuscaChave(nomeTime);
	}
}
