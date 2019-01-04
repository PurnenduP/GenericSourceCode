using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LearnLinq
{
    class Student
    {
        public int StudentID { get; set; }
        public String StudentName { get; set; }
        public int Age { get; set; }
    }

    class Program
    {
        static void Main(string[] args)
        {
            string[] names = { "Bapun", "Kanhu", "Sanu", "Babu", "Momi", "Kuna", "Mina" };

            Student[] studentArray = {
            new Student() { StudentID = 1, StudentName = "John", Age = 18 },
            new Student() { StudentID = 2, StudentName = "Steve",  Age = 21 },
            new Student() { StudentID = 3, StudentName = "Bill",  Age = 25 },
            new Student() { StudentID = 4, StudentName = "Ram" , Age = 20 },
            new Student() { StudentID = 5, StudentName = "Ron" , Age = 31 },
            new Student() { StudentID = 6, StudentName = "Chris",  Age = 17 },
            new Student() { StudentID = 7, StudentName = "Rob",Age = 19  },
            new Student() { StudentID = 8, StudentName = "Rob2",Age = 19  }
        };

            IList mixedList = new ArrayList();

            mixedList.Add(0);
            mixedList.Add("Hero");
            mixedList.Add(0.5f);
            mixedList.Add(Math.PI);
            mixedList.Add("Zero");

            var stringItems = mixedList.OfType<string>().Select(s=> s).OrderByDescending(s=>s.IndexOf('o'));
            foreach (var item in stringItems)
            {
                Console.WriteLine("The mixedList String="+item);
            }





            IEnumerable<Student> teenStu = from s in studentArray
                                           where s.Age > 12
                                           where s.Age < 20
                                           select s;

            IEnumerable<Student> teenStu1 = studentArray
                                           .Where(s => s.Age > 12 && s.Age < 20)
                                           .Select(s => s);

            IEnumerable<Student> AdultStu = studentArray
                                           .Where(s => s.Age > 20)
                                           .Select(s => s);


            var grpStubyAge = from s in studentArray
                              group s by new { s.Age,s.StudentName,s.StudentID};

            Console.WriteLine("Group by Example");
            foreach (var item in grpStubyAge)
            {
                Console.WriteLine("Grouping="+item.Key);
                foreach (var item_stu in item)
                {
                    Console.WriteLine("Student in the group:"+item_stu.StudentName);
                }
            }

            var allStu = studentArray.Select(s => s).OrderBy(s => s.Age);
            //Console.WriteLine("All Students");
            //foreach (var item in allStu)
            //{
            //    Console.WriteLine("item="+item.Age);
            //}
            //Console.WriteLine("TeenAged Students");
            //foreach (var item in teenStu)
            //{
            //    Console.WriteLine(item.StudentName);

            //}
            //Console.WriteLine("AdultStudents");
            //foreach (var item in AdultStu)
            //{
            //    Console.WriteLine(item.StudentName);

            //}

            Student StuBill = studentArray
                                           .Where(s => s.StudentName == "Bills")
                                           .FirstOrDefault();

            //if (StuBill == null)
            //{
            //    Console.WriteLine("No Student named Bills Found");
            //}

            int stucount = studentArray
                           .Count();

            double sumAge = studentArray.Average(s => s.Age);

            // = studentArray.GroupBy(s => s.Age).Select(s=> s.Age);
            //Console.WriteLine("Student Count="+ sameAgeStuCount);

            var stuEvenIndex = studentArray.Where((s, i) => { if (i % 2 == 0) return true; else return false; });

            //foreach (var item in stuEvenIndex)
            //{
            //    Console.WriteLine("Students in"+item.StudentName);
            //}

            //Console.WriteLine("Sum of Student Age=" + sumAge);
            //Console.WriteLine();
            //IEnumerable<string> namestr= from s in names orderby s select s;
            //foreach (var item in namestr)
            //{
            //    Console.Write(item+",");
            //}
            //Console.WriteLine();
        }
    }
}
