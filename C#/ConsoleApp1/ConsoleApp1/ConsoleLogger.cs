using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class ConsoleLogger : ILogger
    {

        public static ILogger getLogger()
        {
            return new ConsoleLogger();
        }

        public void Flush()
        {
            //Do Nothing
        }

        public void Log(string logmsg)
        {
            Console.WriteLine(logmsg);
        }
    }
}
