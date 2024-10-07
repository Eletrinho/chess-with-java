package boardgame;

public class BoardException extends RuntimeException {

    public BoardException(String message) {
        super("\u001B[41m" + message + "\u001B[0m \n\nPress Enter to continue");
    }
}
