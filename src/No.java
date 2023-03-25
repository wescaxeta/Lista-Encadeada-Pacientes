
public class No {

    private Paciente paciente;
    private No proximo;

    public No(Paciente paciente) {
		this.paciente = paciente;
	}

	public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}