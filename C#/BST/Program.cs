using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using System.Runtime.Serialization;

namespace BinaryTree
{
    class Program
    {
        static void Main()
        {
            
            Tree tr = new Tree();
            tr.Insert(43);
            tr.Insert(25);
            tr.Insert(115);
            tr.Insert(45);
            tr.Insert(55);
            tr.Insert(77);
            tr.Insert(28);
            tr.Insert(56);
            tr.Insert(49);
            tr.Insert(50);
            Console.WriteLine(tr.SearchFoliage());
            ////Tree tr1 = new Tree();
            //using (FileStream fs = new FileStream("BST.dat", FileMode.Create))
            //{
            //    BinaryFormatter bf = new BinaryFormatter();
            //    bf.Serialize(fs, tr);
            //}
            //Tree tr_restored;
            //using (FileStream fr = new FileStream("BST.dat",
            //FileMode.Open))
            //{
            //    BinaryFormatter bf = new BinaryFormatter();
            //    tr_restored = (Tree)bf.Deserialize(fr);
            //}
        }
    }
}
