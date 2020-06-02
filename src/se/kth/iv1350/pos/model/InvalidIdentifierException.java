package se.kth.iv1350.pos.model;

/**
 * The following class is the InvalidIdentifierException class.
 * A exception will be given if an item which dose not exist
 * is scanned.
 */

public class InvalidIdentifierException extends java.lang.Exception
{
    public InvalidIdentifierException()
    {
        super();
    }

    public InvalidIdentifierException(String message)
    {
        super(message);
    }
}
