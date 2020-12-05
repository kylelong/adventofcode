import java.util.*;

class day1 {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            list.add(num);
        }
        partOne();
        partTwo();

    }

    public static void partOne() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == 2020) {
                    System.out.println(list.get(i) * list.get(j));
                }
            }
        }
    }

    public static void partTwo() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    if (list.get(i) + list.get(j) + list.get(k) == 2020) {
                        System.out.println(list.get(i) * list.get(j) * list.get(k));
                    }
                }
            }
        }
    }
}