using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Пятнашки
{
    public partial class GameForm : Form
    {
        private int time;
        Mathclass mathclass;
        public GameForm()
        {
            InitializeComponent();
        }

        private void GameForm_Load(object sender, EventArgs e)
        {
            MatrixGame.RowCount = 4;
            MatrixGame.ColumnCount = 4;
            for (int i = 0; i < 4; i++)
            {
                MatrixGame.Columns[i].Width = MatrixGame.Width / 4 - 1;
                MatrixGame.Rows[i].Height = MatrixGame.Height / 4 - 1;
            }

            StartGame(DateTime.UtcNow.Second);
        }

        private void MatrixGame_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            int pos = e.RowIndex * 4 + e.ColumnIndex;
            mathclass.Movements(pos);
            UpdateGame();
            if (mathclass.GameWin())
            {
                MatrixGame.Enabled = false;
                TimerGame.Stop();
                MessageBox.Show("ПОБЕДА! Количество шагов: " + mathclass.Step + ". Время: " + time.ToString() + " сек.");
            }
        }

        private void TimerGame_Tick(object sender, EventArgs e)
        {
            Ltime.Text = "Таймер: " + time.ToString() + " сек";
                  time++;
        }
        private void StartGame(int s)
        {
            mathclass = new Mathclass(s);
            UpdateGame();
            time = 0;
            TimerGame.Start();
        }
        private void Bnewgema_Click(object sender, EventArgs e)
        {
            Ltime.Text = "Таймер: 0 сек";
            if (mathclass.Check())
            {
                MessageBox.Show("15 решаемо");
            }
            else
            {
                MessageBox.Show("15 нерешаемо");
            }
            TimerGame.Stop();
            MatrixGame.Enabled = true;
            StartGame(DateTime.UtcNow.Second);

        }

        private void Bsavedgame_Click(object sender, EventArgs e)
        {
            Ltime.Text = "Таймер: 0 сек";
            TimerGame.Stop();
            MatrixGame.Enabled = true;
            StartGame(mathclass.Seed);
        }

        private void UpdateGame()
        {
            for (int i = 0; i < 16; i++)
            {
                int row = i / 4;
                int cell = i - row * 4;
                MatrixGame.Rows[row].Cells[cell].Value = (mathclass.Arr[i] != 0) ? (mathclass.Arr[i].ToString()) : "";
               MatrixGame.Rows[row].Cells[cell].Selected = false;
            }
            Lstep.Text = "Количество шагов: " + mathclass.Step.ToString();
        }
    }
}
