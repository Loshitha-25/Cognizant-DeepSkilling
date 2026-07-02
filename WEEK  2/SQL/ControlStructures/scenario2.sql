SET SERVEROUTPUT ON;

BEGIN

    FOR customer_record IN
    (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )

    LOOP

        UPDATE Customers

        SET IsVIP = 'TRUE'

        WHERE CustomerID = customer_record.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
        'VIP Status Updated for Customer ID : '
        || customer_record.CustomerID);

    END LOOP;

    COMMIT;

END;
/