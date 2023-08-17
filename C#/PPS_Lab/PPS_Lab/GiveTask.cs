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
    public partial class GiveTask : Form
    {
        SQLiteConnection Connect;
        String taskId, idUser;
        public GiveTask(SQLiteConnection Connect)
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
            int counter = 0;
            if (db.Rows.Count > 1)
            {
                counter = db.Rows.Count;
                for (int i = 0; i < counter - 1; i++)
                {
                    db.Rows.RemoveAt(0);
                }
            }
            if (db2.Rows.Count > 1)
            {
                counter = db2.Rows.Count;
                for (int i = 0; i < counter - 1; i++)
                {
                    db.Rows.RemoveAt(0);
                }
            }
            SQLiteCommand Command = new SQLiteCommand
            {
                Connection = Connect,
                CommandText = String.Format("SELECT id, name, specialization FROM Users WHERE role = '2'")
            };
            SQLiteCommand Command1 = new SQLiteCommand
            {
                Connection = Connect,
                CommandText = String.Format("SELECT idTask, objective FROM Task")
            };
            SQLiteDataReader sqlReader = Command.ExecuteReader();
            SQLiteDataReader sqlReader1 = Command1.ExecuteReader();
            List<string[]> data1 = new List<string[]>();
            List<string[]> data2 = new List<string[]>();
            while (sqlReader.Read())
            {
                data1.Add(new string[3]);
                data1[data1.Count - 1][0] = sqlReader[0].ToString();
                data1[data1.Count - 1][1] = sqlReader[1].ToString();
                data1[data1.Count - 1][2] = sqlReader[2].ToString();
            }
            while (sqlReader1.Read())
            {
                data2.Add(new string[2]);
                data2[data2.Count - 1][0] = sqlReader1[0].ToString();
                data2[data2.Count - 1][1] = sqlReader1[1].ToString();
            }
            sqlReader.Close();
            sqlReader1.Close();
            foreach (string[] s in data1)
            {
                db.Rows.Add(s);
            }
            foreach (string[] s in data2)
            {
                db2.Rows.Add(s);
            }
        }
        private void enterB_Click(object sender, EventArgs e)
        {
            if (idUser == "" || idUser == null ||
                taskId == "" || taskId == null)
            {
                MessageBox.Show("Все поля должны быть заполнены!");
            }
            else
            {
                SQLiteCommand Command = new SQLiteCommand
                {
                    Connection = Connect,
                    CommandText = String.Format("INSERT INTO StudentTask (idStud, idTask) VALUES ('{0}', '{1}');", idUser, taskId)
                };

                Command.ExecuteNonQuery();

            }
        }

        private void idTB_TextChanged(object sender, EventArgs e)
        {
            idUser = idTB.Text;
        }

        private void taskIdB_TextChanged(object sender, EventArgs e)
        {
            taskId = taskIdB.Text;
        }
        
    }
}
