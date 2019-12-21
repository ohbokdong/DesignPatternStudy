using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Client : IClient
    {
        public IServer server;
        public string IP;
        public int data;

        public Client(string ip, int data)
        {
            this.IP = ip;
            this.data = data;
        }

        public void Connect(IServer server)
        {
            this.server = server;
        }

        public int GetData()
        {
            return data;    
        }

        public string GetIP()
        {
            return IP;      
        }

        public void ReciveData(int data)
        {
            this.data = data;   
        }

        public int SendDaTA()
        {
            server.Synchronize(data);
            return data;
        }
    }
}
