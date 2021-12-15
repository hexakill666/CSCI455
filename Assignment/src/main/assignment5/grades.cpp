/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

using namespace std;

/*
   print command help
*/
static void help(){
   cout << "insert name score" << endl;
   cout << "\tInsert this name and score in the grade table. If this name was already present, print a message to that effect, and don't do the insert." << endl;
   cout << "change name newscore" << endl;
   cout << "\tChange the score for name. Print an appropriate message if this name isn't present." << endl;
   cout << "lookup name" << endl;
   cout << "\tLookup the name, and print out his or her score, or a message indicating that student is not in the table." << endl;
   cout << "remove name" << endl;
   cout << "\tRemove this student. If this student wasn't in the grade table, print a message to that effect." << endl;
   cout << "print" << endl;
   cout << "\tPrints out all names and scores in the table." << endl;
   cout << "size" << endl;
   cout << "\tPrints out the number of entries in the table." << endl;
   cout << "stats" << endl;
   cout << "\tPrints out statistics about the hash table at this point. (Calls hashStats() method)" << endl;
   cout << "help" << endl;
   cout << "\tPrints out a brief command summary." << endl;
   cout << "quit" << endl;
   cout << "\tExits the program." << endl;
}


/*
   insert execution
*/
static void insertExce(Table* grades){
   int score;
   string name;
   // read the name and score
   cin >> name >> score;
   // if insert not successful
   if(!grades->insert(name, score)){
      cout << name << " was already present, so no insert." << endl;
   }
}


/*
   change execution
*/
static void changeExce(Table* grades){
   int score;
   string name;
   // read the name and score
   cin >> name >> score;
   // look up student
   int* studentScore = grades->lookup(name);
   // if student not found
   if(studentScore == NULL){
      cout << name << " was not present, so no change." << endl;
   }
   // if student found
   else{
      // update the value
      *studentScore = score;
   }
}


/*
   lookup execution
*/
static void lookupExce(Table* grades){
   string name;
   cin >> name;
   // look up student
   int* studentScore = grades->lookup(name);
   // if student not found
   if(studentScore == NULL){
      cout << name << " was not present, so no score." << endl;
   }
   // if student found
   else{
      cout << "The score of " << name << " is: " << *studentScore << endl;
   }
}


/*
   remove execution
*/
static void removeExce(Table* grades){
   string name;
   cin >> name;
   if(!grades->remove(name)){
      cout << name << " was not present, so no remove." << endl;
   }
}


int main(int argc, char * argv[]) {

   // gets the hash table size from the command line
   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      // atoi converts c-string to int
      hashSize = atoi(argv[1]);
      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" << endl;
         return 1;
      }
      grades = new Table(hashSize);
   }
   // no command line args given -- use default table size
   else {
      grades = new Table();
   }

   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*
   while(true){
      cout << "cmd>";
      string command;
      // read input
      cin >> command;
      // insert
      if(command == "insert"){
         insertExce(grades);
      }
      // change
      else if(command == "change"){
         changeExce(grades);
      }
      // lookup
      else if(command == "lookup"){
         lookupExce(grades);
      }
      // remove
      else if(command == "remove"){
         removeExce(grades);
      }
      // print
      else if(command == "print"){
         grades->printAll();
      }
      // size
      else if(command == "size"){
         cout << "number of entries: " << grades->numEntries() << endl;
      }
      // stats
      else if(command == "stats"){
         grades->hashStats(cout);
      }
      // help
      else if(command == "help"){
         help();
      }
      // quit
      else if(command == "quit"){
         break;
      }
      // invalid command
      else{
         cout << "ERROR: invalid command." << endl;
         help();
      }
   }

   return 0;
}
