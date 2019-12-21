using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Server : IServer
    {
        public List<IClient> ClientList = new List<IClient>();

        public void ShowConnectList()
        {
            Console.WriteLine("connect List: ");

            for (int i = 0; i < ClientList.Count; i++)
            {
                Console.WriteLine(i+ " : IP " + ClientList[i].GetIP() + ", Data " + ClientList[i].GetData());
            }
        }

        public void Connect(IClient client)
        {
            Console.WriteLine("Connect : " + client.GetIP());
            client.Connect(this);
            ClientList.Add(client);
        }

        public void Disconnect(IClient client)
        {
            Console.WriteLine("Disconnect : " + client.GetIP());
            ClientList.Remove(client);
        }

        public void Synchronize(int data)
        {
            Console.WriteLine("Synchronize :" + data);
            for (int i = 0; i < ClientList.Count; i++)
            {
                ClientList[i].ReciveData(data);
            }
        }
    }
}
