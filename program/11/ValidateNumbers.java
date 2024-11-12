public class ValidateNumbers {
    public static void main(String[] args) {
        String[] values = {"100", "10.2", "5.hello", "100hello"};
        
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            try {
                Integer.parseInt(value);
                System.out.println(value + " is a valid integer.");
            } catch (NumberFormatException eint) {
                try {
                    Double.parseDouble(value);
                    System.out.println(value + " is a valid double.");
                } catch (NumberFormatException edouble) {
                    // If both parsing attempts fail, it's neither an integer nor a double
                    System.out.println(value + " is neither a valid integer nor a valid double.");
                }
            }
        }
    }
}
