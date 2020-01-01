namespace Week3
{
    public class Soy : CondimentDecorator
    {
        public Beverage m_Beverage;

        public Soy(Beverage ver)
        {
            m_Beverage = ver;
        }

        public override double Cost()
        {
            return 0.15f + m_Beverage.Cost();
        }

        public override string GetDescription()
        {
            return m_Beverage.GetDescription() + " 두유";
        }
    }
}
