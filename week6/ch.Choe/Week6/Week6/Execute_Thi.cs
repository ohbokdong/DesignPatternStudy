using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Week6
{
    [Serializable]
    class Execute_Thi
    {
        public int num = 0;
        public string Class_Name = "Execute_Thi";

        public void PrintName()
        {
            Console.WriteLine("Class = " + Class_Name + ", " + num + " Start");
            Thread.Sleep(1500);
            Console.WriteLine("Class = " + Class_Name + " End");
            num++;
        }
    }
}
