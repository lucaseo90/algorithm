#include <iostream>

class Node {
public:
	int data;
	Node * left;
	Node * right;
	Node() { };
	Node(int data) { 
		this->data = data; 
		this->left = NULL;
		this->right = NULL;
	}
};
