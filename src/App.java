import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class App {
  public static void main(String[] args) {
    App app = new App();
    List <Integer> list = app.generateList(32);
    list = app.mergeSort(list);
    System.out.println(list);

  }

  public List<Integer> generateList(int size) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add((int) (Math.random() * 100));
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
