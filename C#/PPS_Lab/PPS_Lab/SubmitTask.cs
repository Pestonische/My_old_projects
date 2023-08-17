using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SQLite;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PPS_Lab
{
    public partial class SubmitTask : Form
    {
        SQLiteConnection Connect;
        User user;
        String answer, idTask;
        public SubmitTask(SQLiteConnection Connect, User user)
        {
            this.user = user;
            InitializeComponent();
            this.Connect = Connect;
            table();
        }

        private void enterB_Click(object sender, EventArgs e)
        {
            DateTime thisDate = DateTime.Today;
            String dateDay = thisDate.ToString("yyyy-MM-dd");
            String flag = "";
            
            if (answer == "" || answer == null || idTask == "" || idTask == null)
            {
                MessageBox.Show("Все поля должны быть заполнены!");
            }
            else
            {
                SQLiteCommand Command1 = new SQLiteCommand
                {
                    Connection = Connect,
                    CommandText = String.Format("SELECT Task.deadline FROM Task, StudentTask WHERE Task.idTask = StudentTask.idTask and StudentTask.id ={0}", idTask)
                };
                SQLiteDataReader sqlReader = Command1.ExecuteReader();
                sqlReader.Read();
                
                if (sqlReader.HasRows)
                {
                    string[] s = sqlReader.GetString(0).Split('-');
                    DateTime deadlineDate = new DateTime(int.Parse(s[0]), int.Parse(s[1]), int.Parse(s[2]));
                    if(deadlineDate > thisDate)
                    {
                        flag = "зеленый";
                    }
                    else
                    {
                        flag = "красный";
                    }
                }
                    SQLiteCommand Command = new SQLiteCommand
                {
                    Connection = Connect,
                    CommandText = String.Format("UPDATE StudentTask  SET answer = '{1}', deadline = '{2}', flag = '{3}' WHERE id = {0}", idTask, answer, dateDay, flag)
                };
                Command.ExecuteNonQuery();
            }
        }

        private void cancelB_Click(object sender, EventArgs e)
        {
            MenuForStudent menu = new MenuForStudent(Connect, user);
            menu.Show();
            this.Close();
        }

        private void taskTB_TextChanged(object sender, EventArgs e)
        {
            answer = taskTB.Text;
        }
        private void table()
        {

            if (db.Rows.Count > 1)
            {
                int counter = db.Rows.Count;
                for (int i = 0; i < counter - 1; i++)
                {
                    db.Rows.RemoveAt(0);
                }
            }
            SQLiteCommand Command = new SQLiteCommand
            {
                Connection = Connect,
                CommandText = String.Format("SELECT StudentTask.id, Task.objective, Task.deadline FROM Task, StudentTask WHERE Task.idTask = StudentTask.idTask and StudentTask.idStud = '{0}'", user.getId())
            };
            SQLiteDataReader sqlReader = Command.ExecuteReader();
            List<string[]> data = new List<string[]>();
            while (sqlReader.Read())
            {
                data.Add(new string[3]);
                data[data.Count - 1][0] = sqlReader[0].ToString();
                data[data.Count - 1][1] = sqlReader[1].ToString();
                data[data.Count - 1][2] = sqlReader[2].ToString();
            }
            sqlReader.Close();
            foreach (string[] s in data)
            {
                db.Rows.Add(s);
            }
        }

        private void idTB_TextChanged(object sender, EventArgs e)
        {
            idTask = idTB.Text;
        }
    }
}
