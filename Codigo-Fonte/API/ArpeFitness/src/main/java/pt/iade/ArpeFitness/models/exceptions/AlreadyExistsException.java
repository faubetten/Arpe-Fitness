package pt.iade.ArpeFitness.models.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 5405519104069955535L;
    public AlreadyExistsException(String id, String elemType, String idName) {
    super(elemType+" with "+idName+" "+id+" already exists.");
    }
}