namespace Week3
{
    public class Espresso : Beverage
    {
        public Espresso() 
        {
            m_Description = "에스프레소";
        }

        public override double Cost()
        {
            return 1.99f;
        }
    }
}
