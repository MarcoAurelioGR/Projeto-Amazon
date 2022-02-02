public class Cliente extends Pessoa {

	private String email;
	private String senha;
	private TipoCliente tipo = new TipoCliente();

	public Cliente() {

		setNome("null");
		setCpf("null");
		setCidade("null");
		setRua("null");
		setNumero(0);
		setLogin(false);
		this.email = "null";
		this.senha = "null";

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoNome() {
		return tipo.getNome();
	}

	public void setTipoNome(String nomeTipo) {
		this.tipo.setNome(nomeTipo);
	}

	public int getTipoDesconto() {
		return tipo.getDesconto();
	}

	public void setTipoDesconto(int desconto) {
		this.tipo.setDesconto(desconto);
	}

}
