import java.util.Scanner;

class razbijanjeStevil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int nCopy = n;
        int mCopy = m;
        int nLength = 0; 
        int mLength = 0;

        while (true) {
            if(nCopy >= 1) {
                nLength++;
                nCopy = nCopy / 10;
            }

            if(mCopy >= 1) {
                mLength++;
                mCopy = mCopy / 10;
            }

            if(mCopy < 1 && nCopy < 1) {
                System.out.println(nLength + " --- " + mLength);
                break;
            }
        }
    }
}