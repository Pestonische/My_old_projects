using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace drobi_c_sharp
{
    class drobi: IComparable
    {

        private long numerator, denominator;
        public drobi()
        {
            numerator = 0; denominator = 1;
        }
        public drobi(long Numerator, long Denominator)
        {
            if (Denominator == 0)
            {
                throw new Exception("Знаменатель не может равнятся нулю");
            }
            this.Numerator = Numerator;
            this.Denominator = Denominator;
        }
        public double FractionOut()
        {
            return (double)numerator / denominator;
        }
        public long Numerator
        {
            get
            {
                return numerator;
            }
            set
            {
                numerator = value;
            }
        }
        public long Denominator
        {
            get
            {
                return denominator;
            }
            set
            {
                if (value == 0)
                    throw new Exception("Знаменатель не может быть равен нулю");
                denominator = value;
                
                correct();
            }
        }

        private long nod(long _numerator, long _denominator)
        {
            _numerator = Math.Abs(_numerator);
            _denominator = Math.Abs(_denominator);
            if (_numerator == 0)
                return _denominator;
            if (_numerator == _denominator)
                return _numerator;
            else
            {
                while (_numerator != _denominator)
                {
                    if (_numerator < _denominator)
                        _denominator -= _numerator;
                    else
                        _numerator -= _denominator;
                }
                return _numerator;
            }
        }

        private void correct()
        {
            if (denominator < 0)
            {
                denominator = -denominator;
                numerator = -numerator;
            }
            long _nod = nod(numerator, denominator);
            numerator /= _nod;
            denominator /= _nod;
        }


        public override string ToString()
        {
            if (numerator == 0)
            {
                return "0";
            }
            return String.Format(numerator + "/" + denominator);
        }
        public static drobi operator +(drobi a, drobi b)
        {
            return new drobi(a.numerator * b.denominator + b.numerator * a.denominator, a.denominator * b.denominator);
        }
        public static drobi operator -(drobi a, drobi b)
        {
            return new drobi(a.numerator * b.denominator - b.numerator * a.denominator, a.denominator * b.denominator);
        }
        public static drobi operator -(drobi a)
        {
            return new drobi(-a.numerator, a.denominator);
        }
        public static drobi operator *(drobi a, drobi b)
        {
            return new drobi(a.numerator * b.numerator, a.denominator * b.denominator);
        }
        public static drobi operator /(drobi a, drobi b)
        {
            if (b.denominator == 0 || a.denominator==0)
                throw new Exception("Знаменатель не может быть равен 0\n");
            else
            {
                return new drobi(a.numerator * b.denominator, b.numerator * a.denominator);
            }
        }
        
    public static bool operator > (drobi a, drobi b)
        {
            return a.numerator * b.denominator - b.numerator * a.denominator>0;
        }
        public static bool operator <(drobi a, drobi b)
        {
            return !(a>b);
        }
        public static bool operator ==(drobi a, drobi b)
        {
            return a.numerator==b.numerator&& a.denominator==b.denominator;
        }
        public static bool operator !=(drobi a, drobi b)
        {
            return a.numerator != b.numerator && a.denominator != b.denominator;
        }
        public static bool operator >=(drobi a, drobi b)
        {
            return a.numerator * b.denominator - b.numerator * a.denominator >= 0;
        }
        public static bool operator <=(drobi a, drobi b)
        {
            return !(a >= b);
        }
        public override bool Equals(object obj)
        {
            if (obj == null) 
                throw new NullReferenceException();
            if (!(obj is drobi))
                throw new ArgumentException("Argument should be Temperature type");
            return numerator == (obj as drobi).numerator && denominator == (obj as drobi).denominator;
        }

        public override int GetHashCode()
        {
            return ((double)numerator / denominator).GetHashCode();
        }
        public int CompareTo(object obj)
        {
            if (!(obj is drobi))
                throw new Exception("Объект не является дробью");
            drobi for_sorting = (drobi)obj;
            if (this < for_sorting)
                return -1;
            if (this > for_sorting)
                return 1;
            return 0;
        }
    }
}