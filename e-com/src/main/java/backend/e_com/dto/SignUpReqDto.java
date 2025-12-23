package backend.e_com.dto;

import java.util.HashSet;
import java.util.Set;

import backend.e_com.entity.type.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpReqDto {
    private String username;
    private String password;
    private String name;
    private Set<RoleType> roles = new HashSet<>();

}
