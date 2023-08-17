using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Fool
{
    public partial class GameForm : Form
    {
        public GameForm()
        {
            InitializeComponent();
            this.WindowState = FormWindowState.Maximized;
        }

        private void BDa_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Вы дурак");
        }

        private void BNo_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Вы не дурак");
        }
       
        private void QuestionBox_TextChanged(object sender, EventArgs e)
        {
            if (QuestionBox.Text == "1")
            {
                BNo.Location = new Point(484, 235);
            }
        }
        private void GameForm_MouseMove(object snder, MouseEventArgs e)
        {
            Random rnd = new Random();
            if (QuestionBox.Text != "1")
            {
               
                double length = Math.Sqrt(Math.Pow(MousePosition.X - BNo.Location.X, 2) + Math.Pow(MousePosition.Y - BNo.Location.Y, 2));
                if (length < 220)
                {
                    double _sin = (BNo.Location.Y - MousePosition.Y) / length;
                    double _cos = (BNo.Location.X - MousePosition.X) / length;
                    if (_sin >= 0.5)
                    {
                        if (BNo.Top + 320 <= 980)
                            BNo.Top += 25;
                        else
                            BNo.Location = new Point(rnd.Next(850, 1400), rnd.Next(200, 600));
                    }
                    if (_sin <= -0.5)
                    {
                        if (BNo.Top - 40 >= 0)
                            BNo.Top -= 25;
                        else
                            BNo.Location = new Point(rnd.Next(850, 1400), rnd.Next(200, 600));
                    }
                    if (_cos >= 0.5)
                    {
                        if (BNo.Left + BNo.Width + 400 <= 1720)
                            BNo.Left += 25;
                        else
                            BNo.Location = new Point(rnd.Next(850, 1400), rnd.Next(200, 600));
                    }
                    if (_cos <= -0.5)
                    {
                        if (BNo.Left - 30 >= 0)
                            BNo.Left -= 25;
                        else
                            BNo.Location = new Point(rnd.Next(850, 1400), rnd.Next(200, 600));
                    }

                }

            }
        }
    }
}
