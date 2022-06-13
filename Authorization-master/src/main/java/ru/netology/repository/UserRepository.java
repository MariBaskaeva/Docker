package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.enums.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Map<String, String>, List<Authorities>> autorizedUsers = Map.of(
            Map.of("Mari", "Mari"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            Map.of("Tartaglia", "Password"), List.of(Authorities.READ));

    public List<Authorities> getUserAuthorities(String user, String password) {
        if(!autorizedUsers.containsKey(Map.of(user, password))){
            return new ArrayList<>();
        }
        return autorizedUsers.get(Map.of(user, password));
    }
}