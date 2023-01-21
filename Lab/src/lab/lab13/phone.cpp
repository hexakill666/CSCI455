/*

  CSCI 455 C String lab

  See lab description for what it should do.  
  C++ tools allowed: cout, call by reference, ostream output, new / delete

*/


// for C input functions (e.g., fgets used here)
#include <cstdio>

// C string functions
#include <cstring>

#include <iostream>


using namespace std;

const char NAME_DELIM = ':';
const int AREA_CODE_SIZE = 3;
const int PREFIX_SIZE = 3;
const int LINE_NO_SIZE = 4;
const int MAX_LINE_SIZE = 1024;  // including newline and terminating null char

static void readField(char* buffer, int startLoc, int length, char*& dest){
   dest = new char[length];
   int index = 0;
   for(int a = startLoc; a < length; ){
      dest[index++] = buffer[a++];
   }
}

int main() {

   char buffer[MAX_LINE_SIZE];


   // fgets reads a line of input and puts it in a C string.  If the line of input
   // is longer than the buffer array only gets enough chars that fit (and ignores the
   // rest); this prevents it from overwriting the end of the array.
   // Unlike Java Scanner nextLine(), fgets also saves the newline in the buffer.
   // So after call, buffer will have 0 or more chars read from the line, 
   // then a newline char ('\n'), and then the null char ('\0')
   // note: the sizeof function below does not work with dynamic arrays.
   // fgets returns 0 (false) when it hits EOF
   // Note: stdin (third paremeter below) is the C version of cin or System.in


   // while (fgets(buffer, sizeof(buffer), stdin)) {

   //    int index = 0;
   //    string bufferStr = buffer;
   //    string areaCode = bufferStr.substr(index, AREA_CODE_SIZE);
   //    index += areaCode.length() + 1;
   //    string prefix = bufferStr.substr(index, PREFIX_SIZE);
   //    index += prefix.length() + 1;
   //    string lineNumber = bufferStr.substr(index);

   //    cout << "area code: " <<  areaCode << endl;
   //    cout << "prefix: " <<  prefix << endl;
   //    cout << "lineNumber: " <<  lineNumber << endl;

   // }

   while (fgets(buffer, sizeof(buffer), stdin)) {

      char* areaCode;
      char* prefix;
      char* lineNumber;
      readField(buffer, 0, AREA_CODE_SIZE, areaCode);
      readField(buffer, strlen(areaCode) + 1, strlen(areaCode) + 1 + PREFIX_SIZE, prefix);
      readField(buffer, strlen(areaCode) + 1 + strlen(prefix) + 1, strlen(areaCode) + 1 + strlen(prefix) + 1 + LINE_NO_SIZE, lineNumber);

      cout << "area code: " <<  areaCode << endl;
      cout << "prefix: " <<  prefix << endl;
      cout << "lineNumber: " <<  lineNumber << endl;

   }

}