#include <iostream>

using namespace std;

int main(void){
    int a;
    char grade;
    cin>>a;
    
    switch (a/10){
        case 10 :
        case 9 :
            grade = 'A';
            break;
        case 8 :
            grade = 'B';
            break;
        case 7 :
            grade = 'C';
            break;
        case 6 : 
            grade = 'D';
            break;
        default :
            grade = 'F';
            break;
    }
    cout<<grade<<endl;
    
    return 0;
}
