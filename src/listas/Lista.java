package src.listas;

//definicao da classe List
public class Lista {
	private ListaNo primeiroNo;// Declara variavel de instancia com o nome de
								// PrimeiroN�
	private ListaNo ultimoNo;// Declara variavel de instancia com o nome de
								// UltimoN�
	private String nome; // String como 'lista' usada na impressao

	private int tamanhoLista;

	// construtor cria List vazia com 'list' como o nome
	public Lista() {
		this("Lista");
		this.tamanhoLista = 0;
	}// fim do construtor sem argumentos List

	// construtor cria uma List vazia com um nome
	public Lista(String nomeDaLista) {
		nome = nomeDaLista;
		primeiroNo = ultimoNo = null;
		this.tamanhoLista = 0;
	}// fim do construtor de um argumento List
		// Insere Object na frente de List

	public void insereNoInicio(Object insertItem) {
		if (estaVazia()) { // first e lastNode referenciam o mesmo objeto
			primeiroNo = ultimoNo = new ListaNo(insertItem);
		} else {
			primeiroNo = new ListaNo(insertItem, primeiroNo);
		}// fim do metodo insereNoInicio

		this.tamanhoLista++;
	}// fim do metodo insereNoInicio

	// insere Object no fim de Lista
	public void insereNoFim(Object insertItem) {
		if (estaVazia()) {
			primeiroNo = ultimoNo = new ListaNo(insertItem);
		} else {
			ultimoNo = ultimoNo.proximoNo = new ListaNo(insertItem);
		}
		this.tamanhoLista++;
	}// fim do metodo insereNoFim


	//Insere na posicao informada
	public void insereNaPosicao(int posicao, Object elemento) throws EmptyListException {
		if (estaVazia() || posicao > tamanhoLista) {
			throw new EmptyListException(nome);
		}

		ListaNo novoNo = new ListaNo(elemento);

		if (novoNo == null){
			throw new EmptyListException("Objeto inválido");
		}

		if (posicao == 1){
			novoNo.setProximoNo(primeiroNo);
			primeiroNo = novoNo;
			return;

		} else {
			ListaNo atual = primeiroNo;
			for (int i = 1; i < posicao - 1; i++){
				atual = atual.proximoNo;
			}

			ListaNo proximo = atual.proximoNo; //2
			atual.proximoNo = novoNo; //20
			atual.proximoNo.proximoNo = proximo; //2

		}
		this.tamanhoLista++;
	}

	// remove o primeiro n� de List
	public Object removeNoInicio() throws EmptyListException {
		if (estaVazia()) {
			throw new EmptyListException(nome);
		}
		Object removedItem = primeiroNo.data; // recupera dados sendo removidos
		// atualiza refer�ncias primeiroNo e ultimoNo
		if (primeiroNo == ultimoNo) {
			primeiroNo = ultimoNo = null;
		} else {
			primeiroNo = primeiroNo.proximoNo;
		}
		this.tamanhoLista--;
		return removedItem;// retorna dados de n� removidas
	}// fim do metodo removeNoFim

	public Object removeValor(Object elemento) throws EmptyListException {
		if (estaVazia()) {
			throw new EmptyListException("A lista está vazia.");
		}

		ListaNo atual = primeiroNo;
		ListaNo anterior = null;

		while (atual != null && !atual.getData().equals(elemento)) { //Enquanto o atual for diferente do elemento buscado
			anterior = atual;
			atual = atual.getProximoNo();
			//guarda o anterior no lugar do atual e atribui ao atual o próximo nó
		}

		if (atual == null) {
			return null; // o elemento não foi encontrado
		}

		if (anterior == null) {
			primeiroNo = atual.getProximoNo();
		} else {
			anterior.setProximoNo(atual.getProximoNo());
		}

		tamanhoLista--;

		return atual.getData();
	}


	public Object removeNoFim() throws EmptyListException{
		if (estaVazia()){
			throw new EmptyListException(nome); //lanca excessao se List estiver vazia
		}

		Object removedItem = ultimoNo.data; //recupera dados sendo removidos

		//atualiza refer�ncias primeiroNo e ultimoNo

		if(primeiroNo == ultimoNo){
			primeiroNo = ultimoNo = null;
		}

		else{ //localiza o novo ultimo no
			ListaNo current = primeiroNo;

			//faz loop enquanto n� atual n�o referencia lastNode
			while(current.proximoNo != ultimoNo){
				current = current.proximoNo;
			}

			ultimoNo =	current; //atual �	novo lastNode
			current.proximoNo = null;
		}//fim do else

		this.tamanhoLista--;
		return removedItem; //retorna dados de n� removidos
	}//fim do metodo removeNoFim


	public Object removeFromPosicao(int posicao) throws EmptyListException {
		if (estaVazia()){
			throw new EmptyListException(nome); //lanca excessao se List estiver vazia
		}
		//Posição é maior que o tamanho da lista, remove o último
		if (posicao >= tamanhoLista) {
			Object removedItem = ultimoNo.data;
			this.tamanhoLista--;
			return removedItem;
			//Posição é menor que 0, remove o primeiro
		}

		Object removedItem = ultimoNo.data; // Valor do elemento removido
		if (posicao <= 0) { // Remove o primeiro elemento da lista
			ListaNo current = primeiroNo;
			primeiroNo = current.proximoNo;
			if (primeiroNo == null) { // Atualiza a referência do último elemento
				ultimoNo = null;
			}
		} else { // Remove um elemento no meio ou final da lista
			ListaNo current = primeiroNo;
			for (int i = 0; i < posicao - 1; i++) { // Encontra o elemento anterior ao que será removido
				current = current.proximoNo;
			}
			ListaNo proximo = current.proximoNo; // Elemento que será removido
			removedItem = proximo.getProximoNo();
			current.setProximoNo(proximo.getProximoNo());
			if (proximo == ultimoNo) { // Atualiza a referência do último elemento
				ultimoNo = current;
			}
		}
		tamanhoLista--; // Atualiza o tamanho da lista
		return removedItem; // Retorna o valor do elemento removido
	}
	
	
	public boolean buscaElemento(Object elemento) {
		ListaNo atual = primeiroNo; // Começa a busca pelo primeiro elemento
		while (atual != null) { // Percorre a lista até encontrar o elemento ou chegar ao fim
			if (atual.getData().equals(elemento)) { // Verifica se o elemento atual é igual ao buscado
				return true; // Elemento encontrado
			}
			atual = atual.getProximoNo(); // Passa para o próximo elemento da lista
		}
		return false; // Elemento não encontrado
	}


	// Determina se a lista estiver vazia
	public boolean estaVazia() {
		return primeiroNo == null; // retorna true se List estiver vazia
	}// fim do metodo estaVazia
		// gera sa�da do conte�do de List

	public void print() {
		if (estaVazia()) {
			System.out.printf("Lista Vazia %s\n", nome);
			System.out.println(imprimeTamanho());
			return;
		}// fim do if

		System.out.printf("A lista %s �: ", nome);
		ListaNo current = primeiroNo;
		// enquanto não estiver no fim da lista, gera sa�da dos dados do n�
		// atual
		while (current != null) {
			System.out.printf("%s - ", current.data);
			current = current.proximoNo;
		}// fim do While
		System.out.printf("\n");
		System.out.println(imprimeTamanho());
	} // fim do metodo print

	public String imprimeTamanho(){
		return "Tamanho da Lista: "+this.tamanhoLista;
	}
}// fim da classe List
