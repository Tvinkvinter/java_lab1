import java.util.Random;

public abstract class Unit {
    public char icon;
    StringBuffer buffer = new StringBuffer();
    int[] coordinates = new int[2];

    Unit(Field field) {
        int x = 0, y = 0;
        do {
            x = new Random().nextInt(field.len);
            y = new Random().nextInt(field.len);
        } while (field.map[x][y] != '_');
        coordinates[0] = x;
        coordinates[1] = y;
    }

    abstract String moveTo(Field field, int x, int y);

    protected void addBonusToBuffer() {
        buffer.append("bonus");
    }

    protected int countBonuses() {
        int pointCounter = 0;
        while (!buffer.isEmpty()) {
            buffer.delete(0, 5);
            pointCounter++;
        }
        return pointCounter;
    }
}
