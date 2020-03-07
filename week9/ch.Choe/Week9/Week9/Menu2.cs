using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week9
{
    class Menu2
    {
        static int MAX = 3;
        int index = 0;
        Item[] Items;

        public Menu2()
        {
            Items = new Item[MAX];
            AddItem("Menu2-1","2000",false);
            AddItem("Menu2-2", "3000", false);
            AddItem("Menu2-3", "4000", false);

        }

        public void AddItem(string name, string pri, bool veg)
        {
            Item item = new Item(name, pri, veg);
            if (index >= MAX)
            {

            }
            else
            {
                Items[index] = item;
                index++;
            }
        }

        public Item[] GetItems()
        {
            return Items;
        }
        public UserIterator CreateIterator()
        {
            return new Menu2Iterator(Items);
        }

    }
}
