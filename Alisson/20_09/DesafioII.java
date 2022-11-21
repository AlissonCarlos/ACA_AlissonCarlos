import java.util.Scanner;

public class DesafioII {

	public static void main(String[] args) {
		Usuario u = new Usuario();
		String nome;
		String senha;
		
		Scanner dados = new Scanner (System.in);
		System.out.println("Usuario:");
		nome = dados.next();
		
		System.out.println("Senha:");
		senha = dados.next();
		
		if(nome.equals(u.getNome()) && senha.equals(u.getSenha())){
			
			Coordenador cord = new Coordenador();
			cord.setLoja("Loja da Impacto");
			cord.setMetaDaLoja(1000.0);
			
			System.out.println("Digite o nome:");
			cord.setNome(dados.next());
			System.out.println("Digite a hora Trabalho:");
			
			cord.setSalarioLiquido(cord.calcularSalario(Double.parseDouble(dados.next())));
			System.out.println("Loja do Coordenador" + cord.getLoja());
			System.out.println("Meta da loja" + cord.getMetaDaLoja());
			System.out.println("Salario do coordenador:" + cord.getSalarioLiquido());
		}else{
			System.out.println("Login Inválido");
		}
	}

}

