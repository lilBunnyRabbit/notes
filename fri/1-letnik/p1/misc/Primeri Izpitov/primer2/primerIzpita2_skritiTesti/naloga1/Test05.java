public class Test05 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][] p = {
            {F, T, T, T, T},
            {T, F, T, F, F},
            {T, F, F, T, F},
            {F, F, T, T, F},
        };
        System.out.println(Park.steviloProstih(p));
    }
}
