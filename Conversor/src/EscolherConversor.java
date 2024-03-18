import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EscolherConversor {
    public enum TipoConversor {
        MOEDAS
       
    }

    private final TipoConversor opcaoSelecionada;
    private final EscolheMoedas escolheMoedas;

    public EscolherConversor() {
        String[] opcoes = {
                "Conversor de Moedas",
                
        };

        int opcaoSelecionadaIndex = JOptionPane.showOptionDialog(
                null,
                "Escolha o conversor:",
                "Conversores",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        this.opcaoSelecionada = mapearIndiceParaTipoConversor(opcaoSelecionadaIndex);

        if (this.opcaoSelecionada == TipoConversor.MOEDAS) {
            this.escolheMoedas = new EscolheMoedas(mostrarMenuMoedas());
        } else {
            throw new IllegalArgumentException("Opção inválida");
        }
    }

    public Conversor getConversorSelecionado() {
        switch (this.opcaoSelecionada) {
            case MOEDAS:
                return new ConverteMoedas(escolheMoedas.getOpcaoSelecionada());
           
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }

    private TipoConversor mapearIndiceParaTipoConversor(int indice) {
        switch (indice) {
            case 0:
                return TipoConversor.MOEDAS;
          
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }

    private EscolheMoedas.TipoConversaoMoeda mostrarMenuMoedas() {
        String[] opcoesMoedas = {
                "Real/BRL para Dolar/USD",
                "Real/BRL para Euro/EUR",
                "Real/BRL para Libra/GBP",
                
        };
        
        JComboBox<String> comboMoedas = new JComboBox<>(opcoesMoedas);
        JOptionPane.showMessageDialog(null, comboMoedas, "Escolher a moeda:", JOptionPane.PLAIN_MESSAGE);

        int opcaoMoedaIndex = comboMoedas.getSelectedIndex();
        return mapearIndiceParaTipoConversao(opcaoMoedaIndex);
    }

    private EscolheMoedas.TipoConversaoMoeda mapearIndiceParaTipoConversao(int indice) {
        switch (indice) {
            case 0:
                return EscolheMoedas.TipoConversaoMoeda.BRL_PARA_USD;
            case 1:
                return EscolheMoedas.TipoConversaoMoeda.BRL_PARA_EUR;
            case 2:
                return EscolheMoedas.TipoConversaoMoeda.BRL_PARA_GBP;
            
            default:
                throw new IllegalArgumentException("Opção de conversão inválida");
        }
    }
}