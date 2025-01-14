#include <iostream>
using namespace std;

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int n, s = 0;
    cin >> n;
    for (int i = 0; i < n; i++){
        s += i;
        int x;
        cin >> x;
        s -= x;
    }
    cout << -s;
}