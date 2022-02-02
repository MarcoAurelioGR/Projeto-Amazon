import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Pessoa implements Usuario {

	private String nome;
	private String cpf;
	private String cidade;
	private String rua;
	private int numero;
	private boolean login;

	public Pessoa() {

		this.nome = null;
		this.cpf = null;
		this.cidade = null;
		this.rua = null;
		this.numero = 0;
		this.login = false;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean getLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}
	 
	protected int Login(Cliente[] clientes){

		int keyCliente = 0;
		int opc = 0;

		while (clientes[keyCliente].getLogin() != true) {

			try {
				System.out.println("1 - Entrar");
				System.out.println("2 - Cadastrar");
				System.out.print("Informe: ");
				opc = new Scanner(System.in).nextInt();

				switch (opc) {
				case 1:
					keyCliente = Entrar(clientes);
					break;
				case 2:
					Registrar(clientes);
					break;

				default:
					System.out.println("\n\nERRO: Informe 1 para Entrar ou 2 para se Cadastrar\n\n");
					break;
				}
			} catch (InputMismatchException e) {

				System.out.println("\n\nERRO: Informe 1 para Entrar ou 2 para se Cadastrar\n\n");

			}
		}

		return keyCliente;
	}

	protected Produto[] Comprar(int produto, Produto[] armazem, Cliente[] clientes) {

		int opc = 5;
		int keyCliente = Login(clientes);


		DecimalFormat df = new DecimalFormat("0.00");

		do {
			try {

				System.out.println("\nPre�o: R$"
						+ df.format(armazem[produto].getPreco()
								- (armazem[produto].getPreco() * clientes[keyCliente].getTipoDesconto() / 100.00))
						+ "\n" + armazem[produto].getCaracteristica());

				System.out.println("\nCliente: " + clientes[keyCliente].getNome() + "           Tipo: "
						+ clientes[keyCliente].getTipoNome());
				System.out.println("Cidade: " + clientes[keyCliente].getCidade() + "            Rua: "
						+ clientes[keyCliente].getRua() + "           Numero: " + clientes[keyCliente].getNumero());

				System.out.print("\nPara Ver os Descontos Informe 3:");
				System.out.print("\nInforme 1 para CONFIRMAR ou 0 para VOLTAR: ");
				opc = new Scanner(System.in).nextInt();
				System.out.println();

			} catch (InputMismatchException e) {

			}

			if (opc != 1 && opc != 0 && opc != 3)
				System.out.println("\n\nERRO: Informe 1 para CONFIRMAR ou 0 para VOLTAR. \n\n");

			if (opc == 3) {
				clientes = NovoTipoCliente(clientes, keyCliente);
				opc = 0;
			}
		} while (opc != 1 && opc != 0);

		if (opc == 1) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPROTOCOLO: 2021" + armazem[produto].getNumAux()
					+ produto + "\n\nOBRIGADO PELA PREFERENCIA!!\n\n\n");

			armazem[produto] = new Produto(); // Excluir Produto do ARMAZEM
		}
		return armazem;

	}

	private int Entrar(Cliente[] clientes) {

		String email = "vazio", senha = "vazio";
		int keyCliente = 0;
		boolean validade = false;

		while (validade == false) {

			try {
				System.out.println("\nINFORME UM USUARIO");
				System.out.print("E-mail: ");
				email = new Scanner(System.in).next();

				System.out.print("Senha: ");
				senha = new Scanner(System.in).next();

			} catch (NoSuchElementException e) {

				validade = false;
			}
			for (int j = 0; j < clientes.length; j++) {
				if (clientes[j].getEmail().equals(email) && clientes[j].getSenha().equals(senha)) {
					keyCliente = j;
					validade = true;
					clientes[j].setLogin(true);
				}
			}

			if (validade == false)
				System.out.println("\nERRO: Informe um E-mail e Senha Validos.\n");

			System.out.println("\n");
		}

		return keyCliente;

	}

	private void Registrar(Cliente[] clientes) {

		int newCliente = 0;
		boolean validade = false;

		for (int i = 0; i < clientes.length; i++) {

			if (clientes[i].getNome() == "null") {
				newCliente = i;
				validade = true;
			}
		}

		if (validade == true) {

			System.out.print("\nNome: ");
			clientes[newCliente].setNome(new Scanner(System.in).nextLine());

			System.out.print("CPF: ");
			clientes[newCliente].setCpf(new Scanner(System.in).nextLine());

			System.out.print("Cidade: ");
			clientes[newCliente].setCidade(new Scanner(System.in).nextLine());

			System.out.print("Rua: ");
			clientes[newCliente].setRua(new Scanner(System.in).nextLine());

			System.out.print("Numero: ");
			clientes[newCliente].setNumero(new Scanner(System.in).nextInt());

			System.out.print("Email: ");
			clientes[newCliente].setEmail(new Scanner(System.in).nextLine());

			System.out.print("Senha: ");
			clientes[newCliente].setSenha(new Scanner(System.in).nextLine());

			System.out.println("\n");

		} else
			System.out.println("\n\n\n\nImpossivel Cadastrar!\n\n");

	}

	private Cliente[] NovoTipoCliente(Cliente[] clientes, int keyCliente) {

		boolean chave = false;
		String opcao = "";

		while (chave != true && !opcao.equalsIgnoreCase("S")) {

			System.out.println("\nOp��o        Mensalidades        Tipo        Desconto    Sair = S");
			System.out.print("1            R$20,00             GOLD        20%\n");
			System.out.print("2            R$40,00             PLATINUM    40%\n");
			System.out.print("3            R$60,00             BLACK       60%\n");
			System.out.print("Informe uma Op��o: ");
			opcao = new Scanner(System.in).next();

			if (clientes[keyCliente].getLogin() == true) {

				switch (Integer.parseInt(opcao)) {
				case 1:

					clientes[keyCliente].setTipoNome("GOLD");
					clientes[keyCliente].setTipoDesconto(20);

					System.out.println(
							"\nAssinatura Completa!\nApartir de Agora Voce Tera 20% de Desconto nas suas Compras!\n");

					chave = true;
					break;

				case 2:

					clientes[keyCliente].setTipoNome("PLATINUM");
					clientes[keyCliente].setTipoDesconto(40);

					System.out.println(
							"\nAssinatura Completa!\nApartir de Agora Voce Tera 40% de Desconto nas suas Compras!\n");

					chave = true;
					break;

				case 3:

					clientes[keyCliente].setTipoNome("BLACK");
					clientes[keyCliente].setTipoDesconto(60);

					System.out.println(
							"\nAssinatura Completa!\nApartir de Agora Voce Tera 60% de Desconto nas suas Compras!\n");

					chave = true;
					break;

				default:

					System.out.println("\n\nERRO: Informe umas das Op��es!\n");
					
					break;
				}

			}

		}

		return clientes;
	}

	@Override
	public void Interface(Produto[] armazem, Cliente[] clientes) {

		String opc = " ";
		DecimalFormat df = new DecimalFormat("0.00");

		while (!opc.equalsIgnoreCase("S")) {

			System.out.println("ID                          Produto                                       Pre�o");

			for (int i = 0; i < armazem.length; i++) {

				if (armazem[i].getNome() != null)
					System.out.println(armazem[i].getNumAux() + "                        " + armazem[i].getNome()
							+ "                    R$" + armazem[i].getPreco());

			}

			System.out.println("\nInforme S para Sair:");
			System.out.print("Informe o ID do Produto Desejado: ");
			opc = new Scanner(System.in).next();

			if (!opc.equalsIgnoreCase("S")) {

				for (int i = 0; i < armazem.length; i++) {

					try {

						if (true == Casos(Integer.parseInt(opc), armazem[i].getNumAux())) {

							System.out.println("\nPre�o: R$" + df.format(armazem[i].getPreco()) + "\n"
									+ armazem[i].getCaracteristica());
							System.out.print("\nInforme 1 para COMPRAR ou 0 para VOLTAR: ");
							opc = new Scanner(System.in).next();
							System.out.println();

							if (Integer.parseInt(opc) == 1)
								armazem = Comprar(i, armazem, clientes);

						}
					} catch (NumberFormatException e) {

						System.out.println("\n\nERRO: Informe um ID de um Produto ou S para Sair.\n\n");
						opc = "0";
					}
				}

				if (!opc.equalsIgnoreCase("S") && Integer.parseInt(opc) != 1 && Integer.parseInt(opc) != 0)
					System.out.println("\nERRO: Informe um ID de um Produto ou S para Sair.\n");

			} // FIM: IF SAIR

		} // FIM: While

		System.out.println("\n\nAguardamos a sua volta!!\n");

	}

	boolean Casos(int opc, int caso) {

		if (opc == caso)
			return true;
		else
			return false;

	}
}
