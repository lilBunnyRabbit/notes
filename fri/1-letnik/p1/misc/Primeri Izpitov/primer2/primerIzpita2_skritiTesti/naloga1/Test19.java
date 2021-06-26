public class Test19 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][] p = {
            {F, T, T, T, T, T, F, F, F, F},
            {F, F, F, T, F, F, F, F, F, F},
            {F, F, F, F, F, F, T, F, F, F},
            {F, F, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, F, F, F, F, F},
            {F, F, F, F, F, F, T, F, F, F},
            {F, T, T, T, T, F, F, F, F, F},
            {F, F, F, T, F, F, F, F, F, F},
            {F, F, F, F, T, T, F, F, F, F},
            {F, F, F, F, F, F, F, F, T, F},
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
    }
}
