import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    // TODO - add test cases for four constructors, multiplyBy10, divideBy10, isZero

    /**
     * Test for constructor NaturalNumber3().
     */
    @Test
    public final void firstTestNaturalNumber3() {
        NaturalNumber number = this.constructorTest(new NaturalNumber3());
        NaturalNumber numberExpected = this
                .constructorRef(new NaturalNumber2());
        assertEquals(numberExpected, number);
    }

    /**
     * Test for constructor NaturalNumber3().
     */
    @Test
    public final void secondTestNaturalNumber3() {
        NaturalNumber number = this.constructorTest(1);
        NaturalNumber numberExpected = this.constructorRef(1);
        assertEquals(numberExpected, number);
    }

    /**
     * Test for constructor NaturalNumber3().
     */
    @Test
    public final void thirdTestNaturalNumber3() {
        NaturalNumber number = this.constructorTest("1");
        NaturalNumber numberExpected = this.constructorRef("1");
        assertEquals(numberExpected, number);
    }

    /**
     * Test for constructor NaturalNumber3().
     */
    @Test
    public final void fourthTestNaturalNumber3() {
        NaturalNumber number = this.constructorTest(new NaturalNumber3(1));
        NaturalNumber numberExpected = this
                .constructorRef(new NaturalNumber2(1));
        assertEquals(numberExpected, number);
    }

    /**
     * Test for multiplyBy10 (when number is zero (no string length)).
     */
    @Test
    public final void firstMultiplyBy10Test() {
        final int four = 4;
        NaturalNumber number = this.constructorTest();
        NaturalNumber numberExpected = this.constructorRef("4");
        number.multiplyBy10(four);
        assertEquals(numberExpected, number);
    }

    /**
     * Test for multiplyBy10 (when number is zero (no string length)).
     */
    @Test
    public final void secondMultiplyBy10Test() {
        final int four = 4;
        NaturalNumber number = this.constructorTest("0");
        NaturalNumber numberExpected = this.constructorRef("4");
        number.multiplyBy10(four);
        assertEquals(numberExpected, number);
    }

    /**
     * Test for multiplyby10 for single digit number.
     */
    @Test
    public final void thirdMultiplyBy10Test() {
        final int seven = 7;
        NaturalNumber number = this.constructorTest("1");
        number.multiplyBy10(seven);
        NaturalNumber numberExpected = this.constructorRef("17");
        assertEquals(numberExpected, number);
    }

    /**
     * Test for multiplyby10 for two digit number.
     */
    @Test
    public final void fourthMultiplyBy10Test() {
        final int seven = 7;
        NaturalNumber number = this.constructorTest("25");
        number.multiplyBy10(seven);
        NaturalNumber numberExpected = this.constructorRef("257");
        assertEquals(numberExpected, number);
    }

    /**
     * Test for multiplyby10 for triple digit number.
     */
    @Test
    public final void fifthMultiplyBy10Test() {
        final int seven = 7;
        NaturalNumber number = this.constructorTest("482");
        number.multiplyBy10(seven);
        NaturalNumber numberExpected = this.constructorRef("4827");
        assertEquals(numberExpected, number);
    }

    /**
     * Test for divideBy10 (when number is zero (no length of String)).
     */
    @Test
    public final void firstDivideBy10Test() {
        NaturalNumber number = this.constructorTest();
        NaturalNumber numberExpected = this.constructorRef();
        int digit = number.divideBy10();
        int digitExpected = 0;
        assertEquals(numberExpected, number);
        assertEquals(digitExpected, digit);
    }

    /**
     * Test for divideBy10 (when number is zero (string length of one)).
     */
    @Test
    public final void secondDivideBy10Test() {
        NaturalNumber number = this.constructorTest("0");
        NaturalNumber numberExpected = this.constructorRef();
        int digit = number.divideBy10();
        int digitExpected = 0;
        assertEquals(numberExpected, number);
        assertEquals(digitExpected, digit);
    }

    /**
     * Test for divideBy10 for single digit number.
     */
    @Test
    public final void thirdDivideBy10Test() {
        NaturalNumber number = this.constructorTest("1");
        NaturalNumber numberExpected = this.constructorRef();
        int digit = number.divideBy10();
        int digitExpected = 1;
        assertEquals(numberExpected, number);
        assertEquals(digitExpected, digit);
    }

    /**
     * Test for divideBy10 for two digit number.
     */
    @Test
    public final void fourthDivideBy10Test() {
        NaturalNumber number = this.constructorTest("89");
        NaturalNumber numberExpected = this.constructorRef("8");
        int digit = number.divideBy10();
        int digitExpected = 9;
        assertEquals(numberExpected, number);
        assertEquals(digitExpected, digit);
    }

    /**
     * Test for divideBy10 for triple digit number.
     */
    @Test
    public final void fifthDivideBy10Test() {
        final int six = 6;
        NaturalNumber number = this.constructorTest("456");
        NaturalNumber numberExpected = this.constructorRef("45");
        int digit = number.divideBy10();
        int digitExpected = six;
        assertEquals(numberExpected, number);
        assertEquals(digitExpected, digit);
    }
}
