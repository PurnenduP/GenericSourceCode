using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatternConsoleApp2
{
    class Client
    {
        static void Main(string[] args)
        {
            var intelComputerFactory = new IntelComputerFactory();
            Computer intelComputer = intelComputerFactory.GetComputer();
            Console.WriteLine(intelComputer);
            
        }
    }

    // Abstract Product

    public interface IChip
    {
        string CreateChip();
    }

    public interface IProcessor
    {
        string CreateProcessor();
    }


    // Concrete Product
    public class IntelChip : IChip
    {
        public string CreateChip()
        {
            return "This is Intel Chip";
        }
    }

    public class AMDChip : IChip
    {
        public string CreateChip()
        {
            return "This is AMD Chip";
        }
    }


    public class IntelProcessor : IProcessor
    {
        public string CreateProcessor()
        {
            return "This is Intel Processor";
        }
    }


    public class AMDProcessor : IProcessor
    {
        public string CreateProcessor()
        {
            return "This is AMD Processor";
        }
    }


    public class Computer
    {
        IChip chip;
        IProcessor processor;

        public IChip Chip { get { return chip; } set { chip = value; } }
        public IProcessor Processor { get { return processor; } set { processor = value; } }

        public override string ToString()
        {
            return chip.CreateChip() + processor.CreateProcessor();
        }
    }

    // ABstract Factory

    public abstract class AbstractComputerFactory
    {
        public abstract IChip CreateChip();
        public abstract IProcessor CreateProcessor();
        public abstract Computer GetComputer();

    }

    public class IntelComputerFactory : AbstractComputerFactory
    {
        Computer intelComputer;

        public override IChip CreateChip()
        {
            return new IntelChip();
        }

        public override IProcessor CreateProcessor()
        {
            return new IntelProcessor();
        }

        public override Computer GetComputer()
        {
            intelComputer = new Computer { Chip = new IntelChip(), Processor = new IntelProcessor() };
            return intelComputer;
        }
    }

    public class AMDComputerFactory : AbstractComputerFactory
    {
        public override IChip CreateChip()
        {
            throw new NotImplementedException();
        }

        public override IProcessor CreateProcessor()
        {
            throw new NotImplementedException();
        }

        public override Computer GetComputer()
        {
            throw new NotImplementedException();
        }
    }

}
