#include <iostream>

using namespace std;

int main(void)
    {
    
    int a,b,product;
    
    
    do{
    cin>>a;
    cin>>b;
    
    }while (!(a>0 && b<10));
    
    product = a*b;
    
    cout<<product<<endl;
    
    return 0;
}