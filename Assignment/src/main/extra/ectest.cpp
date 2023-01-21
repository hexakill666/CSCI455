/*  CS 455 Sping 2021
 *  Extra credit assignment
 *
 *  ectest.cpp
 *
 *  a non-interactive test program to test the functions described in ecListFuncs.h
 *
 *    to run it use the command:   ectest
 *
 *  Note: this uses separate compilation.  You put your list code ecListFuncs.cpp
 *  Code in this file should call those functions.
 */


#include <iostream>
#include <string>
#include <vector>

#include "ecListFuncs.h"

using namespace std;

static void testBuildListAndListToString(){
   string input1 = "";
   string input2 = "-1";
   string input3 = "     -1 ";
   string input4 = "0 -1 1";
   string input5 = "  0  -1     1";
   string input6 = "0       -1    1  ";

   vector<string> inputList;
   inputList.push_back(input1);
   inputList.push_back(input2);
   inputList.push_back(input3);
   inputList.push_back(input4);
   inputList.push_back(input5);
   inputList.push_back(input6);

   vector<ListType> builds;
   for(unsigned int a = 0; a < inputList.size(); a++){
      builds.push_back(buildList(inputList[a]));
   }

   vector<string> listStrings;
   for(unsigned int a = 0; a < builds.size(); a++){
      listStrings.push_back(listToString(builds[a]));
   }

   string exp1 = "()";
   string exp2 = "(-1)";
   string exp3 = "(-1)";
   string exp4 = "(0 -1 1)";
   string exp5 = "(0 -1 1)";
   string exp6 = "(0 -1 1)";

   vector<string> expList;
   expList.push_back(exp1);
   expList.push_back(exp2);
   expList.push_back(exp3);
   expList.push_back(exp4);
   expList.push_back(exp5);
   expList.push_back(exp6);

   for(unsigned int a = 0; a < listStrings.size(); a++){
      cout << "==========testBuildListAndListToString==========" << endl;
      cout << "expect result: " << expList[a] << endl;
      cout << "actual result: " << listStrings[a] << endl;
      cout << "final result: " << (expList[a] == listStrings[a] ? "Successful" : "Failed") << endl;
   }
}

static void testInsertAt(){
   vector<int> inputList({-100, -1, 0, 1, 100});

   vector<ListType> lists;
   ListType list1 = NULL;
   for(unsigned int a = 0; a < inputList.size(); a++){
      insertAt(list1, 0, inputList[a]);
   }
   ListType list2 = NULL;
   for(unsigned int a = 0; a < inputList.size(); a++){
      insertAt(list2, a, inputList[a]);
   }
   ListType list3 = NULL;
   for(unsigned int a = 0; a < inputList.size(); a++){
      insertAt(list3, a / 2, inputList[a]);
   }
   lists.push_back(list1);
   lists.push_back(list2);
   lists.push_back(list3);

   string exp1 = "(100 1 0 -1 -100)";
   string exp2 = "(-100 -1 0 1 100)";
   string exp3 = "(-1 1 100 0 -100)";
   vector<string> expList;
   expList.push_back(exp1);
   expList.push_back(exp2);
   expList.push_back(exp3);

   for(unsigned int a = 0; a < lists.size(); a++){
      cout << "==========testInsertAt==========" << endl;
      cout << "expect result: " << expList[a] << endl;
      cout << "actual result: " << listToString(lists[a]) << endl;
      cout << "final result: " << (expList[a] == listToString(lists[a]) ? "Successful" : "Failed") << endl;
   }
}

static void testPartitionBy(){
   string input1 = "";
   string input2 = "1 1 1 1 1";
   string input3 = "-1 -1 -1 -1 -1";
   string input4 = "-1 0 1 10 10 10 1 0 -1";
   string input5 = "10 10 10 -1 0 1 10 10 10";
   string input6 = "-10 -9 -8 10 -7 -6 9 -5 8 7 6 5";
   string input7 = "10 9 8 -10 7 6 -9 5 -8 -7 -6 -5";

   vector<string> inputList;
   inputList.push_back(input1);
   inputList.push_back(input2);
   inputList.push_back(input3);
   inputList.push_back(input4);
   inputList.push_back(input5);
   inputList.push_back(input6);
   inputList.push_back(input7);

   string return1 = "()";
   string return2 = "()";
   string return3 = "(-1 -1 -1 -1 -1)";
   string return4 = "(-1 0 1 1 0 -1)";
   string return5 = "(-1 0 1)";
   string return6 = "(-10 -9 -8 -7 -6 -5)";
   string return7 = "(-10 -9 -8 -7 -6 -5)";

   string afterList1 = "()";
   string afterList2 = "(1 1 1 1 1)";
   string afterList3 = "()";
   string afterList4 = "(10 10 10)";
   string afterList5 = "(10 10 10 10 10 10)";
   string afterList6 = "(10 9 8 7 6 5)";
   string afterList7 = "(10 9 8 7 6 5)";

   vector<string> returnList;
   returnList.push_back(return1);
   returnList.push_back(return2);
   returnList.push_back(return3);
   returnList.push_back(return4);
   returnList.push_back(return5);
   returnList.push_back(return6);
   returnList.push_back(return7);

   vector<string> afterList;
   afterList.push_back(afterList1);
   afterList.push_back(afterList2);
   afterList.push_back(afterList3);
   afterList.push_back(afterList4);
   afterList.push_back(afterList5);
   afterList.push_back(afterList6);
   afterList.push_back(afterList7);

   vector<ListType> lists;
   for(unsigned int a = 0; a < inputList.size(); a++){
      lists.push_back(buildList(inputList[a]));
   }

   vector<int> partitionNumberList({0, 0, 0, 10, 10, -1, -1});
   vector<ListType> partitionList;
   for(unsigned int a = 0; a < lists.size(); a++){
      partitionList.push_back(partitionBy(lists[a], partitionNumberList[a]));
   }

   for(unsigned int a = 0; a < partitionList.size(); a++){
      cout << "==========testPartitionBy==========" << endl;
      cout << "expect return: " << returnList[a] << endl;
      cout << "actual return: " << listToString(partitionList[a]) << endl;
      cout << "expect after list: " << afterList[a] << endl;
      cout << "actual after list: " << listToString(lists[a]) << endl;
      cout << "final result: " << (returnList[a] == listToString(partitionList[a]) && afterList[a] == listToString(lists[a]) ? "Successful" : "Failed") << endl;
   }
}

int main (){

   testBuildListAndListToString();
   testInsertAt();
   testPartitionBy();

   return 0;
}