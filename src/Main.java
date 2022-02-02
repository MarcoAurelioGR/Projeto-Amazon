public class Main {

	public static void main(String[] args) {
		
		Produto[] produtos = new Produto[6];

		for (int i = 0; i < produtos.length; i++)
			produtos[i] = new Produto();

		produtos[0].setNome("As Cronicas de Gelo e Fogo");
		produtos[0].setCaracteristica(
				"Autor: George R. R. Martin; 1 Edição; Editora: Suma; Idioma: Português; N de Paginas: 600");
		produtos[0].setPreco(39.99);

		produtos[1].setNome("Notebook Dell G3          ");
		produtos[1].setCaracteristica(
				"Notebook Dell G3; Processador: i5 8 geracao; Placa de Video: GTX 1080; RAM: 8 GB; SSD: 256 GB; Sem HD");
		produtos[1].setPreco(2999.99);

		produtos[2].setNome("Notebook Dell G5          ");
		produtos[2].setCaracteristica(
				"Notebook Dell G5; Processador: i5 9 geracao; Placa de Video: GTX 1650; RAM: 8 GB; SSD: 512 GB; Sem HD");
		produtos[2].setPreco(5999.99);

		produtos[3].setNome("Notebook Dell G7          ");
		produtos[3].setCaracteristica(
				"Notebook Dell G7; Processador: i9 9 geracao; Placa de Video: RTX 3060; RAM: 16 GB; SSD: 512 GB; HD: 1T");
		produtos[3].setPreco(6999.99);

		produtos[4].setNome("Cacho Bananas             ");
		produtos[4].setCaracteristica("Cacho de Bananas com 10 Bananas.");
		produtos[4].setPreco(5.99);

		produtos[5].setNome("Cacho Uvas                ");
		produtos[5].setCaracteristica("Cacho de Uvas com 30 Uvas");
		produtos[5].setPreco(6.99);

		Cliente[] clientes = new Cliente[4];
		
		for (int i = 0; i < clientes.length; i++)
			clientes[i] = new Cliente();

		clientes[0].setNome("Jubileu Litorano");
		clientes[0].setCpf("00000000000");
		clientes[0].setCidade("Tubatao");
		clientes[0].setRua("Lisboa");
		clientes[0].setNumero(410);
		clientes[0].setLogin(false);
		clientes[0].setTipoNome("GOLD");
		clientes[0].setTipoDesconto(20);
		clientes[0].setEmail("jubileu@litorano.com");
		clientes[0].setSenha("jubileugold");

		clientes[1].setNome("Fulano Litorano");
		clientes[1].setCpf("11111111111");
		clientes[1].setCidade("Tubatao");
		clientes[1].setRua("Barcelona");
		clientes[1].setNumero(305);
		clientes[1].setLogin(false);
		clientes[1].setTipoNome("PLATINUM");
		clientes[1].setTipoDesconto(40);
		clientes[1].setEmail("fulano@litorano.com");
		clientes[1].setSenha("fulanoplatinum");

		clientes[2].setNome("Ciclano Litorano");
		clientes[2].setCpf("22222222222");
		clientes[2].setCidade("Tubatao");
		clientes[2].setRua("Rua Principal");
		clientes[2].setNumero(205);
		clientes[2].setLogin(false);
		clientes[2].setTipoNome("BLACK");
		clientes[2].setTipoDesconto(60);
		clientes[2].setEmail("ciclano@litorano.com");
		clientes[2].setSenha("ciclanoblack");
		
		Pessoa usuario = new Pessoa();
		
		usuario.Interface(produtos, clientes);
		
		// §GR
	}

}
