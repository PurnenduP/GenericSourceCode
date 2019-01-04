using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            var _log = LoggingFactory.GetLogger(LoggerType.FileLogger);
            
            try
            {                
                createTestData();
                _log.Log("Operation Done");
            }
            catch(Exception e)
            {

                //Console.WriteLine(e.ToString());
                _log.Log(e.ToString());
                Console.WriteLine("Error!!! Please check the log file");
                //throw;
            }
            finally
            {
                _log.Flush();
            }
        }

        public static void updateTestDate()
        {
            using (var DbContext = new EMPDBEntities2())
            {

                var course1 = DbContext.courses.Where((s) => s.course_name == "Elementary Physics").FirstOrDefault();
                var emp = DbContext.employee.Find(1);
                emp.courses.Add(course1);
                course1.employee.Add(emp);

                var ins = DbContext.instructor.Find(1);
                course1.instructor.Add(ins);

                //emp.emp_name = "Suvendu Patra";
                DbContext.SaveChanges();
            }

        }
        public static void createTestData()
        {
            using (var DbContext = new EMPDBEntities2())
            {
                var dept = new dept();
                dept.dept_id = 20;
                dept.dept_name = "Chemistry";

                var emp = new employee();
                emp.emp_id = 4;
                emp.emp_name = "Mamata Patra";
                emp.mgr_id = 1;
                emp.dept_id = 20;
                emp.dob = new DateTime(1978, 7, 2);

                //var course = new courses();
                //course.course_id = 1;
                //course.course_name = "Elementary Physics";

                //var instructor = new instructor();
                //instructor.ins_id = 1;
                //instructor.ins_name = "H.C. Verma";

                DbContext.dept.Add(dept);
                DbContext.employee.Add(emp);
                //DbContext.courses.Add(course);
                //DbContext.instructor.Add(instructor);

                DbContext.SaveChanges();
            }

        }
    }
}
