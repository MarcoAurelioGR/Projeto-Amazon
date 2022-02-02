import java.util.Random;

public class Produto {

	private int numAux;
	public String nome;
	public String caracteristica;
	public double preco;
	
	public Produto() {
		
		Produto[] produtos = new Produto[6];

		this.numAux = new Random().nextInt((1000 - 100) + 1) + 100;
		this.nome = null;
		this.caracteristica = null;
		this.preco = 0.0;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getNumAux() {
		return numAux;
	}

}
