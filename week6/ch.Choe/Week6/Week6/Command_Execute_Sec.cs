using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week6
{
    [Serializable]
    class Command_Execute_Sec : Command
    {
        public Execute_Sec sec;

        public Command_Execute_Sec(Execute_Sec fir)
        {
            sec = fir;
        }

        public void execute()
        {
            sec.PrintName();
        }
    }
}
