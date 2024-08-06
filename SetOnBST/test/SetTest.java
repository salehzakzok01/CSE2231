import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    // TODO - add test cases for constructor, add, remove, removeAny, contains, and size
    /**
     * Test for constructor.
     */
    @Test
    public final void constructor() {
        Set<String> s = this.constructorTest();
        Set<String> sExpected = this.constructorRef();

        assertEquals(sExpected, s);
    }

    /**
     * Tests add.
     */
    @Test
    public final void testAddSize0() {

        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef("blue");

        s.add("blue");

        assertEquals(sExpected, s);

    }

    /**
     * Tests add.
     */
    @Test
    public final void testAddSize1() {

        Set<String> s = this.createFromArgsTest("car");
        Set<String> sExpected = this.createFromArgsRef("car", "bike");

        s.add("bike");

        assertEquals(sExpected, s);

    }

    /**
     * Test for add.
     */
    @Test
    public final void testAdd2() {

        Set<String> s = this.createFromArgsTest("car", "bike");
        Set<String> sExpected = this.createFromArgsRef("car", "bike", "bus");

        s.add("bus");
        assertEquals(s, sExpected);
    }

    /**
     * Tests remove.
     */
    @Test
    public final void testRemove0() {

        Set<String> s = this.createFromArgsTest("car");
        Set<String> sExpected = this.createFromArgsRef();

        String removed = s.remove("car");

        assertEquals(sExpected, s);
        assertEquals("car", removed);

    }

    /**
     * Test for remove.
     */
    @Test
    public final void testRemove1() {

        Set<String> s = this.createFromArgsTest("car", "bike");
        Set<String> sExpected = this.createFromArgsRef("car");

        s.remove("bike");
        assertEquals(s, sExpected);
    }

    /**
     * Test for remove.
     */
    @Test
    public final void testRemove2() {

        Set<String> s = this.createFromArgsTest("car", "bike", "bus");
        Set<String> sExpected = this.createFromArgsRef("car", "bus");
        String removed = s.remove("bike");

        assertEquals(sExpected, s);
        assertEquals("bike", removed);
    }

    /**
     * Tests removeAny.
     */
    @Test
    public final void testRemoveAny0() {

        Set<String> s = this.createFromArgsTest("car");
        Set<String> sExpected = this.createFromArgsRef("car");
        String sRemoved = s.removeAny();

        assertTrue(sExpected.contains(sRemoved));
        sExpected.remove(sRemoved);
        assertTrue(s.size() == sExpected.size());

    }

    /**
     * Tests removeAny.
     */
    @Test
    public final void testRemoveAny1() {

        Set<String> s = this.createFromArgsTest("car", "bike");
        Set<String> sExpected = this.createFromArgsRef("car", "bike");
        String sRemoved = s.removeAny();

        assertTrue(sExpected.contains(sRemoved));
        sExpected.remove(sRemoved);
        assertTrue(s.size() == sExpected.size());

    }

    /**
     * Tests removeAny.
     */
    @Test
    public final void testRemoveAny2() {
        /*
         * Set up variables
         */
        Set<String> s = this.createFromArgsTest("car", "bike", "bus");
        Set<String> sExpected = this.createFromArgsRef("car", "bike", "bus");
        String sRemoved = s.removeAny();

        assertTrue(sExpected.contains(sRemoved));
        sExpected.remove(sRemoved);
        assertTrue(s.size() == sExpected.size());

    }

    /**
     * Tests contains false.
     */
    @Test
    public final void testContainsFalse() {

        Set<String> s = this.createFromArgsTest("car", "bike", "bus");
        Set<String> sExpected = this.createFromArgsRef("car", "bike", "bus");

        boolean sContains = s.contains("train");
        boolean sEContains = s.contains("train");

        assertEquals(sExpected, s);
        assertEquals(sEContains, sContains);

    }

    /**
     * Tests contains false.
     */
    @Test
    public final void testContainsFalseEmpty() {

        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();

        boolean sContains = s.contains("car");
        boolean sEContains = s.contains("car");

        assertEquals(sExpected, s);
        assertEquals(sEContains, sContains);

    }

    /**
     * Test for Contains.
     */
    @Test
    public final void testContainsTrue1() {

        Set<String> s = this.createFromArgsTest("bike");
        Set<String> sExpected = this.createFromArgsRef("bike");

        boolean sContains = s.contains("bike");
        boolean sEContains = s.contains("bike");

        assertEquals(sExpected, s);
        assertEquals(sEContains, sContains);

    }

    /**
     * Test for Contains.
     */
    @Test
    public final void testContainsTrue2() {
        /*
         * ,* Set up variables ,
         */
        Set<String> s = this.createFromArgsTest("bus");
        Set<String> sExpected = this.createFromArgsRef("bus");

        String vehicle = "bus";
        assertTrue(s.contains(vehicle));
        assertTrue(sExpected.contains(vehicle));

    }

    /**
     * Test for Contains.
     */
    @Test
    public final void testContainsTrue3() {
        /*
         * ,* Set up variables ,
         */
        Set<String> s = this.createFromArgsTest("car", "bike", "plane");
        Set<String> sExpected = this.createFromArgsRef("car", "bike", "plane");

        String vehicle = "bike";
        assertTrue(s.contains(vehicle));
        assertTrue(sExpected.contains(vehicle));

    }

    /**
     * Test for Contains.
     */
    @Test
    public final void testContainsFalse1() {

        Set<String> s = this.createFromArgsTest("car", "bike", "plane");
        Set<String> sExpected = this.createFromArgsRef("car", "bike", "plane");

        boolean containsVehicle = s.contains("train");

        assertEquals(sExpected, s);
        assertEquals(false, containsVehicle);

    }

    /**
     * Test for Contains.
     */
    @Test
    public final void testContainsFalse5() {

        Set<String> s = this.createFromArgsTest("car", "bike", "plane");
        Set<String> sExpected = this.createFromArgsRef("car", "bike", "plane");

        boolean containsVehicle = s.contains("plane");

        assertEquals(sExpected, s);
        assertEquals(true, containsVehicle);

    }

    /**
     * Test for Size.
     */
    @Test
    public final void testSize0() {

        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();

        int size1 = s.size();
        int size2 = sExpected.size();
        assertTrue(size1 == size2);
    }

    /**
     * Test for Size.
     */
    @Test
    public final void testSize1() {

        Set<String> s = this.createFromArgsTest("car");
        Set<String> sExpected = this.createFromArgsRef("car");

        int size1 = s.size();
        int size2 = sExpected.size();
        assertTrue(size1 == size2);
    }

    /**
     * Test for Size.
     */
    @Test
    public final void testSize2() {

        Set<String> s = this.createFromArgsTest("car", "bike", "plane");
        Set<String> sExpected = this.createFromArgsRef("car", "bike", "plane");

        int size1 = s.size();
        int size2 = sExpected.size();
        assertTrue(size1 == size2);
    }

    /**
     * Test for Size.
     */
    @Test
    public final void testSize3() {

        Set<String> s = this.createFromArgsTest("car", "bike", "plane", "train",
                "bus");
        Set<String> sExpected = this.createFromArgsRef("car", "bike", "plane",
                "train", "bus");

        int size1 = s.size();
        int size2 = sExpected.size();
        assertTrue(size1 == size2);
    }
}
