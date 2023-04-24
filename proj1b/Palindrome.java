public class Palindrome {
    public Deque<Character> wordToDeque(String word){

        if (word.length()==0){
            return null;
        }
        Deque<Character> wDeque = new LinkedListDeque<Character>();
        for(Character ch:word.toCharArray()){
            wDeque.addLast(ch);
        }
        return wDeque;
    }
    public boolean isPalindrome(String word){
        Deque<Character> wDeque=wordToDeque(word);
        String rWord="";
        for(int i=0;i<word.length();i++){
            rWord+=wDeque.removeLast();
        }
        return rWord.equals(word);
    }
    public boolean isPalindrome(String word,CharacterComparator cc){
        Deque<Character> wDeque=wordToDeque(word);
        for(int i=0;i<word.length();i++){
            int flag=word.length()>>1;
            if(i<flag){
                wDeque.addLast(word.charAt(i));
            }
            else if(i==flag){
                if(word.length()%2==1){
                    continue;
                }
                else {
                    wDeque.addLast(word.charAt(i));
                }}
            else{

                if(!((OffByOne)cc).equalChars(word.charAt(i),wDeque.removeLast())){
                    return false;
                }
            }

        }
        return true;
    }



}
