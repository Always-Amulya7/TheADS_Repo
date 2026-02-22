#include<iostream>
using namespace std;
int main(){
	char charr;
	cout << "Enter the character: ";
	cin >> charr;
	if (charr=='A'||charr=='E'||charr=='I'||charr=='O'||charr=='u'||charr=='a'||charr=='e'||charr=='i'||charr=='o'||charr=='u')
	cout << charr << " Is a vowel\n";
	else
	cout << charr << " Is a consonant\n";
	return 0;
}
