public class EscolheMoedas {

    public enum TipoConversaoMoeda {
        REAL_PARA_DOLAR,
        REAL_PARA_EURO,
        REAL_PARA_LIBRA,
        
    }

    private final TipoConversaoMoeda opcaoSelecionada;

    public EscolheMoedas(TipoConversaoMoeda opcaoSelecionada) {
        this.opcaoSelecionada = opcaoSelecionada;
    }

    public TipoConversaoMoeda getOpcaoSelecionada() {
        return this.opcaoSelecionada;
    }
}