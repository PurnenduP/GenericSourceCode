using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class DatabaseLogger : ILogger
    {
        private List<databaselog> _logStorage;
        public static int Logid =0;

        private DatabaseLogger()
        {
            _logStorage = new List<databaselog>();
        }
        public void Log(string logmsg)
        {
            if (_logStorage.Count < 10)
            {
                _logStorage.Add(new databaselog() { log_msg = logmsg,last_added = DateTime.Now });
            }
            else
            {
                saveToDisk();
                _logStorage.Clear();
            }
        }

        public void saveToDisk()
        {
            if (_logStorage.Count > 0)
            {
                using (var dbContext = new EMPDBEntities2())
                {
                    dbContext.databaselog.AddRange(_logStorage);
                    dbContext.SaveChanges();
                }
            }

        }

        public static ILogger getLogger()
        {
            return new DatabaseLogger();
        }

        public void Flush()
        {
            saveToDisk();
        }
    }
}
