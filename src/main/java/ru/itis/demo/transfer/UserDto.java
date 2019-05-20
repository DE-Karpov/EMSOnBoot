package ru.itis.demo.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.demo.models.User;

@Data
@AllArgsConstructor
@Builder
public class UserDto {

    private String firstName;

    public static UserDto from(User user){
        return UserDto.builder()
                .firstName(user.getName())
                .build();
    }
}
