// Pedido.java
class Pedido {
    private Item[] itens;
    private int qtd;
    // Estado do cupom
    private boolean cupomAplicado = false;
    private String cupomCodigo = "";
    private double descontoPercent = 0.0; // 0, 5 ou 10
    public Pedido() { this(10); }
    public Pedido(int capacidade) {
        if (capacidade <= 0) throw new IllegalArgumentException("Capacidade inválida");
        this.itens = new Item[capacidade];
        this.qtd = 0;
    }
    public boolean adicionarItem(Item item) {
        if (item == null) return false; // defensivo
        if (qtd == itens.length) return false;
        itens[qtd++] = item;
        return true;
    }
    public void listarItens() {
        if (qtd == 0) {
            System.out.println("(sem itens)");
            return;
        }
        for (int i = 0; i < qtd; i++) {
            System.out.println((i + 1) + ". " + itens[i]);
        }
    }
    public double calcularSubtotal() {
        double total = 0.0;
        for (int i = 0; i < qtd; i++) {
            total += itens[i].getPreco();
        }
        return total;
    }

    //aplicarCupom
    public boolean aplicarCupom(String codigo) {
        // TODO: recusar se já aplicado
        if(cupomAplicado){
            return false;
        }
        // TODO: cupom só faz sentido se houver ao menos 1 item
        if(qtd == 0){
            return false;
        }
        if(codigo == null){
            return false;
        }
        codigo = codigo.trim().toUpperCase();
        double desconto = 0.0;

        // TODO: aceitar PROMO10 (10%) e PROMO5 (5%). Outros → false
        if(codigo.equals("PROMO10")){
            desconto = 0.10;
        }
        else if(codigo.equals("PROMO5")){
            desconto = 0.05;
        }
        else{
            return false;
        }
        
        // TODO: gravar estado interno (cupomAplicado, cupomCodigo, descontoPercent) e retornar true
        this.descontoPercent = desconto;
        this.cupomAplicado = true;
        this.cupomCodigo = codigo;
        return true;
    }
    public double calcularTaxa(double taxaPercent) {
        // TODO: taxaPercent deve estar entre 0 e 20 (inclusive)
        if(taxaPercent < 0.0 || taxaPercent > 20.0){
            return 0.0;
        }
        double subTotal = calcularSubtotal();
        double base = subTotal;

        // TODO: base da taxa = subtotal - desconto
        if(cupomAplicado){
            base = subTotal  - (subTotal * descontoPercent);
        }

        // TODO: retornar valor da taxa (double)
        return base * (taxaPercent / 100);
    }
    public double calcularTotal(double taxaPercent) {
        // TODO: usar calcularSubtotal(), descontoPercent, calcularTaxa(taxaPercent)
        double subtotal = calcularSubtotal();
        double descontoCupom = 0.0;
        if(cupomAplicado){
            descontoCupom = subtotal * descontoPercent;
        }
        // TODO: total = subtotal - desconto + taxa
        double taxa = calcularTaxa(taxaPercent);
        double total = subtotal - descontoCupom + taxa;
        return total;
    }
    public String gerarRelatorio(double taxaPercent) {
        double subtotal = calcularSubtotal();
        double desconto = subtotal * descontoPercent;
        double baseTaxa = subtotal - desconto;
        double taxa = calcularTaxa(taxaPercent);
        double total = subtotal - desconto + taxa;
        StringBuilder sb = new StringBuilder();
        sb.append("--- Recibo ---\n");
        if (qtd == 0) {
            sb.append("(sem itens)\n");
        } else {
            for (int i = 0; i < qtd; i++) {
                sb.append(String.format("%d. %s\n", (i + 1), itens[i].toString()));
            }
        }
        sb.append("Subtotal: R$ ").append(moeda(subtotal)).append("\n");
        if (cupomAplicado) {
            sb.append("Cupom ").append(cupomCodigo)
              .append(": R$ ").append(moeda(desconto)).append("\n");
        } else {
            sb.append("Cupom: (nenhum)\n");
        }
        sb.append(String.format("Taxa (%.0f%%): +R$ %s\n", taxaPercent, moeda(taxa)));
        sb.append("TOTAL: R$ ").append(moeda(total)).append("\n");
        return sb.toString();
    }
    public static String moeda(double v) {
        // Centraliza formatação com 2 casas decimais
        return String.format("%.2f", v);
    }
    // Getters úteis para testes (opcional)
    public boolean isCupomAplicado() { return cupomAplicado; }
    public String getCupomCodigo() { return cupomCodigo; }
    public double getDescontoPercent() { return descontoPercent; }
    public int getQuantidade(){
        return qtd;
    }
    public int getCapacidade(){
        return itens.length;
    }
}