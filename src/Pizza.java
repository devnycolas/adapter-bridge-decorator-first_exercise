interface Pizza {
    void montarPizza();
}

class Mussarela implements Pizza {
    @Override
    public void montarPizza() {
        System.out.println("Pizza de Mussarela montada.");
    }
}

class Calabresa implements Pizza {
    @Override
    public void montarPizza() {
        System.out.println("Pizza de Calabresa montada.");
    }
}

class Bacon implements Pizza {
    @Override
    public void montarPizza() {
        System.out.println("Pizza de Bacon montada.");
    }
}

interface TamanhoPizza {
    void definirTamanho();
}

class Pequena implements TamanhoPizza {
    @Override
    public void definirTamanho() {
        System.out.println("Pizza Pequena.");
    }
}

class Media implements TamanhoPizza {
    @Override
    public void definirTamanho() {
        System.out.println("Pizza Média.");
    }
}

class Grande implements TamanhoPizza {
    @Override
    public void definirTamanho() {
        System.out.println("Pizza Grande.");
    }
}

abstract class PizzaAbstrata {
    protected Pizza pizza;
    protected TamanhoPizza tamanhoPizza;

    public PizzaAbstrata(Pizza pizza, TamanhoPizza tamanhoPizza) {
        this.pizza = pizza;
        this.tamanhoPizza = tamanhoPizza;
    }

    public abstract void montarPizza();
}
