package MicroEShop.MSecurite.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    Integer id;

    String username;


    String password;


    Instant creationDate;


    List<String> roles = new ArrayList<>();

    boolean acountNonExpired = true;

    boolean accountNonLocked = true;

    boolean credentialsNonExpired = true;

    boolean enabled = true;
}
