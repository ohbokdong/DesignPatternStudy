using System;

namespace Week3
{
    public class Mocha : CondimentDecorator
    {
        public Beverage m_Beverage;

        public Mocha(Beverage ver)
        {
         
            m_Beverage = ver;
        }

        public override double Cost()
        {
            return 0.2f + m_Beverage.Cost();
        }

        public override string GetDescription()
        {
            return m_Beverage.GetDescription() + " 모카";
        }
    }
}
