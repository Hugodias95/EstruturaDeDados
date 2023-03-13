package src.listas;

public class PilhaTeste {
	public static void main(String[] args) {
		Pilha stack = new Pilha();
		// utliza m�todo push
		stack.empilha(-1);
		stack.print();
		stack.empilha(0);
		stack.print();
		stack.empilha(1);
		stack.print();
		stack.empilha(5);
		stack.print();
		// remove itens da pilha
		try {
			Object removedObject = null;
			while (true) {
				removedObject = stack.desempilha();// utiliza o m�todo pop
				System.out.printf("%s removido da pilha\n", removedObject);
				stack.print();
			}// fim do While
		}// fim do trry
		catch (EmptyListException e) {
			e.printStackTrace();
		}// fim do catch
	}// fim do main
}// fim da classe StackInheritanceTest