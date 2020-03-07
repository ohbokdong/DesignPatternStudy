using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week9
{
    class Item
    {
        private string name;
        private string price;
        private bool veg;

        public Item(string name, string price, bool veg)
        {
            this.name = name;
            this.price = price;
            this.veg = veg;
        }
        public string GetName()
        {
            return name;    
        }
        public string GetPrice()
        {
            return price;
        }
        public bool IsVeg()
        {
            return veg;
        }
        
    }
}
