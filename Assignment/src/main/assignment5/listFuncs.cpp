#include <iostream>
#include <cassert>
#include "listFuncs.h"


using namespace std;

/*
   Node class constructor
*/
Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}


/*
   Node class constructor
*/
Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}


//*************************************************************************
// put the function definitions for your list functions below

Node* findNode(ListType& nodeList, const string& key){
   Node* curNode = nodeList;
   // loop until the tail
   while(curNode != NULL){
      // if found, return the node
      if(curNode->key == key){
         return curNode;
      }
      // move to next node
      curNode = curNode->next;
   }
   // if not found, return NULL
   return NULL;
}


Node* findPreNode(ListType& nodeList, const string& key){
   Node* preNode = nodeList;
   // loop until the tail
   while(preNode != NULL && preNode->key != key && preNode->next != NULL){
      // if found, return the node
      if(preNode->next->key == key){
         return preNode;
      }
      // move to next node
      preNode = preNode->next;
   }
   // if not found, return NULL
   return NULL;
}


bool addNode(ListType& nodeList, const string& key, int value){
   // if the key was present, return false
   if(findNode(nodeList, key) != NULL){
      return false;
   }
   Node* newNode = new Node(key, value);
   // if it is the first node
   if(nodeList == NULL){
      nodeList = newNode;
   }
   // if it is not the first node
   else{
      // keep the next node of head node
      Node* nextNode = nodeList->next;
      // set head node's next to new node
      nodeList->next = newNode;
      // set new node's next to reserved node
      nodeList->next->next = nextNode;
   }
   return true;
}


bool removeNode(ListType& nodeList, const string& key){
   // find the previous node
   Node* preNode = findPreNode(nodeList, key);
   // if previous node not found
   if(preNode == NULL){
      // if the key was not present
      if(nodeList == NULL || nodeList->key != key){
         return false;
      }
      // the key was the head node
      else{
         // keep the original linked list
         Node* tempNode = nodeList;
         // set new linked list to next node
         nodeList = nodeList->next;
         // set head node's next to NULL
         tempNode->next = NULL;
         // relase memory
         delete tempNode;
      }
   }
   // if previous node found
   else{
      // keep the next node of previous node
      Node* preNodeNext = preNode->next;
      // skip the delete node
      preNode->next = preNodeNext->next;
      // set delete node's next to NULL
      preNodeNext->next = NULL;
      // relase memory
      delete preNodeNext;
   }
   return true;
}


void printNodeList(ListType nodeList, ostream out){
   Node* curNode = nodeList;
   // loop until the tail
   while(curNode != NULL){
      out << curNode->key << " " << curNode->value << endl;
      curNode = curNode->next;
   }
}