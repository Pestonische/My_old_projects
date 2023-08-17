using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace events
{
    public class DisplayEventArgs : EventArgs
    {
        string result;

        public string Result { get => result; }

        public DisplayEventArgs(string s) : base()
        {
            result = s;
        }
    }
    public class Demonstrator
    {
        public Calculator calculator;
        public delegate void DisplayEventHandler(object sender, DisplayEventArgs e);
        public event DisplayEventHandler Display;

        public delegate void StopEventHandler(object sender, EventArgs e);
        public event StopEventHandler Stop;

        public delegate void StartEventHandler(object sender, EventArgs e);
        public event StartEventHandler Start;

        public void Calc(int time)
        {
            
            if (calculator == null || calculator.time != time)
            {
                calculator = new Calculator(time, this);
               
                calculator.Finished += Calculator_CalcFinish;
            }
            else
            {
                Start(this, new EventArgs());
            }
        }

        private void Calculator_CalcFinish(object sender, CalcFinishEventArgs e)
        {
            string s = "Число Шрёдера номер " + e.num.ToString() + ": " + e.Event.ToString();
            Display?.Invoke(this, new DisplayEventArgs(s));
        }

        public void StopCalc()
        {
            Stop?.Invoke(this, new EventArgs());
           
        }
    }
}
