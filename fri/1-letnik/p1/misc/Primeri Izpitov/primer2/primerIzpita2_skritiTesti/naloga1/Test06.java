public class Test06 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][] p = {
            {T, T, F, T, T},
            {F, T, F, T, T},
            {T, F, T, T, T},
            {T, F, T, T, T},
        };
        System.out.println(Park.steviloProstih(p));
    }
}
