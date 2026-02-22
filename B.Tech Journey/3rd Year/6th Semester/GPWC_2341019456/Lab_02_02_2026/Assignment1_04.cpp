#include<iostream>
using namespace std;
int main(){
	char a,b,A,B;
	cout << "Enter the lowercase alphabets: ";
	cin >> a >> b;
	cout << "The ASCII Series of Lowercase:\n";
	for (int i=(int)a;i<=(int)b;i++){
		if (i!=b)
		cout << i << ", ";
		else
		cout << i;
	}
	cout << "\n";
	cout << "Enter the uppercase alphabets: ";
	cin >> A >> B;
	cout << "The ASCII Series of Uppercase:\n";
	for (int i=(int)A;i<=(int)B;i++){
		if (i!=B)
		cout << i << ", ";
		else
		cout << i;
	}
	cout << "\n";
	return 0;
}
