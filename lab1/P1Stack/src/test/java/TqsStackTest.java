import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {
    private TqsStack<String> testStack0;
    private TqsStack<String> testStack1;

    @BeforeEach
    void setUp() {
        testStack0 = new TqsStack<>();
        testStack1 = new TqsStack<>();

        testStack1.push("item0");
        testStack1.push("item1");
        testStack1.push("item2");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    @Test
    void isEmpty() {
        assertTrue(testStack0.isEmpty(), "Empty stack should report empty!");
    }

    @Test
    void size() {
        assertEquals(3, testStack1.size());
    }

    @Test
    void push3elems() {
        testStack0.push("newItem0");
        testStack0.push("newItem1");
        testStack0.push("newItem2");

        assertEquals(3, testStack0.size());

        assertFalse(testStack1.isEmpty(), "non-empty stack report as empty!");
    }

    @DisplayName("Pop an empty throws Exception")
    @Test
    void popOnEmptyStack() {
        Exception exception = assertThrows(NoSuchElementException.class, () ->
                testStack0.pop());
    }

    @DisplayName("Pop a pushed element")
    @Test
    void pushThenPop() {
        String x = "testItem";

        testStack0.push(x);
        assertEquals(x, testStack0.pop());
    }

    @DisplayName("Peek from empty")
    @Test
    void peekEmpty() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            testStack0.peek();
        });
    }

    @DisplayName("Push to full bounded stack")
    @Test
    void pushFull() {
        TqsStack testStack2 = new TqsStack<>(2);

        for(int i = 0 ; i < 2 ; i++){
            testStack2.push(i);
        }

        assertThrows(IllegalStateException.class, () -> {
            testStack2.push(1);
        });
    }
}