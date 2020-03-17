package springrest.error;

public class CustomerNotFoundException extends RuntimeException
{
    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String string) {
        super(string);
    }

    public CustomerNotFoundException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public CustomerNotFoundException(Throwable thrwbl) {
        super(thrwbl);
    }  
    
    public CustomerNotFoundException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}
