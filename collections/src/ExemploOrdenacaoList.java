import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        List<Gato> meuGatos = new ArrayList<>() {
            {
                add(new Gato("Jon", 18, "preto"));
                add(new Gato("Simba", 6, "tigrado"));
                add(new Gato("Jon", 12, "amarelo"));
            }
        };
        System.out.println(meuGatos);

        Collections.shuffle(meuGatos);
        System.out.println(meuGatos);

        Collections.sort(meuGatos);
        System.out.println(meuGatos);

        // Collections.sort(meuGatos, new ComparatorIdade());
        meuGatos.sort(new ComparatorIdade());
        System.out.println(meuGatos);

        // Collections.sort(meuGatos, new ComparatorCor());
        meuGatos.sort(new ComparatorCor());
        System.out.println(meuGatos);

        // Collections.sort(meuGatos, new ComparatorCor());
        meuGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meuGatos);
    }
}

class Gato implements Comparable<Gato> {
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato gato1, Gato gato2) {
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }

}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato gato1, Gato gato2) {
        return gato1.getCor().compareToIgnoreCase(gato2.getCor());
    }

}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato gato1, Gato gato2) {
        int nome = gato1.getNome().compareToIgnoreCase(gato2.getNome());
        if (nome != 0) {
            return nome;
        }

        int cor = gato1.getCor().compareToIgnoreCase(gato2.getCor());
        if (cor != 0) {
            return cor;
        }

        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }

}