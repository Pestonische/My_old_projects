using serialization;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Media;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Пятнашки
{    
    public partial class GameForm : Form
    {
        public string player="Игрок";
        private int time;
        Mathclass mathclass;
        List<Result> users;
        private DateTime startgame;
        public string file = "15.dat";
        BinaryFormatter bf;
        public GameForm()
        {
            InitializeComponent();
        }
        public int result = 10;
        private void GameForm_Load(object sender, EventArgs e)
        {
            users = new List<Result>(result);
            bf = new BinaryFormatter();
            MatrixGame.RowCount = 4;
            MatrixGame.ColumnCount = 4;
            for (int i = 0; i < 4; i++)
            {
                MatrixGame.Columns[i].Width = MatrixGame.Width / 4 - 1;
                MatrixGame.Rows[i].Height = MatrixGame.Height / 4 - 1;
            }
            using (FileStream fs = new FileStream(file, FileMode.Open))
            {
                if (fs.Length > 0)
                {
                    users = (List<Result>)bf.Deserialize(fs);
                }
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
                
                MessageBox.Show("ПОБЕДА! Количество шагов: " + mathclass.Step + ". Имя: "+ player +". Время: " + time.ToString() + " сек. "+ " Результаты были сохранены.");
                users.Add(new Result(player, startgame, time, mathclass.Step));
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
            startgame = DateTime.Now;
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
        private void TName_TextChanged(object sender, EventArgs e)
        {
            player = TName.Text;
        }
        private void B10recent_results_Click(object sender, EventArgs e)
        {
            List<Result> user = users;
            user.Sort((x, y) => (y.Time).CompareTo(x.Time));
            string results = "";
                var top_10_results = (user.Count > 10) ? users.GetRange(users.Count - 10, 10) : user;
                foreach (var item in top_10_results)
                {
                    results += String.Format("Дата игры:{0}, имя: {1}, шаги: {2}, время: {3} сек\n", item.Time, item.Player, item.Steps, item._Time);

                }
                MessageBox.Show(results);
        }
        private void BBTop10players_steps_Click(object sender, EventArgs e)
        {
            List<Result> user = users;
            user.Sort((x, y) => x.Steps.CompareTo(y.Steps));
            string results = "";
            var top_10_steps = (user.Count > 10) ? user.GetRange(users.Count - 10, 10) : user;
            foreach (var i in top_10_steps)
            {
                results += String.Format("Дата игры:{0}, имя: {1}, шаги: {2}, время: {3} сек\n", i.Time, i.Player, i.Steps, i._Time);

            }
            MessageBox.Show(results);
        }
        private void BTop10players_time_Click(object sender, EventArgs e)
        {
            List<Result> user = users;
            user.Sort((x, y) => x._Time.CompareTo(y._Time));
            string results = "";
            var top_10_time = (user.Count > 10) ? user.GetRange(users.Count - 10, 10) : user;
            foreach (var i in top_10_time)
            {
                results += String.Format("Дата игры:{0}, имя: {1}, шаги: {2}, время: {3} сек\n", i.Time, i.Player, i.Steps, i._Time);

            }
            MessageBox.Show(results);
        }
        private void GameForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            using (FileStream fs = new FileStream(file, FileMode.OpenOrCreate))
            {
                bf.Serialize(fs, users);
            }
            MessageBox.Show("Спасибо за игру!\n Ваши результаты сохранены.");
        }
        private void BDelete_Click(object sender, EventArgs e)
        {
            users.RemoveAll(x => (x.Time <= DateTimePicker.Value));
        }
    }
}
