import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class ConverteMoedas extends Conversor {
    private static final Map<String, Double> COTACOES = new HashMap<>();

    
    static {
        COTACOES.put("REAL/DOLAR", 4.96);
        COTACOES.put("REAL/EURO", 5.57);
        COTACOES.put("REAL/LIBRA", 6.46);
        
    }

    private final EscolheMoedas.TipoConversaoMoeda opcaoSelecionada;

    public ConverteMoedas(EscolheMoedas.TipoConversaoMoeda opcaoSelecionada) {
        this.opcaoSelecionada = opcaoSelecionada;
    }

    @Override
    public void converter(double valor) {
        if (validarOperacao()) {
            realizarConversao(valor);
            exibirResultado();
        } else {
            new TelaErro("Operação de conversão inválida.");
        }
    }

    private boolean validarOperacao() {
        return opcaoSelecionada.name().startsWith("REAL_PARA_");
    }

    private void realizarConversao(double valor) {
        String moedaDestino = opcaoSelecionada.name().replace("REAL_PARA_", "");
        super.simboloConversao = extrairSimbolo(moedaDestino);
        super.valorConvertido = calcularConversao(valor, "REAL/" + moedaDestino);
    }

    private double calcularConversao(double valor, String moedaOrigem) {
        return (moedaOrigem.startsWith("REAL/")) ? valor / COTACOES.get(moedaOrigem) : valor * COTACOES.get(moedaOrigem);
    }

    private String extrairSimbolo(String moedaDestino) {
        return moedaDestino.substring(moedaDestino.length() - 3);
    }

    private void exibirResultado() {
        String msg = String.format("O valor convertido é de %.2f %s", super.valorConvertido, super.simboloConversao);
        JOptionPane.showMessageDialog(null, msg);
    }
}
