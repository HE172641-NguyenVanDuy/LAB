
public class MyString implements IString{

    @Override
    public int f1(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if(checkPrime(a) == true)
            count++;
        }
        return count;
    }
    public boolean checkPrime(char c) {
        int a = Character.getNumericValue(c);
        if(a <= 1) return false;
        else{
            for (int i = 2; i <= (int)Math.sqrt(a); i++) {
                if(a%i == 0)
                    return true;
            }
        }
        return false;
    }

    @Override
    public String f2(String str) {
        String[] a = str.split(" ");
        StringBuilder sb  = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString().trim();
    }
    
}
