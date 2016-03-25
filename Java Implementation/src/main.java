import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//
//ifstream in_data1;
//ofstream out_data1;
//ofstream out_data2;
//
public class main {

	static void findMinMax(String input, int mn, int mx) {

		//   File inputFile = new File (input);

		int num = 0;

		Scanner scanner = new Scanner(input);

		while (scanner.hasNextInt()) {

			if(mn==0) mn=num;
			if (num < mn) mn = num;
			if(num > mx) mx = num;
			scanner.nextInt();

			//System.out.print(scanner.nextInt() + " ");


		}

	}


	public static void main(String[] args) throws Exception {

		int min=0, max =0;

		File in_file = new File(args[0]);
		File out_file1 = new File(args[1]);
		File out_file2 = new File(args[2]);

		findMinMax(args[0],min,max);

		bucketSort myBucket = new bucketSort(min,max, out_file1, out_file2);

		myBucket.buildAry(in_file);

		myBucket.printBucketAry();
		myBucket.printSortedData();

		//out_file1.);
		//out_file2.close();


	}

}



class bucketSort {


	private int minData =0 , maxData=0, bucketSize, offset;
	private int bucketAry[];
	private PrintWriter out_file1;
	private PrintWriter out_file2;


	public bucketSort(int min, int max, File out1, File out2) throws FileNotFoundException {

		minData = min;
		maxData = max;
		offset=min;
		bucketSize = max-min+1;
		bucketAry = new int[bucketSize];

		out_file1 = new PrintWriter(out1);
		out_file2 = new PrintWriter(out2);

	}

	void buildAry(File in_file) throws FileNotFoundException {

		int num = 0;

		Scanner scanner = new Scanner(in_file);

		while (scanner.hasNextInt()) {

			bucketAry[num-offset]++;
			scanner.nextInt();


		}
	}

	void printBucketAry() {

		out_file2<<"Index:  ";
		for(int i=0; i<19; i++) {
			out_data2<<left << setw(3)<<i<<" ";
		}

		out_file2<<endl<<"Value:  ";
		for(int i=0; i<19; i++) {
			out_file2<<left << setw(3)<<bucketAry[i]<<" ";
		}

	}

	void printSortedData() {

		out_file1<<"Sorted List: ";

		for(int i=0; i<bucketSize; i++) {

			while(bucketAry[i]!=0) {

				if(bucketAry[i]!=0) out_file1<<i+offset<<" ";

				bucketAry[i]--;

			}
		}
	}

//	void getInfo() {
//
//		cout<<"min: "<<minData<<endl;
//		cout<<"max: "<<maxData<<endl;
//		cout<<"size: "<<bucketSize<<endl;
//		cout<<"offset: "<<offset<<endl;
//		cout<<bucketAry[197]<<endl;
//
//	}

}
