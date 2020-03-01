using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week8
{
    public abstract class CaffeBeverage
    {

        public void PrepareRecipe()
        {
            Boil();

            Brew();

            CarrayCup();
            Add();

        }

        protected abstract void Brew();
        protected abstract void Add();


        void Boil()
        {
            Console.WriteLine("물 끓어요~");
        }

         void CarrayCup()
        {
            Console.WriteLine("컵으로~");
        }



    }
}
