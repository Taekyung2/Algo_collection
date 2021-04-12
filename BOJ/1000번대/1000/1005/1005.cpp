#include <bits/stdc++.h>
using namespace std;

const int SIZE = 1000;
int n, k;
int t[SIZE + 1], cache[SIZE + 1];
vector<int> order[SIZE + 1];

void simulation();
int dp(int w);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc;
    cin >> tc;
    while(tc--)
        simulation();

    return 0;
}

void simulation() {
    cin >> n >> k;
    for (int i = 1; i <= n; ++i) {
        cin >> t[i];
        order[i].clear();
        cache[i] = -1;
    }

    for (int i = 0; i < k; ++i) {
        int x, y;
        cin >> x >> y;
        order[y].push_back(x);
    }

    int w;
    cin >> w;
    cout << dp(w) << '\n';
}

int dp(int w) {
    int &ret = cache[w];
    if (ret != -1) return ret;

    if (order[w].empty())
        return ret = t[w];

    for (int prev : order[w])
        ret = max(ret, dp(prev) + t[w]);
    return ret;
}