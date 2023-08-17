using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SQLite;
using System.IO;
using System.Diagnostics;

namespace PPS_Lab
{
    public partial class Login : Form
    {
        SQLiteConnection Connect;
        
        string name;
        string password;


        public Login(SQLiteConnection Connect)
        {
            InitializeComponent();
            this.Connect = Connect;
        }

        private void loginB_Click(object sender, EventArgs e)
        {
            User user = new User();
            MenuForStudent menuForStudent;
            MenuForAdmin menuForAdmin = new MenuForAdmin(Connect);
            MenuForProfessor menuForProfessor = new MenuForProfessor(Connect);
            if ((name == "" || name == null) || (password == "" || password == null))
            {
                MessageBox.Show("Все поля должны быть заполнены!");
            }
            else if (password.Length > 20)
            {
                MessageBox.Show("Пороль не должен содержать больше 20 символов!");
            }
            else
            {
                SQLiteCommand Command = new SQLiteCommand
                {
                    Connection = Connect,
                    CommandText = String.Format("SELECT * FROM Users WHERE login = '{0}' and password = '{1}'", name, password)
                };
                SQLiteDataReader sqlReader = Command.ExecuteReader();
                sqlReader.Read();
                if (sqlReader.HasRows)
                {
                    user = new User(sqlReader);
                    if (sqlReader.GetString(3) == "0")
                    {
                        menuForAdmin.Show();
                        this.Hide();

                    }
                    else if (sqlReader.GetString(3) == "2")
                    {
                        menuForStudent = new MenuForStudent(Connect, user);
                        menuForStudent.Show();
                        this.Hide();
                    }
                    else if (sqlReader.GetString(3) == "1")
                    {
                        menuForProfessor.Show();
                        this.Hide();
                    }
                    else
                    {
                        MessageBox.Show("Неверные данные!");
                    }
                }
                else
                {
                    MessageBox.Show("Неверные данные, попробуте войти еще раз!");
                }
            }            
        }

        private void cancelB_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void userNameL_TextChanged(object sender, EventArgs e)
        {
            name = userNameL.Text;
        }

        private void passwordL_TextChanged(object sender, EventArgs e)
        {
            password = passwordL.Text;
        }
    }
}
