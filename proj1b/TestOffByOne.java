import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne(){
        assertTrue(offByOne.equalChars('a','b'));
         assertFalse(offByOne.equalChars('a','a'));
    }
    @Test
    public void testPalindrome(){
        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome("flake",offByOne));
        assertTrue(palindrome.isPalindrome("aa",offByOne));
    }
}
