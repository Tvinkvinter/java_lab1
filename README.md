# java_lab1
Console game in Java.

At the beginning, the program gives the user a choice of two characters – Rook and Bishop. The rook moves up, down, right or left. Bishop moves diagonally. After the selection, a field with the icon of the corresponding character is generated and printed. The field will be recreated until there is at least one “*” character and one “!” character on it.

The user can move the characters using the command /move_to(x, y), where x, y are the coordinates where the character will be on a successful move. After receiving the command, the program checks the following items:
1. Is the character is already in this position;
2. Does the point belong to the printed field;
3. Are there any obstacles on the trajectory of the course or on the point itself.

If the move can be executed, the program collects special cells along the path of the move and takes them into account in the corresponding variables. If the move cannot be executed, the user will receive a corresponding message.

The program execution can be terminated by the /exit command.
