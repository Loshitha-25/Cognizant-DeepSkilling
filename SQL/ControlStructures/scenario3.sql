SET SERVEROUTPUT ON;

BEGIN

    FOR loan_record IN
    (
        SELECT
        c.CustomerName,
        l.DueDate

        FROM Customers c

        JOIN Loans l

        ON c.CustomerID = l.CustomerID

        WHERE l.DueDate
        BETWEEN SYSDATE
        AND SYSDATE + 30
    )

    LOOP

        DBMS_OUTPUT.PUT_LINE(
        'Reminder : '
        || loan_record.CustomerName
        || ' Your loan is due on '
        || TO_CHAR(loan_record.DueDate,'DD-MON-YYYY'));

    END LOOP;

END;
/