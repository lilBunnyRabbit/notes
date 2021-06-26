public class Test11 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][] p = {
            {T, F, F, T, F, F, F, F, T, T, T, F, T, F, F, T, T, F, T, T},
        };
        System.out.println(Park.steviloProstih(p));
    }
}
