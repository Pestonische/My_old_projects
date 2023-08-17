using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
using SHOT;

namespace events
{
    public class ShotEventArgs : EventArgs
    {
        public int X;
        public int Y;

        public ShotEventArgs(int X, int Y)
        {
            this.X = X;
            this.Y = Y;
        }

    }
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

        public delegate void ShotEventHandler(object sender, ShotEventArgs e);
        public event ShotEventHandler Shoot;

        public int shoot_delay;
        public int R;
        public Thread ShootThread;
        public Shooting shooting;
        public static bool activ = false;
        public Demonstrator(int shoot_delay, int shoot_radius)
        {
            this.shoot_delay = shoot_delay;
            this.R = shoot_radius;
            activ = true;
                shooting = new Shooting(this);
                shooting.Show();
           
            ShootThread = new Thread(StartShoot);
            ShootThread.Start();
        }
        Random X = new Random();
        Random Y = new Random();
        public void StartShoot()
        {
            while (true)
            {
                X = new Random();
                var XN = X.Next(-2 * R, 2 * R);
                Y = new Random();
                var YN = X.Next(-2 * R, 2 * R);
                Shoot?.Invoke(this, new ShotEventArgs(XN, YN));
                Thread.Sleep(shoot_delay);
            }
        }
        public bool calc_in_work = true;
        public void Calc(int time)
        {
            calc_in_work = true;
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
            calc_in_work = false;
        }
       
    }
}
