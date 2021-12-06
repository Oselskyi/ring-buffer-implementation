package ringbuffer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingBufferTest {

    @Test
    void offer() {

        RingBuffer<String> buffer = new RingBuffer(7);

        assertTrue(buffer.offer("String"));
        assertEquals(1, buffer.size());
    }

    @Test
    void poll() {

        RingBuffer<String> buffer = new RingBuffer(7);

        buffer.offer("Lion");
        String animal = buffer.poll();
        assertEquals("Lion", animal);
    }
    @Test
    void moreThanOnepoll() {

        RingBuffer<String> buffer = new RingBuffer(7);

        buffer.offer("Tiger");
        buffer.offer("Elephant");
        buffer.offer("Lion");
        String animal = buffer.poll();
        assertEquals("Tiger", animal);
        String animal2 = buffer.poll();
        assertEquals("Elephant", animal2);
    }

    @Test
    void isNotAdded() {

        RingBuffer<String> buffer = new RingBuffer(7);

        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");

        assertFalse( buffer.offer("Lion"));
    }
    @Test
    void isNotPoped() {

        RingBuffer<String> buffer = new RingBuffer(7);

        assertNull(buffer.poll());
    }

    @Test
    void isAdded() {

        RingBuffer<String> buffer = new RingBuffer(7);

        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.offer("Lion");
        buffer.poll();

        assertTrue( buffer.offer("Lion"));
    }

}