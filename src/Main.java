import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cardápio de pizzas disponíveis
        Map<String, Pizza> cardapio = new HashMap<>();
        cardapio.put("mussarela", new Mussarela());
        cardapio.put("calabresa", new Calabresa());
        cardapio.put("bacon", new Bacon());

        int tentativasRestantes = 3;

        while (tentativasRestantes > 0) {
            // Solicitar o nome da pizza ao usuário
            System.out.print("Digite o nome da pizza: ");
            final String nomePizza = scanner.nextLine().toLowerCase();

            // Verificar se a pizza está no cardápio
            Pizza pizza = cardapio.get(nomePizza);

            if (pizza == null) {
                System.out.println("Pizza não encontrada no cardápio. Tentativas restantes: " + (tentativasRestantes - 1));
                for (String pizzaNome : cardapio.keySet()) {
                    System.out.println("- " + pizzaNome);
                }

                if (tentativasRestantes == 1) {
                    System.out.println("Você esgotou suas tentativas.");
                    break;
                }

                tentativasRestantes--;
                continue;
            }

            // Solicitar o tamanho da pizza ao usuário
            System.out.print("Digite o tamanho da pizza (Pequena, Media ou Grande): ");
            final String tamanhoPizza = scanner.nextLine().toLowerCase();

            double valorPedido = 0.0; // Valor inicial como zero

            switch (tamanhoPizza) {
                case "pequena":
                    valorPedido = 20.0; // Valor para pizza pequena
                    break;
                case "media":
                    valorPedido = 35.0; // Valor para pizza média
                    break;
                case "grande":
                    valorPedido = 50.0; // Valor para pizza grande
                    break;
                default:
                    System.out.println("Tamanho de pizza inválido.");
                    return;
            }

            // Solicitar o método de pagamento ao usuário
            System.out.print("Digite o método de pagamento (Dinheiro, Cartao ou Pix): ");
            String metodoPagamento = scanner.nextLine().toLowerCase();

            PaymentAdapter pagamento;
            switch (metodoPagamento) {
                case "dinheiro":
                    pagamento = new PagamentoDinheiro();
                    break;
                case "cartao":
                    pagamento = new PagamentoCartaoCredito();
                    break;
                case "pix":
                    pagamento = new PagamentoPix();
                    break;
                default:
                    System.out.println("Método de pagamento inválido.");
                    return;
            }

            // Montar a pizza
            final String mensagemMontagem = "Pizza de " + nomePizza + " " + tamanhoPizza + " montada.";
            pizzaMontada(pizza, tamanhoPizza, mensagemMontagem);

            // Efetuar o pagamento com base no valor do pedido
            pagamento.pagar(valorPedido);

            // Fechar o scanner
            scanner.close();
            break;
        }
    }

    private static void pizzaMontada(Pizza pizza, String tamanhoPizza, String mensagemMontagem) {
        System.out.println(mensagemMontagem);
        // Implemente a lógica de montagem da pizza aqui, se necessário.
    }
}
