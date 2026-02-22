#include <iostream>
using namespace std;
void Reverse(char str[],int index){
	if (str[index]=='\0') 
	return;
	Reverse(str,index+1);
	cout << str[index]; 
}
int main(){
	char str[50];
        cout << "Enter the string: ";
        cin.getline(str,50);
        cout << "The reversed string is: ";
        Reverse(str,0);
        cout << "\n";
        return 0;
}
