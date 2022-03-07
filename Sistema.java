package helloworld;
import java.io.*;

	public class Sistema {
	private Companhia c1;
	private BufferedReader reader;
	
	public static void main(String[] args) throws Exception {
		Sistema se = new Sistema();
		se.c1 = new Companhia();
		se.reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Informe o nome da companhia:");
		se.c1.setNome(se.reader.readLine());
		System.out.println("Telefone:");
		se.c1.setFone(se.reader.readLine());
		se.menu();
	}
	
	public void menu() throws Exception {
		String opcao = "";
		while(!opcao.equals("4")) {
			System.out.println("\n-------------------------");
			System.out.println("[1] Cadastrar novo Voo");
			System.out.println("[2] Listar voos existentes");
			System.out.println("[3] Consultar voo");
			System.out.println("[4] Consultar assentos de um voo");
			System.out.println("[5] Sair");
			opcao = this.reader.readLine();
			
			if(opcao.equals("1")){
				this.cadastrarVoo();
			}else if(opcao.equals("2")) {
				this.listarVoos();
			}else if(opcao.equals("3")) {
				this.consultarVoo();
			}else if(opcao.equals("4")) {
				this.consultaAssentos();
			}else if(opcao.equals("5")) {
				System.out.println("Encerrando...");
			}
			else { System.out.println("Opcao invalida...");
				
			}
		}
	}

	public void cadastrarVoo() {
		try {
			Voo voo = new Voo();
			int xxx = voo.getAssentos();
			System.out.println("Numero do voo:");
			String numVoo = this.reader.readLine();
			voo.setNumeroVoo(Integer.parseInt(numVoo));
			
			
			System.out.println("Destino do voo:");
			voo.setNomeVoo(this.reader.readLine());
			
			System.out.println("Data:");
			String ano = this.reader.readLine();
			voo.setData(ano);
			
			System.out.println("\n---------Passageiros--------");
			for(int i=0; i<xxx; i++) {
				System.out.println("\n-----------------");
				System.out.println("Informe o nome do passageiro:");
				String nomePassageiro = this.reader.readLine();
				if(nomePassageiro.equals("")) {
					break;
				}
				Passageiro passageiro = new Passageiro();
				passageiro.setNome(nomePassageiro);
				
				System.out.println("Numero do Documento:");
				passageiro.setDocumento(this.reader.readLine());
				
				voo.setPassageiro(i, passageiro);
			}
			this.c1.setVoo(voo);
			
		}catch(Exception c1){
			System.out.println("formato invalido...");
		}
	}
	
	public void listarVoos() throws Exception{
		System.out.println("------------------------");
		System.out.println("Relatorio de Voos");
		for(int i = 0; i < this.c1.getqtdeVoo(); i++){
			String linha = "Numero: " + this.c1.getVoo(i).getNumeroVoo();
			
			System.out.print(linha);
			
			linha = " - Destino: " + this.c1.getVoo(i).getNomeVoo();
			System.out.print(linha);
			
			linha = " - Data: " + this.c1.getVoo(i).getData();
			System.out.print(linha + "\n");
		}
	}
	
	public void consultarVoo(){
		try{
			System.out.println("------------------------");
			System.out.println("Consulta de Voo");
			System.out.println("Informe o numero do Voo: ");
			int numVoo = Integer.parseInt(this.reader.readLine());
			boolean achou = false;
			
			for(int i = 0; i < this.c1.getqtdeVoo(); i++) {
				Voo t = this.c1.getVoo(i);
				if(t.getNumeroVoo() == numVoo){
					System.out.println("Passageiros do Voo:");
					int pos = 0;
					while(t.getPassageiro(pos) != null){
						String linha = "\nNome: " + t.getPassageiro(pos).getNome();
						System.out.print(linha);
						
						pos++;
					}
					achou = true;
					break;
				}
			}
			if(!achou){
				System.out.println("Voo nao encontrado");
			}
		}catch(Exception e1){
			System.out.println("formato invalido...");
		}
	}
	
	
	public void consultaAssentos() {
		
	
		try{
			
			System.out.println("------------------------");
			System.out.println("Consulta de Assentos");
			System.out.println("Informe o numero do Voo: ");
			int numVoo = Integer.parseInt(this.reader.readLine());
			boolean achou = false;
			
			for(int i = 0; i < this.c1.getqtdeVoo(); i++) {
				Voo t = this.c1.getVoo(i);
				if(t.getNumeroVoo() == numVoo){
					System.out.println("Passageiros do Voo:");
					int pos = 0;
					int qtd = 10;
					while(t.getPassageiro(pos) != null){
						String linha = "\nNome: " + t.getPassageiro(pos).getNome();
						System.out.print(linha);
						
						pos++;
						qtd--;
					}
					System.out.print("\nQuantidade de Assentos livres: " + qtd);
					achou = true;
					break;
				}
			}
			if(!achou){
				System.out.println("Voo nao encontrado");
			}
		}catch(Exception e1){
			System.out.println("formato invalido...");
		}
	}
}