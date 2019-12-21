using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    interface IServer
    {

        void Connect(IClient client);
        void Disconnect(IClient client);

        void Synchronize(int data);

    }
}
