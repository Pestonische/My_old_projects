using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace events
{
    public class CalcFinishEventArgs : EventArgs
    {
        public BigInteger Event;
        public int num;
        public CalcFinishEventArgs(BigInteger Event, int n)
        {
            this.Event = Event;
            num = n;
        }
    }
    public class Calculator
    {
        Thread thread;
        public Thread T { get => thread; }
        List<BigInteger> Cache;

        public int time;
        public bool in_work = true;
        private Random rand = new Random();
        
        public delegate void CalcFinishedEventHandler(object sender, CalcFinishEventArgs e);
        public event CalcFinishedEventHandler Finished;
        private void StartCalculator()
        {

            while (in_work)
            {
                int C = rand.Next(1, 1000);

                Finished?.Invoke(this, new CalcFinishEventArgs(FindNumber(C), C));
                Thread.Sleep(time);
            }
        }
        private BigInteger FindNumber(int n)
        {
            BigInteger a = 1;

            Cache = new List<BigInteger>(n + 1);
            Cache.Add(a);

            for (int i = 1; i <= n; i++)
            {
                Cache.Add(Cache[i - 1] + Sum(Cache, Cache.Count - 1));
                a = Cache[i];
            }
            return Cache[n];
        }
        public BigInteger Sum(List<BigInteger> cache, int n)
        {
            int g = n;
            if (n == 0)
                return 1;
            else n++;

            BigInteger sum = 0;

            for (int i = 0; i < n; i++)
            {
                sum += cache[i] * cache[g];
                g--;
            }

            return sum;
        }
        private void Starting()
        {
            in_work = true;
            thread = new Thread(StartCalculator);
            thread.Start();
        }
        private void Demonstrator_Start(object sender, EventArgs e)
        {
            Starting();
        }

        private void Demonstrator_Stop(object sender, EventArgs e)
        {
            if (thread.IsAlive)
            {
                thread.Abort();
                in_work = false;
                thread.Join();
            }
        }
        public Calculator(int time, Demonstrator demonstrator)
        {
            this.time = time;
            demonstrator.Stop += Demonstrator_Stop;
            demonstrator.Start += Demonstrator_Start;
            Starting();
        }   
    }
}
