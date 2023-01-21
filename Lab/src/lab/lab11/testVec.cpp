#include<iostream>
#include<vector>

using namespace std;

static vector<int> readVals(){
    vector<int> v;
    int num;
    while (cin >> num){
        v.push_back(num);
    }
    return v;
}

static void printVals(vector<int> v){
    for(int a = 0; a < v.size(); a++){
        cout << v[a] << " ";
    }
    cout << endl;
}

int main(int argc, char const *argv[]){
    vector<int> v = readVals();
    printVals(v);
    return 0;
}