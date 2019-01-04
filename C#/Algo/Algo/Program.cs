using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algo
{
    class Program
    {

        public static void permutationIterative()
        {
            int[] arr = Enumerable.Range(1, 1).ToArray();

            for (int j = 0; j < arr.Length; j++)
            {

                swap(arr, 0, j);
                display(arr);
                Console.WriteLine();
                for (int i = 1; i < arr.Length-1; i++)
                {
                    swap(arr, 1, i+1);
                    display(arr);
                    swap(arr, i+1, 1);
                    Console.WriteLine();
                }
                swap(arr, j, 0);


                //    display(arr, 0, arr.Length);
                //    Console.WriteLine();
                //    if (j == arr.Length - 1)
                //        break;
                //    int temp = arr[j + 1];
                //    arr[j + 1] = arr[j];
                //    arr[j] = temp;
            }
            Console.WriteLine();
            Console.WriteLine("Original Array");
            display(arr);
            Console.WriteLine();

        }
        static void display(int[] a)
        {
            for (int i = 0; i < a.Length; i++)
            {
                Console.Write(a[i] + ",");
            }
        }

        static void swap(int[] Parr, int a, int b)
        {
            //Console.Write("Swapping {0},{1}", a, b);
            if (a != b)
            {
                int temp = Parr[a];
                Parr[a] = Parr[b];
                Parr[b] = temp;
            }
        }


        /*
         
         
         permutationRecursive(arr,0,3)
             swap(0,0)
             permutationRecursive(1,3)
                 swap(1,1)
                 permutationRecursive(2,3)
                    swap(2,2)
                    permutationRecursive(3,3) --- Display 1,2,3
                    swap(2,2)
                 swap(1,1)
                 swap(1,2)
                 permutationRecursive(3,3) --display 1,3,2
                 swap(2,1)
             swap(0,0)
             swap(0,1)
             permutationRecursive(2,3);
                    swap(2,2)
                    permutationRecursive(3,3) --- Display 2,1,3
                    swap(2,2)
             swap(1,0)

        */

        public static void superSet(int[] arr,int pick)
        {
            for (int i = 0; i < arr.Length; i+=pick)
            {

                int pickstart = i + 1;
                for (int j = pickstart,k = 0; k<((int)Math.Ceiling((decimal)arr.Length/pick)+1) && j<arr.Length; j++,k++)
                {
                    Console.Write(arr[0]+","+arr[j]);
                }
                Console.WriteLine();
            }
        }


        public static void permutationRecursive(int []arr,int start,int end)
        {

            if (start == end )
            {
                display(arr);Console.WriteLine("Returning");
                //return;
             }
            else
            {

                for (int j = start; j < end; j++)
                {
                    swap(arr, start, j); //Console.WriteLine(">>First");
                    //Console.WriteLine("calling Recursion with start{0},End{1}",j+1,end);
                    permutationRecursive(arr, start + 1, end);
                    //display(arr); Console.WriteLine("Main");
                    swap(arr, j, start); //Console.WriteLine(">>Last");

                }
            }
        }


        public static int factorial(int n)
        {
            if (n == 1)
                return 1;
            else
                return  n * factorial(n-1);
        }

        public static void printArrayInReverseUsingRecursion()
        {
            int[] arr = Enumerable.Range(1, 20).ToArray();
            string printArrary(int[] a,int len)
            {
                if (len == 0)
                {
                    return a[len].ToString();
                }
                else
                    return a[len] + "," + printArrary(arr,len-1);
            }

            Console.WriteLine(printArrary(arr,arr.Length-1));

        }

        public static void bubbleSortDesc()
        {
            int[] arr = Enumerable.Range(1, 20).ToArray();

            arr.ToList().ForEach(n => { Console.Write(n); Console.Write(","); });
            Console.WriteLine();
            for (int i = 0; i < arr.Length-1; i++)
            {
                for (int j = i+1; j < arr.Length; j++)
                {
                    if(arr[i] < arr[j])
                    {
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }

            arr.ToList().ForEach(n => { Console.Write(n); Console.Write(","); });
            Console.WriteLine();
        }

        public static void insertionSort()
        {
            int[] arr = Enumerable.Range(1, 20).ToArray();

            for (int i = 0; i < arr.Length; i++)
            {

            }
        }
        static void Main(string[] args)
        {
            //permutationIterative();
            int[] samplearray = Enumerable.Range(1, 4).ToArray();
            superSet(samplearray, 3);
            //permutationRecursive(samplearray, 0, samplearray.Length);
            //Console.WriteLine("Original Array:");
            //display(samplearray);

            //int Fact_num;
            //int FactorialVal;
            ////new SortingClass().recursiveSort();
            //while (true)
            //{
            //    Console.Write("Enter a Number for which u want to calculate factorial:");
            //    Fact_num = Int32.Parse(Console.ReadLine());
            //    FactorialVal = factorial(Fact_num);
            //    Console.WriteLine("Factorial of {0} is {1}", Fact_num, FactorialVal);
            //    Console.Write("Do you want to continue(y/n):");
            //    if (Console.ReadLine().ToLower() == "y")
            //        continue;
            //    else
            //        break;
            //}
        }
    }

    class SortingClass
    {
        int[] arr = Enumerable.Range(1, 200).ToArray();
        public void recursiveSort()
        {
            for (int i = 0; i < arr.Length; i++)
            {
                Console.WriteLine(arr[i]);
            }

        }
    }
}
