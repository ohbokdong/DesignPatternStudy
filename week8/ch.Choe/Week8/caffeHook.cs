using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week8
{
    abstract class CaffeHook
    {
        void PrepareRecipe()
        {
            Boil();
            Brew();
            CarryCup();
            if(Condiments())
            {
                Add();
            }
        }

        protected abstract void Brew();

        protected abstract void Add();

        void Boil()
        {

        }
        void CarryCup()
        {

        }

        bool Condiments()
        {
            return true;    
        }
    }


}
