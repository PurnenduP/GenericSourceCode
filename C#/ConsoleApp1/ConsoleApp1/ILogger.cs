﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    interface ILogger
    {
        void Log(string logmsg);
        void Flush();
    }
}