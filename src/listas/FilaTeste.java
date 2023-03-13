package src.listas;

public class FilaTeste {
	public static void main(String[] args) {
		Fila queue = new Fila();
		// utiliza o m�todo enqueue
		queue.enfileira(-1);
		queue.print();
		queue.enfileira(0);
		queue.print();
		queue.enfileira(1);
		queue.print();
		queue.enfileira(5);
		queue.print();
		queue.enfileira(7);
		queue.print();
		// remove os objetos da fila
		try {
			Object removedObject = null;
			while (true) {
				removedObject = queue.desenfileira();// utiliza m�todo dequeue
				System.out.printf("%s saiu da Fila, pr�ximo poder� ser atendido\n",	removedObject);
				queue.print();
			}// fim do while
		}// fim de try
		catch (EmptyListException e) {
			e.printStackTrace();// imprime a pilha de erros
		}// fim do catch
	}// fim de main
}// fim da classe QueueTest