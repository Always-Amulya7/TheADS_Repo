#include<iostream>
using namespace std;
int main(){
	float length, breadth;
	cout << "Enter the length and breadth: ";
	cin >> length >> breadth;
	float area=length*breadth;
	float perimeter=2*(length+breadth);
	cout << "The area and perimeter is: " << area << ", " << perimeter << "\n";
	return 0;
}
