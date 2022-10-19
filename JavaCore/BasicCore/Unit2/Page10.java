public class Page10{
	public static int countDigit(String value){
        int i=0,count=0;
        while(i<value.length()){
            char c=value.charAt(i);
            if(Character.isDigit(c)){
                count++;
            }
            i++;
        }
        return count;
    }
 public static void main(String[] args) {
        System.out.println("There are "+countDigit(args[0])+" digits in the text.");
    }
}