package Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        Map<String, Livro> meusLivros = new HashMap<>() {
            {
                put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
                put("Duhigg, Charles", new Livro("O Poder do habito", 408));
                put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
            }
        };

        for (Map.Entry<String, Livro> entry : meusLivros.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("-----------------");

        Map<String, Livro> meusLivros2 = new LinkedHashMap<>() {
            {
                put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
                put("Duhigg, Charles", new Livro("O Poder do habito", 408));
                put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
            }
        };

        for (Map.Entry<String, Livro> entry : meusLivros2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("-----------------");

        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);

        for (Map.Entry<String, Livro> entry : meusLivros3.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("-----------------");

        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());

        for (Map.Entry<String, Livro> entry : meusLivros4) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    public String toString() {
        return "{" +
                "nome='" + nome + "\'" +
                ", paginas=" + paginas +
                "}";
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Entry<String, Livro> livro1, Entry<String, Livro> livro2) {
        return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
    }

}