using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Week4.Ingredient;
using Week4.IngredientFactory;

namespace Week4
{
    public abstract class Pizza
    {
        protected string m_Name;
        protected Dough m_Dough;
        protected Cheese m_Cheese;
        protected Pepperoni m_Pepperoni;
        protected PizzaIngredientFactory m_Factory;
        protected IPizzaCutting m_Cutting;
        public Pizza(string name, PizzaIngredientFactory fac, IPizzaCutting cut)
        {
            m_Name = name;
            m_Factory = fac;
            m_Cutting = cut;
        }

        public abstract void Prepare();
        
        public void Bake()
        {
            Console.WriteLine("Baking... ");
        }

        public void Cut()
        {
            m_Cutting.Cutting();
        }
        public virtual void Box()
        {
            Console.WriteLine("Box");
        }
        public string GetName()
        {
            return m_Name;
        }

    }
}

