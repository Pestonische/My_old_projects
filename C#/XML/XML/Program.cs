using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Xml;
using System.Xml.Schema;

namespace XML
{
    class Program
    {
        private static void displayTree(XmlNode node)
        {
            if (node.Name == "#text")
            {
                Console.WriteLine(node.Value);
                return;
            }

            if (node.Attributes != null)
            {
                for (var i = 0; i < node.Attributes.Count; i++)
                    Console.WriteLine("\t{0}: {1}", node.Attributes[i].Name, node.Attributes[i].Value);
                for (var i = 0; i < node.ChildNodes.Count; i++)
                    displayTree(node.ChildNodes[i]);
            }
        }
        static void Main(string[] args)
        {
            XmlDocument xd = new XmlDocument();
            XmlReaderSettings settings = new XmlReaderSettings();
            settings.DtdProcessing = DtdProcessing.Parse;
            settings.ValidationType = ValidationType.DTD;
            using (XmlReader reader = XmlReader.Create("XML.xml", settings))
            {
                try
                {
                    xd.Load(reader);
                }
                catch (XmlSchemaException ex)
                {
                    Console.WriteLine(ex.Message);
                    return;
                }
            }
            XmlNode root = xd.DocumentElement;
            displayTree(root);
        }
    }
}
