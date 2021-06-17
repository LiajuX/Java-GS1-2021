import java.util.ArrayList;
import java.util.Scanner;

public class TesteProjeto {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Estoque estoque = new Estoque();

    ArrayList<Componente> componentes = new ArrayList<>();

    ArrayList<Eletronico> eletronicos = new ArrayList<>();

    System.out.println("Qual a quantidade máxima de produtos que podem ser armazenados no seu estoque?");
    estoque.setLimite(input.nextInt());

    input.nextLine();

    boolean continuar = true;
    int i = 0;

    do {
      i++;

      System.out.println("\nCadastrando o " + i + "º material...");
      System.out.println("O material cadastrado é um componente ou um eletrônico?");
      System.out.println("Responda 'C' para componente e 'E' para eletrônico.");

      String subclassificacao = input.nextLine();

      if (subclassificacao.equalsIgnoreCase("C")) {
        Componente componente = new Componente();

        componente.setSubclassificacao("Componente");

        System.out.println("Informe o nome do componente:");
        componente.setNome(input.nextLine());

        System.out.println("Informe a descrição do componente:");
        componente.setDescricao(input.nextLine());

        System.out.println("Informe para qual eletrônico este componente é:");
        componente.setParaQualEletronico(input.nextLine());

        System.out.println("Informe o modelo do componente:");
        componente.setModelo(input.nextLine());

        componentes.add(componente);
        estoque.atualizarQuantidadeAtual();

      } else if (subclassificacao.equalsIgnoreCase("E")) {
        Eletronico eletronico = new Eletronico();

        eletronico.setSubclassificacao("Eletrônico");

        System.out.println("Informe o nome do eletrônico:");
        eletronico.setNome(input.nextLine());

        System.out.println("Informe a descrição do eletrônico:");
        eletronico.setDescricao(input.nextLine());

        System.out.println("Informe a marca do eletrônico:");
        eletronico.setMarca(input.nextLine());

        System.out.println("É um eletrônico portátil? Responda com sim ou não.");
        eletronico.setPortatil(input.nextLine().equalsIgnoreCase("sim"));

        eletronicos.add(eletronico);
        estoque.atualizarQuantidadeAtual();
      } else {
        System.out.println("Opção inválida!");
        i--;
      }

      if (estoque.quantidadeAtual < estoque.getLimite()) {
        System.out.println("\nDeseja cadastrar outro produto? Responda com sim ou não.");
        if (!input.nextLine().equalsIgnoreCase("sim")) {
          continuar = false;
        }

      } else {
        System.out.println("\nSeu estoque está cheio e você não pode cadastrar mais nenhum material.");
        continuar = false;
      }
    } while (continuar);

    System.out.println("\nSituação atual do estoque: " + estoque.quantidadeAtual + "/" + estoque.getLimite());
    System.out.println("Você possui " + estoque.quantidadeAtual + " materiais cadastrados no estoque:");

    for (i = 0; i < componentes.size(); i++) {
      Componente componente = componentes.get(i);

      System.out.println("\nDados do " + (i + 1) + "º componete cadastrado no estoque:");
      System.out.println("Nome do componente: " + componente.getNome());
      System.out.println("Descrição: " + componente.getDescricao());
      System.out.println("Componete utilizado em: " + componente.getParaQualEletronico());
      System.out.println("Modelo: " + componente.getModelo());
    }

    for (i = 0; i < eletronicos.size(); i++) {
      Eletronico eletronico = eletronicos.get(i);

      System.out.println("\nDados do " + (i + 1) + "º eletrônico cadastrado no estoque:");
      System.out.println("Nome do eletrônico: " + eletronico.getNome());
      System.out.println("Descrição: " + eletronico.getDescricao());
      System.out.println("Marca: " + eletronico.getMarca());
      System.out.println("Eletrônico portátil? " + eletronico.isPortatil());
    }
  }
}
