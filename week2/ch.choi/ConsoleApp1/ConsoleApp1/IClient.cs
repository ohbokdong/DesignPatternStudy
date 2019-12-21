using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    interface IClient
    {
        void Connect(IServer server);
        string GetIP();

        void ReciveData(int data);

        int SendDaTA();
        int GetData();
    }
}
