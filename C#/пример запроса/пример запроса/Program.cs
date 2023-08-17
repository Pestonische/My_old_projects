using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace пример_запроса
{
    class Team
    {
        public string Name;
        public string City;
        public Team(string s1, string s2)
        {
            Name = s1; City = s2;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Team[] teams = { new Team("Chelsea", "London"),
                new Team("Arsenal", "London"),
                new Team("Arsenal", "Kiiv"),
                new Team("Real", "Madrid"),
                new Team("Manchester United", "Manchester"),
                new Team("Manchester City", "Manchester"),
                new Team("Real", "San-Sebastian") };
            var rezt = from t in teams
                       group t by t.City;
            Console.WriteLine("Команды, сгруппированные по городам: ");
            foreach (var city in rezt)
            {
                Console.WriteLine("Город {0}", city.Key);
                foreach (var team in city)
                    Console.WriteLine("    " + team.Name);
                Console.WriteLine();
            }
           


        }
    }
}