using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Пятнашки
{
    class Mathclass
    {
        public int Seed { get; private set; }
        public int[] Arr { get; private set; }
        private int EmptySpace { get; set; }
        public int Step { get; private set; }
        public void swap(ref int _a, ref int _b)
        {
            int temp = _a;
            _a = _b;
            _b = temp;
        }
        public Mathclass(int timer) 
        {
            Random rnd = new Random(timer);
            Seed = timer;
            Arr = new int[16];
            for (int i = 0; i < 15; i++)
                Arr[i] = i+1;
           for(int i = 0; i < 16; i++)
            {
                swap(ref Arr[i], ref Arr[rnd.Next(1, 16)]);
            }
            for (int i = 0; i < 16; i++)
            {
                if (Arr[i] == 0)
                    EmptySpace = i;
            }
                Step = 0;
        }

        public bool Check()
        {
            int inv = 0;

            for (int i = 0; i < 16; ++i)
                    for (int j = 0; j < i; ++j)
                        if (Arr[j] > Arr[i])
                            ++inv;
            for (int i = 0; i < 16; ++i)
                if (Arr[i] == 0)
                    inv += 1 + i / 4;

            if (inv % 2 == 0)
                return false;
            return true;
        }
        public bool GameWin()
        {
            for (int i = 0; i < 15; i++)
                if (Arr[i] != i + 1)
                    return false;
            return true;
        }
        public bool Movements(int pos)
        {
            if ((pos == EmptySpace - 1 && EmptySpace % 4 != 0) || (pos == EmptySpace + 1 && EmptySpace % 4 != 3)
                || (pos == EmptySpace + 4) || (pos == EmptySpace - 4))
            {
                Step++;
                Arr[EmptySpace] = Arr[pos];
                Arr[pos] = 0;
                EmptySpace = pos;
                return true;
            }
            return false;
        }
    }
}
