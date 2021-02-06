import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator cc = new OffByN(2);

    @Test
    public void testEqualChars() {
        assertEquals(cc.equalChars('a', 'c'), true);
    }
}
