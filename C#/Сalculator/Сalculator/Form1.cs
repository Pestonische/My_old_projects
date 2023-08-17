using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Сalculator
{
    public partial class Calculator : Form
    {
        private double Number1 = 0, Number2 = 0;
        private string s="";
        private string badge = "";
        double _result = 0;
        public Calculator()
        {
            InitializeComponent();
        }

        private void BPlus_Click(object sender, EventArgs e)
        {
            if (double.TryParse(TFirstNumber.Text, out Number1) &&
            double.TryParse(TSecondNumber.Text, out Number2))
            {
                Number1 = double.Parse(TFirstNumber.Text);
                Number2 = double.Parse(TSecondNumber.Text);
                s = Number1.ToString() + " + " + Number2.ToString();
                TResult.Text = s;
                badge = "+";
            }
            else
            {
                MessageBox.Show("Введите число!");
            }
        }
        private void BMinus_Click(object sender, EventArgs e)
        {
            if (double.TryParse(TFirstNumber.Text, out Number1) &&
            double.TryParse(TSecondNumber.Text, out Number2))
            {
                Number1 = double.Parse(TFirstNumber.Text);
                Number2 = double.Parse(TSecondNumber.Text);
                s = Number1.ToString() + " - " + Number2.ToString();
                TResult.Text = s;
                badge = "-";
            }
            else
            {
                MessageBox.Show("Введите число!");
            }
        }
        private void BMultiplizieren_Click(object sender, EventArgs e)
        {
            if (double.TryParse(TFirstNumber.Text, out Number1) &&
            double.TryParse(TSecondNumber.Text, out Number2))
            {
                Number1 = double.Parse(TFirstNumber.Text);
                Number2 = double.Parse(TSecondNumber.Text);
                s = Number1.ToString() + " * " + Number2.ToString();
                TResult.Text = s;
                badge = "*";
            }
            else
            {
                MessageBox.Show("Введите число!");
            }
        }
        private void BDivision_Click(object sender, EventArgs e)
        {
            if (double.TryParse(TFirstNumber.Text, out Number1) &&
            double.TryParse(TSecondNumber.Text, out Number2))
            {
                if (Number2 == 0)
                {
                    MessageBox.Show("На ноль делить нельзя!");
                }
                else
                {
                    s = Number1.ToString() + " / " + Number2.ToString();
                    TResult.Text = s;
                    badge = "/";
                }
            }
            else
            {
                MessageBox.Show("Введите число!");
            }
        }
        private void BGleich_Click(object sender, EventArgs e)
        {
            
            if (badge == "+")
            {
                _result = Number1 + Number2;
                TResult.Text = _result.ToString();
            }
            if (badge == "-")
            {
                _result = Number1 - Number2;
                TResult.Text = _result.ToString();
            }
            if (badge == "*")
            {
                _result = Number1 * Number2;
                TResult.Text = _result.ToString();
            }
            if (badge == "/")
            {
                _result = Number1 / Number2;
                TResult.Text = _result.ToString();
            }

        }

        private void BСlear_Click(object sender, EventArgs e)
        {
            Number1 = 0;
            Number2 = 0;
            _result = 0;
            badge = "";
            TFirstNumber.Text = Number1.ToString();
            TSecondNumber.Text = Number2.ToString();
            TResult.Text = "";
        }

        private void Calculator_Load(object sender, EventArgs e)
        {
            TFirstNumber.Text = Number1.ToString();
            TSecondNumber.Text = Number2.ToString();
        }
    }
}
