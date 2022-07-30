package ru.gb.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.gb.market.model.User;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;

    @NotNull(message = "Пользователь должен иметь имя")
    @Length(min = 3, max = 255, message = "Длина имени должна составлять 3-255 символов")
    private String username;

    @NotNull(message = "Пользователь должен иметь пароль")
    @Length(min = 3, max = 255, message = "Длина пароля должна составлять 3-255 символов")
    private String password;

    @NotNull(message = "Пользователь должен иметь электронный адрес")
    private String email;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
