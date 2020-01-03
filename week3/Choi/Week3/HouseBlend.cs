namespace Week3
{
    public class HouseBlend : Beverage
    {
        public HouseBlend() : base()
        {
            m_Description = "하우스 블랜드";
        }

        public override double Cost()
        {
            return 0.89f;
        }
    }
}
