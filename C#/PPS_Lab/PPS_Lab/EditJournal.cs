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
    public partial class EditJournal : Form
    {
        String id, mark;
        SQLiteConnection Connect;

        public EditJournal(SQLiteConnection Connect)
        {
            InitializeComponent();
            this.Connect = Connect;
            table();
        }

        private void returnToMenuB_Click(object sender, EventArgs e)
        {
            MenuForProfessor menuForProfessor = new MenuForProfessor(Connect);
            menuForProfessor.Show();
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
                CommandText = String.Format("SELECT StudentTask.id, Users.specialization, Users.name, StudentTask.answer, Task.objective, StudentTask.mark, StudentTask.flag  FROM Users, Task, StudentTask WHERE Users.id = StudentTask.idStud and Task.idTask = StudentTask.idTask and role = '2'")
            };
            SQLiteDataReader sqlReader = Command.ExecuteReader();
            List<string[]> data = new List<string[]>();
            while (sqlReader.Read())
            {
                data.Add(new string[7]);
                data[data.Count - 1][0] = sqlReader[0].ToString();
                data[data.Count - 1][1] = sqlReader[1].ToString();
                data[data.Count - 1][2] = sqlReader[2].ToString();
                data[data.Count - 1][3] = sqlReader[3].ToString();
                data[data.Count - 1][4] = sqlReader[4].ToString();
                data[data.Count - 1][5] = sqlReader[5].ToString();
                data[data.Count - 1][6] = sqlReader[6].ToString();
            }
            sqlReader.Close();
            foreach (string[] s in data)
            {
                db.Rows.Add(s);
            }
        }


        private void enterB_Click(object sender, EventArgs e)
        {
            if (id == "" || id == null || mark == "" || mark == null)
            {
                MessageBox.Show("Все поля должны быть заполнены!");
            }
            else
            {

                SQLiteCommand Command = new SQLiteCommand
                {
                    Connection = Connect,
                    CommandText = String.Format("UPDATE StudentTask  SET mark = {1} WHERE id = {0}", id, mark)
                };
                Command.ExecuteNonQuery();
            }
            table();
        }

        private void idTB_TextChanged(object sender, EventArgs e)
        {
            id = idTB.Text;
        }

        private void markB_TextChanged(object sender, EventArgs e)
        {
            mark = markB.Text;
        }
        
    }
}
