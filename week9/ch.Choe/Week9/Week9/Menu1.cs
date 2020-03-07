using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week9
{
    class Menu1
    {
        List<Item> ItemList;
        int postion = 0;
        public Menu1()
        {
            ItemList = new List<Item>();

            AddItem("Menu1", "1000", false);
            AddItem("Menu2", "2000", false);
            AddItem("Menu3", "3000", false);
        }

        public void AddItem(string name, string pri, bool veg)
        {
            Item item = new Item(name, pri, veg);
            ItemList.Add(item);
        }

        public List<Item> GetItems()
        {
            return ItemList;
        }

        public UserIterator CreateIterator()
        {
            return new Menu1Iterator(ItemList);
        }
      
    }
}
