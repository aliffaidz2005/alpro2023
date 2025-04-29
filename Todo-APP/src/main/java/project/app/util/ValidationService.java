package project.app.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class ValidationService {

    private Validator validator;

    public ValidationService(Validator validator){
        this.validator = validator;
    }
    public void validation(Object object){
        Set<ConstraintViolation<Object>> validate = validator.validate(object);
        if(!validate.isEmpty()){
            throw new ConstraintViolationException(validate);
        }
    }
}
