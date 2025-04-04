import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class base {
    public static void main(String[] args) throws FileNotFoundException {
        String pathFile = "/tmp/disneyplus.csv";
        String pathFileWin = "./disneyplus.csv";

        // Procura o Arquivo
        File file = new File(pathFileWin);

        // Lê do arquivo para salvar no código
        Scanner sc = new Scanner(file);

        // Pula o cabeçálio
        sc.nextLine();

        // Array de Shows!
        Show[] shows = new Show[1368];

        // while (sc.hasNextLine()) {
        // String linha = sc.nextLine();
        // array[n] = linha;
        // n++;
        // }
        String temp = sc.nextLine();

        shows[0].ler(temp);

        System.out.println(shows[0].show_id);

        sc.close();
    }

}

class RetornoDuplo {
    public RetornoDuplo(String resultado, String linhaEncurtada) {
        this.resultado = resultado;
        this.linhaEncurtada = linhaEncurtada;
    }

    String resultado;
    String linhaEncurtada;
}

class Show {
    String show_id;
    String type;
    String title;
    String director;
    String country;
    String rating;
    String duration;
    String[] cast;
    String[] listed_in;

    Date date_added;
    int release_year;

    public static RetornoDuplo descascador(String linha, int tipo) {
        // Tipo 1 = sem aspas ------ Tipo 2 = com aspas

        String resultado = "";
        String linhaEncurtada = "";
        int i = 0;

        // Lendo até encontrar uma ,
        if (tipo == 1) {
            while (linha.charAt(i) != ',') {
                resultado += linha.charAt(i);
                i++;
            }
            i++;
        }
        // Reduzindo o resto da linha para simplificar o código
        for (; i < linha.length(); i++) {
            linhaEncurtada += linha.charAt(i);
        }

        RetornoDuplo retorno = new RetornoDuplo(resultado, linhaEncurtada);
        return retorno;
    }

    public Show ler(String linha) {
        Show show = new Show();

        // Lê o ID
        RetornoDuplo r = descascador(linha, 1);
        show.show_id = r.resultado;
        linha = r.linhaEncurtada;

        System.out.println(show.show_id);

        return show;
    }
}