// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>
#include "listFuncs.h"


using namespace std;

int main() {

   ListType head = NULL;
   cout << "----------" << endl;
   printNodeList(head, cout);
   addNode(head, "a", -1);
   cout << "----------" << endl;
   printNodeList(head, cout);
   addNode(head, "b", 0);
   cout << "----------" << endl;
   printNodeList(head, cout);
   addNode(head, "c", 100);
   cout << "----------" << endl;
   printNodeList(head, cout);
   addNode(head, "a", -100);
   cout << "----------" << endl;
   printNodeList(head, cout);
   addNode(head, "b", 0);
   cout << "----------" << endl;
   printNodeList(head, cout);
   addNode(head, "d", 10);
   cout << "----------" << endl;
   printNodeList(head, cout);
   removeNode(head, "c");
   cout << "----------" << endl;
   printNodeList(head, cout);
   removeNode(head, "c");
   cout << "----------" << endl;
   printNodeList(head, cout);
   removeNode(head, "a");
   cout << "----------" << endl;
   printNodeList(head, cout);
   removeNode(head, "a");
   cout << "----------" << endl;
   printNodeList(head, cout);
   removeNode(head, "b");
   cout << "----------" << endl;
   printNodeList(head, cout);
   removeNode(head, "b");
   cout << "----------" << endl;
   printNodeList(head, cout);
   removeNode(head, "d");
   cout << "----------" << endl;
   printNodeList(head, cout);
   removeNode(head, "d");
   cout << "----------" << endl;
   printNodeList(head, cout);

   return 0;
}
