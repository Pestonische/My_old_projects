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
    public partial class AddUser : Form
    {
        String name, password, userName, role, spec;
        SQLiteConnection Connect;
        public AddUser(SQLiteConnection Connect)
        {
            InitializeComponent();
            this.Connect = Connect;
        }

        private void cancelB_Click(object sender, EventArgs e)
        {
            MenuForAdmin menu = new MenuForAdmin(Connect);
            menu.Show();
            this.Close();
        }

        private void createUserB_Click(object sender, EventArgs e)
        {
            Regex regex = new Regex(@"^([a-zA-Z]|[а-яА-Я]|[\s])+$");
            if (name == "" || name == null ||
                password == "" || password == null ||
                userName == "" || userName == null ||
                role == "" || role == null || (role == "2" && (spec == null || spec == "")))
            {
                MessageBox.Show("Все поля должны быть заполнены!");
            }
            else if (!regex.IsMatch(name))
            {
                MessageBox.Show("Имя состоит только из букв");
            }
            else
            {
                if(role != "2")
                {
                    spec = null;
                    MessageBox.Show("Пользователь не является студентом, поэтому в специальность ничего небыло записано");
                }
                SQLiteCommand Command = new SQLiteCommand
                {
                    Connection = Connect,
                    CommandText = String.Format("INSERT INTO Users (name, login, role, password, specialization) VALUES ('{0}', '{1}', '{2}', {3}, '{4}');", name, userName, role, password, spec)
                };                    
                    
                Command.ExecuteNonQuery();
                
            }
        }

        private void nameTB_TextChanged(object sender, EventArgs e)
        {
            name = nameTB.Text;
        }

        private void specTB_TextChanged(object sender, EventArgs e)
        {
            spec = specTB.Text;
        }

        private void roleTB_TextChanged(object sender, EventArgs e)
        {
            role = roleTB.Text;
        }

        private void passwordTB_TextChanged(object sender, EventArgs e)
        {
            password = passwordTB.Text;
        }

        private void userNameTB_TextChanged(object sender, EventArgs e)
        {
            userName = userNameTB.Text;
        }
        
    }
}
