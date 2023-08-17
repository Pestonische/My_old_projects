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
    public partial class MenuForAdmin : Form
    {
        SQLiteConnection Connect;

        public MenuForAdmin(SQLiteConnection Connect)
        {
            InitializeComponent();
            this.Connect = Connect;
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

        private void editBDB_Click(object sender, EventArgs e)
        {
            AddUser addUser = new AddUser(Connect);
            addUser.Show();
            this.Close();
        }

        private void viewingJournalB_Click(object sender, EventArgs e)
        {
            JournalBD journalBD = new JournalBD(Connect);
            journalBD.Show();
            this.Close();
        }
       
    }
}
