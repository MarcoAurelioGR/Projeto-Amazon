
public class TipoCliente {

	private String nome;
	private int desconto;
	
	public TipoCliente() {

		this.nome = "Comum";
		this.desconto = 0;
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	
}
