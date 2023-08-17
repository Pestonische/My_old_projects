using System;
using System.Collections.Generic;
using System.Data.SQLite;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PPS_Lab
{
    public class User
    {
        private String name, id, login, role, special, password;
        public User()
        {

        }
        public User(String id, String name, String login, String role, String special, String password)
        {
            this.id = id;
            this.name = name;
            this.login = login;
            this.role = role;
            this.special = special;
            this.password = password;
        }
        public User(SQLiteDataReader user)
        {
            this.id = user[0].ToString();
            this.name = user[1].ToString();
            this.login = user[2].ToString();
            this.role = user[3].ToString();
            this.special = user[4].ToString();
            this.password = user[5].ToString();
        }
        public String setId()
        {
            return this.id;
        }
        public void setName(String name)
        {
            this.name = name;
        }
        public void setLogin(String login)
        {
            this.login = login;
        }
        public void setRole(String role)
        {
            this.role = role;
        }
        public void setSpecial(String special)
        {
            this.special = special;
        }
        public void setPassword(String password)
        {
            this.password = password;
        }
        public String getId()
        {
            return this.id;
        }
        public String getName()
        {
            return this.name;
        }
        public String getLogin()
        {
            return this.login;
        }
        public String getRole()
        {
            return this.role;
        }
        public String getSpecial()
        {
            return this.special;
        }
        public String getPassword()
        {
            return this.password;
        }
    }
}
