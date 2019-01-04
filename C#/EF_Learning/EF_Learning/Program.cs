using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EF_Learning
{
    class Program
    {
        static void Main(string[] args)
        {
            using (var ctx = new SchoolContext())
            {
                var Student = new Student { StudentID = 1, StudentName = "Puru" };
                ctx.Students.Add(Student);
                ctx.SaveChanges();
            }
        }
    }
}
