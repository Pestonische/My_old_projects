using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FormForLessonn05032020
{
    public partial class frmMain : Form
    {
        private Game g;
        public frmMain()
        {
            InitializeComponent();
            this.SuspendLayout();
            // 
            // frmMain
            // 
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Name = "frmMain";
            this.Load += new System.EventHandler(this.frmMain_Load_1);
            this.ResumeLayout(false);
        }

        private void frmMain_Load(object sender, EventArgs e)
        {
            g = new Game();
            dgwGame.RowCount = 4;
            dgwGame.ColumnCount = 4;
            showGrid();
        }
        private void showGrid()
        {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                {
                    if (g.Table[i, j])
                    {
                        dgwGame.Rows[i].Cells[j].Value = "open";//Rows - индексатор, получает получить доступ к i -ой строке
                        dgwGame.Rows[i].Cells[j].Style.BackColor = Color.Green;
                    }
                    else
                    {
                        dgwGame.Rows[i].Cells[j].Value = "";
                        dgwGame.Rows[i].Cells[j].Style.BackColor = Color.Firebrick;
                    }
                }
        }

        private void dgwGame_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            g.reCalc(e.RowIndex, e.ColumnIndex);
            showGrid();
            if (g.isFinished())
            {
                MessageBox.Show("Холодильник открыт, кот выпущен!");
                Close();
            }

        }

       /* private void InitializeComponent()
        {
            

        }*/

        private void frmMain_Load_1(object sender, EventArgs e)
        {

        }
    }
}

