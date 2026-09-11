public class MainClass {
    public static void main(String[] args) {

        double taxa = 0.10;
        
        IngressoComum comum1 = new IngressoComum("C001", 200.0, "Kaue", false);
        IngressoComum comum2 = new IngressoComum(200.0, true);
        //IngressoComum comum3 = new IngressoComum(200.0, false);

        IngressoVip vip1 = new IngressoVip("V001", 200.0, "Bruninho", true);
        IngressoVip vip2 = new IngressoVip("V002", 200.0);

        IngressoCamarote cam1 = new IngressoCamarote("CAM001",200.0, "Renatinho", "Setor B");
        IngressoCamarote cam2 = new IngressoCamarote("CAM002", 200.0);

        System.out.println("\n--- INGRESSOS COMUNS ---");
        comum1.imprimirDados(taxa);
        comum2.imprimirDados(taxa);
        System.out.println(comum1.getResumo(taxa));
        //comum3.imprimirDados(taxa);
    
        System.out.println("\n--- INGRESSOS VIP ---");
        vip1.imprimirDados(taxa);
        vip2.imprimirDados(taxa);
        System.out.println(vip1.getResumo(taxa));

        System.out.println("\n--- INGRESSOS CAMAROTE ---");
        cam1.imprimirDados(taxa);
        cam2.imprimirDados(taxa);
        System.out.println(cam1.getResumo(taxa));

        System.out.println("\nMudar o camarote 2");
        cam2.mudarSetor("Setor Premium");
        cam2.imprimirDados(taxa);
        
    }
}