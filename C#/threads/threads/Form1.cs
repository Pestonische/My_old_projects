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
    public partial class FThreads : Form
    {
        int n = 0;
        private int shoot_delay = 1000;
        private int shoot_radius = 50;
        public Demonstrator demonstrator;
     
        public FThreads()
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
                if (int.TryParse(TBDelay.Text, out time) && int.TryParse(TBRadius.Text, out time) && 
                    int.Parse(TBDelay.Text) > 0 && int.Parse(TBRadius.Text) > 0)
                {
                    
                    shoot_delay = int.Parse(TBDelay.Text);
                    shoot_radius = int.Parse(TBRadius.Text);
                    TBDelay.Enabled = false;
                    TBRadius.Enabled = false;
                    TTime.Enabled = false;
                    BStart.Enabled = false;
                    BFinish.Enabled = true;
                    if (Demonstrator.activ)
                        demonstrator.shooting.Close();
                    demonstrator = new Demonstrator(shoot_delay, shoot_radius);
                    demonstrator.Display += Demonstrator_DisplayEvent;
                    demonstrator.Calc(time);
                }
                else
                {
                    MessageBox.Show("Не верные параметры для мишени мишени!");
                }
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
            TBDelay.Enabled = true;
            TBRadius.Enabled = true;
            demonstrator.StopCalc();
        }

        private void FThreads_Load(object sender, EventArgs e)
        {
            BFinish.Enabled = false;
            TBDelay.Text = shoot_delay.ToString();
            TBRadius.Text = shoot_radius.ToString();
        }
        
    }
}
