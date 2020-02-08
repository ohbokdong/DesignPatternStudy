using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Week6
{
    class JobSceheduler
    {
        //public Command CommandQueue;
        public Queue<Command> CommandQueue = new Queue<Command>();


        public Queue<Thread> ThreadQueue = new Queue<Thread>();
        public Queue<ThreadTest> ThreadTestQueue = new Queue<ThreadTest>();
        public List<Thread> useThread = new List<Thread>();
        public List<ThreadTest> useThreadTest = new List<ThreadTest>();


        private Thread ReturnCheker;

        private int Max_Count = 0;


        public void SetThreadQueue(int num)
        {
            for (int i = 0; i < num; i++)
            {
                ThreadTest test = new ThreadTest(i);

                ThreadTestQueue.Enqueue(test);
            }
            Max_Count = num;
            ReturnCheker = new Thread(new ThreadStart(ReturnThread));
        }

        public bool StartJob()
        {
            if(ThreadTestQueue.Count == 0)
            {
                return false; 
            }

            if(CommandQueue.Count == 0)
            {
                Console.WriteLine("All Start!!");
                return false;
            }

            Console.WriteLine("CommandQueue count :" + CommandQueue.Count);
            ThreadTest tt = ThreadTestQueue.Dequeue();
            tt.Start(CommandQueue.Dequeue());

      
            useThreadTest.Add(tt);

            Console.WriteLine("Thread Queue : " + ThreadTestQueue.Count);
            Console.WriteLine("Use Thread Queue : " + useThreadTest.Count);
            if(ReturnCheker.ThreadState == ThreadState.Unstarted)
            {
                ReturnCheker.Start();
            }
            return true;
        }

        public void Push(Command com)
        {
            CommandQueue.Enqueue(com);
        }

        public void Pop()
        {
            (CommandQueue.Dequeue()).execute();
        }

        public void CommandSave()
        {
            string path = Directory.GetCurrentDirectory();
            string savepath = Path.Combine(path, "Save.dat");
            Console.WriteLine("Save path " + savepath);

            BinaryFormatter format = new BinaryFormatter();
            byte[] bytes;
            using (MemoryStream str = new MemoryStream())
            {
                format.Serialize(str, CommandQueue);
                bytes = new byte[str.Length];
                bytes = str.GetBuffer();

                File.WriteAllBytes(savepath, bytes);
                CommandQueue.Clear();
                Console.WriteLine("Queue Count = " + CommandQueue.Count);

            }
        }
        public void CommandLoad()
        {

            string path = Directory.GetCurrentDirectory();
            string savepath = Path.Combine(path, "Save.dat");
            Console.WriteLine("Save path " + savepath);

            BinaryFormatter format = new BinaryFormatter();
            
            using(FileStream str = new FileStream(savepath,FileMode.Open, FileAccess.Read))
            {
                CommandQueue = ((Queue<Command>)format.Deserialize(str));

                if(CommandQueue == null  )
                {
                    Console.WriteLine("LoadCommandQueue NULL ");
                }
                else
                {
                    Console.WriteLine("Queue Count = " + CommandQueue.Count);
                    AllPop();
                }
            }
        }

        public void AllPop()
        {
            int count = CommandQueue.Count;
            for (int i = 0; i < count; i++)
            {
                Pop();
            }
        }


        private void ReturnThread()
        {
            while(true)
            {
                int count = useThreadTest.Count;

                for (int i = 0; i < count; i++)
                {
                    //Console.WriteLine(useThreadTest[i].state);
                    if(useThreadTest[i] == null)
                    {
                        break;
                    }
                    if(useThreadTest[i].state == TestState.wait)
                    {
                        ThreadTest re = useThreadTest[i];
                        ThreadTestQueue.Enqueue(re);
                        useThreadTest.RemoveAt(i);

                        Console.WriteLine("Thread count : " + ThreadTestQueue.Count + ", Use Thread" + useThreadTest.Count);
                        break;
                    }
                }
            }
        }

      
    }
}
