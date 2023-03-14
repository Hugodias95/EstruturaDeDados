package src.listas;

//classe para representar um n� em uma lista
public class ListaNo {
	Object data;
	ListaNo proximoNo;

	ListaNo(Object object) {
		this(object, null);
	}// Fim do construtor de um argumento ListaNo
	
	// construtor cria ListaNo que referencia
	
	// Object e o pr�ximo ListaNo
	ListaNo(Object object, ListaNo node) {
		data = object;
		proximoNo = node;
	}// fim do construtor de dois argumentos ListaNo
	
	//seta um objeto data
	public void setData(Object data){
		this.data = data;
	}
	
	// retorna refer�ncia aos dados no nó
	Object getData() {
		return data; // retorna Object nesse n�
	}// fim do metodo getObject
		// retorna refer�ncia ao pr�ximo n� na lista

	ListaNo getProximoNo() {
		return proximoNo; // obt�m pr�ximo n�
	}// fim do metodo getNext

	public void setProximoNo(ListaNo novo) {
		// TODO Auto-generated method stub
		this.proximoNo = novo;
	}
}// fim da classe ListaNo
