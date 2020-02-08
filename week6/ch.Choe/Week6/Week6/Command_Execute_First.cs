using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week6
{
    [Serializable]
    public class Command_Execute_First : Command
    {
        public Execute_First first;

        public Command_Execute_First(Execute_First fir)
        {
            first = fir;
        }

        public void execute()
        {
            first.PrintName();
        }
    }
}
