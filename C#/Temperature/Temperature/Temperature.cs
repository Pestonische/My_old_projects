using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Temperature
{
    class Temperature
    {
        private double _celcium;
        public Temperature()
        {
            _celcium = 0; 
        }
        public Temperature(double t)
        { 
            _celcium = t;
        }
        public static Temperature operator +(Temperature t1, Temperature t2)
        {
            Temperature t = new Temperature();
            t._celcium = t1._celcium+ t2._celcium;
            return t;
        }
        public static Temperature operator -(Temperature t1, Temperature t2)
        {
            Temperature t = new Temperature();
            t._celcium = t1._celcium - t2._celcium;
            return t;
        }
        public static Temperature operator -(Temperature t1)
        {
            Temperature t = new Temperature();
            t._celcium = -t1._celcium;
            return t;
        }
        public double getCelcium()
        {
            return _celcium;
        }
        public static bool operator <(Temperature t2, Temperature t1)
        {
            return (t1._celcium < t2._celcium);
        }
        public static bool operator >(Temperature t2, Temperature t1)
        {
            return (t1._celcium > t2._celcium);
        }
        public static bool operator ==(Temperature t2, Temperature t1)
        {
            return (t1._celcium == t2._celcium);
        }
        public static bool operator !=(Temperature t2, Temperature t1)
        {
            return (t1._celcium != t2._celcium);
        }
        public static bool operator >=(Temperature t2, Temperature t1)
        {
            return (t1._celcium >= t2._celcium);
        }
        public static bool operator <=(Temperature t2, Temperature t1)
        {
            return (t1._celcium <= t2._celcium);
        }

    }
}
