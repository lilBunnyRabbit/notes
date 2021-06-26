public class Test08 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][] p = {
            {T, T, T, T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T, T, T, T},
            {T, T, T, T, T, T, T, T, T, T},
        };
        System.out.println(Park.steviloProstih(p));
    }
}
