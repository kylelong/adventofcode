import java.util.*;

public class day8 {
    static List<String> list = new ArrayList<>();
    static int accumulator = 0;
    static Set<Integer> set = new HashSet<>();
    static final int SIZE = 625;
    static String[] data = new String[SIZE];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index = 0;
        while (scan.hasNext()) {
            String line = scan.nextLine();
            list.add(line);
            data[index] = line;
            index++;
        }
        System.out.println(part1());
        part2();
    }

    public static int part1() {
        String[] line = null;
        int i = 0;
        boolean loop = false;
        while (loop == false && i < list.size()) {
            if (!set.add(i)) {
                loop = true;
                return accumulator;
            }
            String s = list.get(i);
            line = s.split(" ");
            String op = line[0]; // nop, acc, jmp,
            char sign = line[1].charAt(0);
            int num = Integer.valueOf(line[1].substring(1, line[1].length()));
            if (op.equals("nop")) {
                i++;
                continue;
            }
            if (op.equals("acc")) {
                if (sign == '-') {
                    accumulator -= num;
                } else if (sign == '+') {
                    accumulator += num;
                }
                i++;

            }
            if (op.equals("jmp")) {
                if (sign == '-') {
                    i -= num;
                } else if (sign == '+') {
                    i += num;
                }

            }

        }
        return accumulator;

    }

    public static void part2() {
        String[] line = null;
        String[] result = new String[SIZE];
        for (int i = 0; i < SIZE; i++) {
            String s = data[i];
            line = s.split(" ");
            String op = line[0].trim(); // nop, acc, jmp,
            if (hasLoop(data) == false) {
                result = data;
                terminate(data);
                return;
            }
            if (op.equals("nop")) {
                String replace = "jmp" + s.substring(3, s.length());
                data[i] = replace;
                if (hasLoop(data) == false) {
                    result = data;
                    terminate(result);
                    return;
                }
                data[i] = s;

            } else if (op.equals("jmp")) {
                String replace = "nop" + s.substring(3, s.length());
                data[i] = replace;
                if (hasLoop(data) == false) {
                    result = data;
                    terminate(result);

                    return;
                }
                data[i] = s;
            }
        }

    }

    public static int terminate(String[] l) {
        String[] line = null;
        int i = 0;
        accumulator = 0;
        set = new HashSet<>();
        while (i < SIZE) {
            String s = l[i];
            line = s.split(" ");
            String op = line[0].trim(); // nop, acc, jmp,
            char sign = line[1].charAt(0);

            int num = Integer.valueOf(line[1].substring(1, line[1].length()));
            if (op.equals("nop")) {
                i++;
                continue;
            }
            if (op.equals("acc")) {
                if (sign == '-') {
                    accumulator -= num;
                } else if (sign == '+') {
                    accumulator += num;
                }
                i++;

            }
            if (op.equals("jmp")) {
                if (sign == '-') {
                    i -= num;
                } else if (sign == '+') {
                    i += num;
                }

            }

        }
        System.out.println(accumulator);
        return accumulator;

    }

    public static boolean hasLoop(String[] l) {
        String[] line = null;
        int i = 0;
        boolean loop = false;
        accumulator = 0;
        set = new HashSet<>();
        while (loop == false && i < list.size()) {
            if (!set.add(i)) {
                loop = true;
                return true;
            }
            String s = l[i];
            line = s.split(" ");
            String op = line[0]; // nop, acc, jmp,
            char sign = line[1].charAt(0);
            int num = Integer.valueOf(line[1].substring(1, line[1].length()));
            if (op.equals("nop")) {
                i++;
                continue;
            }
            if (op.equals("acc")) {
                if (sign == '-') {
                    accumulator -= num;
                } else if (sign == '+') {
                    accumulator += num;
                }
                i++;

            }
            if (op.equals("jmp")) {
                if (sign == '-') {
                    i -= num;
                } else if (sign == '+') {
                    i += num;
                }

            }

        }
        return false;

    }
}