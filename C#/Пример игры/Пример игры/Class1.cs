using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FormForLessonn05032020
{
    class Game
    {
        public bool[,] Table { get; private set; }
        public Game()
        {
            Table = new bool[4, 4];
            Random rnd = new Random();
            do
            {
                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 4; j++)
                        Table[i, j] = (rnd.Next(2) > 0);
            } while (isFinished());
        }
        public bool isFinished()
        {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (!Table[i, j])
                        return false;
            return true;
        }
        public void reCalc(int r, int c)
        {
            for (int i = 0; i < 4; i++)
                Table[r, i] = !Table[r, i];
            for (int i = 0; i < 4; i++)
                Table[i, c] = !Table[i, c];
            Table[r, c] = !Table[r, c];
        }

    }
}
