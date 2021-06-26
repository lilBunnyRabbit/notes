public class Test23 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][] p = {
            {F, F, T, F, F, F, T, T, T, T, T, T, T, F, T, F, T, T, T, F},
            {T, T, T, T, F, T, F, T, T, F, T, F, T, F, F, F, T, T, F, F},
            {T, F, T, F, T, F, F, F, T, T, T, T, T, F, T, T, F, T, T, T},
            {T, F, T, T, F, T, F, T, T, F, F, T, T, F, T, F, T, F, T, T},
            {F, F, T, T, F, F, T, T, F, T, T, F, F, T, T, T, T, F, F, F},
            {T, T, F, T, T, T, F, T, T, F, F, F, F, T, T, T, T, T, T, F},
            {F, T, T, F, F, T, T, F, T, T, F, T, T, F, T, T, T, F, F, T},
            {T, T, T, F, T, T, T, F, T, T, F, T, T, F, T, T, F, F, F, F},
            {F, F, F, T, T, T, F, T, F, F, F, T, F, T, F, T, T, F, T, T},
            {T, T, T, T, F, T, F, F, T, T, T, T, T, F, T, F, T, T, T, T},
        };
        System.out.println(Park.zaporedje(p, 1));
        System.out.println(Park.zaporedje(p, 2));
        System.out.println(Park.zaporedje(p, 3));
        System.out.println(Park.zaporedje(p, 4));
        System.out.println(Park.zaporedje(p, 5));
        System.out.println(Park.zaporedje(p, 6));
        System.out.println(Park.zaporedje(p, 7));
        System.out.println(Park.zaporedje(p, 8));
        System.out.println(Park.zaporedje(p, 9));
        System.out.println(Park.zaporedje(p, 10));
        System.out.println(Park.zaporedje(p, 11));
        System.out.println(Park.zaporedje(p, 12));
        System.out.println(Park.zaporedje(p, 13));
        System.out.println(Park.zaporedje(p, 14));
        System.out.println(Park.zaporedje(p, 15));
        System.out.println(Park.zaporedje(p, 16));
        System.out.println(Park.zaporedje(p, 17));
        System.out.println(Park.zaporedje(p, 18));
        System.out.println(Park.zaporedje(p, 19));
    }
}
