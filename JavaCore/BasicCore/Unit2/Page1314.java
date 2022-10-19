public class Page1314 {

    public static class SaiSoException extends Exception {

        private String so;

        public SaiSoException(String value) {
            this.so = value;
        }

        @Override
        public String getMessage() {
            return "Gia tri\"" + so + "\'khong phai la so!";
        }
    }

    public static int toNumber(String value) throws SaiSoException {
        try {
            Integer inte = Integer.parseInt(value);
            return inte.intValue();
        } catch (NumberFormatException e) {
            throw new SaiSoException(value);
        }
    }

    public static void main(String[] args) {
        try{
            System.out.println("Number = "+toNumber(args[0]));
        }catch(SaiSoException e){
            System.err.println(e.getMessage());
        }
    }
}