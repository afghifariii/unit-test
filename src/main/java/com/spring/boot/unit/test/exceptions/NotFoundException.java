package com.spring.boot.unit.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IT'S NOT FOUND")
public class NotFoundException extends RuntimeException {

}
