import java.util.*;

class Triple<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>> implements Comparable<Triple<T1, T2, T3>> {
    private T1 first;
    private T2 second;
    private T3 third;

    public Triple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public T3 getThird() {
        return third;
    }

    @Override
    public int compareTo(Triple<T1, T2, T3> other) {
        int cmp = this.first.compareTo(other.first);
        if (cmp != 0) {
            return cmp;
        }
        cmp = this.second.compareTo(other.second);
        if (cmp != 0) {
            return cmp;
        }
        return this.third.compareTo(other.third);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) obj;
        return Objects.equals(first, triple.first) &&
                Objects.equals(second, triple.second) &&
                Objects.equals(third, triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return "Triple<" + first + ", " + second + ", " + third + ">";
    }
}

public class Main {
    public static void main(String[] args) {
        // a. Wypisywanie klasy Triple z użyciem System.out.println
        Triple<Integer, String, Double> triple1 = new Triple<>(1, "two", 3.0);
        System.out.println(triple1);

        // b. Porównywanie elementów klasy Triple z użyciem metody equals
        Triple<Integer, String, Double> triple2 = new Triple<>(1, "two", 3.0);
        System.out.println("Are triple1 and triple2 equal? " + triple1.equals(triple2));

        // c. Tworzenie listy i dodawanie kilku obiektów typu Triple
        List<Triple<Integer, String, Double>> tripleList = new ArrayList<>();
        tripleList.add(new Triple<>(3, "four", 5.0));
        tripleList.add(new Triple<>(1, "two", 3.0));
        tripleList.add(new Triple<>(5, "six", 7.0));
        tripleList.add(new Triple<>(2, "three", 4.0));
        tripleList.add(new Triple<>(4, "five", 6.0));

        // d. Sortowanie listy i wypisywanie posortowanych elementów
        Collections.sort(tripleList);
        System.out.println("Sorted list:");
        for (Triple<Integer, String, Double> triple : tripleList) {
            System.out.println(triple);
        }

        // e. Sortowanie listy z użyciem Comparatora i wypisywanie posortowanych elementów
        Collections.sort(tripleList, Comparator.reverseOrder());
        System.out.println("Reverse sorted list:");
        for (Triple<Integer, String, Double> triple : tripleList) {
            System.out.println(triple);
        }
    }
}
