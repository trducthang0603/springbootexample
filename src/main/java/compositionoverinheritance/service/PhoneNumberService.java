package compositionoverinheritance.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PhoneNumberService {
    private final Map<Long, String> phoneNumberByUserId =  Map.of(1L, "0123456789");
    public String getPhoneNumberByUserId(long userId) {
        return phoneNumberByUserId.get(userId);
    }
}