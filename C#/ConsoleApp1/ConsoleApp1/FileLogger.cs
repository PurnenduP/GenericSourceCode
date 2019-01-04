using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApp1
{
    class FileLogger : ILogger
    {
        public void Log(string logmsg)
        {
            using (StreamWriter logfile = new StreamWriter(@"C:\EntityLog.txt", true))
            {
                logfile.WriteLine(logmsg);
            }
        }

        public static ILogger getLogger()
        {
            return new FileLogger();
        }

        public void Flush()
        {
            //Do Nothing;
        }
    }
}
