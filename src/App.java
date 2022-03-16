import java.util.ArrayList;
import java.util.List;

class App {
  public static void main(String[] args) {
    App app = new App();
    List <Integer> list1 = app.generateList(32); // caso 1
    List <Integer> list2 = app.generateList(1024); // caso 2
    List <Integer> list3 = app.generateList(1048576); // caso

    long time1 = app.countTime(() -> app.mergeSort(list1));
    long time2 = app.countTime(() -> app.mergeSort(list2));
    long time3 = app.countTime(() -> app.mergeSort(list3));

    System.out.println("Caso 1: " + time1 + " ms");
    System.out.println("Caso 2: " + time2 + " ms");
    System.out.println("Caso 3: " + time3 + " ms");

  }

  // count time function in milliseconds
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
}
