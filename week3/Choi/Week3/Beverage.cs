namespace Week3
{
    public abstract class Beverage
    {
        public string m_Description = "제목없음";

        
        public virtual string GetDescription()
        {
            return m_Description;
        }

        public abstract double Cost();

    }
}
