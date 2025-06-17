package com.back.cd.back.cd.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoudException extends RuntimeException {

		private static final long serialVersionUID =1l;
		
		public ResourceNotFoudException(String message) {
			super(message);
		}
}
