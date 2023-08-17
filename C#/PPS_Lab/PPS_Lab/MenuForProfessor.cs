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
    public partial class MenuForProfessor : Form
    {
        SQLiteConnection Connect;
        public MenuForProfessor(SQLiteConnection Connect)
        {
            InitializeComponent();
            this.Connect = Connect;
        }

        private void addTaskB_Click(object sender, EventArgs e)
        {
            AddTask addTask = new AddTask(Connect);
            addTask.Show();
            this.Close();
        }

        private void editJournalB_Click(object sender, EventArgs e)
        {
            EditJournal editJournal = new EditJournal(Connect);
            editJournal.Show();
            this.Close();
        }

        private void returnForLoginB_Click(object sender, EventArgs e)
        {
            Login login = new Login(Connect);
            login.Show();
            this.Close();
        }

        private void exitB_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void giveTaskB_Click(object sender, EventArgs e)
        {
            GiveTask giveTask = new GiveTask(Connect);
            giveTask.Show();
            this.Close();
        }
        
    }
}
