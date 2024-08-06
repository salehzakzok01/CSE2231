import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    // TODO - add test cases for constructor, add, remove, and length

    /**
     * Constructor test.
     */
    @Test
    public void testConstructor() {
        Sequence<String> sequence = this.constructorTest();
        Sequence<String> expected = this.constructorRef();
        assertEquals(sequence, expected);
    }

    /**
     * Test "add" method.
     */
    @Test
    public void testAdd() {
        Sequence<String> s = this.createFromArgsTest("a", "c");
        Sequence<String> sExpected = this.createFromArgsRef("b", " a ", " c ");
        s.add(0, " b ");
        assertEquals(sExpected, s);
    }

    /**
     * Test "remove" method.
     */
    @Test
    public void testRemove() {
        Sequence<String> q = this.createFromArgsTest("red", "green", "blue");
        Sequence<String> qExpected = this.createFromArgsRef("green", "blue");
        String digit = q.remove(0);
        assertEquals(qExpected, q);
        assertEquals(digit, "red");
    }

    /**
     * Test "length" method when sequence is empty.
     */
    @Test
    public void testLengthEmpty() {
        Sequence<String> s = this.createFromArgsTest();
        Sequence<String> sExpected = this.createFromArgsRef();
        int length = s.length();
        assertEquals(sExpected, s);
        assertEquals(length, 0);
    }

    /**
     * Test "length" method when sequence is not empty.
     */
    @Test
    public void testLengthNonEmpty() {
        Sequence<String> s = this.createFromArgsTest("orange");
        Sequence<String> sExpected = this.createFromArgsRef("orange");
        int length = s.length();
        assertEquals(sExpected, s);
        assertEquals(length, 1);
    }

}
