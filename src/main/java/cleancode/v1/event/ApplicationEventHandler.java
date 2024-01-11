package cleancode.v1.event;

public interface ApplicationEventHandler<E> {

    void handle(E event);

    Class<E> getEventType();
}
