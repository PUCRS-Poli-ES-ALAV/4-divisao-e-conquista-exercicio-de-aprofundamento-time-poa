package br.pucrs;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] testArray = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        long[] testArray2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // 1
        // System.out.println("Merge Sort: " +
        // java.util.Arrays.toString(mergeSort(testArray)));

        // 2
        // System.out.println("Max Value: " + maxVal1(testArray2, testArray2.length));

        // 3
        // System.out.println("Max Value (Divide and Conquer): " + maxVal2(testArray2,
        // testArray2.length));

        // 4.1
        // System.out.println("Multiply: " + multiply(10, 10));

        // 4.2
        System.out.println("Multiply Strings: " + multiply("111", "101"));

    }

    public static int[] mergeSort(int[] arr) {
        // 1. Vamos começar com um algorítmo já estudado e conhecido (em AEDI). O Merge
        // Sort é um algorítmo de ordenação baseado nos seguintes passos:

        // * recursivamente ordene a metade esquerda do vetor
        // * recursivamente ordene a metade direita do vetor
        // * mescle (faça o merge) das duas metades para ter o vetor ordenado.

        // Assim:

        // * implemente o algortimo abaixo;
        // * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32,
        // 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o
        // algoritmo executa, e o tempo gasto;

        // ```java
        // MERGE-SORT(L: List with n elements) : Ordered list with n elements
        // IF (list L has one element)
        // RETURN L.
        // Divide the list into two halves A and B.
        // A ← MERGE-SORT(A).
        // B ← MERGE-SORT(B).
        // L ← MERGE(A, B).
        // RETURN L.
        // `

        if (arr.length <= 1) {
            System.out.println("Base case reached with array: " + java.util.Arrays.toString(arr));
            return arr;
        } else {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
                System.out.println("Left array at index " + i + ": " + left[i]);
            }
            for (int i = mid; i < arr.length; i++) {
                right[i - mid] = arr[i];
                System.out.println("Right array at index " + (i - mid) + ": " + right[i - mid]);
            }
            left = mergeSort(left);
            right = mergeSort(right);
            return merge(left, right);
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

    public static long maxVal1(long A[], int n) {
        // 2. O algoritmo a seguir (que não utiliza divisão-e-conquista) encontra o
        // maior valor em um vetor.

        // Assim, novamente:

        // * implemente o algortimo abaixo;
        // * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32,
        // 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o
        // algoritmo executa, e o tempo gasto;

        // ```java
        // long maxVal1(long A[], int n) {
        // long max = A[0];
        // for (int i = 1; i < n; i++) {
        // if( A[i] > max )
        // max = A[i];
        // }
        // return max;
        // }
        // ```

        long max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max)
                max = A[i];
        }
        return max;
    }

    public static long maxVal2(long A[], int n) {
        // 3. O algoritmo a seguir (que utiliza divisão-e-conquista) encontra o maior
        // valor em um vetor.

        // Assim, novamente:

        // * implemente o algortimo abaixo;
        // * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32,
        // 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o
        // algoritmo executa, e o tempo gasto;

        // ```java
        // long maxVal2(long A[], int n) {
        // if (n == 1)
        // return A[0];
        // long max1 = maxVal2(A, n / 2);
        // long max2 = maxVal2(A + n / 2, n - n / 2);
        // return (max1 > max2) ? max1 : max2;
        // }
        // ```

        if (n == 1)
            return A[0];
        long max1 = maxVal2(A, n / 2);
        long max2 = maxVal2(java.util.Arrays.copyOfRange(A, n / 2, A.length), n - n / 2);
        return (max1 > max2) ? max1 : max2;
    }

    public static int multiply(int a, int b) {
        // 4.1 O algoritmo a seguir (que utiliza divisão-e-conquista) realiza a
        // multiplicação de dois números inteiros.

        // Assim, novamente:

        // * implemente o algortimo abaixo;
        // * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32,
        // 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o
        // algoritmo executa, e o tempo gasto;

        // ```java
        // int multiply(int a, int b) {
        // if (a == 0 || b == 0)
        // return 0;
        // if (a < b)
        // return multiply(b, a);
        // int half = multiply(a / 2, b);
        // if (a % 2 == 0)
        // return half + half;
        // else
        // return half + half + b;
        // }
        // ```

        if (a == 0 || b == 0)
            return 0;
        if (a < b)
            return multiply(b, a);
        int half = multiply(a / 2, b);
        if (a % 2 == 0)
            return half + half;
        else
            return half + half + b;
    }

    public static long multiply(String X, String Y) {
        // 4.2 Multiplica duas strings de bits x e y
        // e retorna o resultado como um inteiro "long".
        // public static long multiply(String X, String Y);

        return Integer.parseInt(X, 2) * Integer.parseInt(Y, 2);
    }

}
