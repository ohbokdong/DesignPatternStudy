using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week9
{
    class Menu1Iterator : UserIterator
    {
        List<Item> Items;
        int position;

        public Menu1Iterator(List<Item> list)
        {
            Items = list;   
        }
        public bool HasNext()
        {
            if (position >= Items.Count)
            {
                return false;
            }
            return true;
        }

        public object Next()
        {
            Item result = Items[position];
            position++;
            return result;
        }
    }
}
