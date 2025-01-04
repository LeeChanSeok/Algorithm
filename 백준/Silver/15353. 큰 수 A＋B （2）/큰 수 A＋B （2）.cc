#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main () {
    
    string a, b;
    vector <int> v;
    
    cin >> a >> b;
    
    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());
    
    if (a.size() < b.size())
        swap(a, b);
    
    for(int i=0; i<b.size(); i++){
        int A = a[i] - '0';
        int B = b[i] - '0';
        v.push_back(A+B);
    }
    for(int i=b.size(); i<a.size(); i++){
        v.push_back(a[i] - '0');
    }
    
    for(int i=0; i<v.size(); i++){
        if(v[i] >= 10) {
            if(i == v.size()-1){
                v.push_back(0);
            }
            v[i+1]++;
            v[i] -= 10;
        }
    }
    
    reverse (v.begin(), v.end());
    for(int i=0; i<v.size(); i++){
        cout << v[i];
    }
        
    return 0;
}