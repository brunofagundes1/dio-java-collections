package Set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {
    public static void main(String[] args) {
        Set<Double> notas = new HashSet<>(Arrays.asList(7.0, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6));
        System.out.println(notas);

        System.out.println(notas.contains(5.0));
        
        System.out.println(Collections.min(notas));

        System.out.println(Collections.max(notas));

        Iterator<Double> iterator1 = notas.iterator();
        Double soma = 0.0;
        while(iterator1.hasNext()){
            soma += iterator1.next();
        }
        System.out.println(soma);

        System.out.println(soma/notas.size());

        notas.remove(0.0);
        System.out.println(notas);

        Iterator<Double> iterator2 = notas.iterator();
        while(iterator2.hasNext()){
            if(iterator2.next() < 7){
                iterator2.remove();
            }
        }
        System.out.println(notas);

        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7.0, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6));
        System.out.println(notas2);

        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        notas.clear();
        System.out.println(notas);

        System.out.println(notas.isEmpty());
        System.out.println(notas2.isEmpty());
        System.out.println(notas3.isEmpty());
    }
}
