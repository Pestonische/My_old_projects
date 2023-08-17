using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Flag1
{
    public partial class Bunting : Form
    {
        bool flag = true;
        public Bunting()
        {
            InitializeComponent();
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            DrawFlag(ClientRectangle, e.Graphics);
        }

        private void DrawFlag(Rectangle r, Graphics g)
        {
            const int PROPX1 = 11, PROPY1 = 28;
            g.Clear(Color.Gray);

            int Height1 = r.Height, Width1 = r.Width;
            Point WN1 = new Point(0, 0);
            if (PROPX1 * r.Width > PROPY1 * r.Height) 
            {
                Width1 = Height1 * PROPY1 / PROPX1;
                WN1.X = (r.Width - Width1) / 2;
            }
            else
                if (PROPX1 * r.Width < PROPY1 * r.Height)
            {
                Height1 = Width1 * PROPX1 / PROPY1;
                WN1.Y = (r.Height - Height1) / 2;
            }

            const int PROPX2 = 1, PROPY2 = 2;
            g.Clear(Color.Gray);
            Point WN2 = new Point(0, 0);
            int Height2 = r.Height, Width2 = r.Width;
            
            if (PROPX2 * r.Width > PROPY2 * r.Height)
            {
                Width2 = Height2 * PROPY2 / PROPX2;
                WN2.X = (r.Width - Width2) / 2;
            }
            else
                if (PROPX2 * r.Width < PROPY2 * r.Height)
            {
                Height2 = Width2 * PROPX2 / PROPY2;
                WN2.Y = (r.Height - Height2) / 2;
            }
            

            if (flag)
            {
                
                SolidBrush brush = new SolidBrush(Color.White);               
                g.FillRectangle(brush, WN1.X, WN1.Y, Width1*10 / 35, Height1);

               
                brush.Color = Color.Maroon;
                g.FillRectangle(brush, WN1.X + Width1*10/35, WN1.Y, Width1 * 2 / 3 + Width1 * 10 / 35, Height1);

                brush.Color = Color.White;
                Point L1 = new Point(WN1.X + Width1*10/35, WN1.Y);
                Point R1 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1/ 9);
                Point D1 = new Point(WN1.X + Width1 * 10 / 35 + Height1 *5 / 27, WN1.Y + Height1 / 18);
                Point[] thorn1 = { L1, R1, D1 };
                g.FillPolygon(brush, thorn1);

                Point L2 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 / 9);
                Point R2 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1*2 / 9);
                Point D2 = new Point(WN1.X + Width1 * 10 / 35 + Height1 * 5 / 27, WN1.Y + Height1 / 9 + Height1 / 18);

                Point[] thorn2 = { L2, R2, D2 };
                g.FillPolygon(brush, thorn2);

                Point L3 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 2 / 9);
                Point R3 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1*3 / 9);
                Point D3 = new Point(WN1.X + Width1 * 10 / 35 + Height1 * 5 / 27, WN1.Y + Height1*2 / 9 + Height1 / 18);

                Point[] thorn3 = { L3, R3, D3 };
                g.FillPolygon(brush, thorn3);

                Point L4 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 3 / 9);
                Point R4 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 4 / 9);
                Point D4 = new Point(WN1.X + Width1 * 10 / 35 + Height1 * 5 / 27, WN1.Y + Height1 * 3 / 9 + Height1 / 18);
                Point[] thorn4 = { L4, R4, D4 };
                g.FillPolygon(brush, thorn4);

                Point L5 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 4 / 9);
                Point R5 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 5 / 9);
                Point D5 = new Point(WN1.X + Width1 * 10 / 35 + Height1 * 5 / 27, WN1.Y + Height1 * 4 / 9 + Height1 / 18);
                Point[] thorn5 = { L5, R5, D5 };
                g.FillPolygon(brush, thorn5);

                Point L6 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 5 / 9);
                Point R6 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 6 / 9);
                Point D6 = new Point(WN1.X + Width1 * 10 / 35 + Height1 * 5 / 27, WN1.Y + Height1 * 5 / 9 + Height1 / 18);
                Point[] thorn6 = { L6, R6, D6 };
                g.FillPolygon(brush, thorn6);

                Point L7 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 6 / 9);
                Point R7 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 7 / 9);
                Point D7 = new Point(WN1.X + Width1 * 10 / 35 + Height1 * 5 / 27, WN1.Y + Height1 * 6 / 9 + Height1 / 18);
                Point[] thorn7 = { L7, R7, D7 };
                g.FillPolygon(brush, thorn7);

                Point L8 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 7 / 9);
                Point R8 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 8 / 9);
                Point D8 = new Point(WN1.X + Width1 * 10 / 35 + Height1 * 5 / 27, WN1.Y + Height1 * 7 / 9 + Height1 / 18);
                Point[] thorn8 = { L8, R8, D8 };
                g.FillPolygon(brush, thorn8);

                Point L9 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1 * 8 / 9);
                Point R9 = new Point(WN1.X + Width1 * 10 / 35, WN1.Y + Height1);
                Point D9 = new Point(WN1.X + Width1 * 10 / 35 + Height1 * 5 / 27, WN1.Y + Height1 * 8 / 9 + Height1 / 18);
                Point[] thorn9 = { L9, R9, D9 };
                g.FillPolygon(brush, thorn9);

                Font font = new Font("Courier New", 15, FontStyle.Bold | FontStyle.Italic);
                StringFormat drawFormat = new System.Drawing.StringFormat();
                brush.Color = Color.Black;
                g.DrawString("Флаг Катара. Для перехода нажмите любую клавишу", font, brush, 0, 0, drawFormat);
                brush.Dispose();
                
                font.Dispose();
            }
            else
            {
                SolidBrush brush = new SolidBrush(Color.Black);
                g.FillRectangle(brush, WN2.X, WN2.Y, Width2, Height2*3/10);

                brush.Color = Color.White;
                g.FillRectangle(brush, WN2.X, WN2.Y + Height2*3/10, Width2, Height2*5/100);

                brush.Color = Color.Red;
                g.FillRectangle(brush, WN2.X, WN2.Y + Height2*3/10+ Height2 * 5 / 100, Width2, Height2*3/10);
                
                brush.Color = Color.White;
                g.FillRectangle(brush, WN2.X, WN2.Y + Height2 * 6 / 10+ Height2 * 5 / 100, Width2, Height2 * 5 / 100);

                brush.Color = Color.Green;
                g.FillRectangle(brush, WN2.X, WN2.Y + Height2 * 6 / 10 + Height2 * 10 / 100, Width2, Height2 * 3 / 10);

                brush.Color = Color.MediumBlue;
                Point L1 = new Point(WN2.X , WN2.Y);
                Point L2 = new Point(WN2.X, WN2.Y + Height2);
                Point L3 = new Point(WN2.X + Height2* 75 /100+ Height2/ 10, WN2.Y + Height2 / 2);
                Point[] thorn1 = { L1, L2, L3 };
                g.FillPolygon(brush, thorn1);
                
               
                int n = 5;
                double R2 = Height2 / 5.8, R1 = R2 * 2 / 5;
                double alpha = 140;
                double x0 = WN2.X + Width2/6.5, y0 = WN2.Y + Height2 / 2;
                brush.Color = Color.Yellow;
                PointF[] points = new PointF[2 * n + 1];

                double da = Math.PI / n, l;
                for (int k = 0; k < 2 * n + 1; k++)
                {
                    l = k % 2 == 0 ? R2 : R1;
                    points[k] = new PointF((float)(x0 + l * Math.Cos(alpha)),
                    (float)(y0 + l * Math.Sin(alpha)));
                    alpha += da;
                }
                Font font = new Font("Courier New", 15, FontStyle.Bold | FontStyle.Italic);
                StringFormat drawFormat = new System.Drawing.StringFormat();
                g.FillPolygon(brush, points);
                brush.Color = Color.White;
                g.DrawString("Флаг Южного Судана. Для перехода нажмите любую клавишу", font, brush, 0, 0, drawFormat);
            }
        }
        
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void Form1_Resize_1(object sender, EventArgs e)
        {
            Invalidate();
        }

        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (flag)
                flag = false;
            else
                flag = true;
            Invalidate();
        }
    }
}
