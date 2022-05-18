import static java.lang.Math.abs;

public class Bishop extends Unit {
    StringBuffer buffer;

    Bishop(Field field) {
        super(field);
        icon = '&';
    }

    String moveTo(Field field, int x, int y) {
        x--;
        y--;
        if (x == coordinates[0] && y == coordinates[1]) return "Character is already in this position";
        if (x >= field.len || y >= field.len) return "You are going to move the character out of the field!";
        if (abs(abs(x) - coordinates[0]) == abs(abs(y) - coordinates[1])) {
            int kX, kY; // coefficients determine the direction of movement
            if (x > coordinates[0]) kX = 1;
            else kX = -1;
            if (y > coordinates[1]) kY = 1;
            else kY = -1;
            for (int i = 1; coordinates[0] + i * kX != x + kX && coordinates[1] + i * kY != y + kY; i++) {
                if (field.map[coordinates[0] + i * kX][coordinates[1] + i * kY] == '0')
                    return "This move is impossible!";
            }
            // collect bonuses on the way
            for (int i = 1; coordinates[0] + i * kX != x + kX && coordinates[1] + i * kY != y + kY; i++) {
                if (field.map[coordinates[0] + i * kX][coordinates[1] + i * kY] == '*') {
                    addBonusToBuffer();
                    field.map[coordinates[0] + i * kX][coordinates[1] + i * kY] = '_';
                } else if (field.map[coordinates[0] + i * kX][coordinates[1] + i * kY] == '!') {
                    System.out.println("You collected " + countBonuses() + " bonuses");
                    field.map[coordinates[0] + i * kX][coordinates[1] + i * kY] = '_';
                }
            }
            coordinates[0] = x;
            coordinates[1] = y;
            return "The move was made successfully";
        } else return "This move is impossible!";
    }
}
