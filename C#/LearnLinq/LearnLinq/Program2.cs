using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LearnLinq2
{
    class Student
    {
        public int StudentID { get; set; }
        public string StudentName { get; set; }
        public int StandardID { get; set; }
    }

    class Standard
    {
        public int StandardID { get; set; }
        public string StandardName { get; set; }
    }
    class Program2
    {

        public static void Main(string [] args)
        {
            IList<Student> studentList = new List<Student>() {
            new Student() { StudentID = 1, StudentName = "John", StandardID =1 },
            new Student() { StudentID = 2, StudentName = "Moin", StandardID =1 },
            new Student() { StudentID = 3, StudentName = "Bill", StandardID =2 },
            new Student() { StudentID = 4, StudentName = "Ram" , StandardID =2 },
            new Student() { StudentID = 5, StudentName = "Ron"  }
            };

            IList<Standard> standardList = new List<Standard>() {
            new Standard(){ StandardID = 1, StandardName="Standard 1"},
            new Standard(){ StandardID = 2, StandardName="Standard 2"},
            new Standard(){ StandardID = 3, StandardName="Standard 3"}
            };

            var stustdlist = studentList.Join(standardList, a => new { a.StandardID, anotherKey="anotherKey" }, b => new { b.StandardID, anotherKey = "anotherKey" }, (a, b) => new { studentName= a.StudentName,standardName=b.StandardName });

            foreach (var item in stustdlist)
            {
                Console.WriteLine("StudentName="+item.studentName);
                Console.WriteLine("StandardName=" + item.standardName);
            }
        }
    }
}
