interface PaymentAdapter {
    void pagar(double valor);
}

class PagamentoDinheiro implements PaymentAdapter {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento em dinheiro no valor de $" + valor);
    }
}

class PagamentoCartaoCredito implements PaymentAdapter {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento com cartão de crédito no valor de $" + valor);
    }
}

class PagamentoPix implements PaymentAdapter {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento com Pix no valor de $" + valor);
    }
}
