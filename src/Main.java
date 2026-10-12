import java.util.Arrays;

/**
 * ALP - cw2: rozwiązania zadań.
 * Wszystkie metody są void - wynik wypisujemy przez System.out.println(...).
 * A = tablica n liczb rzeczywistych z przedziału [0, 1].
 */
public class Main {

    // 1. Największy element
    // Algorytm: max = A[0], potem jedno przejście po tablicy.
    // Złożoność: O(n)
    static void najwiekszyElement(double[] A) {
        if (A.length == 0) {
            System.out.println("Pusta tablica.");
            return;
        }
        double max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        System.out.println(max);
    }

    // 2. Średnia
    // Algorytm: suma wszystkich elementów / n.
    // Złożoność: O(n)
    static void srednia(double[] A) {
        if (A.length == 0) {
            System.out.println("Nie można obliczyć średniej dla pustej tablicy.");
            return;
        }
        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        System.out.println(sum / A.length);
    }

    // 3. Elementy większe od średniej
    // Algorytm: pierwszy przebieg - średnia, drugi - zliczanie elementów > średnia.
    // Złożoność: O(n) + O(n) = O(n)
    static void elementyWiekszeOdSredniej(double[] A) {
        if (A.length == 0) {
            System.out.println(0);
            return;
        }
        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        double avg = sum / A.length;

        int licznik = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > avg) {
                licznik++;
            }
        }
        System.out.println(licznik);
    }

    // 4. Element większy od 0,5
    // Algorytm: przerywamy przy pierwszym znalezionym elemencie.
    // Złożoność: O(n) w najgorszym przypadku
    static void elementWiekszyOd05(double[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0.5) {
                System.out.println("tak");
                return;
            }
        }
        System.out.println("nie");
    }

    // 5. k-ty największy element
    // Algorytm: kopia tablicy, sortowanie, element o indeksie n - k.
    // Złożoność: O(n log n)
    static void ktyNajwiekszyElement(double[] A, int k) {
        if (k < 1 || k > A.length) {
            System.out.println("Nieprawidłowa wartość k.");
            return;
        }
        double[] copy = Arrays.copyOf(A, A.length);
        Arrays.sort(copy);
        System.out.println(copy[copy.length - k]);
    }

    // 6. Duplikaty (bez dodatkowych struktur danych)
    // Algorytm: porównujemy każdą parę i < j.
    // Złożoność: O(n^2)
    static void duplikaty(double[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    System.out.println("Są duplikaty.");
                    return;
                }
            }
        }
        System.out.println("Nie ma duplikatów.");
    }

    // 7. Wszystkie pary i < j: A[i] + A[j]
    // Złożoność: O(n^2)
    static void wszystkiePary(double[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                System.out.println(A[i] + A[j]);
            }
        }
    }

    // 8. Sortowanie bąbelkowe (sortuje tablicę A "w miejscu")
    // Algorytm: porównujemy sąsiadów i zamieniamy, jeśli są w złej kolejności.
    //           Z flagą: jeśli w przebiegu nie było zamiany, kończymy.
    // Złożoność: O(n^2) (O(n) dla już posortowanej tablicy dzięki fladze)
    static void sortowanieBabelkowe(double[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            boolean bylaZamiana = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    double tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                    bylaZamiana = true;
                }
            }
            if (!bylaZamiana) {
                break;
            }
        }
        System.out.println(Arrays.toString(A));
    }

    // 9. Najmniejsza różnica |A[i] - A[j]|
    // Algorytm: sortujemy kopię; najmniejsza różnica jest między sąsiadami.
    // Złożoność: O(n log n)
    static void najmniejszaRoznica(double[] A) {
        if (A.length < 2) {
            System.out.println("Potrzeba co najmniej 2 elementów.");
            return;
        }
        double[] sorted = Arrays.copyOf(A, A.length);
        Arrays.sort(sorted);

        double minRoznica = sorted[1] - sorted[0];
        double a = sorted[0];
        double b = sorted[1];
        for (int i = 1; i < sorted.length - 1; i++) {
            double roznica = sorted[i + 1] - sorted[i];
            if (roznica < minRoznica) {
                minRoznica = roznica;
                a = sorted[i];
                b = sorted[i + 1];
            }
        }
        System.out.println("Najmniejsza różnica: " + minRoznica + " (liczby: " + a + " i " + b + ")");
    }

    // 10. Wszystkie trójki i < j < k: A[i] + A[j] + A[k]
    // Złożoność: O(n^3)
    static void wszystkieTrojki(double[] A) {
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 1; j < A.length - 1; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    System.out.println(A[i] + A[j] + A[k]);
                }
            }
        }
    }

    // 11. Mediana
    // Algorytm: sortujemy kopię; środkowy element lub średnia dwóch środkowych.
    // Złożoność: O(n log n)
    static void mediana(double[] A) {
        if (A.length == 0) {
            System.out.println("Pusta tablica.");
            return;
        }
        double[] sorted = Arrays.copyOf(A, A.length);
        Arrays.sort(sorted);
        int n = sorted.length;
        if (n % 2 == 1) {
            System.out.println("Mediana: " + sorted[n / 2]);
        } else {
            System.out.println("Mediana: " + (sorted[n / 2 - 1] + sorted[n / 2]) / 2.0);
        }
    }

    // 12. Suma kwadratów
    // Złożoność: O(n)
    static void sumaKwadratow(double[] A) {
        double suma = 0;
        for (int i = 0; i < A.length; i++) {
            suma += A[i] * A[i];
        }
        System.out.println("Suma kwadratów: " + suma);
    }

    // 13. Procent liczb większych od średniej
    // Algorytm: średnia, licznik elementów > średnia, wynik = licznik * 100.0 / n.
    // Złożoność: O(n)
    static void procent(double[] A) {
        if (A.length == 0) {
            System.out.println("Pusta tablica.");
            return;
        }
        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        double avg = sum / A.length;

        int licznik = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > avg) {
                licznik++;
            }
        }
        System.out.println("Procent: " + (licznik * 100.0 / A.length) + "%");
    }

    public static void main(String[] args) {
        double[] A = {0.12, 0.85, 0.33, 0.5, 0.91, 0.07, 0.64};

        najwiekszyElement(A);
        srednia(A);
        elementyWiekszeOdSredniej(A);
        elementWiekszyOd05(A);
        ktyNajwiekszyElement(A, 3);
        duplikaty(A);
        wszystkiePary(A);
        sortowanieBabelkowe(Arrays.copyOf(A, A.length)); // kopia, żeby nie zmieniać A
        najmniejszaRoznica(A);
        wszystkieTrojki(A);
        mediana(A);
        sumaKwadratow(A);
        procent(A);
    }
}