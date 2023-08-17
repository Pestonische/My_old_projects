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
    public partial class MenuForStudent : Form
    {
        SQLiteConnection Connect;
        User user;
        public MenuForStudent(SQLiteConnection Connect, User user)
        {
            InitializeComponent();
            this.user = user;
            this.Connect = Connect;
        }

        private void exitB_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void returnForLoginB_Click(object sender, EventArgs e)
        {
            Login login = new Login(Connect);
            login.Show();
            this.Close();
        }

        private void viewingJournalB_Click(object sender, EventArgs e)
        {
            MenuJournal menuJournal = new MenuJournal(Connect, user);
            menuJournal.Show();
            this.Close();
        }

        private void submitTaskB_Click(object sender, EventArgs e)
        {
            SubmitTask submitTask = new SubmitTask(Connect, user);
            submitTask.Show();
            this.Close();
        }
        
    }
}
