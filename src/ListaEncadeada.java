import java.util.ArrayList;
import java.util.Collections;

public class ListaEncadeada {

    private No primeiro = null;
    private No ultimo = null;
    private int quantidade = 0;

    public int retornarQuantidadeDePacientes() {
        return quantidade;
    }
    
    public void imprimirCrescente() {
        if (quantidade == 0) {
            System.out.println("Não existem pacientes");
            return;
        }

        ArrayList<Paciente> pacientes = retornarPacientes();
        imprimir(pacientes);
    }
    
    public void imprimirDecrescente() {
        if (quantidade == 0) {
            System.out.println("Não existem pacientes");
            return;
        }

        ArrayList<Paciente> pacientes = retornarPacientes();
        Collections.reverse(pacientes);
        imprimir(pacientes);
    }

    public void imprimir(Paciente p) {
		System.out.println("** Paciente: **");
		System.out.println("Nome: " + p.getNome());
		System.out.println("CPF: " + p.getCpf());	
		System.out.println("Telefone: " + p.getTelefone());
		System.out.println("Plano: " + (p.getPlano() == 1 ? "Unimed" : (
				p.getPlano() == 2 ? "Amil" : "Outro")));
		System.out.println();
	}
    
    public void imprimir(ArrayList<Paciente> lista) {
		for (int i = 0; i < lista.size(); i++) {
			imprimir(lista.get(i));
		}
	}

	public ArrayList<Paciente> retornarPacientes() {
    	ArrayList<Paciente> lista = new ArrayList<Paciente>();
    	No atual = primeiro;

        while (atual.getProximo() != null) {
        	lista.add(atual.getPaciente());
            atual = atual.getProximo();
        }

        lista.add(atual.getPaciente());
        return lista;
    }
    
    public Paciente busca(Paciente aux) {
		if (isEmpty())
			return null;
		No i = null;
		for (i = primeiro; i != null && aux.getCpf() != i.getPaciente().getCpf(); i = i.getProximo());
		if (i == null) {
			return null;
		}
		Paciente paciente = i.getPaciente();
		return paciente;
	}

	public boolean adicionaOrdenado(Paciente aux) {
		Paciente buscado = busca(aux);
		if (buscado != null)
			return false;
		No novo = new No(aux);
		if (isEmpty()) {
			primeiro = novo;
			quantidade++;
			return true;
		}
		No i = primeiro;
		No ant = primeiro;
		for (; i != null && aux.getNome().compareTo(i.getPaciente().getNome()) > 0; ant = i, i = i.getProximo());
		
		if (i == ant) {
			novo.setProximo(primeiro);
			primeiro = novo;
		} else {
			ant.setProximo(novo);
			novo.setProximo(i);
		}
		quantidade++;
		return true;
	}
	
	 public boolean remover(Paciente paciente) {
		if (busca(paciente) == null) {
			return false;
		}
    	int indice = buscarIndice(paciente);
    	removerNaPosicao(indice);
    	return true;
    }

	public boolean isEmpty() {
		return (primeiro == null);
	}

    public No getPrimeiro() {
        return primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }
    
    private void removerNoInicio() {
        if(quantidade == 0) {
            return;
        }

        primeiro = primeiro.getProximo();
        quantidade--;

        if(quantidade == 0) {
            ultimo = null;
        }
    }

    private void removerNoFinal() {
        if(quantidade == 0) {
            return;
        }

        if(quantidade == 1) {
            removerNoInicio();
            return;
        }

        No noNaPosicaoAnterior = buscarNoNaPosicao(quantidade - 2);
        noNaPosicaoAnterior.setProximo(null);

        ultimo = noNaPosicaoAnterior;
        quantidade--;
    }
    
    private void removerNaPosicao(int posicao) {
        if (quantidade == 0) {
            removerNoInicio();
        } else if(posicao == quantidade) {
            removerNoFinal();
        } else if(posicao == 0) {
            removerNoFinal();
        } else {
            No noNaPosicaoAnterior = buscarNoNaPosicao(posicao - 1);
            No noNaPosicaoAtual = noNaPosicaoAnterior.getProximo();

            if(noNaPosicaoAtual.getProximo() != null) {
                noNaPosicaoAnterior.setProximo(noNaPosicaoAtual.getProximo());
            } else {
                noNaPosicaoAnterior.setProximo(null);
                ultimo = noNaPosicaoAnterior;
            }

            quantidade--;
        }
    }
    
    private No buscarNoNaPosicao(int posicao) {
        if(!existePacienteNaPosicao(posicao)) {
            throw new RuntimeException("Posição não existente");
        }

        No atual = primeiro;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    
    private boolean existePacienteNaPosicao(int posicao){
        return posicao >= 0 && posicao < quantidade;
    }

	
	private int buscarIndice(Paciente paciente)
	{
		No t = primeiro;
		int index = 0;
		while(t.getPaciente().getCpf() != paciente.getCpf())
		{
			index++;
			t = t.getProximo();
		}
		return index;
	}

	public String montarArquivo() {
		String dados = "";

		for (No i = primeiro; i != null; i = i.getProximo()) {
			dados = dados + i.getPaciente().getNome() + ";";
			dados = dados + i.getPaciente().getCpf() + ";";
			dados = dados + i.getPaciente().getTelefone() + ";";
			dados = dados + i.getPaciente().getPlano() + "\n";
		}

		return dados;
	}
}
