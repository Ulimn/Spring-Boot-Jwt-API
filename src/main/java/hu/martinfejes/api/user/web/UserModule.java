package hu.martinfejes.api.user.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.module.SimpleModule;
import hu.martinfejes.api.user.Email;
import hu.martinfejes.api.user.User;

/**
 * Module class for {@link User} entity.
 */
public class UserModule extends SimpleModule {

    private static final long serialVersionUID = -7508540231713896829L;

    public UserModule() {
        setMixInAnnotation(User.class, UserMixin.class);
    }

    @JsonAutoDetect(isGetterVisibility = JsonAutoDetect.Visibility.NONE)
    static abstract class UserMixin {

        abstract @JsonUnwrapped
        Email getEmail();
    }
}
