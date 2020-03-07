using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week9
{
    class Menu2Iterator :UserIterator
    {
        Item[] Items;
        int postion = 0;

        public Menu2Iterator(Item[] items)
        {
            this.Items = items;
        }

        public bool HasNext()
        {
            if (postion >= Items.Length || Items[postion] == null)
            {
                return false;
            }
            return true;
        }

        public object Next()
        {
            Item result = Items[postion];
            postion++;
            return result;
        }
    }
}
