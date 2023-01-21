// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

// for hash function called in private hashCode method defined below
#include <functional>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

/*
   Table class constructor, variables initialization
*/
Table::Table() {
   hashSize = HASH_SIZE;
   entrySize = 0;
   nonEmptyBucket = 0;
   longestChainIndex = 0;
   chainSizeArray = new int[hashSize]();
   table = new Node*[hashSize]();
}

/*
   Table class constructor, variables initialization
*/
Table::Table(unsigned int hSize) {
   hashSize = hSize;
   entrySize = 0;
   nonEmptyBucket = 0;
   longestChainIndex = 0;
   chainSizeArray = new int[hashSize]();
   table = new Node*[hashSize]();
}


int * Table::lookup(const string &key) {
   // find the node
   Node* curNode = findNode(table[hashCode(key)], key);
   // if not found, return NULL. If found, return the pointer of value
   return curNode == NULL ? NULL : &curNode->value;
}


bool Table::remove(const string &key) {
   // bucket index
   int bucket = hashCode(key);
   bool bucketNonEmpty = false;
   // before remove, if the bucket is occupied
   if(table[bucket] != NULL){
      bucketNonEmpty = true;
   }
   // remove entry
   bool removeResult = removeNode(table[bucket], key);
   // if successful
   if(removeResult){
      // after remove, if the bucket is NULL
      if(bucketNonEmpty && table[bucket] == NULL){
         // decrease non-empty bucket size
         nonEmptyBucket--;
      }
      // decrease entry size
      entrySize--;
      // decrease chain size
      chainSizeArray[bucket]--;
      // if the bucket has the longest chain
      if(bucket == longestChainIndex){
         // find the new longest chain index
         longestChainIndex = findLongestChainIndex();
      }
   }
   return removeResult;
}


bool Table::insert(const string &key, int value) {
   // bucket index
   int bucket = hashCode(key);
   bool bucketEmpty = false;
   // before insert, if the bucket is NULL
   if(table[bucket] == NULL){
      bucketEmpty = true;
   }
   // add entry
   bool addResult = addNode(table[bucket], key, value);
   // if successful
   if(addResult){
      // after insert, if the bucket is occupied
      if(bucketEmpty){
         // increase non-empty bucket size
         nonEmptyBucket++;
      }
      // increase entry size
      entrySize++;
      // increase chain size
      chainSizeArray[bucket]++;
      // after insert, if the chain size is longer than the longest one
      if(chainSizeArray[bucket] > chainSizeArray[longestChainIndex]){
         // keep the bucket index
         longestChainIndex = bucket;
      }
   }
   return addResult;
}


int Table::numEntries() const {
   // return entry size
   return entrySize;
}


void Table::printAll() const {
   // print all entries in the table
   for(int a = 0; a < hashSize; a++){
      printNodeList(table[a], cout);
   }
}


void Table::hashStats(ostream &out) const {
   // print table statistics
   out << "number of buckets: " << hashSize << endl;
   out << "number of entries: " << numEntries() << endl;
   out << "number of non-empty buckets: " << nonEmptyBucket << endl;
   out << "longest chain: " << chainSizeArray[longestChainIndex] << endl;
}


// hash function for a string
// (we defined it for you)
// returns a value in the range [0, hashSize)
unsigned int Table::hashCode(const string &word) const {

   // Note: calls a std library hash function for string (it uses the good hash
   //   algorithm for strings that we discussed in lecture).
   return hash<string>()(word) % hashSize;

}


// add definitions for your private methods here
int Table::findLongestChainIndex(){
   int longestIndex = 0;
   // loop the chain size array
   for(int a = 1; a < hashSize; a++){
      // if the chain size is longer
      if(chainSizeArray[a] > chainSizeArray[longestIndex]){
         // keep the index
         longestIndex = a;
      }
   }
   return longestIndex;
}
