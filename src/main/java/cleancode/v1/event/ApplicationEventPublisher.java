package cleancode.v1.event;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ApplicationEventPublisher {

    //private final EzySingletonFactory singletonFactory;

//    public ApplicationEventPublisher(EzySingletonFactory singletonFactory) {
//        this.singletonFactory = singletonFactory;
//    }

    public void publishEvent(OnUserRegistrationCompleteEvent event) {
        List<ApplicationEventHandler> eventHandlers = new ArrayList<>();
//                singletonFactory.getSingletonsOf(ApplicationEventHandler.class);
        for (ApplicationEventHandler handler : eventHandlers) {
            if (handler.getEventType() == OnUserRegistrationCompleteEvent.class) {
                handler.handle(event);
            }
        }
    }
}
