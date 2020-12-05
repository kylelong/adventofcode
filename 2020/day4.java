import java.util.*;

public class day4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] delim = { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid" };
        List<String> fields = new ArrayList<>();
        for (String d : delim)
            fields.add(d);

        int valid = 0;
        List<String> data = new ArrayList<>();
        List<String> colors = new ArrayList<>();
        colors.add("amb");
        colors.add("blu");
        colors.add("brn");
        colors.add("gry");
        colors.add("grn");
        colors.add("hzl");
        colors.add("oth");
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            if (s.isEmpty()) {
                if (data.size() == 7) {
                    boolean good = true;
                    for (String str : data) {
                        String field = str.substring(0, 3);
                        String value = str.substring(4, str.length());
                        if (field.equals("byr")) {
                            int year = Integer.valueOf(value);
                            if (year < 1920 || year > 2002)
                                good = false;
                        }
                        if (field.equals("iyr")) {
                            int year = Integer.valueOf(value);
                            if (year < 2010 || year > 2020)
                                good = false;
                        }
                        if (field.equals("eyr")) {
                            int year = Integer.valueOf(value);
                            if (year < 2020 || year > 2030)
                                good = false;
                        }
                        if (field.equals("hgt")) {
                            if (value.endsWith("cm")) {
                                int height = Integer.parseInt(value.substring(0, value.length() - 2));
                                if (height < 150 || height > 193)
                                    good = false;
                            } else if (value.endsWith("in")) {
                                int height = Integer.parseInt(value.substring(0, value.length() - 2));
                                if (height < 59 || height > 76)
                                    good = false;
                            } else {
                                good = false;
                            }
                        }
                        if (field.equals("hcl")) {
                            if (!value.matches("^#[0-9a-f]{6}"))
                                good = false;
                        }
                        if (field.equals("ecl")) {
                            if (!colors.contains(value))
                                good = false;
                        }
                        if (field.equals("pid")) {

                            if (value.length() == 9) {
                                for (char c : value.toCharArray()) {
                                    if (c >= '0' && c <= '9') {
                                        continue;
                                    } else {
                                        good = false;
                                    }
                                }
                            } else {
                                good = false;
                            }

                        }
                    }

                    if (good)
                        valid++;
                }
                data = new ArrayList<>();
            } else {
                String[] arr = s.split(" ");
                for (String a : arr) {
                    if (fields.contains(a.substring(0, 3))) {
                        data.add(a);
                    }
                }

            }

        }
        System.out.println(data.size());
        System.out.println(valid);
    }

    public static void part1() {
        Scanner scan = new Scanner(System.in);
        String[] delim = { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid" };
        int valid = 0, count = 0;

        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            if (s.isEmpty()) {
                if (count == 7) {
                    valid++;
                }
                count = 0;
            } else {
                for (String d : delim) {
                    if (s.indexOf(d) != -1) {
                        count++;
                    }
                }
            }

        }
        System.out.println(valid);
    }

    public static void part2() {

    }
}