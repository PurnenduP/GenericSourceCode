using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    public enum LoggerType { DatabaseLogger,FileLogger,ConsoleLogger};
    class LoggingFactory
    {
        public static ILogger GetLogger(LoggerType loggerType)
        {
            switch (loggerType)
            {
                case LoggerType.DatabaseLogger:
                    return DatabaseLogger.getLogger();
                case LoggerType.FileLogger:
                    return FileLogger.getLogger();
                case LoggerType.ConsoleLogger:
                    return ConsoleLogger.getLogger();
                default:
                    return null;
            }
        }
    }
}
