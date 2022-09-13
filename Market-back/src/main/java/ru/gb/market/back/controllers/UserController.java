package ru.gb.market.back.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.back.model.User;
import ru.gb.market.back.services.UserService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public User findAll() {
        return (User) userService.findAll();
    }

//    @PostMapping("/users")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User saveUser(@RequestBody @Validated UserDto userdto, BindingResult bindingResult) {
////        if (bindingResult.hasErrors()) {
//            throw new DataValidationException(bindingResult
//                    .getAllErrors()
//                    .stream()
//                    .map(ObjectError::getDefaultMessage)
//                    .collect(Collectors.toList()));
//        }
//        User user = new User();
//        user.setId(userdto.getId());
//        user.setUsername(userdto.getUsername());
//        user.setPassword(userdto.getPassword());
//        user.setEmail(userdto.getEmail());
////        user.setRoles(userdto.getId(),2);
////        user.setCreatedAt(new Date());
//        userService.saveUser(user);
//        return user;
//    }
}


