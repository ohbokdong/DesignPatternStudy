using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week4
{
    public class StaticSimpleCuttingFactory
    {
        public enum SliceType
        {
            Base,
            Square
        }

        public static IPizzaCutting CreateCutting(SliceType type)
        {
            IPizzaCutting result = null;

            switch (type)
            {
                case SliceType.Base:
                    result = new BaseCutting();
                    break;
                case SliceType.Square:
                    result = new SquareCutting();
                    break;
            }

            return result;
        }
    }
}
