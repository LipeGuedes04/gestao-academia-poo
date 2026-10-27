package entities;

public class Plano {

	private String nome;
	private double preco;
	private boolean areaVip;

	public Plano(String nome, double preco, boolean areaVip) {
		this.nome = nome;
		this.preco = preco;
		this.areaVip = areaVip;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public double setPreco(double preco) {
		this.preco = preco;
		return preco;
	}

	public boolean isAreaVip() {
		return areaVip;
	}

	public String toString() {
		return "Plano: " + nome + " || Valor: " + preco + " || Vip: " + areaVip;

	}

}
