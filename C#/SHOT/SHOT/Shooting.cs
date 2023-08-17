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

        private int R = 60;
        private int _shot = 0;
        private int _hits = 0;
        private int _misses = 0;

        List<Point> shoots = new List<Point>();

        public Shooting()
        {
            InitializeComponent();
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
        private void BRadius_Click(object sender, EventArgs e)
        {
            int Radius;
            if (int.TryParse(TRadius.Text, out Radius))
            {
                if (Radius <= 60 && Radius > 0)
                {
                    TRadius.Text = "";
                    LaRadius.Text = "Текущий радиус:\n " + Radius.ToString();
                    R = Radius;
                    _shot = 0;
                    _hits = 0;
                    _misses = 0;
                    LHits.Text = "Попадания: 0";
                    LShot.Text = "Все выстрелы: 0";
                    LMisses.Text = "Промахи: 0";
                    shoots.Clear();
                    Invalidate();
                }
                else
                {
                    TRadius.Text = "";
                    MessageBox.Show("Неправильное значение радиуса");
                    TRadius.Select();
                }
            }
            else
            {
                MessageBox.Show("Введите значение радиуса в виде целого числа!");
            }


            }

        private void Form1_MouseClick(object sender, MouseEventArgs e)
        {
            var shoot = PointToClient(new Point(MousePosition.X, MousePosition.Y));
            shoots.Add(shoot);
            int XC1 = ClientRectangle.Width / 2 + 60 + R;
            int YC1 = ClientRectangle.Height / 2 - R;
            int XC2 = ClientRectangle.Width / 2 + 60 - R;
            int YC2 = ClientRectangle.Height / 2 + R;
            int X0 = ClientRectangle.Width / 2 + 60;
            int Y0 = ClientRectangle.Height / 2;

            if ((Math.Sqrt((XC1 - shoot.X) * (XC1 - shoot.X) + (YC1 - shoot.Y) * (YC1 - shoot.Y)) <= R
                && (Math.Abs(shoot.X - X0) >= Math.Abs(shoot.Y - Y0)))
                || (Math.Sqrt((XC2 - shoot.X) * (XC2 - shoot.X) + (YC2 - shoot.Y) * (YC2 - shoot.Y)) <= R
                && (Math.Abs(shoot.X - X0) >= Math.Abs(shoot.Y - Y0))))

            {
                _hits += 1;
                LHits.Text = "Попадания: " + _hits.ToString();
            }
            _shot += 1;
            LShot.Text = "Все выстрелы: " + _shot.ToString();
            _misses = _shot - _hits;
            LMisses.Text = "Промахи: " + _misses.ToString();

            Invalidate();

        }

        private void Form1_SizeChanged(object sender, EventArgs e)
        {
            _shot = 0;
            _hits = 0;
            _misses = 0;
            LHits.Text = "Попадания: 0";
            LShot.Text = "Все выстрелы: 0";
            LMisses.Text = "Промахи: 0";
            shoots.Clear();
            Invalidate();
        }

        private void BShot_Click(object sender, EventArgs e)
        {
            int X;
            int Y;
            if (int.TryParse(TX.Text, out X) && int.TryParse(TY.Text, out Y))
            {

                int XC1 = ClientRectangle.Width / 2 + 60 + R;
                int YC1 = ClientRectangle.Height / 2 - R;
                int XC2 = ClientRectangle.Width / 2 + 60 - R;
                int YC2 = ClientRectangle.Height / 2 + R;
                int X0 = ClientRectangle.Width / 2 + 60;
                int Y0 = ClientRectangle.Height / 2;
                var shoot = new Point(X0 + X, Y0 - Y);
                shoots.Add(shoot);

                if ((Math.Sqrt((XC1 - shoot.X) * (XC1 - shoot.X) + (YC1 - shoot.Y) * (YC1 - shoot.Y)) <= R
                && (Math.Abs(shoot.X - X0) >= Math.Abs(shoot.Y - Y0)))
                || (Math.Sqrt((XC2 - shoot.X) * (XC2 - shoot.X) + (YC2 - shoot.Y) * (YC2 - shoot.Y)) <= R
                && (Math.Abs(shoot.X - X0) >= Math.Abs(shoot.Y - Y0))))
                {
                    _hits += 1;
                    LHits.Text = "Попадания: " + _hits.ToString();
                }
                _shot += 1;
                LShot.Text = "Все выстрелы: " + _shot.ToString();
                _misses = _shot - _hits;
                LMisses.Text = "Промахи: " + _misses.ToString();
                Invalidate();
            }
            else
            {
                TX.Text = "";
                TY.Text = "";
                MessageBox.Show("Неправильные значения координат выстрела!");
            }
        }

    }
}
