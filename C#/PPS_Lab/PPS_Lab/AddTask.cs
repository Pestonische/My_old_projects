using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SQLite;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PPS_Lab
{
    public partial class AddTask : Form
    {
        String task, deadline;
        SQLiteConnection Connect;
        public AddTask(SQLiteConnection Connect)
        {
            InitializeComponent();
            this.Connect = Connect;
        }

        private void cancelB_Click(object sender, EventArgs e)
        {
            MenuForProfessor menuForProfessor = new MenuForProfessor(Connect);
            menuForProfessor.Show();
            this.Close();
        }

        private void createTaskB_Click(object sender, EventArgs e)
        {
            Regex regex = new Regex(@"[\d]{4}-(([1][0-2])|([0][\d]))-(([3][0-1])|([0-2][\d]))");
            if (deadline == "" || deadline == null || task == "" || task == null)
            {
                MessageBox.Show("Все поля должны быть заполнены!");
            }
            else if(!regex.IsMatch(deadline))
            {
                MessageBox.Show("Неверная дата!");
            }
            else
            {
                SQLiteCommand Command = new SQLiteCommand
                {
                    Connection = Connect,
                    CommandText = String.Format("INSERT INTO Task (objective, deadline) VALUES ('{0}', '{1}');", task, deadline)
                };

                Command.ExecuteNonQuery();

            }
        }

        private void taskTB_TextChanged(object sender, EventArgs e)
        {
            task = taskTB.Text;
        }

        private void deadlineTB_TextChanged(object sender, EventArgs e)
        {
            deadline = deadlineTB.Text;
        }
    }
}
