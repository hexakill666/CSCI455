#include <string>
#include <cassert>

// for istringstream
#include <sstream>

#include "ecListFuncs.h"

using namespace std;

// *********************************************************
// Node constructors: do not change
Node::Node(int item) { 
   data = item;
   next = NULL;
}

Node::Node(int item, Node *n) {
   data = item;
   next = n;
}
// *********************************************************


string listToString(ListType list) {
   string result = "(";
   while(list != NULL){
      result += to_string(list->data);
      list = list->next;
      if(list != NULL){
         result += " ";
      }
   }
   result += ")";
   return result;
}


ListType buildList(const string & listString) {
   ListType cur = NULL;
   ListType head = NULL;
   
   istringstream iss(listString);
   int value;
   while(iss >> value){
      if(cur == NULL){
         cur = new Node(value);
         head = cur;
      }
      else{
         cur->next = new Node(value);
         cur = cur->next;
      }
   }
   
   return head;
}


void insertAt(ListType & list, int index, int value) {
   ListType newNode = new Node(value);
   if(index == 0){
      newNode->next = list;
      list = newNode;
   }
   else{
      ListType preNode = list;
      while(--index > 0){
         preNode = preNode->next;
      }
      ListType preNodeNext = preNode->next;
      preNode->next = newNode;
      newNode->next = preNodeNext;
   }
}


ListType partitionBy(ListType & list, int number) {
   ListType partCur = NULL;
   ListType partHead = NULL;
   ListType listCur = NULL;
   ListType listHead = NULL;

   while(list != NULL){
      if(list->data < number){
         if(partCur == NULL){
            partCur = list;
            partHead = partCur;
         }
         else{
            partCur->next = list;
            partCur = partCur->next;
         }
      }
      else{
         if(listCur == NULL){
            listCur = list;
            listHead = listCur;
         }
         else{
            listCur->next = list;
            listCur = listCur->next;
         }
      }
      list = list->next;
   }
   if(partCur != NULL){
      partCur->next = NULL;
   }
   if(listCur != NULL){
      listCur->next = NULL;
   }
   list = listHead;
   
   return partHead;
}