using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Week6
{
    [Serializable]
    public class Execute_First
    {
        public int num = 0;
        public string Class_Name = "Execute_First";

        public void PrintName()
        {
            
            Console.WriteLine("Class = " + Class_Name +", " + num + " Start");
            Thread.Sleep(1000);
            Console.WriteLine("Class = " + Class_Name + " End");
            num++;
        }
    }
}
