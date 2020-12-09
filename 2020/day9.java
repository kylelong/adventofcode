import java.util.*;

public class day9 {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLong()) {
            long number = scan.nextLong();
            list.add(number);
        }
        System.out.println(part1());
        part2();

    }

    public static long part1() {
        int index = 25, start = 0, end = 0;
        boolean found = false;
        while (index < list.size()) {
            start = index - 25;
            end = index - 1;
            long target = list.get(index);
            for (int i = start; i <= end; i++) {
                for (int j = start; j <= end; j++) {
                    long a = list.get(i);
                    long b = list.get(j);
                    if (i != j && a != b) {
                        if (a + b == target) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found)
                    break;
            }
            if (found == false) {
                return target;
            }
            found = false;
            index++;
        }
        return -1;
    }

    public static void part2() {
        long ans = 32321523;
        int i = 0, start = 0;
        long sum = 0;

        while (i < list.size() && sum != ans) {
            while (sum < ans) {
                sum += list.get(i);
                if (sum == ans) {
                    List<Long> numbers = new ArrayList<>();
                    System.out.printf("%d %d\n", start, i);
                    for (int k = start; k <= i; k++) {
                        numbers.add(list.get(k));
                    }
                    Collections.sort(numbers);
                    System.out.printf("%d + %d = %d \n", numbers.get(0), numbers.get(numbers.size() - 1),
                            numbers.get(0) + numbers.get(numbers.size() - 1));
                }

                i++;
            }
            sum = 0;
            start++;
            i = start;
        }
    }
}