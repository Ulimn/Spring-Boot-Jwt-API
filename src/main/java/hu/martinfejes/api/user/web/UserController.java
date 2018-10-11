package hu.martinfejes.api.user.web;

import hu.martinfejes.api.user.Email;
import hu.martinfejes.api.user.User;
import hu.martinfejes.api.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * Controller to handle {@link User} entities.
 */
@BasePathAwareController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final @NonNull UserRepository repository;
    private final @NonNull UserResourceAssembler userResourceAssembler;

    /**
     * Show the data of the currenctly logged in {@link User}.
     * @param principal
     * @return
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/me")
    public @ResponseBody
    ResponseEntity<?> showOwnPage(Principal principal) {
        System.out.println(principal.getName());
        User user = repository.findByEmail(new Email(principal.getName()));

        if (user == null) {
            throw new UserNotFoundException(); // TODO web response?
        }

        Resource<User> resource = userResourceAssembler.toResource(user);

        return ResponseEntity.ok().eTag(String.valueOf(user.getVersion())).body(resource);
    }
}
