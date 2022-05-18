import java.util.Random;

public class Field {
    char[][] map;
    public int len = 0;
    private boolean isThereStar, isThereExclamationMark;

    Field(int len) {
        this.len = len;
        map = new char[len][len];

        //recreating the field until there are both * and !
        while (!isThereStar || !isThereExclamationMark) {
            for (int x = 0; x < len; x++) {
                for (int y = 0; y < len; y++) {
                    int rand_val = new Random().nextInt(100);
                    if (0 < rand_val && rand_val <= 75) map[x][y] = '_';
                    else if (75 < rand_val && rand_val <= 94) map[x][y] = '0';
                    else if (94 < rand_val && rand_val <= 97) {
                        map[x][y] = '*';
                        isThereStar = true;
                    } else {
                        map[x][y] = '!';
                        isThereExclamationMark = true;
                    }
                }
            }
        }
    }

    public void printField(Unit player) {
        for (int y = len - 1; y >= 0; y--) {
            System.out.print((y + 1) + "\t");
            for (int x = 0; x < len; x++) {
                if (x == player.coordinates[0] && y == player.coordinates[1])
                    System.out.print(player.icon + "  ");
                else System.out.print(map[x][y] + "  ");
            }
            System.out.println();
        }
        System.out.print("    ");
        for (int j = 0; j < len; j++) {
            System.out.print(j + 1 + "  ");
        }
        System.out.println();
    }
}
