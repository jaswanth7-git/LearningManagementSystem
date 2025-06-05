package com.LearningportalGroup.Learning.Exceptions;
public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message){
        super(message);
    }
}
