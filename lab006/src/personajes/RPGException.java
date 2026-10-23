package personajes;
public class RPGException extends Exception {
    
    public RPGException(String message) {
        super(message);
    }
    public RPGException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
