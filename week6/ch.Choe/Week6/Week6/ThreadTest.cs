using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Week6
{
    public enum TestState
    {
        UnStart,
        Run,
        wait
    }
    class ThreadTest
    {
        public int Number;
        public TestState state = TestState.UnStart;
        public bool Blocking = false;
        public Command CommandFunc;


        private Thread thread;
        private bool start = false;
        

        public ThreadTest(int num)
        {
            thread = new Thread(new ThreadStart(TaskJob));
            Number = num;
            thread.Name = "ThreadTest ," + Number.ToString();

        }
        public void Start(Command com)
        {
            start = true;
            CommandFunc = com;  
            if (state == TestState.UnStart)
            {
                thread.Start();
            }
        }

        public void TaskJob()
        {
            while(true)
            {
                if (start)
                {
                    start = false;
                    state = TestState.Run;
                    if(CommandFunc != null)
                    {
                        CommandFunc.execute();
                    }
                    
                    state = TestState.wait;
                }
            }
            
        }
    }
}
