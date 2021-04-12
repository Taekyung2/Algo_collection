#include <bits/stdc++.h>
using namespace std;

int cache[41] = {0, 1, };

int fibo(int n) {
    if(n == 0 || n == 1) return cache[n];
    int& ret = cache[n];
    if(ret != 0) return ret;
    return ret = fibo(n - 1) + fibo(n - 2);
}

int main() {
    int tc;
    cin >> tc;
    while(tc--) {
        int n;
        cin >> n;
        if(n == 0)
            cout << "1 0" << endl;
        else
            cout << fibo(n - 1) << " " << fibo(n) << endl;
    }
}