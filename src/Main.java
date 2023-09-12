import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Cardápio de pizzas disponíveis
        Map<String, Pizza> cardapio = new HashMap<>();
        cardapio.put("mussarela", new Mussarela());
        cardapio.put("calabresa", new Calabresa());
        cardapio.put("bacon", new Bacon());

        int tentativasRestantes = 3;

        while (tentativasRestantes > 0) {
            try {
                // Solicitar o nome da pizza ao usuário
                System.out.print("Digite o nome da pizza: ");
                final String nomePizza = reader.readLine().toLowerCase();

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
                final String tamanhoPizza = reader.readLine().toLowerCase();

                double valorPedido = 0.0; // Valor inicial como zero

                switch (tamanhoPizza) {
                    case "pequena":
                        valorPedido = 25.0; // Valor para pizza pequena
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
                String metodoPagamento = reader.readLine().toLowerCase();

                PaymentAdapter pagamento;
                switch (metodoPagamento) {
                    case "dinheiro":
                        pagamento = new PagamentoDinheiro();
                        break;
                    case "cartão":
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

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Fechar o BufferedReader
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void pizzaMontada(Pizza pizza, String tamanhoPizza, String mensagemMontagem) {
        System.out.println(mensagemMontagem);
        // Implemente a lógica de montagem da pizza aqui, se necessário.
    }
}
