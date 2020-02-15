using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week7
{
    class HomeTheaterFacade
    {
        private Tuner tuner;
        private Screen screen;
        private Amplifier amplifier;

        public HomeTheaterFacade(Tuner tu, Screen scr, Amplifier amp)
        {
            tuner = tu;
            screen = scr;
            amplifier = amp;    
        }

        public void WatchMovie()
        {
            tuner.On();
            screen.UP();
            amplifier.SetCD();
        }

        public void EndMovie()
        {
            tuner.Off();
            screen.Down();
            amplifier.Setvolume();
        }
    }
}
