SET SERVEROUTPUT ON;

BEGIN

    FOR customer_record IN
    (
        SELECT CustomerID
        FROM Customers
        WHERE Age > 60
    )

    LOOP

        UPDATE Loans

        SET InterestRate = InterestRate - 1

        WHERE CustomerID = customer_record.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
        'Interest Rate Updated for Customer ID : '
        || customer_record.CustomerID);

    END LOOP;

    COMMIT;

END;
/