using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace events
{
    public partial class FEvents : Form
    {
        int n = 0;
        public Demonstrator demonstrator;

        public FEvents()
        {
            InitializeComponent();
        }
        private void Demonstrator_DisplayEvent(object sender, DisplayEventArgs e)
        {
            RTBResult?.Invoke((MethodInvoker)(
                () => RTBResult.AppendText((++n) + ") " + e.Result + Environment.NewLine+
                "********************************************"+Environment.NewLine)));
        }
        private void BStart_Click(object sender, EventArgs e)
        {
            int time;
            if (int.TryParse(TTime.Text, out time) && int.Parse(TTime.Text)>=0)
            {
                TTime.Enabled = false;
                BStart.Enabled = false;
                BFinish.Enabled = true;
                demonstrator = new Demonstrator();
                demonstrator.Display += Demonstrator_DisplayEvent;
                demonstrator.Calc(time);
            }
            else
            {
                MessageBox.Show("Задержка должна быть целым положительным числом или 0!");
            }
        }
        private void BFinish_Click(object sender, EventArgs e)
        {
            BFinish.Enabled = false;
            BStart.Enabled = true;
            TTime.Enabled = true;
            demonstrator.StopCalc();
        }
        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            demonstrator.calculator.T.Abort();
        }
    }
}
