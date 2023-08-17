using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace serialization
{
    [Serializable]
    public class Result
    {
        public string Player { get; set; }
        public DateTime Time { get; set; }
        public int _Time { get; set; }
        public int Steps { get; set; }
        public Result(string player, DateTime time, int _time, int steps)
        {
            Player = player;
            Time = time;
            _Time = _time;
            Steps = steps;
        }
    }
}
