using events;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SHOT
{
    public partial class Shooting : Form
    {
        Demonstrator demonstrator;
        private int R;
        private int _shot = 0;
        private int _hits = 0;
        private int _misses = 0;

        List<Point> shoots = new List<Point>();

        public Shooting(Demonstrator demonstrator)
        {
            this.demonstrator = demonstrator;
            InitializeComponent();
            demonstrator.Shoot += Shoot;
            this.R = demonstrator.R;
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);

            DrawTarget(e.Graphics, R);
            DrawShoots(e.Graphics);
        }


        private void DrawTarget(Graphics g, int R)
        {

            int X0 = ClientRectangle.Width / 2 + 60;
            int Y0 = ClientRectangle.Height / 2;


            Brush brush = new SolidBrush(Color.Black);
            g.FillEllipse(brush, X0, Y0 - 2 * R, 2 * R, 2 * R);
            g.FillEllipse(brush, X0 - 2 * R, Y0, 2 * R, 2 * R);
            SolidBrush blueBrush = new SolidBrush(Color.White);

            Point point1 = new Point(X0, Y0);
            Point point2 = new Point(X0, Y0 - 2 * R);
            Point point3 = new Point(X0 + 3 * R, Y0 - 3 * R);

            Point[] curvePoints1 = { point1, point2, point3 };

            g.FillPolygon(blueBrush, curvePoints1);

            Point point4 = new Point(X0, Y0);
            Point point5 = new Point(X0, Y0 + 2 * R);
            Point point6 = new Point(X0 - 3 * R, Y0 + 3 * R);

            Point[] curvePoints2 = { point4, point5, point6 };

            g.FillPolygon(blueBrush, curvePoints2);
            Pen pen = new Pen(Color.Black);
            g.DrawLine(pen, X0, Y0, X0 + 3 * R, Y0);
            g.DrawLine(pen, X0, Y0, X0 + 3 * R, Y0 - 3 * R);
            g.DrawLine(pen, X0, Y0, X0 - 3 * R, Y0);
            g.DrawLine(pen, X0, Y0, X0 - 3 * R, Y0 + 3 * R);
            g.DrawLine(pen, X0, Y0, X0, Y0 + 3 * R);
            g.DrawLine(pen, X0, Y0, X0, Y0 - 3 * R);

        }
        private void DrawShoots(Graphics g)
        {
            Brush brush = new SolidBrush(Color.Green);
            foreach (var shoot in shoots)
            {
                g.FillEllipse(brush, shoot.X - 5, shoot.Y - 5, 10, 10);
            }


        }
        
        private void Shoot(object sender, ShotEventArgs e)
        {
            int XC1 = ClientRectangle.Width / 2 + 60 + R;
            int YC1 = ClientRectangle.Height / 2 - R;
            int XC2 = ClientRectangle.Width / 2 + 60 - R;
            int YC2 = ClientRectangle.Height / 2 + R;
            int X0 = ClientRectangle.Width / 2 + 60;
            int Y0 = ClientRectangle.Height / 2;

            var shoot = new Point(X0 + e.X, Y0 - e.Y);
            shoots.Add(shoot);

            if ((Math.Sqrt((XC1 - shoot.X) * (XC1 - shoot.X) + (YC1 - shoot.Y) * (YC1 - shoot.Y)) <= R
                && (Math.Abs(shoot.X - X0) >= Math.Abs(shoot.Y - Y0)))
                || (Math.Sqrt((XC2 - shoot.X) * (XC2 - shoot.X) + (YC2 - shoot.Y) * (YC2 - shoot.Y)) <= R
                && (Math.Abs(shoot.X - X0) >= Math.Abs(shoot.Y - Y0))))

            {
                _hits += 1;
                LHits.Invoke((MethodInvoker)(
                () => LHits.Text = "Попадания: \n" + _hits.ToString()));
            }
            _shot += 1;
            LShot.Invoke((MethodInvoker)(
                () =>LShot.Text = "Все выстрелы: \n" + _shot.ToString()));
            _misses = _shot - _hits;
            LMisses.Invoke((MethodInvoker)(
                () =>LMisses.Text = "Промахи: \n" + _misses.ToString()));

            Invalidate();

        }
        private void BExit_Click(object sender, EventArgs e)
        {
            if (demonstrator.calc_in_work)
                MessageBox.Show("В начеле нужно прекратить работу вычеслений!");
            else
            {
                demonstrator.ShootThread.Abort();
                BExit.Enabled = false;
                
            }
        }
        
        private void Shooting_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (demonstrator.calc_in_work)
            {
                e.Cancel = true;
                MessageBox.Show("В начеле нужно прекратить работу вычеслений!");
            }
            else
            {
                Demonstrator.activ = false;
                demonstrator.ShootThread.Abort();

            }
        }

       
        private void Shooting_Load(object sender, EventArgs e)
        {
            LaRadius.Text = "Текущий радиус:\n" + R.ToString();
        }
    }
}
