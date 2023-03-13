package src.listas;

public class ListaTeste {
	public static void main(String[] args) {
		
		Lista list = new Lista(); // cria o cont�iner de List
		
		// insere inteiros na lista
		list.insereNoInicio(-1);
		list.print();
		list.insereNoInicio(0);
		list.print();
		list.insereNoFim(1);
		list.print();
		list.insereNoFim(5);
		list.print();
		list.insereNoInicio(3);
		list.print();
		
		// remove objetos da lista; imprime depois de cada remo��o
		try {
			Object removedObject = list.removeNoInicio();
			System.out.printf("%s removido\n", removedObject);
			list.print();
			removedObject = list.removeNoInicio();
			System.out.printf("%s removido\n", removedObject);
			list.print();
			removedObject = list.removeNoFim();
			System.out.printf("%s removido\n", removedObject);
			list.print();
			removedObject = list.removeNoFim();
			System.out.printf("%s removido\n", removedObject);
			list.print();
			removedObject = list.removeNoFim();
			System.out.printf("%s removido\n", removedObject);
			list.print();
		}// fim do try
		catch (EmptyListException e) {
			e.printStackTrace();
		}// fim do catch
		
		
	}// fim de main
}// fim da classe ListTest