package com.example.bookmyevemt.Exception;

public class ActorNotFoundException extends Exception{
    public ActorNotFoundException(Long id)
    {
        super("This actor id is not found : "+id);
    }
}
