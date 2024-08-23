package bbq.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ProblemDetail> handleException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest()
                .body(
                        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage())
                );
    }

}
