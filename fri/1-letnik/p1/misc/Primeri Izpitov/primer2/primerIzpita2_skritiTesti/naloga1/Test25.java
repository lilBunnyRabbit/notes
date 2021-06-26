public class Test25 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][] p = {
            {T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T},
        };
        System.out.println(Park.zaporedje(p, 1));
        System.out.println(Park.zaporedje(p, 2));
        System.out.println(Park.zaporedje(p, 3));
        System.out.println(Park.zaporedje(p, 4));
        System.out.println(Park.zaporedje(p, 5));
        System.out.println(Park.zaporedje(p, 6));
    }
}
