import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    public void additionShouldCorrect() {
        int result = 6;
        int resultTest = Calculator.calculation(3, 3, '+');
        assertEquals(result, resultTest, "Íåêîððåêòíîå ñëîæåíèå");
    }


    @Test
    public void differenceShouldCorrect() {
        int result = 3;
        int resultTest = Calculator.calculation(6, 3, '-');
        assertEquals(result, resultTest, "Íåêîððåêòíîå âû÷èòàíèå");
    }


    @Test
    public void multiplicationShouldCorrect() {
        int result = 8;
        int resultTest = Calculator.calculation(4, 2, '*');
        assertEquals(result, resultTest, "Íåêîððåêòíîå óìíîæåíèå");
    }


    @Test
    public void divisionShouldCorrect() {
        int result = 6;
        int resultTest = Calculator.calculation(18, 3, '/');
        assertEquals(result, resultTest, "Íåêîððåêòíîå äåëåíèå");
    }


    @Test
    public void rootIntegerShouldExtracted() {
        double result = 5.0;
        double resultTest = Calculator.squareRootExtraction(25.0);
        assertEquals(result, resultTest, "Êîðåíü öåëîãî ÷èñëà èçâëå÷åí íå êîððåêòíî");
    }


    @Test
    public void calculatingDiscountShouldCorrect() {
        double result = 4500.0;
        double resultTest = Calculator.calculatingDiscount(5000, 10);
        assertEquals(result, resultTest, "Íåêîððåêòíîå âû÷èñëåíèå ñêèäêè");
    }

    @Test
    public void checkDivisionByZero() {
        String message = "Division by zero is not possible";
        Exception exception = assertThrows(ArithmeticException.class, () ->
                Calculator.calculation(5, 0, '/'));
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void checkInvalidOperator() {
        String message = "Unexpected value operator: _";
        Exception exception = assertThrows(IllegalStateException.class, () ->
                Calculator.calculation(9, 3, '_'));
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void checkTakingRootNegativeNumber() {
        String message = "Cannot calculate square root of a negative number";
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Calculator.squareRootExtraction(-0.1));
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void purchaseAmountCannotLessOne() {
        String messageException = "Ñóììà ïîêóïîê íå ìîæåò áûòü ìåíüøå 1 usd";
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculatingDiscount(0, 10));
        assertEquals(messageException, exception.getMessage());
    }

    @Test
    public void discountAmountCannotLessZero() {
        String message = "Ïðîöåíò ñêèäêè íå ìîæåò áûòü îòðèöàòåëüíûì";
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculatingDiscount(100, -5));
        assertEquals(message, exception.getMessage());
    }
}