package AshutoshRajput.CoursesByMe.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CourseDeletionException extends RuntimeException {
    public CourseDeletionException(String message) {
        super(message);
    }
}

