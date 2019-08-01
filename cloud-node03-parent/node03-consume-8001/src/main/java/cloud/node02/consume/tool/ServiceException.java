package cloud.node02.consume.tool;

public class ServiceException extends RuntimeException {
    public ServiceException (String msg){
        super(msg);
    }
}
