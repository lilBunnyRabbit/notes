public class Test10 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][] p = {
            {T, F, F, F, F, T, F, T, T, F},
            {F, T, F, F, F, T, F, T, F, T},
            {T, F, F, F, F, F, F, F, F, F},
            {F, F, F, T, T, F, T, F, T, T},
            {F, F, F, F, F, T, T, T, F, F},
            {F, F, F, T, T, T, F, F, F, F},
            {F, F, F, F, F, T, F, F, F, F},
            {T, F, F, F, T, T, T, F, F, T},
            {F, F, T, F, F, T, T, F, T, F},
            {T, T, T, T, F, F, F, T, T, F},
        };
        System.out.println(Park.steviloProstih(p));
    }
}
