package rs.ac.ni.pmf.web.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.DuplicateResourceException;
import rs.ac.ni.pmf.web.exception.ErrorInfo;
import rs.ac.ni.pmf.web.exception.ExceptionEnums.ErrorCode;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;

@ControllerAdvice
@ResponseBody
public class ErrorController {

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorInfo handleBadRequestException(final BadRequestException e) {
		return ErrorInfo.builder().errorCode(ErrorCode.BAD_REQUEST).message(e.getMessage()).build();
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorInfo handleNotFoundException(final ResourceNotFoundException e) {
		return ErrorInfo.builder().errorCode(ErrorCode.NOT_FOUND).resourceType(e.getResourceType())
				.message(e.getMessage()).build();
	}

	@ExceptionHandler(DuplicateResourceException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorInfo handleDuplicateResourceException(final DuplicateResourceException e) {
		return ErrorInfo.builder().errorCode(ErrorCode.DUPLICATE).resourceType(e.getResourceType())
				.message(e.getMessage()).build();
	}

}