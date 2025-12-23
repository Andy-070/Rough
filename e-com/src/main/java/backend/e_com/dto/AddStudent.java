package backend.e_com.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddStudent {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;
}
