public class Test37 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][][] g = {
            {
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
            } ,
            {
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
            } ,
            {
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
            } ,
            {
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
            } ,
            {
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
            } ,
            {
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
                {T, T, T, T, T},
            } ,
        };
        System.out.println(Park.steviloMest(g));
    }
}
