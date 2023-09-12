import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface LeitorTeclado {
    String ler();
}

class Teclado implements LeitorTeclado {
    @Override
    public String ler() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

class TecladoComMensagem implements LeitorTeclado {
    private LeitorTeclado leitorTeclado;

    public TecladoComMensagem(LeitorTeclado leitorTeclado) {
        this.leitorTeclado = leitorTeclado;
    }

    @Override
    public String ler() {
        System.out.print("Digite algo: ");
        return leitorTeclado.ler();
    }
}
