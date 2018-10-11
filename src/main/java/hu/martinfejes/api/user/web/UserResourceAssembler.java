package hu.martinfejes.api.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;

import hu.martinfejes.api.user.User;

@Service
public class UserResourceAssembler implements ResourceAssembler<User, Resource<User>> {

    private EntityLinks entityLinks;

    @Autowired
    UserResourceAssembler(EntityLinks entityLinks) {
        this.entityLinks = entityLinks;
    }

    @Override
    public Resource<User> toResource(User user) {
        Link self = entityLinks.linkFor(User.class).slash(user.getId()).withSelfRel();
        Link rel = entityLinks.linkFor(User.class).slash(user.getId()).withRel("user");
        return new Resource<>(user, self, rel);
    }
}
