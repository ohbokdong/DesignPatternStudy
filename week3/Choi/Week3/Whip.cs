namespace Week3
{
    public class Whip : CondimentDecorator
    {
        public Beverage m_Beverage;

        public Whip(Beverage ver)
        {
            m_Beverage = ver;

        }

        public override double Cost()
        {
            return 0.1f + m_Beverage.Cost();
        }

        public override string GetDescription()
        {
            return m_Beverage.GetDescription() + " 휘핑 크림";
        }
    }
}
