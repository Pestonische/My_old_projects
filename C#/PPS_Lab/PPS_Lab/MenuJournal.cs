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
    public partial class MenuJournal : Form
    {
        SQLiteConnection Connect;
        User user;
        public MenuJournal(SQLiteConnection Connect, User user)
        {
            InitializeComponent();
            this.Connect = Connect;
            this.user = user;
            table();
        }

        private void returnToMenuB_Click(object sender, EventArgs e)
        {
            MenuForStudent menu = new MenuForStudent(Connect, user);
            menu.Show();
            this.Close();
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
                CommandText = String.Format("SELECT StudentTask.answer, Task.objective, Task.deadline, StudentTask.mark, StudentTask.flag  FROM Task, StudentTask WHERE Task.idTask = StudentTask.idTask and StudentTask.idStud = '{0}'", user.getId())
            };
            SQLiteDataReader sqlReader = Command.ExecuteReader();
            List<string[]> data = new List<string[]>();
            while (sqlReader.Read())
            {
                data.Add(new string[5]);
                data[data.Count - 1][0] = sqlReader[0].ToString();
                data[data.Count - 1][1] = sqlReader[1].ToString();
                data[data.Count - 1][2] = sqlReader[2].ToString();
                data[data.Count - 1][3] = sqlReader[3].ToString();
                data[data.Count - 1][4] = sqlReader[4].ToString();
            }
            sqlReader.Close();
            foreach (string[] s in data)
            {
                db.Rows.Add(s);
            }
        }
    }
}
