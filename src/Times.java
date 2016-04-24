// Nós (Aline, Jonatan, Gabriel), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.


public enum Times 
{
	Arsenal(0, "Arsenal"),
	AstonVilla(1, "Aston Villa"),
	Liverpool(2, "Liverpool"),
	Stoke(3, "Stoke"),
	Norwich(4, "Norwich"),
	Everton(5, "Everton"),
	Sunderland(6, "Sunderland"),
	Fulham(7, "Fulham"),
	Swansea(8, "Swansea"),
	ManUnited(9, "Man United"),
	WestBrom(10, "West Brom"),
	Southampton(11, "Southampton"),
	WestHam(12, "West Ham"),
	Cardiff(13, "Cardiff"),
	Chelsea(14, "Chelsea"),
	Hull(15, "Hull"),
	CrystalPalace(16, "Crystal Palace"),
	Tottenham(17, "Tottenham"),
	ManCity(18, "Man City"),
	Newcastle(19, "Newcastle");
	
	private String Nome;
	private int indice;
	
	Times(int indice, String nome) 
	{ 
		this.indice = indice; 
		this.Nome = nome; 
	}

    int getIndice() { return indice; }
    String getNome() { return Nome; }
    
    
	public static int BuscaChave(String nome)
	{
		for (Times time: Times.values()) {
            if (nome.equalsIgnoreCase(time.Nome)) return time.indice;
        }
        throw new IllegalArgumentException("Time inválido");
	}
}
