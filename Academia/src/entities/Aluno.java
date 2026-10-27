package entities;

public class Aluno {

	private String nome;
	private int id;
	private Plano plano;


	public Aluno(String nome, int id, Plano plano) {
		this.nome = nome;
		this.id = id;
		this.plano = plano;
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	public double aplicarDesconto(double porcentagem) {
		double valor = plano.setPreco(plano.getPreco() - (plano.getPreco() * (porcentagem / 100)));
		return valor;
	}

	@Override
	public String toString() {
		return "ID: " + id + " || Nome: " + nome + " || " + plano;
	}
}
