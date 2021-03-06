﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Week4.IngredientFactory;

namespace Week4
{
    public class CCCheesePizzz : Pizza
    {
        public CCCheesePizzz(PizzaIngredientFactory fac ,IPizzaCutting cut) : base("CCCheesePizzz",fac, cut)
        {

        }

     
        public override void Prepare()
        {
            this.m_Dough = this.m_Factory.CreateDough();
            this.m_Cheese = this.m_Factory.CreateCheese();
            this.m_Pepperoni = this.m_Factory.CreatePepperoni();

        }
    }
}
