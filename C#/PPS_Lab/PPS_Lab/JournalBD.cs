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
    public partial class JournalBD : Form
    {
        String pc, delete;
        SQLiteConnection Connect;
        private void deleteB_Click(object sender, EventArgs e)
        {
            if (delete == "" || delete == null)
            {
                MessageBox.Show("Все поля должны быть заполнены!");
            }
            else
            {
                
                SQLiteCommand Command = new SQLiteCommand
                {
                    Connection = Connect,
                    CommandText = String.Format("DELETE FROM Users WHERE id = {0}", delete)
                };
                Command.ExecuteNonQuery();
            }
            table();
            
        }

        private void deleteIdTB_TextChanged(object sender, EventArgs e)
        {
            delete = deleteIdTB.Text;
        }

        public JournalBD(SQLiteConnection Connect)
        {
            InitializeComponent();
            this.Connect = Connect;
            prCB.Items.Add(0);
            prCB.Items.Add(1);
            prCB.Items.Add(2);
            prCB.SelectedItem = prCB.Items[1];
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
                CommandText = String.Format("SELECT id, name, login, role, password FROM Users WHERE role='{0}'", pc)
            };
            SQLiteDataReader sqlReader = Command.ExecuteReader();
            List<string[]> data = new List<string[]>();
            if (data.Count > 1)
            {
                for (int i = 0; i < data.Count; i++)
                {
                    data.RemoveAt(i);
                }
            }
            while (sqlReader.Read())
            {
                data.Add(new string[5]);
                data[data.Count - 1][0] = sqlReader[0].ToString();
                data[data.Count - 1][1] = sqlReader[1].ToString();
                data[data.Count - 1][2] = sqlReader[2].ToString();
                if (sqlReader[3].ToString() == "0")
                {
                    data[data.Count - 1][3] = "Админестратор";
                }
                else if (sqlReader[3].ToString() == "2")
                {
                    data[data.Count - 1][3] = "Студент";
                }
                else if (sqlReader[3].ToString() == "1")
                {
                    data[data.Count - 1][3] = "Преподаватель";
                }                    
                data[data.Count - 1][4] = sqlReader[4].ToString();
            }
            sqlReader.Close();
            foreach (string[] s in data)
            {
                db.Rows.Add(s);
            }
            
        }
        private void returnToMenuB_Click(object sender, EventArgs e)
        {
            MenuForAdmin menuForAdmin = new MenuForAdmin(Connect);
            menuForAdmin.Show();
            this.Close();
        }

        private void prCB_SelectedIndexChanged(object sender, EventArgs e)
        {
            pc = prCB.Text;
            table();
        }
    }
}
