using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Week6
{
    class Program
    {
        static void Main(string[] args)
        {
            JobSceheduler job = new JobSceheduler();

            Execute_First first = new Execute_First();
            Command_Execute_First commandfirst = new Command_Execute_First(first);

            Execute_Sec sec = new Execute_Sec();
            Command_Execute_Sec commandsec = new Command_Execute_Sec(sec);

            Execute_Thi thi = new Execute_Thi();
            Command_Execute_Thi commandthi = new Command_Execute_Thi(thi);

            job.SetThreadQueue(4);

            job.Push(commandfirst);
            job.Push(commandsec);
            job.Push(commandthi);

            

            while(true)
            {
                //if(Console.ReadLine() == "e")
                //{
                //    break;
                //}

                while (job.StartJob()) { }
                
                Thread.Sleep(1000);
                job.Push(commandfirst);
                job.Push(commandsec);
                job.Push(commandthi);
            }
            
            //job.CommandSave();

            //job.CommandLoad();

        }


    }
}
