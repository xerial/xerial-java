#include <iostream>
#include <fstream>
#include <string>
#include <cstdio>
#include <ctime>
using namespace std;

int main(int argc, char** argv) {
  
  if(argc <= 1) {
    cout << "usage: [input file]" << endl;
    return 0;
  }

  const char* filename = argv[1];
  cout << "input file name: " << filename << endl; 
  
  FILE* f = fopen(filename, "r");
  if(f == NULL){
    cout << "file not found" << endl;
    return -1;
  }

  fseek( f, 0, SEEK_END );
  long fileSize = ftell(f);
  fclose(f);
  cout << "file size: " << fileSize << endl;

  clock_t  start, end;
  start = clock();

  ifstream fin(filename, ifstream::in);
  if(!fin.good()) { cout << "failed to open " << filename << endl; return -1; }
  
  string s;
  int line = 0;
  while(!fin.eof()) {
    getline(fin, s);
    line++;
  }
  end = clock();
  fin.close();
   
  cout << "#line: " << line << endl;
  double time = (end - start) / (double) CLOCKS_PER_SEC;
  cout << time << " sec." << endl;
  double mbPerSec = (double) fileSize / 1024.0 / 1024.0 / time ;
  cout << mbPerSec << " MB/sec" << endl;
    
  return 0;
}
