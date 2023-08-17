using System;
using System.Collections.Generic;
using System.Data.SQLite;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PPS_Lab
{
    static class Program
    {
        /// <summary>
        /// Главная точка входа для приложения.
        /// </summary>
        [STAThread]
        static void Main()
        {
            using (SQLiteConnection Connect = new SQLiteConnection(@"Data Source=C:\ПРПС\оно\DB.db; Version=3;"))
            {
                Connect.Open();
                Application.EnableVisualStyles();
                Application.SetCompatibleTextRenderingDefault(false);
                Application.Run(new Login(Connect));
                Connect.Close();
            }
        }
    }
}
