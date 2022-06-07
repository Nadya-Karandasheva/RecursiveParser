import org.junit.Test;
import static org.junit.Assert.*;

public class test {
    @Test
    public  void check(){
        assertTrue(main.check("a"));
        assertTrue(main.check("ccccac"));
        assertFalse(main.check("bca"));
        assertFalse(main.check("aaf"));
    }

}
