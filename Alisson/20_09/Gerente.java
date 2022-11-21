public class Gerente extends Funcionario{
	public String Regional;
	public Double MetaRegional;
	double percentual = 15.0 / 100.0; 
	
	
	public String getRegional() {
		return Regional;
	}
	public void setRegional(String regional) {
		Regional = regional;
	}
	public Double getMetaRegional() {
		return MetaRegional;
	}
	public void setMetaRegional(Double metaRegional) {
		MetaRegional = metaRegional;
	}
	
	public Double calcularSalarioGerente(Double horaTrabalho){
		Double salario = 60 * horaTrabalho;
		Double salarioSemDesconto = salario;
		double valorFinal = salarioSemDesconto + (percentual * salario);
		return valorFinal;
	}
	

}
