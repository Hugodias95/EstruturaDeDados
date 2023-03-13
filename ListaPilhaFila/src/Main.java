package src;

import src.listas.EmptyListException;
import src.listas.Lista;

public class Main {

    public static void main(String[] args) throws EmptyListException {

        Lista lista = new Lista();
        lista.insereNoInicio(11);
        lista.insereNoInicio(12);
        lista.insereNoInicio(13);
        lista.insereNoInicio(14);
        lista.insereNoInicio(15);
        lista.print();

        lista.removeFromPosicao(0);
        lista.removeFromPosicao(3);

        lista.print();

    }

}
