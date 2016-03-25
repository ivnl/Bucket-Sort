#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
using namespace std;

ifstream in_data1;
ofstream out_data1;
ofstream out_data2;

class bucketSort {

    private:
        int minData =0 , maxData=0, bucketSize, offset;
        int* bucketAry;

    public:
        bucketSort(int min, int max) {

            minData = min;
            maxData = max;
            offset=min;
            bucketSize = max-min+1;
            bucketAry = new int[bucketSize]();

            }

        ~bucketSort() {

            delete[] bucketAry;

            }

        void buildAry(ifstream& in_data) {

            int num = 0;
            if (in_data.is_open()) {
                while (in_data>>num) {

                    bucketAry[num-offset]++;

                    }
                }
            }

        void printBucketAry() {

            out_data2<<"Index:  ";
            for(int i=0; i<19; i++) {
                out_data2<<left << setw(3)<<i<<" ";
                }

            out_data2<<endl<<"Value:  ";
            for(int i=0; i<19; i++) {
                out_data2<<left << setw(3)<<bucketAry[i]<<" ";
                }

            }

        void printSortedData() {

            out_data1<<"Sorted List: ";

            for(int i=0; i<bucketSize; i++) {

                while(bucketAry[i]!=0) {

                    if(bucketAry[i]!=0) out_data1<<i+offset<<" ";

                    bucketAry[i]--;

                    }
                }
            }

        void getInfo() {

            cout<<"min: "<<minData<<endl;
            cout<<"max: "<<maxData<<endl;
            cout<<"size: "<<bucketSize<<endl;
            cout<<"offset: "<<offset<<endl;
            cout<<bucketAry[197]<<endl;

            }

    };


void findMinMax(ifstream& in_data, int &mn, int &mx) {

    int num;

    if (in_data.is_open()) {

        while (in_data>>num) {
            if(mn==0) mn=num;
            if (num < mn) mn = num;
            if(num > mx) mx = num;
            }
        }
    }


int main(int argc, char * argv[]) {

    int min=0, max =0;
    in_data1.open(argv[1]);
    out_data1.open(argv[2]);
    out_data2.open(argv[3]);

    findMinMax(in_data1,min,max);

    bucketSort myBucket (min,max);

    in_data1.close();
    in_data1.open(argv[1]);
    myBucket.buildAry(in_data1);

    myBucket.printBucketAry();
    myBucket.printSortedData();

    in_data1.close();
    out_data1.close();
    out_data2.close();

    return 0;

    }
