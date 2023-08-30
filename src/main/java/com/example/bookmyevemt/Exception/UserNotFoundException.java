package com.example.bookmyevemt.Exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(Long userId)
    {
        super("This user : "+userId+"is Not found in database ");
    }
}
