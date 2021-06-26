#include <stdio.h>
#include <stdbool.h>
#include <math.h>

int main() {
    long n, m;

    scanf("%ld %ld", &n, &m);

    int nLength = 0;
    int mLength = 0;

    long nCopy = n;
    long mCopy = m;

    while(nCopy >= 1 || mCopy >= 1) {
        if (nCopy >= 1) {
            nCopy = nCopy / 10;
            nLength++;
        }

        if(mCopy >= 1) {
            mCopy = mCopy / 10;
            mLength++;
        }

        if(mCopy < 1 && nCopy < 1) {
            break;
        }
    }

    nCopy = n;
    mCopy = m;
    long nTen = 1;
    long mTen = 1;

    for(int i = 0; i < nLength; i++) {
        nTen = nTen * 10;
    }

    //printf("%ld\n", nTen);

    for(int i = 0; i < mLength - 1; i++) {
        mTen = mTen * 10;
    }

    int mNumber, nNumber;

    while(mTen != 0) {
        mNumber = mCopy / mTen;
        mCopy = mCopy - (mTen * mNumber);
        mTen = mTen / 10;

        //printf("%d\n", mNumber);

        for(int i = 0; i < mNumber; i++) {
            nTen = nTen / 10;
        }
        //printf("%d %ld ", mNumber, nCopy);
        //printf("%ld ", nTen);
        nNumber = nCopy / nTen;
        printf("%d\n", nNumber);
        nCopy = nCopy - (nTen * nNumber);
        //printf("%d\n", nNumber);



        
    }
    
    
    

    
}