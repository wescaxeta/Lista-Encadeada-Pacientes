
public class Paciente {
	private String nome;
	private long cpf;
	private long telefone;
	private int plano;

	public Paciente(String nome, long cpf, long telefone, int plano) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.plano = plano;
	}
	
	public Paciente(long cpf) {
		super();
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public int getPlano() {
		return plano;
	}
	public void setPlano(int plano) {
		this.plano = plano;
	}
}
