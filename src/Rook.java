import java.util.Random;

import static java.lang.Math.abs;

public class Rook extends Unit {

    Rook(Field field) {
        super(field);
        icon = '@';
    }

    String moveTo(Field field, int x, int y) {
        x--;
        y--;
        int bonusCount = 0;
        if (x >= field.len || y >= field.len) return "You are going to move the character out of the field!";
        int k; // coefficient determines the direction of movement
        if (coordinates[0] == x) {
            if (y > coordinates[1]) k = 1;
            else if (y < coordinates[1]) k = -1;
            else return "Character is already in this position";

            for (int i = 1; coordinates[1] + i * k != y + k; i++) {
                if (field.map[x][coordinates[1] + i * k] == '0') return "This move is impossible!";
            }

            // collect bonuses on the way
            for (int i = 1; coordinates[1] + i * k != y + k; i++) {
                if (field.map[x][coordinates[1] + i * k] == '*') {
                    addBonusToBuffer();
                    field.map[x][coordinates[1] + i * k] = '_';
                } else if (field.map[x][coordinates[1] + i * k] == '!') {
                    System.out.println("You collected " + countBonuses() + " bonuses");
                    field.map[x][coordinates[1] + i * k] = '_';
                }
            }
            coordinates[1] = y;
            return "The move was made successfully";
        } else if (coordinates[1] == y) {
            if (x > coordinates[0]) k = 1;
            else if (x < coordinates[0]) k = -1;
            else return "Character is already in this position";

            for (int i = 1; coordinates[0] + i * k != x + k; i++) {
                if (field.map[coordinates[0] + i * k][y] == '0') return "This move is impossible!";
            }
            // collect bonuses on the way
            for (int i = 1; coordinates[0] + i * k != x + k; i++) {
                if (field.map[coordinates[0] + i * k][y] == '*') {
                    addBonusToBuffer();
                    field.map[coordinates[0] + i * k][y] = '_';
                } else if (field.map[coordinates[0] + i * k][y] == '!') {
                    System.out.println("You collected " + countBonuses() + " bonuses");
                    field.map[coordinates[0] + i * k][y] = '_';
                }
            }
            coordinates[0] = x;
            return "The move was made successfully";
        } else return "This move is impossible!";
    }
}
