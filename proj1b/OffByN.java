public class OffByN implements CharacterComparator {

    private int diff;
    OffByN(int diff){
       this.diff=diff;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(x-y)==diff){
            return true;
        }
        else{
            return false;
        }
    }
}
