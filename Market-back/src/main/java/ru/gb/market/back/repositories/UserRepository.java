package ru.gb.market.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.market.back.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    // попытка добавления новому Пользователю роли Юзер
//    @Query("insert into users_roles (user_id, role_id) values (:userId, 1)")
//    void insertUserRole(Long userId);
}
