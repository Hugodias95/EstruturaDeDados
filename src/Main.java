package src;

import src.listas.EmptyListException;
import src.listas.Lista;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        //Lista lista = new Lista();
        //lista.insereNoInicio(11);
        //lista.insereNoInicio(12);
        console();
        //lista.removeFromPosicao(0);
        //lista.removeFromPosicao(3);


        //lista.print();



    }

    private static void console() throws Exception {
        try {

            //inserir.remover.buscar.imprimir.sair

            int selecionado = 0;
            int valor = 0;
            int posicao = 0;

            Lista lista = new Lista();
            lista.insereNoFim(1);
            lista.insereNoFim(2);
            lista.insereNoFim(3);
            lista.insereNoFim(4);
            Scanner sc = new Scanner(System.in);
            while (true) {

                System.out.println("Selecione:\n(1) Inserir\n(2) Remover\n(3) Buscar\n(4) Imprimir\n(0) Sair");
                selecionado = Integer.parseInt(sc.nextLine());

                if (selecionado==1) {
                    System.out.println("Como você deseja inserir:\n");
                    System.out.println("(1) Inserir no início\n(2) Inserir no fim\n(3) Inserir na posição");
                    int selecionadoInserir = Integer.parseInt(sc.nextLine());

                    switch (selecionadoInserir){
                        case 1:
                            System.out.println("Qual número deseja inserir no início?");
                            valor = Integer.parseInt(sc.nextLine());
                            lista.insereNoInicio(valor);
                            lista.print();
                            break;
                        case 2:
                            System.out.println("Qual número deseja inserir no final?");
                            valor = Integer.parseInt(sc.nextLine());
                            lista.insereNoFim(valor);
                            lista.print();
                            break;
                        case 3:
                            System.out.println("Escolha a posição que deseja colocar o número:");
                            posicao = Integer.parseInt(sc.nextLine());
                            System.out.println("Escolha o número para inserir:");
                            valor = Integer.parseInt(sc.nextLine());
                            lista.insereNaPosicao(posicao,valor);
                            lista.print();
                            break;
                    }
                }
                if (selecionado == 2) {
                    System.out.println("Como você deseja remover:\n");
                    System.out.println("(1) Remover do início\n(2) Remover do fim\n(3) Remover por valor\n(4) Remover por posição");
                    int selecionadoRemover = Integer.parseInt(sc.nextLine());//

                    switch (selecionadoRemover){
                        case 1:
                            lista.removeNoInicio();
                            System.out.println("Valor removido do início");
                            lista.print();
                            break;
                        case 2:
                            lista.removeNoFim();
                            System.out.println("Valor removido do final");
                            lista.print();
                            break;
                        case 3:
                            System.out.println("Qual número você deseja remover?");
                            valor = Integer.parseInt(sc.nextLine());
                            lista.removeValor(valor);
                            lista.print();
                            break;
                        case 4:
                            System.out.println("Escolha a posição que deseja remover o número:");
                            posicao = Integer.parseInt(sc.nextLine());
                            lista.removeFromPosicao(posicao);
                            lista.print();
                            break;
                    }
                }
                if (selecionado == 3)  {
                    Boolean achou = false;
                    System.out.println("Qual número você deseja buscar?");
                    valor = Integer.parseInt(sc.nextLine());
                    achou = lista.buscaElemento(valor);
                    if (achou == true) {
                        System.out.println("Número " + valor + " está na lista!" );
                    } else {
                        System.out.println("Número " + valor + " não está na lista!" );
                    }
                    lista.print();
                }
                if (selecionado == 4) {
                    lista.print();
                }
                if (selecionado == 0) {
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
