package backend.e_com.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {

    private LocalDateTime timestamp;
    private String message;
    private HttpStatus status;

    public ApiError( String message,HttpStatus status) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
    }

}
