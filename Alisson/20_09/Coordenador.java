public class Coordenador extends Funcionario {
	
	private String loja;
	private Double metaDaLoja;
	double percentual = 7.0 / 100.0; 
	
	public Coordenador() {
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public Double getMetaDaLoja() {
		return metaDaLoja;
	}

	public void setMetaDaLoja(Double metaDaLoja) {
		this.metaDaLoja = metaDaLoja;
	}
	
	public Double calcularSalario(Double horaTrabalho){
		Double salario = 40 * horaTrabalho;
		Double salarioSemDesconto = salario;
		double valorFinal = salarioSemDesconto + (percentual * salario);
		return valorFinal;
	}
}
