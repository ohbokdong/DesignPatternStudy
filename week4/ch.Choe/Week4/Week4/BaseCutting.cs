﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week4
{
    public class BaseCutting : IPizzaCutting
    {
        public void Cutting()
        {
            Console.WriteLine("Cutting.... Base Slices");
        }
    }
}
