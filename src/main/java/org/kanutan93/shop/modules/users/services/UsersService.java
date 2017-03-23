package org.kanutan93.shop.modules.users.services;
import org.kanutan93.shop.modules.users.models.User;

import java.util.List;

public interface UsersService {
    User createUser(User item) throws IllegalAccessException, NoSuchFieldException;
    User updateUser(User item) throws IllegalAccessException, NoSuchFieldException;
    List<User> getUsers(String filter);
    void deleteUser(String name);
}
