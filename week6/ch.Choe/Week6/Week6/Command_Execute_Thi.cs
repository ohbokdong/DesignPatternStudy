using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week6
{
    [Serializable]
    class Command_Execute_Thi : Command
    {
        public Execute_Thi thi;

        public Command_Execute_Thi(Execute_Thi fir)
        {
            thi = fir;
        }

        public void execute()
        {
            thi.PrintName();
        }
    }
}
