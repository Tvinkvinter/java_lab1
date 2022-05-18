import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int choice;
        Field field = new Field(10);
        Unit player = null;
        Scanner input = new Scanner(System.in);
        System.out.print("Chose the character:\n" +
                "1. Rook\n" +
                "2. Bishop\n" +
                "Enter the number: ");
        while (player == null) {
            choice = input.nextInt();
            if (choice == 1) {
                player = new Rook(field);
                System.out.println("Icon of the character is " + player.icon);
                game(field, player);

            } else if (choice == 2) {
                player = new Bishop(field);
                System.out.println("Icon of the character is " + player.icon);
                game(field, player);

            } else if (choice == 0) return;
            else System.out.println("Wrong number! Try again");
        }
    }


    private static void game(Field field, Unit player) {
        String command;
        int x, y, xIndex, yIndex;
        Scanner input = new Scanner(System.in);
        String regex = "\\/move_to\\(\\d+, \\d+\\)";
        Pattern patternCommandMove = Pattern.compile(regex);
        do {
            field.printField(player);
            System.out.println("Use the command /move_to(x, y) to move the character to point (x, y) and /exit to end the game");
            command = input.nextLine();
            if (patternCommandMove.matcher(command).matches()) {
                xIndex = command.indexOf('(') + 1;
                yIndex = command.indexOf(',') + 2;
                x = Integer.parseInt(command.substring(xIndex, command.indexOf(',')));
                y = Integer.parseInt(command.substring(yIndex, command.lastIndexOf(')')));
                System.out.println(player.moveTo(field, x, y));
            } else if (command.equals("/exit")) System.out.print("See you!");
            else System.out.println("Command is not recognized!");

        } while (!"/exit".equals(command));
    }
}
