// Nós (Aline, Jonatan, Gabriel), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

package src;

public class Hash 
{
	private InfoTime[] tabelaHash = new InfoTime[20];
	
	
	public void Insere(InfoTime time)
	{
		int posicao = HashFunction(time.Nome);
		tabelaHash[posicao] = time;
	}
	
	public InfoTime Remove(String nomeTime)
	{
		int posicao = HashFunction(nomeTime);
		InfoTime timeExcluido = tabelaHash[posicao];
		tabelaHash[posicao] = null;
		return timeExcluido;
	}
	
	public InfoTime Busca(String nomeTime)
	{
		int posicao = HashFunction(nomeTime);
		return tabelaHash[posicao];
	}
	
	private int HashFunction(String nomeTime)
	{
		return Times.BuscaChave(nomeTime);
	}
}
