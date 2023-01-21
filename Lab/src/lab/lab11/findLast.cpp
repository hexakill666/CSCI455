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

static vector<int> valsGT0(vector<int> v){
    vector<int> fv;
    for(int a = 0; a < v.size(); a++){
        if(v[a] > 0){
            fv.push_back(v[a]);
        }
    }
    return fv;
}

static int findLast(vector<int> v, int target){
    for(int a = v.size() - 1; a >= 0; a--){
        if(v[a] == target){
            return a;
        }
    }
    return -1;
}

int main(int argc, char const *argv[]){
    vector<int> v = readVals();

    cout << "Vector: ";
    printVals(v);
    
    int target = 0;
    int index = findLast(v, target);
    cout << "The last instance of " << target << " is at position " << index << endl;
    
    return 0;
}