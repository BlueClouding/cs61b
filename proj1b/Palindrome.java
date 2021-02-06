public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            Character character = word.charAt(i);
            deque.addLast(character);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordInDeque = wordToDeque(word);
        return helper(wordInDeque);
    }

    public boolean helper(Deque<Character> word) {
        if (word.size() <= 1) {
            return true;
        }
        if (word.removeFirst() == word.removeLast()) {
            return helper(word);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordInDeque = wordToDeque(word);
        return overloadHelper(wordInDeque, cc);
    }

    public boolean overloadHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        }
        if (cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            return overloadHelper(deque, cc);
        }
        return false;
    }
}
