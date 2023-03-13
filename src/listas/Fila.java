package src.listas;

public class Fila extends Lista {

	// contrutor sem argumento
	public Fila() {
		super("Queue - Fila");
	}// fim do construtor sem argumento Fila
	// adiciona o objeto � fila

	public void enfileira(Object object) {
		insereNoFim(object);
	}// fim do m�todo enfileira
	// remove o objeto da fila

	public Object desenfileira() throws EmptyListException {
		return removeNoInicio();
	}// fim do m�todo desenfileira
	// determina se a fila est� vazia

} // fim da classe Fila