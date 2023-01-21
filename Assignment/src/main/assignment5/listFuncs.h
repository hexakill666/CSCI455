//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to *not* put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H

#include <string>

/*
   Node class
*/
struct Node {
   std::string key;
   int value;

   Node *next;

   Node(const std::string &theKey, int theValue);

   Node(const std::string &theKey, int theValue, Node *n);
};

typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

/*
   find the node in the linked list based on given key, return the node pointer
*/
Node* findNode(ListType& nodeList, const std::string& key);

/*
   find the previous node in the linked list based on given key. 
   If found, return node pointer, otherwise return NULL
*/
Node* findPreNode(ListType& nodeList, const std::string& key);

/*
   add the node to linked list. Return false iff the key was present,
   otherwise return true
*/
bool addNode(ListType& nodeList, const std::string& key, int value);

/*
   remove the node from linked list. Return false iff the key was not present, 
   otherwise return ture
*/
bool removeNode(ListType& nodeList, const std::string& key);

/*
   print the linked list
*/
void printNodeList(ListType& nodeList, std::ostream& out);

// keep the following line at the end of the file
#endif
