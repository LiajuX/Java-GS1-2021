public class Estoque {
  private int limite;
  int quantidadeAtual = 0;

  public int getLimite() {
    return limite;
  }

  public void setLimite(int limite) {
    this.limite = limite;
  }

  public void atualizarQuantidadeAtual() {
    quantidadeAtual++;
  }
}
