public class Test36 {
    public static void main(String[] args) {
        
        final boolean T = true;
        final boolean F = false;
        
        boolean[][][] g = {
            {
                {F, F, F, F, F},
                {F, F, F, F, T},
                {F, F, F, F, F},
                {F, F, F, F, F},
                {F, F, T, F, F},
            } ,
            {
                {F, F, F, F, T},
                {F, F, F, F, F},
                {F, F, F, T, F},
                {F, F, F, F, F},
                {F, F, T, F, F},
            } ,
            {
                {F, F, F, F, F},
                {F, T, F, F, F},
                {F, F, F, T, F},
                {F, F, F, F, F},
                {T, F, F, F, F},
            } ,
            {
                {T, F, F, T, F},
                {F, F, F, F, F},
                {T, F, T, T, F},
                {F, F, F, T, F},
                {F, F, T, F, F},
            } ,
            {
                {F, F, T, F, F},
                {F, F, F, F, F},
                {F, F, F, F, F},
                {T, F, F, F, T},
                {F, T, T, F, F},
            } ,
        };
        System.out.println(Park.steviloMest(g));
    }
}
