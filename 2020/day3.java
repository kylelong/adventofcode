import java.util.*;

class day3 {
    static char[][] grid = new char[323][31];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = 0;
        while (scan.hasNext()) {
            String s = scan.nextLine();
            for (int i = 0; i < grid[0].length; i++) {
                grid[row][i] = s.charAt(i);
            }
            row++;
        }
        scan.close();
        System.out.println(part1(3, 1) * part1(1, 1) * part1(5, 1) * part1(7, 1) * part1(1, 2));
    }

    static long part1(int x, int y) {
        int row = 0, col = 0;
        long count = 0;
        if (grid[row][col] == '#')
            count++;
        while (row < 323) {
            row += y;
            col += x;
            if (row < 323 && grid[row][col % 31] == '#')
                count++;
        }
        return count;
    }
}