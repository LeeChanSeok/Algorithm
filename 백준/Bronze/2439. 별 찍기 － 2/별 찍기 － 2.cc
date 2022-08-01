#include <iostream>

using namespace std;

int main(void){
    int a,i,j,k;
    cin>>a;
    
    for(i=0;i<a;i++)
    {
        for(j= a-i;j>1;j--)
            cout<<" ";
        
        for(k=0;k<=i;k++)
            cout<<"*";
            
        cout<<endl;
    }
    
    
    return 0;
}