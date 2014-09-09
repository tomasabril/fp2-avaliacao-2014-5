
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utfpr.ct.dainf.if62c.avaliacao.Ordenador;

/**
 * IF62C Fundamentos de Programação 2 Avaliação parcial.
 *
 * @author 1013343 Tomás Abril <tomas@alunos.utfpr.edu.br>
 */
public class Avaliacao5 {

    public static void main(String[] args) {
        List<Ordenador> ordenadores = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String caminho = "";

        while (true) {
            System.out.print("Ordenar> ");
            caminho = input.nextLine();

            if (caminho.equals("") || caminho == null) {
                //System.out.println("leu vazio");
                break;
            } else {
                Ordenador o = new Ordenador(caminho);
                o.start();
                ordenadores.add(o);
                caminho = "";
                //System.out.println("ordenando");
            }
        }
        //System.out.println("fim da leitura");
        int i = 0;
        for (Ordenador o : ordenadores) {
            if (!o.isTerminou()) {
                i++;
            }
        }
        if (i != 0) {
            System.out.println("Aguardando o processamento de " + i + " arquivo...");
        }
        for (Ordenador o : ordenadores) {

            while (!o.isTerminou()) {
                try {
                    //System.out.println("esperando");
                    o.wait();
                    //System.out.println("terminou a espera");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Avaliacao5.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //System.out.println("fim");
    }
}
