import java.util.ArrayList;
import java.util.List;

class App {
  public static void main(String[] args) {
    App app = new App();

    // Exercicio 1
    List <Integer> list1 = app.generateList(32); // caso 1
    List <Integer> list2 = app.generateList(1024); // caso 2
    List <Integer> list3 = app.generateList(1048576); // caso

    long time1 = app.countTime(() -> app.mergeSort(list1));
    long time2 = app.countTime(() -> app.mergeSort(list2));
    long time3 = app.countTime(() -> app.mergeSort(list3));

    System.out.println("Caso 1: " + time1 + " ms");
    System.out.println("Caso 2: " + time2 + " ms");
    System.out.println("Caso 3: " + time3 + " ms");

    // Exercicio 2
    int [] A = app.sort(32);
    int [] B = app.sort(2048);
    int [] C = app.sort(1048576);

    app.maxVal1(A, A.length);
    app.maxVal1(B, B.length);
    app.maxVal1(C, C.length);

  }

  public int[] sort(int n) {
    int [] A = new int[n];
    for (int i = 0; i < A.length; i++) {
      A[i] = (int) (Math.random() * 1024);
    }

    return A;
  }

  public long countTime(Runnable r) {
    long start = System.currentTimeMillis();
    r.run();
    long end = System.currentTimeMillis();
    return end - start;
  }

  public List<Integer> generateList(int size) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add((int) (Math.random() * 1024));
    }
    return list;
  }

  public List<Integer> mergeSort(List<Integer> list) {
    if (list.size() == 1) {
      return list;
    }

    List<Integer> left = mergeSort(list.subList(0, list.size() / 2));
    List<Integer> right = mergeSort(list.subList(list.size() / 2, list.size()));

    return merge(left, right);
  }

  public List<Integer> merge(List<Integer> left, List<Integer> right) {
    List<Integer> result = new ArrayList<>();
    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {
      if (left.get(leftIndex) < right.get(rightIndex)) {
        result.add(left.get(leftIndex));
        leftIndex++;
      } else {
        result.add(right.get(rightIndex));
        rightIndex++;
      }
    }

    while (leftIndex < left.size()) {
      result.add(left.get(leftIndex));
      leftIndex++;
    }

    while (rightIndex < right.size()) {
      result.add(right.get(rightIndex));
      rightIndex++;
    }

    return result;
  }

 // Exercicio 2
  public void maxVal1(int[] A, int n) {
    int max = A[0];
    int count = 0;
    for (int i = 1; i < n; i++) {
      if( A[i] > max ) {
        count++;
        max = A[i];
      }
    }

    System.out.println("O maior valor é " + max + " e apareceu " + count + " vezes");
  }
}
