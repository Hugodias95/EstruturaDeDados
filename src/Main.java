package src;

import src.listas.EmptyListException;
import src.listas.Lista;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Lista lista = new Lista();
        lista.insereNoInicio(11);
        lista.insereNoInicio(12);
        lista.insereNoInicio(13);
        lista.insereNoInicio(14);
        lista.insereNoInicio(15);
        lista.print();
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
            String palavraBuscada = "";

            Lista lista = new Lista();

            Scanner sc = new Scanner(System.in);
            while (true) {

                System.out.println("Selecione:\n(1) Inserir\n(2) Remover\n(3) Buscar\n(4) Imprimir\n(0) Sair");
                selecionado = Integer.parseInt(sc.nextLine());

                if (selecionado==1) {
                    System.out.println("Como você deseja inserir:\n");
                    System.out.println("(1) Inserir no início\n(2) Inserir no fim\n(3) Inserir na posição");
                    selecionado = Integer.parseInt(sc.nextLine());

                    switch (selecionado){
                        case 1:
                            System.out.println("Qual número deseja inserir no início?");
                            valor = Integer.parseInt(sc.nextLine());
                            lista.insereNoInicio(valor);
                            break;
                        case 2:
                            System.out.println("Qual número deseja inserir no final?");
                            valor = Integer.parseInt(sc.nextLine());
                            lista.insereNoFim(valor);
                            break;
                        case 3:
                            System.out.println("Escolha a posição que deseja colocar o número:");
                            posicao = Integer.parseInt(sc.nextLine());
                            System.out.println("Escolha o número para inserir:");
                            valor = Integer.parseInt(sc.nextLine());
                            lista.insereNaPosicao(posicao,valor);
                            break;
                    }
                }
                if (selecionado == 2) {
                    System.out.println("Como você deseja remover:\n");
                    System.out.println("(1) Remover do início\n(2) Remover do fim\n(3) Remover por valor\n(4) Remover por posição");
                    selecionado = Integer.parseInt(sc.nextLine());

                    switch (selecionado){
                        case 1:
                            lista.removeNoInicio();
                            System.out.println("Valor removido do início");
                            break;
                        case 2:
                            lista.removeNoFim();
                            System.out.println("Valor removido do final");
                            break;
                        case 3:
                            System.out.println("Qual número você deseja remover?");
                            valor = Integer.parseInt(sc.nextLine());
                            lista.removeValor(valor);
                            break;
                        case 4:
                            System.out.println("Escolha a posição que deseja remover o número:");
                            posicao = Integer.parseInt(sc.nextLine());
                            lista.removeFromPosicao(posicao);
                            break;
                    }
                }
                if (selecionado == 3)  {
                    System.out.println("Qual número você deseja buscar?");
                    valor = Integer.parseInt(sc.nextLine());
                    lista.buscaElemento(valor);
                    if (lista.buscaElemento(valor) == true) {
                        System.out.println("Número " + valor + " está na lista!" );
                    } else {
                        System.out.println("Número " + valor + " não está na lista!" );
                    }
                }
                if (selecionado == 4) {
                    lista.print();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
