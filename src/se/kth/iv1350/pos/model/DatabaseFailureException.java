package se.kth.iv1350.pos.model;

/**
 * The following class is the DatabaseFailureException class.
 * This class gives an exception when the program fails to
 * connect to the database.
 */

public class DatabaseFailureException extends java.lang.RuntimeException
{
    public DatabaseFailureException()
    {
        super();
    }

    public DatabaseFailureException(String msg) {
        super(msg);
    }
}
