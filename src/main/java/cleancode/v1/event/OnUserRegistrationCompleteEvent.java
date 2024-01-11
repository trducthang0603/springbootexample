package cleancode.v1.event;

import cleancode.v1.model.User;

public class OnUserRegistrationCompleteEvent extends ApplicationEvent {

    private String redirectUrl;
    private User user;

    public OnUserRegistrationCompleteEvent(User user, String redirectUrl) {
        super(user);
        this.user = user;
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
