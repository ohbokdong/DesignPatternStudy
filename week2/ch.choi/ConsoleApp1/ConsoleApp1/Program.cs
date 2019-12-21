using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        private static Server myServer = null;
        private static List<Client> m_ClientList = new List<Client>();

        static void Main(string[] args)
        {
            CreateServer();
            string read = string.Empty;
            bool loop = true; 
            while(loop)
            {
                read = Console.ReadLine();
                string[] parser = read.Split(' ');
                if (parser.Length == 0)
                {
                    continue;
                }
                
                switch (parser[0])
                {
                    case "q":
                        loop = false;
                        break;
                    case "i":
                        myServer.ShowConnectList();
                        break;
                    case "c":
                        m_ClientList.Add(CreateClient(parser[1], int.Parse(parser[2])));
                        break;
                    case "cc":
                        AllConnect();
                        break;
                    case "dd":
                        AllDisConnect();
                        break;
                    case "s":
                        SendDatat(int.Parse(parser[1]));
                        break;
                    default:
                        break;
                }
            }

        }

        private static Client CreateClient(string ip, int data)
        {
            Console.WriteLine("CreateClient " + ip +"," + data );
            Client c = new Client(ip, data);
            return c;
        }

        public static void SendDatat(int index)
        {
            m_ClientList[index].SendDaTA();
        }
        private static void AllConnect()
        {
            for (int i = 0; i < m_ClientList.Count; i++)
            {
                myServer.Connect(m_ClientList[i]);
            }
        }
        private static void AllDisConnect()
        {
            int last = m_ClientList.Count - 1;
            for (int i = last; i >= 0; i--)
            {
                myServer.Disconnect(m_ClientList[i]);
            }   
        }
        private static void CreateServer()
        {
            
            if(myServer == null)
            {
                myServer = new Server();
            }
        }
        
    }
}
